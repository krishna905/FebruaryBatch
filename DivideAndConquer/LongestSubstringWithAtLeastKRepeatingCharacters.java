package DivideAndConquer;

/*
URL: https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 */

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    private int getLengthOfLongestSubstring(String s, int k, int start, int end) {
        if(k == 1) {
            return (end - start + 1);
        }

        if(start > end) {
            return 0;
        }

        int frequencyArray[] = new int[26];
        int result;

        for(int i = start; i <= end; i++) {
            frequencyArray[s.charAt(i) - 'a'] += 1;
        }

        for(int i = start; i <= end; i++) {
            int frequency = frequencyArray[s.charAt(i) - 'a'];

            if(frequency < k) {
                int frequency1 = getLengthOfLongestSubstring(s, k, start, i - 1);
                int frequency2 = getLengthOfLongestSubstring(s, k, i + 1, end);

                result = Math.max(frequency1, frequency2);

                return result;
            }
        }

        result = end - start + 1;

        return result;
    }

    public int longestSubstring(String s, int k) {
        int length = getLengthOfLongestSubstring(s, k, 0, s.length() - 1);

        return length;
    }
}
