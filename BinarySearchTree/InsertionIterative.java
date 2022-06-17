package BinarySearchTree;

public class InsertionIterative {
    static Node root;

    static class Node {
        Node left;
        int data;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    private void insertNode(int data) {
        Node newNode = new Node(data);

        if(root == null) {
            root = newNode;
        }
        else {
            Node current = root;
            Node parent = null;

            /*
            while(current != null) {
                parent = current;
                if(data > current.data) {
                    current = current.right;
                }
                else {
                    current = current.left;
                }
            }

            if(data > parent.data) {
                parent.right = newNode;
            }
            else {
                parent.left = newNode;
            }
             */

            while(true) {
                if(data > current.data) {
                    if(current.right == null) {
                        current.right = newNode;
                        break;
                    }
                    else {
                        current = current.right;
                    }
                }
                else {
                    if(current.left == null) {
                        current.left = newNode;
                        break;
                    }
                    else {
                        current = current.left;
                    }
                }
            }
        }
    }

    private void inorderTraversal(Node currentNode) {
        if(currentNode != null) {
            inorderTraversal(currentNode.left);
            System.out.print(currentNode.data + " ");
            inorderTraversal(currentNode.right);
        }
    }

    public static void main(String[] args) {
        InsertionIterative insertionIterative = new InsertionIterative();

        insertionIterative.insertNode(8);
        insertionIterative.insertNode(3);
        insertionIterative.insertNode(10);
        insertionIterative.insertNode(1);
        insertionIterative.insertNode(14);
        insertionIterative.inorderTraversal(root);
    }
}
