package GreedyAlgorithms;

import java.util.Scanner;

public class IncreasingArray {
    public static void main(String[] args) {
        // Your code here
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int arr[] = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int divisor = 2;
        boolean result = true;
        for(int j = 1; j < N; j++) {
            while(divisor <= arr[j] && arr[j] % divisor != 0) {
                divisor++;
            }
            if(divisor > arr[j]) {
                result = false;
                break;
            }
            divisor++;
        }

        if(result) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
