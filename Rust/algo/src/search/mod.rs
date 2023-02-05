pub mod binary;
pub mod linear;

#[cfg(test)]
mod test {  
     
    use super::binary::binary_search;
    use super::linear::linear_search;
    
    #[test]
    fn linear() {
        let arr = [1,2,3,4,5,6,7,8,9,10];
        assert_eq!(linear_search(&arr, 1), Some(0));
        assert_eq!(linear_search(&arr, 2), Some(1));
        assert_eq!(linear_search(&arr, 3), Some(2));
        assert_eq!(linear_search(&arr, 4), Some(3));
        assert_eq!(linear_search(&arr, 5), Some(4));
        assert_eq!(linear_search(&arr, 6), Some(5));
        assert_eq!(linear_search(&arr, 7), Some(6));
        assert_eq!(linear_search(&arr, 8), Some(7));
        assert_eq!(linear_search(&arr, 9), Some(8));
        assert_eq!(linear_search(&arr, 10), Some(9));
        assert_eq!(linear_search(&arr, 11), None);
    }

    #[test]
    fn binary() {
        let arr = [1,2,3,4,5,6,7,8,9,10];
        assert_eq!(binary_search(&arr, 1), Some(0));
        assert_eq!(binary_search(&arr, 2), Some(1));
        assert_eq!(binary_search(&arr, 3), Some(2));
        assert_eq!(binary_search(&arr, 4), Some(3));
        assert_eq!(binary_search(&arr, 5), Some(4));
        assert_eq!(binary_search(&arr, 6), Some(5));
        assert_eq!(binary_search(&arr, 7), Some(6));
        assert_eq!(binary_search(&arr, 8), Some(7));
        assert_eq!(binary_search(&arr, 9), Some(8));
        assert_eq!(binary_search(&arr, 10), Some(9));
        assert_eq!(binary_search(&arr, 11), None);
    }
}
