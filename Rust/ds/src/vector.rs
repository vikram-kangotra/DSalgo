use std::{ptr, alloc::{Layout, alloc, dealloc}};

pub struct Vector<T> {
    data: *mut T,
    len: usize,
    cap: usize,
}

impl<T> Vector<T> {
    #[allow(dead_code)]
    pub fn new() -> Self {
        Self {
            data: ptr::null_mut(),
            len: 0,
            cap: 0,
        }
    }
    
    #[allow(dead_code)]
    pub fn with_capacity(cap: usize) -> Self {
        let data = unsafe {
            let layout = Layout::from_size_align_unchecked(cap, std::mem::size_of::<T>());
            alloc(layout) as *mut T
        };
        Self {
            data,
            len: 0,
            cap,
        }
    }

    #[allow(dead_code)]
    pub fn push_back(&mut self, value: T) {
        if self.len == self.cap {
            self.grow();
        }
        unsafe {
            self.data.add(self.len).write(value);
        }
        self.len += 1;
    }

    #[allow(dead_code)]
    pub fn pop_back(&mut self) -> Option<T> {
        if self.len == 0 {
            return None;
        }
        self.len -= 1;
        unsafe {
            Some(self.data.add(self.len).read())
        }
    }

    #[allow(dead_code)]
    pub fn len(&self) -> usize {
        self.len
    }

    #[allow(dead_code)]
    pub fn capacity(&self) -> usize {
        self.cap
    }

    #[allow(dead_code)]
    fn grow(&mut self) {
        self.cap = if self.cap == 0 {
            1
        } else {
            self.cap * 2
        };
        let new_data = unsafe {
            let layout = Layout::from_size_align_unchecked(self.cap, std::mem::size_of::<T>());
            alloc(layout) as *mut T
        };
        unsafe {
            ptr::copy_nonoverlapping(self.data, new_data, self.len);
        }
        self.data = new_data;
    }
}

impl<T> Drop for Vector<T> {
    fn drop(&mut self) {
        unsafe {
            let layout = Layout::from_size_align_unchecked(self.cap, std::mem::size_of::<T>());
            dealloc(self.data as *mut u8, layout);
        }
    }
}
