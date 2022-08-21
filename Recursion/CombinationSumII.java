package Recursion;

/*
URL: https://leetcode.com/problems/combination-sum-ii/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
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
            if(i > currentIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }

            currentCombinationList.add(candidates[i]);
            getCombinationSumList(candidates, completeCombinationList,
                    currentCombinationList, i + 1, target - candidates[i]);
            currentCombinationList.remove(currentCombinationList.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
        CombinationSumII combinationSumII = new CombinationSumII();

        int candidates[] = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> completeCombinationList
                = combinationSumII.combinationSum2(candidates, target);

        System.out.println(completeCombinationList);
    }
}
