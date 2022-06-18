package BinarySearchTree.LeetcodeQuestions;

/*
URL: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */

public class KthSmallestElementInABinarySearchTree {
    static int count;
    static int result;

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

    private void inorderTraversal(TreeNode currentNode, int k) {
        if(currentNode != null) {
            inorderTraversal(currentNode.left, k);
            count++;

            if(count == k) {
                result = currentNode.val;
                return;
            }
            inorderTraversal(currentNode.right, k);
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        count = 0;

        inorderTraversal(root, k);

        return result;
    }
}