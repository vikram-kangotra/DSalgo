// Problem Title: Rotate Array
// Problem URL: https://leetcode.com/problems/rotate-array/

pub fn rotate(arr: &mut [i32], k: u32) {
    arr.reverse();
    arr[..k as usize].reverse();
    arr[k as usize..].reverse();
}
