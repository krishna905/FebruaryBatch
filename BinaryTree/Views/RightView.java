package BinaryTree.Views;

import java.util.ArrayList;
import java.util.List;

public class RightView {
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

    private void getRightView(Node node, int levelNumber) {
        if(node != null) {
            if(levelNumber == output.size()) {
                output.add(node.data);
            }

            getRightView(node.right, levelNumber + 1);
            getRightView(node.left, levelNumber + 1);
        }
    }
    
    public static void main(String[] args) {
        RightView rightView = new RightView();
        rightView.output = new ArrayList<>();

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        root.left.right.left = new Node(6);

        rightView.getRightView(root, 0);

        System.out.println(rightView.output);
    }
}
