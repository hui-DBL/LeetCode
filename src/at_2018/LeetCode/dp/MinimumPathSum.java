package at_2018.LeetCode.dp;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        if (m == 1 && n == 1) {
            return grid[0][0];
        }

        int[][] step = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    step[i][j] = grid[i][j];
                    continue;
                }

                if (i == 0) {
                    step[i][j] = step[i][j - 1] + grid[i][j];
                    continue;
                }

                if (j == 0) {
                    step[i][j] = step[i - 1][j] + grid[i][j];
                    continue;
                }

                step[i][j] = Math.min(step[i - 1][j] + grid[i][j], step[i][j - 1] + grid[i][j]);
            }
        }

        return step[m - 1][n - 1];
    }
}
