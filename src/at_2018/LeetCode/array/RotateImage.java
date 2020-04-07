package at_2018.LeetCode.array;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        showMatrix(matrix);
        rotate(matrix);
        showMatrix(matrix);
    }

    public static void showMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf(String.valueOf(matrix[i][j]));
                if (j < matrix[i].length - 1) {
                    System.out.printf(",");
                }
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        if (matrix.length <= 1) {
            return;
        }
        int N = matrix.length;
        int[][] flag = new int[N][N];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int x = j;
                int y = N - i - 1;
                if (flag[i][j] != 1) {
                    int tmp = matrix[x][y];
                    matrix[x][y] = matrix[i][j];
                    matrix[i][j] = tmp;
                    flag[i][j] = 1;
                    flag[x][y] = 1;
                }
            }
        }
    }
}
