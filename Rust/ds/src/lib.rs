mod vector;
mod array;

#[cfg(test)]
mod tests {
    
    use crate::vector::Vector;
    use crate::array::rotate::rotate;

    #[test]
    fn test_rotate() {
        let mut arr = [1, 2, 3, 4, 5, 6, 7];
        rotate(&mut arr, 3);
        assert_eq!(arr, [5, 6, 7, 1, 2, 3, 4]);
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
}
