package Backtracking;

import java.util.Scanner;

public class MaxString {
    private String max;

    private void getLexicographicallyMaximumString(char sArr[], int K) {
        if(K == 0) {
            return;
        }

        for(int i = 0; i < sArr.length; i++) {
            for(int j = (i + 1); j < sArr.length; j++) {
                if(sArr[i] < sArr[j]) {
                    //swap
                    char temp = sArr[i];
                    sArr[i] = sArr[j];
                    sArr[j] = temp;

                    String newString = new String(sArr);

                    if(max.compareTo(newString) < 0) {
                        max = newString;
                    }

                    getLexicographicallyMaximumString(sArr, K - 1);

                    temp = sArr[i];
                    sArr[i] = sArr[j];
                    sArr[j] = temp;
                }
            }
        }
    }

    public static void main (String[] args) {
        // Your code here
        MaxString maxString = new MaxString();
        Scanner scanner = new Scanner(System.in);

        String S = scanner.nextLine();
        int K = scanner.nextInt();

        char sArr[] = S.toCharArray();

        maxString.max = S;

        maxString.getLexicographicallyMaximumString(sArr, K);

        System.out.println(maxString.max);
    }
}