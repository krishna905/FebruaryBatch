package BinarySearchTree;

public class Insertion {
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
        Insertion insertion = new Insertion();

        insertion.insertNode(8);
        insertion.insertNode(3);
        insertion.insertNode(10);
        insertion.insertNode(1);
        insertion.insertNode(14);
        insertion.inorderTraversal(root);
    }
}
