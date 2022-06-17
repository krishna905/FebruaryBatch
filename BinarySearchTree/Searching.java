package BinarySearchTree;

public class Searching {
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

    private void searchNode(int data) {
        Node searchResult = null;

        Node current = root;

        while(current != null) {
            if(data > current.data) {
                current = current.right;
            }
            else if(data < current.data) {
                current = current.left;
            }
            else {
                searchResult = current;
                break;
            }
        }

        if(searchResult != null) {
            System.out.println(data + " found");
        }
        else {
            System.out.println(data + " not found");
        }
    }

    public static void main(String[] args) {
        Searching searching = new Searching();

        searching.insertNode(8);
        searching.insertNode(3);
        searching.insertNode(10);
        searching.insertNode(1);
        searching.insertNode(14);

        searching.searchNode(10);
        searching.searchNode(14);
        searching.searchNode(4);
    }
}
