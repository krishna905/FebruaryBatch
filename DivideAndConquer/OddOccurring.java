package DivideAndConquer;

import java.util.Scanner;

public class OddOccurring {
    public static void main (String[] args) {
        // Your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int left = 0, right = n - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(mid % 2 == 0) {
                if(arr[mid] == arr[mid + 1]) {
                    left = mid + 2;
                }
                else {
                    right = mid;
                }
            }
            else {
                if(arr[mid] == arr[mid - 1]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }

        System.out.println(arr[left]);
    }
}
