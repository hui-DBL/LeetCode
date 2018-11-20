package LeetCode.dp;

public class UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] map = new int[m][n];
        map[0][0] = 1;

        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    map[i][j] = 0;
                    continue;
                }
                if (i == 0) {
                    map[i][j] = map[i][j - 1];
                    continue;
                }
                if (j == 0) {
                    map[i][j] = map[i - 1][j];
                    continue;
                }
                if (map[i - 1][j] != 0) {
                    map[i][j] = map[i - 1][j];
                }
                if (map[i][j - 1] != 0) {
                    map[i][j] += map[i][j - 1];
                }
            }
        }
        return map[m - 1][n - 1];
    }
}
