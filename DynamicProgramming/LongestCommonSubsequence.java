package DynamicProgramming;

public class LongestCommonSubsequence {
    private int calculateLengthOfLongestCommonSubstring(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int lcs[][] = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 || j == 0) {
                    lcs[i][j] = 0;
                }
                else if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                }
                else {
                    lcs[i][j] = Math.max(
                            lcs[i - 1][j],
                            lcs[i][j - 1]
                    );
                }
            }
        }

        return lcs[m][n];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence
                = new LongestCommonSubsequence();

        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";

        int lengthOfLCS = longestCommonSubsequence.calculateLengthOfLongestCommonSubstring(str1, str2);

        System.out.println("Length of LCS: " + lengthOfLCS);
    }
}
