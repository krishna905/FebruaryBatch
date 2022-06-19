package BinarySearchTree.Questions;

/*
URL: https://leetcode.com/problems/validate-binary-search-tree/
 */

public class ValidateBinarySearchTree {
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

    private boolean check(TreeNode currentNode, Integer min, Integer max) {
        boolean leftStatus = true;
        boolean rightStatus = true;

        if(currentNode != null) {
            if(min != null && currentNode.val <= min) {
                leftStatus = false;
            }

            if(max != null && currentNode.val >= max) {
                rightStatus = false;
            }

            if(leftStatus && rightStatus) {
                leftStatus = check(currentNode.left, min, currentNode.val);
                rightStatus = check(currentNode.right, currentNode.val, max);
            }
        }

        return (leftStatus && rightStatus);
    }

    public boolean isValidBST(TreeNode root) {
        boolean result = check(root, null, null);

        return result;
    }
}