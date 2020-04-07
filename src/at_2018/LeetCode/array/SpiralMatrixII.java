package at_2018.LeetCode.array;

public class SpiralMatrixII {
    public static void main(String[] args) {
        int n = 4;
        RotateImage.showMatrix(generateMatrix(n));
    }

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n == 1) {
            result[0][0] = 1;
            return result;
        }
        int u = 0;
        int d = n - 1;
        int l = 0;
        int r = n - 1;
        int index = 1;
        while (true) {
            if (u <= d && l <= r) {
                for (int i = l; i <= r; i++) {
                    result[u][i] = index;
                    index++;
                }
                u++;
                for (int i = u; i <= d; i++) {
                    result[i][r] = index;
                    index++;
                }
                r--;
                for (int i = r; i >= l; i--) {
                    result[d][i] = index;
                    index++;
                }
                d--;
                for (int i = d; i >= u; i--) {
                    result[i][l] = index;
                    index++;
                }
                l++;
            } else {
                break;
            }
        }
        return result;
    }
}
