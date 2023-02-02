pub mod sort;
pub mod search;

#[cfg(test)]
mod tests {
    use crate::search::binary::binary_search;
    use crate::search::linear::linear_search;

    use crate::sort::bubble::bubble_sort;
    use crate::sort::count::counting_sort;
    use crate::sort::selection::selection_sort;
    use crate::sort::insertion::insertion_sort; 
    use crate::sort::merge::merge_sort;
    use crate::sort::quick::quick_sort;

    #[test]
    fn bubble() {
        let mut arr = [4,6,7,5,8,7,3,2];
        bubble_sort(&mut arr);
        assert_eq!(arr, [2,3,4,5,6,7,7,8]);
    }

    #[test]
    fn selection() {
        let mut arr = [4,6,7,5,8,7,3,2];
        selection_sort(&mut arr);
        assert_eq!(arr, [2,3,4,5,6,7,7,8]);
    }

    #[test]
    fn insertion() {
        let mut arr = [4,6,7,5,8,7,3,2];
        insertion_sort(&mut arr);
        assert_eq!(arr, [2,3,4,5,6,7,7,8]);
    }
    
    #[test]
    fn count() {
        let mut arr = [4,6,7,5,8,7,3,2];
        counting_sort(&mut arr);
        assert_eq!(arr, [2,3,4,5,6,7,7,8]);
    
    }

    #[test]
    fn merge() {
        let mut arr = [4,6,7,5,8,7,3,2];
        merge_sort(&mut arr);
        assert_eq!(arr, [2,3,4,5,6,7,7,8]);
    }

    #[test]
    fn quick() {
        let mut arr = [4,6,7,5,8,7,3,2];
        quick_sort(&mut arr);
        assert_eq!(arr, [2,3,4,5,6,7,7,8]);
    }

    #[test]
    fn binary() {
        let arr = [2,3,4,5,6,7,7,8];
        let index = binary_search(&arr, 6)
            .expect("6 should be in the array");
        assert_eq!(index, 4);
    }

    #[test]
    fn linear() {
        let arr = [2,3,4,5,6,7,7,8];
        let index = linear_search(&arr, &6)
            .expect("6 should be in the array");
        assert_eq!(index, 4);
    }
}
