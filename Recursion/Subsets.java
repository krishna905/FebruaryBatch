package Recursion;

/*
URL: https://leetcode.com/problems/subsets/
 */

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    /*
    Krushna's Approach (using Backtracking):

    public List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> subsets = new ArrayList<>();
		generateSubsets(0, nums, new ArrayList<Integer>(), subsets);

		return subsets;
	}

	public void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> subsets){
		subsets.add(new ArrayList<>(current));
		for(int i = index; i < nums.length; i++){
			current.add(nums[i]);
			generateSubsets(i + 1, nums, current, subsets);
			current.remove(current.size() - 1);
		}
	}
     */

    private void getSubsets(int[] nums, List<List<Integer>> completeSubsetList, int currentIndex) {
        if(currentIndex < nums.length) {
            List<List<Integer>> currentCompleteSubsetList = new ArrayList<>(completeSubsetList);

            for(List<Integer> eachCurrentCompleteSubsetList : currentCompleteSubsetList) {
                List<Integer> currentList = new ArrayList<>(eachCurrentCompleteSubsetList);

                currentList.add(nums[currentIndex]);
                completeSubsetList.add(currentList);
            }

            getSubsets(nums, completeSubsetList, currentIndex + 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> completeSubsetList = new ArrayList<>();

        //takes care of empty list in the output
        completeSubsetList.add(new ArrayList<Integer>());

        //'0' is the starting index
        getSubsets(nums, completeSubsetList, 0);

        return completeSubsetList;
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int nums[] = {1, 2, 3};

        List<List<Integer>> result = subsets.subsets(nums);

        System.out.println(result);
    }
}
