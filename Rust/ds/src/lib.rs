mod vector;
mod array;
mod linkedlist;

#[cfg(test)]
mod tests {
    
    use crate::array::majority::majority_element;
    use crate::vector::Vector;
    use crate::array::rotate::rotate;
    use crate::linkedlist::linkedlist::LinkedList;

    #[test]
    fn test_rotate() {
        let mut arr = [1, 2, 3, 4, 5, 6, 7];
        rotate(&mut arr, 3);
        assert_eq!(arr, [5, 6, 7, 1, 2, 3, 4]);
    }

    #[test]
    fn test_majority() {
        let mut arr = [1, 2, 1, 4, 5, 1, 1];
        assert_eq!(majority_element(&mut arr), 1);
    }

    #[test]
    fn vector() {
        let mut v = Vector::new();
        assert_eq!(v.len(), 0);

        v.push_back(1);
        assert_eq!(v.len(), 1);

        v.push_back(2);
        assert_eq!(v.len(), 2);

        v.push_back(3);
        assert_eq!(v.capacity(), 4);

        v.pop_back();
        assert_eq!(v.len(), 2);

        v.pop_back();
        v.pop_back();
        v.pop_back();

        assert_eq!(v.len(), 0);
        assert_eq!(v.capacity(), 4);
    }

    #[test]
    fn linkedlist() {
        let mut list = LinkedList::new();

        list.push_back(10);
        list.push_back(23);
        list.pop_back();
        list.push_back(34);

        let values: Vec<u32> = list.into_iter().collect();

        assert_eq!(values, vec![10, 34]);
    }
}
