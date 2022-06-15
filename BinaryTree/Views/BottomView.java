package BinaryTree.Views;

import java.util.*;

public class BottomView {
    static Node root;

    static class Node {
        Node left;
        int data;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    class Pair {
        int verticalLevelNumber;
        Node currentNode;

        Pair(int verticalLevelNumber, Node currentNode) {
            this.verticalLevelNumber = verticalLevelNumber;
            this.currentNode = currentNode;
        }
    }

    private List<Integer> getBottomView(Node root) {
        List<Integer> output = new ArrayList<>();

        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        queue.add(new Pair(0, root));

        while(!queue.isEmpty()) {
            Pair p = queue.poll();

            int verticalLevelNumber = p.verticalLevelNumber;
            Node currentNode = p.currentNode;

            map.put(verticalLevelNumber, currentNode.data);

            if(currentNode.left != null) {
                queue.add(new Pair(verticalLevelNumber - 1, currentNode.left));
            }

            if(currentNode.right != null) {
                queue.add(new Pair(verticalLevelNumber + 1, currentNode.right));
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            output.add(entry.getValue());
        }

        return output;
    }

    public static void main(String[] args) {
        BottomView bottomView = new BottomView();

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(8);
        root.right.right = new Node(7);
        root.left.right.left = new Node(6);

        List<Integer> bottomViewOfBinaryTree = bottomView.getBottomView(root);

        System.out.println(bottomViewOfBinaryTree);
    }
}
