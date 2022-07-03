package DynamicProgramming;

/*
URL: https://leetcode.com/problems/unique-paths/
 */

public class UniquePathsRavi {
    public static int countWays(int row, int col, int i, int j, int[][] mat) {
        if(i == row-1 || j == col-1){
            return 1;
        }

        if(mat[i][j] != 0){
            return mat[i][j];
        }

        int down = countWays(row, col, i+1, j, mat);
        int right = countWays(row, col, i, j+1, mat);

        mat[i][j] = down + right;

        return mat[i][j];
    }

    public int uniquePaths(int m, int n) {

        int[][] mat = new int[m][n];

        return countWays(m, n, 0, 0, mat);
    }
}
