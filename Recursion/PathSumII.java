package Recursion;

/*
URL: https://leetcode.com/problems/path-sum-ii/
 */

import BinaryTree.LeetcodeQuestions.BinaryTreeMaximumPathSum;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class PathSumII {
    private void getPathSumList(TreeNode root,
                                List<List<Integer>> completeList,
                                List<Integer> currentList,
                                int target) {
        if(root == null) {
            return;
        }

        currentList.add(root.val);
        if(root.left == null && root.right == null && root.val == target) {
            List<Integer> tempCurrentList = new ArrayList<>(currentList);
            completeList.add(tempCurrentList);

            currentList.remove(currentList.size() - 1);

            return;
        }

        getPathSumList(root.left, completeList, currentList, target - root.val);
        getPathSumList(root.right, completeList, currentList, target - root.val);

        currentList.remove(currentList.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> completeList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();

        getPathSumList(root, completeList, currentList, targetSum);

        return completeList;
    }
}
