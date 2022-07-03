package DynamicProgramming;

/*
URL: https://leetcode.com/problems/unique-paths/
 */

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int pathDp[][] = new int[m][n];

        for(int i = 0; i < m; i++) {
            pathDp[i][0] = 1;
        }

        for(int i = 0; i < n; i++) {
            pathDp[0][i] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                pathDp[i][j] = pathDp[i][j - 1] + pathDp[i - 1][j];
            }
        }

        return pathDp[m - 1][n - 1];
    }
}
