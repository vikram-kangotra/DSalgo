mod missing_number_in_array;
mod minimum_steps_to_make_product_equal_to_one;
mod trailing_zeros_in_factorial;

#[cfg(test)]
mod tests {

    use crate::missing_number_in_array::missing_number_in_array;
    use crate::minimum_steps_to_make_product_equal_to_one::min_steps;
    use crate::trailing_zeros_in_factorial::trailing_zeros;

    #[test]
    fn test_missing_number_in_array() {
        let arr = [0, 5, 8, 7, 9, 4, 2, 3, 1];
        let num = missing_number_in_array(&arr);
        assert_eq!(num, 6);
    }

    #[test]
    fn test_minimum_steps_to_make_product_equal_to_one() {
        let nums = [0, -2, -1, -3, 4];
        let steps = min_steps(&nums);
        assert_eq!(steps, 7);
    }

    #[test]
    fn test_trailing_zeros() {
        let num = 30;
        let zeros = trailing_zeros(num);
        assert_eq!(zeros, 7);
    }
}
