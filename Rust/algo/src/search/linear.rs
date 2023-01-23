pub fn linear_search<T:Ord>(arr: &[T], key: &T) -> Option<usize> {
    for (i, val) in arr.iter().enumerate() {
        if val == key {
            return Some(i);
        }
    }
    None
}
