package Backtracking;

import java.util.Scanner;

public class BeautifulArrangement {
    private int count;
    private void getBeautifulArrangementCount(int N, int start, boolean visited[]) {
        if(start > N) {
            count++;
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i] && (start % i == 0 || i % start == 0)) {
                visited[i] = true;
                getBeautifulArrangementCount(N, start + 1, visited);
                visited[i] = false;
            }
        }
    }

    public static void main (String[] args) {
        // Your code here
        Scanner scanner = new Scanner(System.in);
        BeautifulArrangement beautifulArrangement = new BeautifulArrangement();
        int N = scanner.nextInt();

        boolean visited[] = new boolean[N + 1];

        beautifulArrangement.count = 0;
        beautifulArrangement.getBeautifulArrangementCount(N, 1, visited);

        System.out.print(beautifulArrangement.count);
    }
}
