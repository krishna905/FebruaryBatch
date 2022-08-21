package Recursion;

/*
URL: https://leetcode.com/problems/permutations/
 */

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    private void getPermutationList(int nums[],
                                    List<Integer> currentPermutationList,
                                    List<List<Integer>> completePermutationList) {
        if(currentPermutationList.size() == nums.length) {
            completePermutationList.add(new ArrayList<>(currentPermutationList));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(currentPermutationList.contains(nums[i])) {
                continue;
            }
            currentPermutationList.add(nums[i]);
            getPermutationList(nums, currentPermutationList, completePermutationList);
            currentPermutationList.remove(currentPermutationList.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> completePermutationList
                = new ArrayList<>();

        List<Integer> currentPermutationList = new ArrayList<>();

        getPermutationList(nums, currentPermutationList, completePermutationList);

        return completePermutationList;
    }
}
