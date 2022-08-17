package DynamicProgramming.Questions.LeetcodeQuestions;

/*
URL: https://leetcode.com/problems/climbing-stairs/
 */

public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }

        if(n == 2) {
            return 2;
        }

        int numberOfWays[] = new int[n + 1];
        numberOfWays[0] = 0;
        numberOfWays[1] = 1;
        numberOfWays[2] = 2;

        for(int i = 3; i <= n; i++) {
            numberOfWays[i] = numberOfWays[i - 1] + numberOfWays[i - 2];
        }

        return numberOfWays[n];
    }
}
