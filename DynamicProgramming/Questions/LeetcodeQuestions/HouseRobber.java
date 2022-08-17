package DynamicProgramming.Questions.LeetcodeQuestions;

/*
URL: https://leetcode.com/problems/house-robber/
 */

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        if(nums.length == 2) {
            return (Math.max(nums[0], nums[1]));
        }


        int maximumMoney[] = new int[nums.length + 1];
        maximumMoney[0] = 0;
        maximumMoney[1] = nums[0];

        for(int i = 2; i <= nums.length; i++) {
            maximumMoney[i] = Math.max(nums[i - 1] + maximumMoney[i - 2], maximumMoney[i - 1]);
        }

        return maximumMoney[nums.length];
    }
}
