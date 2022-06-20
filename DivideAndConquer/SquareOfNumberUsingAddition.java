package DivideAndConquer;

import java.util.Scanner;

public class SquareOfNumberUsingAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int square = 0;

        for(int i = 1; i <= num; i++) {
            square = square + num;
        }

        System.out.println(square);
    }
}
