package DivideAndConquer;

import java.util.Scanner;

public class LogicalSearchDecreaseAndConquer {
    public static void main (String[] args) {
        // Your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int start = 0, end = n - 1;
        int difference = (arr[end] - arr[start]) / n;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if((mid + 1 < n) && (arr[mid + 1] - arr[mid] != difference)) {
                System.out.println(arr[mid + 1] - difference); //(arr[mid] + difference);
                break;
            }

            if((mid - 1 >= 0) && (arr[mid] - arr[mid - 1] != difference)) {
                System.out.println(arr[mid - 1] + difference); //return (arr[mid] - difference);
                break;
            }

            if(arr[mid] - arr[0] != (mid * difference)) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
    }
}
