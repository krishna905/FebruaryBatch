/*
Author: Bhaskar Devendra
 */
package DivideAndConquer;

import java.util.Scanner;

public class SquareOfNumberUsingRecursiveAddition {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int square = square(n, 1, n);
        System.out.print(square);
    }

    public static int square(int n, int start, int end) {
        if(start < end){
            int mid = start + ((end - start) >> 1);
            int output = square(n, start, mid) + square(n,mid + 1, end);
            return output;
        }

        return n;
    }
}