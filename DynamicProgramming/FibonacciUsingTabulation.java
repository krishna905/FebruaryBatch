package DynamicProgramming;

public class FibonacciUsingTabulation {
    private int calculateFibonacci(int n) {
        int fibonacci[] = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            if(i < 2) {
                fibonacci[i] = i;
            }
            else {
                fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            }
        }

        return fibonacci[n];
    }
    public static void main(String[] args) {
        int n = 7;
        FibonacciUsingTabulation fibonacciUsingTabulation
                = new FibonacciUsingTabulation();

        int nthFibonacciNumber = fibonacciUsingTabulation.calculateFibonacci(n);

        System.out.println(nthFibonacciNumber);
    }
}
