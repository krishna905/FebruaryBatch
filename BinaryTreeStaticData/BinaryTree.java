package BinaryTreeStaticData;

public class BinaryTree {
    static Node root;

    static class Node {
        Node left;
        int data;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        root = new Node(100);
        root.left = new Node(200);
        root.right = new Node(300);
        root.left.left = new Node(400);
        root.left.right = new Node(500);
    }
}
