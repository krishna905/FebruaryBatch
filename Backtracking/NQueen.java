package Backtracking;

public class NQueen {
    int N = 5;

    private void printChessBoard(char chessBoard[][]) {
        System.out.println("Chess Board: ");
        for(int i = 0; i < chessBoard.length; i++) {
            for(int j = 0; j < chessBoard[0].length; j++) {
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    private boolean isSafe(char chessBoard[][], int rowNumber, int columnNumber) {
        //left upper diagonal
        for(int x = rowNumber - 1, y = columnNumber - 1; x >= 0 && y >= 0; x--, y--) {
            if(chessBoard[x][y] == 'Q') {
                return false;
            }
        }

        //left row
        for(int x = columnNumber - 1; x >= 0; x--) {
            if(chessBoard[rowNumber][x] == 'Q') {
                return false;
            }
        }

        //left lower diagonal
        for(int x = rowNumber + 1, y = columnNumber - 1; x < N && y >= 0; x++, y--) {
            if(chessBoard[x][y] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private boolean solveNQueenUtil(char chessBoard[][], int columnNumber) {
        if(columnNumber >= N) {
            return true;
        }

        for(int rowNumber = 0; rowNumber < N; rowNumber++) {
            if(isSafe(chessBoard, rowNumber, columnNumber)) {
                chessBoard[rowNumber][columnNumber] = 'Q';

                if(solveNQueenUtil(chessBoard, columnNumber + 1)) {
                    return true;
                }
                chessBoard[rowNumber][columnNumber] = '.';
            }
        }

        return false;
    }

    private void solveNQueen() {
        char chessBoard[][] = new char[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                chessBoard[i][j] = '.';
            }
        }

        boolean result = solveNQueenUtil(chessBoard, 0);

        if(result) {
            printChessBoard(chessBoard);
        }
        else {
            System.out.println("Solution doesn't exist");
        }
    }

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        nQueen.solveNQueen();
    }
}
