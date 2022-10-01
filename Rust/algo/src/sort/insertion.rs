pub fn insertion_sort<T:Ord + Copy>(arr: &mut [T]) {
    for i in 1..arr.len() {
        let mut j : isize = (i - 1) as isize;
        let key = arr[i];
        while j >= 0 && key < arr[j as usize] {
            arr[(j+1) as usize] = arr[j as usize];
            j -= 1;
        }
        arr[(j+1) as usize] = key;
    }
}
