pub fn selection_sort<T:Ord + Copy>(arr: &mut [T]) {
    for i in 0..arr.len()-1 {
        let mut sel = i;
        for j in i+1..arr.len() {
            if arr[j] < arr[sel] {
                sel = j;
            }
        }
        (arr[i], arr[sel]) = (arr[sel], arr[i])
    }
}
