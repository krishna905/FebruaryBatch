package DynamicProgramming;

public class ZeroOneKnapsack {
    private void print2DArray(int arr[][]) {
        System.out.println("Knapsack Array: ");

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.printf("%5d", arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private int getMaximumValue(int weight[], int value[], int W) {
        int n = weight.length;
        int knapsack[][] = new int[n + 1][W + 1];

        for(int i = 0; i <= n; i++) {
            for(int w = 0; w <= W; w++) {
                if(i == 0 || w == 0) {
                    knapsack[i][w] = 0;
                }
                else {
                    if(weight[i - 1] <= w) {
                        knapsack[i][w] = Math.max(
                                knapsack[i - 1][w],
                                value[i - 1] + knapsack[i - 1][w - weight[i - 1]]
                        );
                    }
                    else {
                        knapsack[i][w] = knapsack[i - 1][w];
                    }
                }
            }
        }

        print2DArray(knapsack);

        return knapsack[n][W];
    }

    public static void main(String[] args) {
        ZeroOneKnapsack zeroOneKnapsack = new ZeroOneKnapsack();
        int weight[] = {1, 2, 3};
        int value[] = {10, 15, 40};
        int W = 6;

        int maximumValue = zeroOneKnapsack.getMaximumValue(weight, value, W);

        System.out.println("Maximum Value: " + maximumValue);
    }
}
