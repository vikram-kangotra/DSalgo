pub fn bubble_sort<T:Ord + Copy>(arr: &mut [T]) {
    for _ in 0..arr.len() {
        let mut swapped = false;
        for j in 0..arr.len()-1 {
            if arr[j] > arr[j+1] {
                (arr[j], arr[j+1]) = (arr[j+1], arr[j]);
                swapped = true;
            }
        }
        if swapped == false {
            break;
        }
    }
}
