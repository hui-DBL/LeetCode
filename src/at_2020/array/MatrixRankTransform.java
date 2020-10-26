package at_2020.array;

/**
 * @author hui.zhong
 * @date 2020/10/25
 */
public class MatrixRankTransform {

    public static void main(String[] args) {

    }

    public static int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] results = new int[m][n];

        int minM = 0;
        int minN = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                if (tmp < matrix[minM][minN]) {
                    minM = i;
                    minN = j;
                }
            }
        }
        results[minM][minN] = 1;

        return results;
    }
}
