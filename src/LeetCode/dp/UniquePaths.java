package LeetCode.dp;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
    }

    public static int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];
        map[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    map[i][j] = 1;
                    continue;
                }
                if (j == 0) {
                    map[i][j] = 1;
                    continue;
                }
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
        return map[m - 1][n - 1];
    }
}
