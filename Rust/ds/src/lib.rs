mod vector;

#[cfg(test)]
mod tests {
    
    use crate::vector::Vector;

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
