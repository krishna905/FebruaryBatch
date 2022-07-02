package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueenAllSolutions {
    char chessBoard[][];
    int upperLeftDiagonalCheck[];
    int rowCheck[];
    int lowerLeftDiagonalCheck[];
    List<List<String>> result;

    private void prettyPrintResult() {
        for(List<String> eachResult : result) {
            for(String eachRow : eachResult) {
                System.out.println(eachRow);
            }

            System.out.println();
        }
    }

    private List<String> constructList() {
        List<String> currentResult = new ArrayList<>();
        for(int i = 0; i < chessBoard.length; i++) {
            String s = new String(chessBoard[i]);
            currentResult.add(s);
        }

        return currentResult;
    }

    private boolean isSafe(int rowNumber, int columnNumber) {
        //left upper diagonal
        if(upperLeftDiagonalCheck[(chessBoard.length - 1) + (rowNumber - columnNumber)] == 1) {
            return false;
        }

        //left row
        if(rowCheck[rowNumber] == 1) {
            return false;
        }

        //left lower diagonal
        if(lowerLeftDiagonalCheck[rowNumber + columnNumber] == 1) {
            return false;
        }

        return true;
    }

    private void solve(int columnNumber) {
        if(columnNumber == chessBoard[0].length) {
            result.add(constructList());
            return;
        }

        for(int rowNumber = 0; rowNumber < chessBoard.length; rowNumber++) {
            if(isSafe(rowNumber, columnNumber)) {
                chessBoard[rowNumber][columnNumber] = 'Q';
                upperLeftDiagonalCheck[(chessBoard.length - 1) + (rowNumber - columnNumber)] = 1;
                rowCheck[rowNumber] = 1;
                lowerLeftDiagonalCheck[rowNumber + columnNumber] = 1;

                solve(columnNumber + 1);

                chessBoard[rowNumber][columnNumber] = '.';
                upperLeftDiagonalCheck[(chessBoard.length - 1) + (rowNumber - columnNumber)] = 0;
                rowCheck[rowNumber] = 0;
                lowerLeftDiagonalCheck[rowNumber + columnNumber] = 0;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        chessBoard = new char[n][n];
        upperLeftDiagonalCheck = new int[2 * n - 1];
        rowCheck = new int[n];
        lowerLeftDiagonalCheck = new int[2 * n - 1];
        result = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                chessBoard[i][j] = '.';
            }
        }

        solve(0);

        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        NQueenAllSolutions nQueenAllSolutions = new NQueenAllSolutions();
        nQueenAllSolutions.result = nQueenAllSolutions.solveNQueens(n);

        nQueenAllSolutions.prettyPrintResult();
    }
}
