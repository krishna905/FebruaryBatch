package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutationsOfString {
    List<String> result;

    private void permuteString(String s, String answer) {
        if(s.length() == 0) {
            result.add(answer);
            return;
        }

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String leftSubstring = s.substring(0, i);
            String rightSubstring = s.substring(i + 1);
            String remainingString = leftSubstring + rightSubstring;
            permuteString(remainingString, answer + ch);
        }
    }

    public static void main(String[] args) {
        PrintAllPermutationsOfString printAllPermutationsOfString
                = new PrintAllPermutationsOfString();

        String str = "abc";
        printAllPermutationsOfString.result = new ArrayList<>();
        printAllPermutationsOfString.permuteString(str, "");

        System.out.println(printAllPermutationsOfString.result);
    }
}
