// Problem Title: Trailing Zeroes in Factorial
//
// Given an integer n, return the number of trailing zeroes in n!.

pub fn trailing_zeros(n: u32) -> u32 {
    let mut count = 0;
    let mut i = 5;
    while n / i >= 1 {
        count += n / i;
        i *= 5;
    }
    count
}
