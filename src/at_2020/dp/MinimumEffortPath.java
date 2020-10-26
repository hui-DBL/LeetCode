package at_2020.dp;

/**
 * @author hui.zhong
 * @date 2020/10/25
 */
public class MinimumEffortPath {

    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(minimumEffortPath(heights));

    }

    public static int minimumEffortPath(int[][] heights) {
        int[][] result = new int[heights.length][heights[0].length];
        int m = 0;
        int n = 0;
        result[m][n] = 0;
        result[m + 1][n] = heights[m + 1][n] - heights[0][0];
        result[m][n + 1] = heights[m][n + 1] - heights[0][0];
        m++;
        n++;
        while (m < heights.length || n < heights[0].length) {
            if (m >= heights.length) {
                n++;
            }
            if (n >= heights[0].length) {
                m++;
            }
            result[m][n] = Math.min(
                    Math.max(result[m - 1][n], heights[m][n] - heights[m - 1][n]),
                    Math.max(result[m][n - 1], heights[m][n] - heights[m][n - 1]));
            if (m <= n) {
                m++;
            } else {
                n++;
            }
        }

        return result[m][n];
    }
}
