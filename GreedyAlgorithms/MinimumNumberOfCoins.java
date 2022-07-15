package GreedyAlgorithms;

import java.util.Scanner;

public class MinimumNumberOfCoins {
    public static void main (String[] args) {
        // Your code here
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        int denomination[] = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};

        for(int i = 1; i <= T; i++) {
            int A = scanner.nextInt();

            int result = 0;
            for(int j = 9; j >= 0; j--) {
                result += A / denomination[j];
                A = A % denomination[j];
            }

            System.out.println(result);
        }
    }
}
