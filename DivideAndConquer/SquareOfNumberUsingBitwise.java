package DivideAndConquer;

import java.util.Scanner;

public class SquareOfNumberUsingBitwise {
    private int calculateSquareOfNumber(int num) {
        if(num == 0) {
            return 0;
        }
        if(num < 0) {
            num = -num;
        }

        int halfOfN = num >> 1;

        if(num % 2 == 0) {
            return (calculateSquareOfNumber(halfOfN) << 2);
        }
        else {
            return ((calculateSquareOfNumber(halfOfN) << 2) + (halfOfN << 2) + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SquareOfNumberUsingBitwise squareOfNumberUsingBitwise
                = new SquareOfNumberUsingBitwise();
        int num = scanner.nextInt();

        int square = squareOfNumberUsingBitwise.calculateSquareOfNumber(num);

        System.out.println(square);
    }
}
