package Backtracking;

/*
URL: https://leetcode.com/problems/unique-paths/
 */

/*
Note: Backtracking solution will lead to TLE with larger input values.
Consider solving using DP
 */

public class UniquePaths {
    int result;

    private void exploreGrid(int m, int n, int x, int y) {
        if(x == (m - 1) && y == (n - 1)) {
            result++;
            return;
        }

        if(x < (m - 1)) {
            exploreGrid(m, n, x + 1, y);
        }

        if(y < (n - 1)) {
            exploreGrid(m, n, x, y + 1);
        }
    }

    public int uniquePaths(int m, int n) {
        exploreGrid(m, n, 0, 0);

        return result;
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();

        int m = 3;
        int n = 7;

        int result = uniquePaths.uniquePaths(m, n);

        System.out.println("Result: " + result);
    }
}
