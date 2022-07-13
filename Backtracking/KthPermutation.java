package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KthPermutation {
    private String getKthPermutation(int N, int K) {
        StringBuilder result = new StringBuilder();
        List<Integer> numberList = new ArrayList<>();
        int factorial = 1;

        for(int i = 1; i <= N; i++) {
            numberList.add(i);

            factorial = factorial * i;
        }

        K = K - 1;
        for(int i = 0; i < N; i++) {
            factorial = factorial / (N - i);
            int index = K / factorial;

            result.append(numberList.get(index));
            numberList.remove(index);

            K = K - (index * factorial);
        }

        return result.toString();
    }

    public static void main (String[] args) {
        // Your code here
        KthPermutation kthPermutation = new KthPermutation();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        String result = kthPermutation.getKthPermutation(N, K);

        System.out.println(result);
    }
}
