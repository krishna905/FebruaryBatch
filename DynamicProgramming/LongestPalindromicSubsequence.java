package DynamicProgramming;

public class LongestPalindromicSubsequence {
    private void print2DArray(int arr[][]) {
        System.out.println("Array: ");
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.printf("%5d", arr[i][j]);
            }
            System.out.println();
        }

        System.out.println();
    }

    private int getLengthOfLongestPalindromicSubsequence(String sequence) {
        int length = sequence.length();
        int lpsArray[][] = new int[length][length];

        for(int i = 0; i < length; i++) {
            lpsArray[i][i] = 1;
        }

        for(int currentLength = 2; currentLength <= length; currentLength++) {
            for(int i = 0; i < (length - currentLength + 1); i++) {
                int j = i + currentLength - 1;

                boolean iEqualJ = sequence.charAt(i) == sequence.charAt(j);

                if(currentLength == 2 && iEqualJ) {
                    lpsArray[i][j] = 2;
                }
                else if(iEqualJ) {
                    lpsArray[i][j] = lpsArray[i + 1][j - 1] + 2;
                }
                else {
                    lpsArray[i][j] = Math.max(
                            lpsArray[i][j - 1],
                            lpsArray[i + 1][j]
                    );
                }
            }
        }

        print2DArray(lpsArray);

        return lpsArray[0][length - 1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence longestPalindromicSubsequence
                = new LongestPalindromicSubsequence();
        String sequence = "BABCBAB";
        int lpsLength = longestPalindromicSubsequence.
                getLengthOfLongestPalindromicSubsequence(sequence);

        System.out.println("Length of LPS: " + lpsLength);
    }
}
