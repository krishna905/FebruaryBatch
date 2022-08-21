package Recursion;

/*
URL: https://leetcode.com/problems/combination-sum/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    private void getCombinationSumList(int candidates[],
                                       List<List<Integer>> completeCombinationList,
                                       List<Integer> currentCombinationList,
                                       int currentIndex,
                                       int target) {
        if(target < 0) {
            return;
        }

        if(target == 0) {
            List<Integer> tempCurrentCombinationList
                    = new ArrayList<>(currentCombinationList);

            completeCombinationList.add(tempCurrentCombinationList);

            return;
        }

        for(int i = currentIndex; i < candidates.length; i++) {
            currentCombinationList.add(candidates[i]);
            getCombinationSumList(candidates, completeCombinationList,
                    currentCombinationList, i, target - candidates[i]);
            currentCombinationList.remove(currentCombinationList.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> completeCombinationList
                = new ArrayList<>();

        List<Integer> currentCombinationList = new ArrayList<>();
        int currentIndex = 0;

        getCombinationSumList(candidates, completeCombinationList,
                currentCombinationList,
                currentIndex, target);

        return completeCombinationList;
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();

        int candidates[] = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> completeCombinationList
                = combinationSum.combinationSum(candidates, target);

        System.out.println(completeCombinationList);
    }
}
