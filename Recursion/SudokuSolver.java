package Recursion;

/*
URL: https://leetcode.com/problems/sudoku-solver/
 */

public class SudokuSolver {
    private boolean isValid(char board[][], int rowNumber, int columnNumber, char currentValue) {
        int regionRow = (rowNumber / 3) * 3;
        int regionColumn = (columnNumber / 3) * 3;
        for(int i = 0; i < 9; i++) {
            if(board[i][columnNumber] != '.' && board[i][columnNumber] == currentValue) {
                return false;
            }

            if(board[rowNumber][i] != '.' && board[rowNumber][i] == currentValue) {
                return false;
            }

            if(board[regionRow + (i / 3)][regionColumn + (i % 3)] != '.'
                    && board[regionRow + (i / 3)][regionColumn + (i % 3)] == currentValue) {
                return false;
            }
        }

        return true;
    }

    private boolean solve(char board[][]) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') {
                    for(char k = '1'; k <= '9'; k++) {
                        if(isValid(board, i, j, k)) {
                            board[i][j] = k;

                            if(solve(board)) {
                                return true;
                            }
                            else {
                                board[i][j] = '.';
                            }
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}
