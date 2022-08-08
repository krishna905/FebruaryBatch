package Recursion;

public class TowerOfHanoi {
    private static void solveTowerOfHanoi(int n, char source, char helper, char destination) {
        if(n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
        }
        else {
            solveTowerOfHanoi(n - 1, source, destination, helper);
            System.out.println("Move disk " + n + " from " + source + " to " + destination);
            solveTowerOfHanoi(n - 1, helper, source, destination);
        }
    }

    public static void main(String[] args) {
        int n = 3;

        solveTowerOfHanoi(n, 'S', 'H', 'D');
    }
}
