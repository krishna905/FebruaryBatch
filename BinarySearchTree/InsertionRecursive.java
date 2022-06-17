package BinarySearchTree;

public class InsertionRecursive {
    static Node root;

    static class Node {
        Node left;
        int data;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    private Node insertNodeHelper(Node currentNode, int data) {
        if(currentNode == null) {
            currentNode = new Node(data);
        }
        else {
            if(data < currentNode.data) {
                currentNode.left = insertNodeHelper(currentNode.left, data);
            }
            else {
                currentNode.right = insertNodeHelper(currentNode.right, data);
            }
        }

        return currentNode;
    }

    private void insertNode(int data) {
        root = insertNodeHelper(root, data);
    }

    private void inorderTraversal(Node currentNode) {
        if(currentNode != null) {
            inorderTraversal(currentNode.left);
            System.out.print(currentNode.data + " ");
            inorderTraversal(currentNode.right);
        }
    }

    public static void main(String[] args) {
        InsertionRecursive insertionRecursive = new InsertionRecursive();

        insertionRecursive.insertNode(8);
        insertionRecursive.insertNode(3);
        insertionRecursive.insertNode(10);
        insertionRecursive.insertNode(1);
        insertionRecursive.insertNode(14);
        insertionRecursive.inorderTraversal(root);
    }
}
