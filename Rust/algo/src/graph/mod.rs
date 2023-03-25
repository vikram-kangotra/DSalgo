pub mod floyd_warshall;

#[cfg(test)]
mod test {

    use super::floyd_warshall::floyd_warshall;

    #[test]
    fn floyd_warshall_test() {
        let mut graph = vec![
            vec![0, 5, std::i64::MAX, 10],
            vec![std::i64::MAX, 0, 3, std::i64::MAX],
            vec![std::i64::MAX, std::i64::MAX, 0, 1],
            vec![std::i64::MAX, std::i64::MAX, std::i64::MAX, 0],
        ];

        floyd_warshall(&mut graph);

        assert_eq!(graph, vec![
            vec![0, 5, 8, 9],
            vec![std::i64::MAX, 0, 3, 4],
            vec![std::i64::MAX, std::i64::MAX, 0, 1],
            vec![std::i64::MAX, std::i64::MAX, std::i64::MAX, 0],
        ]);
    }
}
