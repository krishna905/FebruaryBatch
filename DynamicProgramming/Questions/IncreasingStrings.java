package DynamicProgramming.Questions;

import java.util.Scanner;

public class IncreasingStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int dp[][] = new int[n + 1][26];

        int mod = (int)(1e9 + 7);

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < 26; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % mod;
                }
            }
        }

        System.out.println(dp[n][25]);
    }
}
