package BinarySearchTree.Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReorderBinarySearchTree {
    private static final long MOD = 1000000007;
    long pascalsTriangle[][];

    private void buildPascalsTriangle(int n) {
        pascalsTriangle = new long[n][n];

        for(int i = 0; i < n; i++) {
            pascalsTriangle[i][0] = 1;
            pascalsTriangle[i][i] = 1;
        }

        for(int i = 2; i < n; i++) {
            for(int j = 1; j < i; j++) {
                pascalsTriangle[i][j] = (pascalsTriangle[i - 1][j - 1] + pascalsTriangle[i - 1][j]) % MOD;
            }
        }
    }

    private long getNumberOfWays(List<Integer> tree) {
        if(tree.size() <= 2) {
            return 1;
        }

        int root = tree.get(0);
        List<Integer> leftSubtree = new ArrayList<>();
        List<Integer> rightSubtree = new ArrayList<>();

        for(int i = 1; i < tree.size(); i++) {
            int node = tree.get(i);

            if(node < root) {
                leftSubtree.add(node);
            }
            else {
                rightSubtree.add(node);
            }
        }

        int n = leftSubtree.size() + rightSubtree.size();
        int r = leftSubtree.size();

        long result = (pascalsTriangle[n][r] * (getNumberOfWays(leftSubtree) % MOD) % MOD) * (getNumberOfWays(rightSubtree) % MOD);

        return result;
    }

    public static void main (String[] args) {
        //Your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> tree = new ArrayList<Integer>();

        for(int i = 0; i < n; i++) {
            int input = scanner.nextInt();
            tree.add(input);
        }

        ReorderBinarySearchTree reorderBST = new ReorderBinarySearchTree();
        reorderBST.buildPascalsTriangle(n + 1);
        long result = reorderBST.getNumberOfWays(tree);

        System.out.println(result);
    }
}
