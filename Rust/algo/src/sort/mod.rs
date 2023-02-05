pub mod bubble;
pub mod selection;
pub mod insertion;
pub mod count;
pub mod merge;
pub mod quick;

#[cfg(test)]
mod tests {

    use super::bubble::bubble_sort;
    use super::count::counting_sort;
    use super::selection::selection_sort;
    use super::insertion::insertion_sort; 
    use super::merge::merge_sort;
    use super::quick::quick_sort;

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

}
