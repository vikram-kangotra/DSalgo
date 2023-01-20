pub fn merge_sort<T:Ord + Copy + std::fmt::Debug>(arr: &mut [T]) {
    merge_sort_helper(arr, 0, arr.len() - 1);
}

fn merge_sort_helper<T:Ord + Copy + std::fmt::Debug>(arr: &mut [T], start: usize, end: usize) {
    if start >= end {
        return;
    }
    let pivot = start + (end - start) / 2;
    merge_sort_helper(arr, start, pivot);
    merge_sort_helper(arr, pivot + 1, end);
    merge(arr, start, pivot, end);
}

fn merge<T:Ord + Copy+ std::fmt::Debug>(arr: &mut [T], start: usize, pivot: usize, end: usize) {

    let l1 = pivot - start + 1;
    let l2 = end - pivot;

    let left = arr[start..start + l1].to_vec();
    let right = arr[pivot + 1..pivot + 1 + l2].to_vec();

    let mut i = 0;
    let mut j = 0;
    let mut k = start;

    while i < l1 && j < l2 {
        if left[i] <= right[j] {
            arr[k] = left[i];
            i += 1;
        } else {
            arr[k] = right[j];
            j += 1;
        }
        k += 1;
    }

    arr[k..k + l1 - i].copy_from_slice(&left[i..]);
    arr[k..k + l2 - j].copy_from_slice(&right[j..]);
}
