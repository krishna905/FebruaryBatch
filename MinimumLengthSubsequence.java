import java.util.*;

/*
Yash's solution: https://my.newtonschool.co/playground/code/mv62m0jqxm59/
Shiva's solution: https://my.newtonschool.co/playground/code/rulz46689gas/
 */

public class MinimumLengthSubsequence {
    private void buildPositionMap(String S, Map<Character, List<Integer>> positionMap) {
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            List<Integer> positionList;

            if(positionMap.containsKey(ch)) {
                positionList = positionMap.get(ch);
            }
            else {
                positionList = new ArrayList<>();
            }
            positionList.add(i);

            positionMap.put(ch, positionList);
        }
    }

    private int isNumberPresentInList(int start, List<Integer> numberList) {
        for(Integer number : numberList) {
            if(number >= start) {
                return number;
            }
        }

        return -1;
    }

    private int getLengthOfMinimumLengthSubsequence(String S1, Map<Character, List<Integer>> positionMap) {
        String S2 = "abcdefghijklmnopqrstuvwxyz";

        int startIndex;
        int endIndex = -1;
        int lastValidIndex;

        List<Integer> positionListOfA = positionMap.get('a');
        int currentIndexOfA = positionListOfA.size() - 1;
        int minimumLength = Integer.MAX_VALUE;

        while(currentIndexOfA >= 0) {
            startIndex = positionListOfA.get(currentIndexOfA);
            lastValidIndex = startIndex;

            int i;
            for(i = 1; i < 26; i++) {
                char currentCharacter = S2.charAt(i);
                List<Integer> positionList = positionMap.get(currentCharacter);
                int positionOfCurrentCharacter = isNumberPresentInList(lastValidIndex, positionList);
                if(positionOfCurrentCharacter != -1) {
                    lastValidIndex = positionOfCurrentCharacter;
                    endIndex = lastValidIndex;
                }
                else {
                    break;
                }
            }

            if (i >= 26) {
                System.out.println("Start: " + startIndex);
                System.out.println("End: " + endIndex);
                System.out.println("----------------");
                int currentMinimumLength = endIndex - startIndex + 1;
                minimumLength = Math.min(minimumLength, currentMinimumLength);
            }
            currentIndexOfA--;
        }

        if(minimumLength == Integer.MAX_VALUE) {
            minimumLength = -1;
        }

        return minimumLength;
    }

    public static void main(String[] args) {
        MinimumLengthSubsequence minimumLengthSubsequence
                = new MinimumLengthSubsequence();

        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();

        Map<Character, List<Integer>> positionMap
                = new HashMap<>();
        minimumLengthSubsequence.buildPositionMap(S, positionMap);

        int length;

        if(S.length() < 26 || positionMap.get('a') == null || positionMap.size() < 26) {
            length = -1;
        }
        else {
            length = minimumLengthSubsequence.getLengthOfMinimumLengthSubsequence(S, positionMap);
        }

        System.out.println(length);
    }
}
