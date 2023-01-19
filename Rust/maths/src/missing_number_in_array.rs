// Problem title: Missing Number in Array
// Problem url: https://leetcode.com/problems/missing-number-in-array
//
// Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
// find the one that is missing from the array.

pub fn missing_number_in_array(nums: &[u32]) -> u32 {
    let a = nums.iter().fold(0, |acc, x| acc + x);
    let b = (nums.len() * (nums.len() + 1) / 2) as u32;
    return b - a;
}
