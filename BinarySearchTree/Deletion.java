package BinarySearchTree;

public class Deletion {
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

    private int getInorderSuccessor(Node currentNode) {
        int minimumValue = currentNode.data;

        while(currentNode.left != null) {
            currentNode = currentNode.left;
            minimumValue = currentNode.data;
        }

        return minimumValue;
    }

    private Node deleteNodeHelper(Node currentNode, int data) {
        if(currentNode == null) {
            return root;
        }

        if(data < currentNode.data) {
            currentNode.left = deleteNodeHelper(currentNode.left, data);
        }
        else if(data > currentNode.data) {
            currentNode.right = deleteNodeHelper(currentNode.right, data);
        }
        else {
            if(currentNode.left == null) {
                return currentNode.right;
            }
            else if(currentNode.right == null) {
                return currentNode.left;
            }
            else {
                currentNode.data = getInorderSuccessor(currentNode.right);

                currentNode.right = deleteNodeHelper(currentNode.right, currentNode.data);
            }
        }

        return currentNode;
    }

    private void deleteNode(int data) {
        root = deleteNodeHelper(root, data);
    }

    private void inorderTraversal(Node currentNode) {
        if(currentNode != null) {
            inorderTraversal(currentNode.left);
            System.out.print(currentNode.data + " ");
            inorderTraversal(currentNode.right);
        }
    }

    public static void main(String[] args) {
        Deletion deletion = new Deletion();

        deletion.insertNode(8);
        deletion.insertNode(3);
        deletion.insertNode(10);
        deletion.insertNode(1);
        deletion.insertNode(14);
        deletion.insertNode(5);
        deletion.insertNode(4);
        deletion.inorderTraversal(root);
        System.out.println();

        deletion.deleteNode(14);
        deletion.inorderTraversal(root);
        System.out.println();

        deletion.deleteNode(5);
        deletion.inorderTraversal(root);
        System.out.println();

        deletion.deleteNode(3);
        deletion.inorderTraversal(root);
        System.out.println();
    }
}

