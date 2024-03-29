pub fn binary_search<T:Ord>(arr: &[T], val: T) -> Option<usize> {
    let mut start = 0;
    let mut end = arr.len();

    while start < end {
        let mid = start + (end - start) / 2;
        if arr[mid] == val {
            return Some(mid);
        } else if arr[mid] < val {
            start = mid + 1;
        } else {
            end = mid;
        }
    }

    None
}
