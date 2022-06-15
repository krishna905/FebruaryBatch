package BinaryTree.LeetcodeQuestions;

/*
URL: https://leetcode.com/problems/diameter-of-binary-tree/
 */

public class DiameterOfBinaryTree {
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

    int longestPath = 0;

    private int calculateHeight(TreeNode currentNode) {
        int height = 0;

        if(currentNode != null) {
            int leftHeight = calculateHeight(currentNode.left);
            int rightHeight = calculateHeight(currentNode.right);

            height = Math.max(leftHeight, rightHeight) + 1;

            longestPath = Math.max(longestPath, leftHeight + rightHeight);
        }

        return height;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);

        return longestPath;
    }
}
