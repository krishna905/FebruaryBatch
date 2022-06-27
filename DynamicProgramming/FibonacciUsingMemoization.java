package DynamicProgramming;

import java.util.Arrays;

public class FibonacciUsingMemoization {
    int n;
    int fibonacci[];
    final int NIL = -1;

    FibonacciUsingMemoization(int n) {
        this.n = n;
        this.fibonacci = new int[n + 1];
    }

    private void initialize() {
        //Arrays.fill(fibonacci, -1);
        for(int i = 0; i <= n; i++) {
            fibonacci[i] = NIL;
        }
    }

    private int calculateNthFibonacci(int n) {
        if(fibonacci[n] == NIL) {
            if(n == 0 || n == 1) {
                fibonacci[n] = n;
            }
            else {
                fibonacci[n] = calculateNthFibonacci(n - 1) + calculateNthFibonacci(n - 2);
            }
        }

        return fibonacci[n];
    }

    public static void main(String[] args) {
        int n = 7;
        FibonacciUsingMemoization fibonacciUsingMemoization
                = new FibonacciUsingMemoization(n);

        fibonacciUsingMemoization.initialize();

        int nthFibonacciNumber = fibonacciUsingMemoization.calculateNthFibonacci(n);

        System.out.println(nthFibonacciNumber);
    }
}
