package BinaryTree.TreeConstruction;

public class InorderAndPreorder {
    int preorderIndex;
    static class Node {
        Node left;
        char data;
        Node right;

        Node(char data) {
            this.data = data;
        }
    }

    private void inorderTraversal(Node root) {
        if(root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }

    private int search(char inorder[], int inorderStart, int inorderEnd, char key) {
        for(int i = inorderStart; i <= inorderEnd; i++) {
            if(inorder[i] == key) {
                return i;
            }
        }

        return -1;
    }

    private Node buildTree(char inorder[], char preorder[], int inorderStart, int inorderEnd) {
        if(inorderStart > inorderEnd) {
            return null;
        }

        char data = preorder[preorderIndex];
        Node currentRootNode = new Node(data);
        preorderIndex++;

        //Node currentRootNode = new Node(preorder[preorderIndex++]);

        if(inorderStart == inorderEnd) {
            return currentRootNode;
        }

        int inorderIndex = search(inorder, inorderStart, inorderEnd, data);

        currentRootNode.left = buildTree(inorder, preorder, inorderStart, inorderIndex - 1);
        currentRootNode.right = buildTree(inorder, preorder, inorderIndex + 1, inorderEnd);

        return currentRootNode;
    }

    public static void main(String[] args) {
        InorderAndPreorder inorderAndPreorder = new InorderAndPreorder();

        char inorder[] = {'D', 'B', 'E', 'A', 'F', 'C'};
        char preorder[] = {'A', 'B', 'D', 'E', 'C','F'};

        int length = inorder.length;

        inorderAndPreorder.preorderIndex = 0;

        Node root = inorderAndPreorder.buildTree(inorder, preorder, 0, length - 1);

        System.out.println("Inorder traversal of the constructed tree: ");
        inorderAndPreorder.inorderTraversal(root);
    }
}