package BinaryTree.TreeConstruction;

public class PreorderAndPostorder {
    int preorderIndex;
    int size;

    static class Node {
        Node left;
        int data;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    private void postorderTraversal(Node root) {
        if(root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    private void preorderTraversal(Node root) {
        if(root != null) {
            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    private int search(int postorder[], int key, int postorderStart, int postorderEnd) {
        for(int i = postorderStart; i <= postorderEnd; i++) {
            if(postorder[i] == key) {
                return i;
            }
        }

        return -1;
    }

    private Node buildTree(int preorder[], int postorder[], int postorderStart, int postorderEnd) {
        if(preorderIndex >= size || postorderStart > postorderEnd) {
            return null;
        }

        int data = preorder[preorderIndex];
        Node currentRootNode = new Node(data);
        preorderIndex++;

        if(postorderStart == postorderEnd || preorderIndex >= size) {
            return currentRootNode;
        }

        data = preorder[preorderIndex];

        int postorderIndex = search(postorder, data, postorderStart, postorderEnd);

        currentRootNode.left = buildTree(preorder, postorder, postorderStart, postorderIndex);
        currentRootNode.right = buildTree(preorder, postorder, postorderIndex + 1, postorderEnd - 1);

        return currentRootNode;
    }

    public static void main(String[] args) {
        PreorderAndPostorder preorderAndPostorder = new PreorderAndPostorder();

        int preorder[] = {1, 2, 4, 8, 9, 5, 3, 6, 7};
        int postorder[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};

        preorderAndPostorder.size = preorder.length;
        preorderAndPostorder.preorderIndex = 0;

        Node root = preorderAndPostorder.buildTree(preorder, postorder, 0, preorderAndPostorder.size - 1);

        System.out.println("Preorder traversal of the built tree: ");
        preorderAndPostorder.preorderTraversal(root);

        System.out.println();

        System.out.println("Postorder traversal of the built tree: ");
        preorderAndPostorder.postorderTraversal(root);
    }
}
