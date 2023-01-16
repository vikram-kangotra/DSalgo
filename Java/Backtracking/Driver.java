public class Driver {

    public static void main(String[] args) {
        NQueenProblem nq = new NQueenProblem(8);
        nq.solveNQ();
        SudokuProblem sp = new SudokuProblem(new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        });
        sp.solve();

        RatInMazeProblem rim = new RatInMazeProblem(new int[][]{
             { 1, 0, 0, 0 },
            { 1, 1, 0, 1 },
            { 0, 1, 0, 0 },
            { 1, 1, 1, 1 } 
        });
        rim.solveMaze();

        M_Coloring_Problem mcp = new M_Coloring_Problem(new int[][]{
            {0, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {1, 0, 1, 0}
        }, 3);
        mcp.graphColoring();

        HamiltonianCycleProblem hcp = new HamiltonianCycleProblem(new int[][]{
            {0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {0, 1, 1, 1, 0}
        });
        hcp.solve();

        Knights_tour_problem ktp = new Knights_tour_problem(5);
        ktp.solve();
    }
    
}
