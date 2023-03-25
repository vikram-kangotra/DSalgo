pub fn floyd_warshall(g: &mut Vec<Vec<i64>>) {
    let n = g.len();
    for k in 0..n {
        for i in 0..n {
            for j in 0..n {
                if g[i][k] != std::i64::MAX && g[k][j] != std::i64::MAX {
                    g[i][j] = std::cmp::min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
    }
}
