package DynamicProgramming.Questions.LeetcodeQuestions;

/*
URL: https://leetcode.com/problems/trapping-rain-water/
 */

public class TrappingRainwater {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];
        int max;

        max = height[0];
        leftMax[0] = max;
        for(int i = 1; i < n; i++) {
            if(height[i] > max) {
                max = height[i];
            }
            leftMax[i] = max;
        }

        max = height[n - 1];
        rightMax[n - 1] = max;
        for(int i = (n - 2); i >= 0; i--) {
            if(height[i] > max) {
                max = height[i];
            }
            rightMax[i] = max;
        }

        int result = 0;
        for(int i = 0; i < n; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            int quantityOfWater = minHeight - height[i];
            result = result + quantityOfWater;
        }

        return result;
    }
}
