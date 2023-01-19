// Problem Title: Majority Element
// Problem URL: https://leetcode.com/problems/majority-element/

// Boyer-Moore Voting Algorithm
// only works when the majority element exists
// majority element is the element that appears more than n/2 times
// Time Complexity: O(n)
// Space Complexity: O(1)
pub fn majority_element(nums: &[i32]) -> i32 {
    let mut count = 0;
    let mut candidate = 0;

    for num in nums {
        if count == 0 {
            candidate = *num;
        }
        count += if *num == candidate { 1 } else { -1 };
    }

    return candidate;
}
