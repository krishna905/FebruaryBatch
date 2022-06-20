/*
Author: Yash Kumar Chandrakar
 */

package DivideAndConquer;

import java.util.Scanner;

public class LogicalSearchDivideAndConquer {
    public static int solve(int []arr, int start, int end, int diff){
        if(start > end){
            return 0;
        }
        int mid = (end + start) / 2;
        if(mid != 0 && arr[mid] - arr[mid - 1] != diff){
            return arr[mid] - diff;
        }
        return solve(arr, start, mid - 1,diff) +
                solve(arr, mid + 1, end, diff);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int difference = (arr[n - 1] - arr[0]) / n;
        int result = solve(arr, 0, n - 1, difference);

        System.out.println(result);
    }
}
