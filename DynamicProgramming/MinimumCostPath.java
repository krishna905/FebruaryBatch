package DynamicProgramming;

public class MinimumCostPath {
    private void print2DMatrix(int arr[][]) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.printf("%3d", arr[i][j]);
            }
            System.out.println();
        }
    }

    private int calculateMinimumCostToXY(int cost[][], int x, int y) {
        int totalCost[][] = new int[x + 1][y + 1];

        totalCost[0][0] = cost[0][0];

        //first column
        for(int i = 1; i <= x; i++) {
            totalCost[i][0] = totalCost[i - 1][0] + cost[i][0];
        }

        //first row
        for(int i = 1; i <= y; i++) {
            totalCost[0][i] = totalCost[0][i - 1] + cost[0][i];
        }

        //others
        for(int i = 1; i <= x; i++) {
            for(int j = 1; j <= y; j++) {
                /*
                i - 1, j - 1
                i - 1, j
                i, j - 1
                 */
                totalCost[i][j] = Math.min(
                        Math.min(totalCost[i][j - 1], totalCost[i - 1][j]),
                totalCost[i - 1][j - 1]) + cost[i][j];
            }
        }

        System.out.println("Total Cost: ");
        print2DMatrix(totalCost);

        return totalCost[x][y];
    }

    public static void main(String[] args) {
        MinimumCostPath minimumCostPath = new MinimumCostPath();

        int m = 4, n = 5;
        int cost[][] = new int[m][n];
        int x = 3, y = 4;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int currentCost = (int)(Math.random() * 10 + 1);
                cost[i][j] = currentCost;
            }
        }

        System.out.println("Cost: ");
        minimumCostPath.print2DMatrix(cost);

        int minimumCostToXY = minimumCostPath.calculateMinimumCostToXY(cost, x, y);

        System.out.println("Minimum Cost from (0, 0) to (" + x + ", " + y + "): " + minimumCostToXY);
    }
}
