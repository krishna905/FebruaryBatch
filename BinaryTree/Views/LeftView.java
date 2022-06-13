package BinaryTree.Views;

import java.util.ArrayList;
import java.util.List;

public class LeftView {
    static Node root;
    List<Integer> output;

    static class Node {
        Node left;
        int data;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    private void getLeftView(Node node, int levelNumber) {
        if(node != null) {
            if(levelNumber == output.size()) {
                output.add(node.data);
            }

            getLeftView(node.left, levelNumber + 1);
            getLeftView(node.right, levelNumber + 1);
        }
    }

    public static void main(String[] args) {
        LeftView leftView = new LeftView();
        leftView.output = new ArrayList<>();

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        root.left.right.left = new Node(6);

        leftView.getLeftView(root, 0);

        System.out.println(leftView.output);
    }
}
