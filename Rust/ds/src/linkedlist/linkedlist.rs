#[derive(Clone)]
pub struct Node {
    pub value: u32,
    pub next: Option<Box<Node>>,
}

#[derive(Clone)]
pub struct LinkedList {
    pub head: Option<Box<Node>>,
}

impl LinkedList {
    #[allow(dead_code)]
    pub fn new() -> Self {
        LinkedList { head: None }
    }

    #[allow(dead_code)]
    pub fn push_back(&mut self, elem: u32) {
        if self.head.is_none() {
            let node = Node {
                value: elem,
                next: None,
            };
            self.head = Some(Box::new(node));
        } else {
            let mut next_address = &mut self.head;
            while next_address.as_ref().unwrap().next.is_some() {
                next_address = &mut next_address.as_mut().unwrap().next;
            }
            let node = Node {
                value: elem,
                next: None,
            };
            next_address.as_mut().unwrap().next = Some(Box::new(node));
        }
    }

    #[allow(dead_code)]
    pub fn pop_back(&mut self) -> u32 {
        if self.head.is_none() {
            return 0;
        }
        let mut next_address = &mut self.head;
        while next_address.as_ref().unwrap().next.is_some() {
            next_address = &mut next_address.as_mut().unwrap().next;
        }
        let value = next_address.as_ref().unwrap().value;
        next_address.take();
        value
    }

    #[allow(dead_code)]
    pub fn show(&self) {
        let mut next_address = self.head.clone();
        while next_address.is_some() {
            print!("{} ", next_address.as_ref().unwrap().value);
            next_address = next_address.unwrap().next.clone();
        }
        println!();
    }
}

pub struct ListIter(LinkedList);

impl Iterator for ListIter {
    type Item = u32;

    fn next(&mut self) -> Option<Self::Item> {
        match self.0 {
            LinkedList { head: Some(ref mut node) } => {
                let value = node.value;
                self.0 = LinkedList { head: node.next.clone() };
                Some(value)
            }
            _ => None,
        }
    }
}

impl IntoIterator for LinkedList {
    type Item = u32;
    type IntoIter = ListIter;

    fn into_iter(self) -> Self::IntoIter {
        ListIter(self)
    }
}
