package Backtracking;

public class NQueenIsSafeOptimised {
    int N = 5;
    char chessBoard[][];
    char upperLeftDiagonalCheck[];
    char rowCheck[];
    char lowerLeftDiagonalCheck[];

    private void initialize() {
        chessBoard = new char[N][N];
        upperLeftDiagonalCheck = new char[2 * N - 1];
        rowCheck = new char[N];
        lowerLeftDiagonalCheck = new char[2 * N - 1];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                chessBoard[i][j] = '.';
            }
        }

        for(int i = 0; i < (2 * N - 1); i++) {
            upperLeftDiagonalCheck[i] = '.';
            lowerLeftDiagonalCheck[i] = '.';
        }

        for(int i = 0; i < N; i++) {
            rowCheck[i] = '.';
        }
    }

    private void printChessBoard() {
        System.out.println("Chess Board: ");
        for(int i = 0; i < chessBoard.length; i++) {
            for(int j = 0; j < chessBoard[0].length; j++) {
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    private boolean isSafe(int rowNumber, int columnNumber) {
        //left upper diagonal
        if(upperLeftDiagonalCheck[(N - 1) + (rowNumber - columnNumber)] == 'Q') {
            return false;
        }

        //left row
        if(rowCheck[rowNumber] == 'Q') {
            return false;
        }

        //left lower diagonal
        if(lowerLeftDiagonalCheck[rowNumber + columnNumber] == 'Q') {
            return false;
        }

        return true;
    }

    private boolean solveNQueenUtil(int columnNumber) {
        if(columnNumber >= N) {
            return true;
        }

        for(int rowNumber = 0; rowNumber < N; rowNumber++) {
            if(isSafe(rowNumber, columnNumber)) {
                chessBoard[rowNumber][columnNumber] = 'Q';
                upperLeftDiagonalCheck[(N - 1) + (rowNumber - columnNumber)] = 'Q';
                rowCheck[rowNumber] = 'Q';
                lowerLeftDiagonalCheck[rowNumber + columnNumber] = 'Q';

                if(solveNQueenUtil(columnNumber + 1)) {
                    return true;
                }
                chessBoard[rowNumber][columnNumber] = '.';
                upperLeftDiagonalCheck[(N - 1) + (rowNumber - columnNumber)] = '.';
                rowCheck[rowNumber] = '.';
                lowerLeftDiagonalCheck[rowNumber + columnNumber] = '.';
            }
        }

        return false;
    }

    private void solveNQueen() {
        initialize();

        boolean result = solveNQueenUtil(0);
        if(result) {
            printChessBoard();
        }
        else {
            System.out.println("Solution doesn't exist");
        }
    }

    public static void main(String[] args) {
        NQueenIsSafeOptimised nQueenIsSafeOptimised = new NQueenIsSafeOptimised();
        nQueenIsSafeOptimised.solveNQueen();
    }
}
