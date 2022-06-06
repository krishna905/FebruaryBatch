package BinaryTreeDynamicData;

import java.util.LinkedList;
import java.util.Queue;

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

    private void levelOrderTraversal() {
        Queue<Node> queue = new LinkedList<>();
        Node temp = root;

        queue.add(temp);

        while(!queue.isEmpty()) {
            temp = queue.poll();
            System.out.print(temp.data + " ");

            if(temp.left != null) {
                queue.add(temp.left);
            }

            if(temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    private void insert(int data) {
        Node node = new Node(data);

        if(root == null) {
            root = node;
        }
        else {
            Queue<Node> queue = new LinkedList<>();
            Node temp = root;

            queue.add(temp);

            while(!queue.isEmpty()) {
                temp = queue.poll();

                if(temp.left != null) {
                    queue.add(temp.left);
                }
                else {
                    temp.left = node;
                    break;
                }

                if(temp.right != null) {
                    queue.add(temp.right);
                }
                else {
                    temp.right = node;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insert(10);
        binaryTree.insert(20);
        binaryTree.insert(30);
        binaryTree.insert(40);
        binaryTree.insert(50);
        binaryTree.levelOrderTraversal();
    }
}
