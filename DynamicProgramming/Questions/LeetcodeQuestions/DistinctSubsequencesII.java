package DynamicProgramming.Questions.LeetcodeQuestions;

/*
URL: https://leetcode.com/problems/distinct-subsequences-ii/
 */

public class DistinctSubsequencesII {
    public int distinctSubseqII(String s) {
        int mod = (int)(1e9 + 7);
        int lastOccurrence[] = new int[26];
        int length = s.length();
        int subsequenceCount[] = new int[length + 1];

        subsequenceCount[0] = 1;
        for(int i = 0; i < 26; i++) {
            lastOccurrence[i] = -1;
        }

        for(int i = 1; i <= length; i++) {
            int newCount = ((subsequenceCount[i - 1] % mod) * 2) % mod;

            char ch = s.charAt(i - 1);
            int index = ch - 'a';

            if(lastOccurrence[index] != -1) {
                int duplicateCount = subsequenceCount[lastOccurrence[index] - 1];
                subsequenceCount[i] = (newCount - duplicateCount + mod) % mod;
            }
            else {
                subsequenceCount[i] = newCount;
            }

            lastOccurrence[index] = i;
        }


        return subsequenceCount[length] - 1;
    }
}
