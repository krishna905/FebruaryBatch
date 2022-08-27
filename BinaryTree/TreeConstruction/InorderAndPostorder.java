package BinaryTree.TreeConstruction;

public class InorderAndPostorder {
    static class Node {
        Node left;
        int data;
        Node right;

        Node(int data) {
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

    private void postorderTraversal(Node root) {
        if(root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    private int search(int inorder[], int inorderStart, int inorderEnd, int key) {
        for(int i = inorderStart; i <= inorderEnd; i++) {
            if(inorder[i] == key) {
                return i;
            }
        }

        return -1;
    }

    private Node buildTree(int inorder[], int postorder[], int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {
        if(inorderStart > inorderEnd) {
            return null;
        }

        int data = postorder[postorderEnd];
        Node currentRootNode = new Node(data);

        if(inorderStart == inorderEnd) {
            return currentRootNode;
        }

        int inorderIndex = search(inorder, inorderStart, inorderEnd, data);

        currentRootNode.right = buildTree(inorder, postorder, inorderIndex + 1, inorderEnd, postorderEnd - inorderEnd + inorderIndex, postorderEnd - 1);
        currentRootNode.left = buildTree(inorder, postorder, inorderStart, inorderIndex - 1, postorderStart, postorderStart - inorderStart + inorderIndex - 1);

        return currentRootNode;
    }

    public static void main(String[] args) {
        InorderAndPostorder inorderAndPostorder = new InorderAndPostorder();

        int inorder[] = {4, 8, 2, 5, 1, 6, 3, 7};
        int postorder[] = {8, 4, 5, 2, 6, 7, 3, 1};

        int size = inorder.length;

        Node root = inorderAndPostorder.buildTree(inorder, postorder, 0, size - 1, 0, size - 1);

        System.out.println("Inorder Traversal of the built tree: ");
        inorderAndPostorder.inorderTraversal(root);

        System.out.println();

        System.out.println("Postorder Traversal of the built tree: ");
        inorderAndPostorder.postorderTraversal(root);
    }
}










//Simplified Code
import java.util.*;

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val=val;
    }
}
class Main{
    static int n=0;
    static int postOrderIdx;
    public static void main(String args[]){
        int inOrder[]={4,2 ,5, 1, 3 };
        int postOrder[]={4, 5, 2, 3, 1};
        n=inOrder.length;
        postOrderIdx=n-1;

         Node root=binaryTree(inOrder, postOrder, 0,n-1);
         System.out.println("inorder traversal is: ");
         inOrderTraversal(root);
         System.out.println();
          System.out.println("postorder traversal is: ");
         postOrderTraversal(root);        
    }
     public static void inOrderTraversal(Node root){
        if(root!=null){
             inOrderTraversal(root.left);
             System.out.print(root.val+" ");
            
             inOrderTraversal(root.right);

        }
    }
     public static void postOrderTraversal(Node root){
        if(root!=null){
            
             postOrderTraversal(root.left);
             postOrderTraversal(root.right);
              System.out.print(root.val+" ");

        }
    }
    public static Node binaryTree(int inorder[], int postorder[], int inStart, int inEnd){
        if(inStart>inEnd)
            return null;

        int data = postorder[postOrderIdx];
        Node curRootnode = new Node(data);
        postOrderIdx--;
        int inorderIndex = search(inorder, inStart, inEnd, data);
        curRootnode.right = binaryTree(inorder, postorder, inorderIndex+1,inEnd);
        curRootnode.left = binaryTree(inorder, postorder, inStart, inorderIndex-1);
        return curRootnode;
    }

     public static int search(int[] inOrder, int inStart, int inEnd, int key){

        for(int i=inStart; i<=inEnd;i++){
            if(key==inOrder[i])
            return i;
        }
        return -1;
    }
}
