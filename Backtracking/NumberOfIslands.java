package Backtracking;

/*
URL: https://leetcode.com/problems/number-of-islands/
 */

public class NumberOfIslands {
    int m;
    int n;

    private void exploreIsland(char grid[][], int i, int j) {
        if(0 <= i
                && i < m
                && 0 <= j
                && j < n
                && grid[i][j] == '1') {
            grid[i][j] = '2';

            exploreIsland(grid, i - 1, j);
            exploreIsland(grid, i, j + 1);
            exploreIsland(grid, i + 1, j);
            exploreIsland(grid, i, j - 1);
        }
    }

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int islandCount = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    exploreIsland(grid, i, j);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }
}
