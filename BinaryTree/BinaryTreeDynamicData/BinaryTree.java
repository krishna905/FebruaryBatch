package BinaryTree.BinaryTreeDynamicData;

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

    private void inorderTraversal(Node rootNode) {
        if(rootNode != null) {
            inorderTraversal(rootNode.left);
            System.out.print(rootNode.data + " ");
            inorderTraversal(rootNode.right);
        }
    }

    private void preorderTraversal(Node rootNode) {
        if(rootNode != null) {
            System.out.print(rootNode.data + " ");
            preorderTraversal(rootNode.left);
            preorderTraversal(rootNode.right);
        }
    }

    private void postorderTraversal(Node rootNode) {
        if(rootNode != null) {
            postorderTraversal(rootNode.left);
            postorderTraversal(rootNode.right);
            System.out.print(rootNode.data + " ");
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

    private void deleteDeepestRightmostNode(Node deleteNode) {
        Queue<Node> queue = new LinkedList<>();
        Node temp = root;

        queue.add(temp);

        while(!queue.isEmpty()) {
            temp = queue.poll();

            if(temp.right != null) {
                if(temp.right == deleteNode) {
                    temp.right = null;
                    return;
                }
                else {
                    queue.add(temp.right);
                }
            }

            if(temp.left != null) {
                if(temp.left == deleteNode) {
                    temp.left = null;
                    return;
                }
                else {
                    queue.add(temp.left);
                }
            }
        }
    }

    private void delete(int key) {
        //empty tree
        if(root == null) {
            System.out.println("Empty tree. Deletion is not possible");
            return;
        }

        //tree with only one node
        if(root.left == null && root.right == null) {
            //delete the only node in the tree
            if(root.data == key) {
                root = null;
            }
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        Node temp = root;

        queue.add(temp);

        Node deleteNode = null;

        while(!queue.isEmpty()) {
            temp = queue.poll();

            if(temp.data == key) {
                deleteNode = temp;
            }

            if(temp.left != null) {
                queue.add(temp.left);
            }

            if(temp.right != null) {
                queue.add(temp.right);
            }
        }

        if(deleteNode != null) {
            deleteNode.data = temp.data;
            deleteDeepestRightmostNode(temp);
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insert(10);
        binaryTree.insert(20);
        binaryTree.insert(30);
        binaryTree.insert(40);
        binaryTree.insert(50);

        System.out.print("Level Order Traversal: ");
        binaryTree.levelOrderTraversal();

        System.out.println();

        System.out.print("Inorder Traversal: ");
        binaryTree.inorderTraversal(root);

        System.out.println();

        System.out.print("Preorder Traversal: ");
        binaryTree.preorderTraversal(root);

        System.out.println();

        System.out.print("Postorder Traversal: ");
        binaryTree.postorderTraversal(root);

        binaryTree.delete(30);

        System.out.println();
        System.out.println("After deleting 30: ");

        System.out.print("Level Order Traversal: ");
        binaryTree.levelOrderTraversal();

        System.out.println();

        System.out.print("Inorder Traversal: ");
        binaryTree.inorderTraversal(root);

        System.out.println();

        System.out.print("Preorder Traversal: ");
        binaryTree.preorderTraversal(root);

        System.out.println();

        System.out.print("Postorder Traversal: ");
        binaryTree.postorderTraversal(root);
    }
}
