package LeetCode.array;

import util.MatrixUtil;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        MatrixUtil.showMatrix(matrix);
        setZeroes(matrix);
        System.out.println();
        MatrixUtil.showMatrix(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<String> list = new ArrayList<>(m + n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    list.add(i + "," + j);
                }
            }
        }

        delToZero(matrix,list);
    }

    private static void delToZero(int[][] matrix, List<String> list) {
        for (String i : list) {
            String[] strs = i.split(",");
            int m = Integer.valueOf(strs[0]);
            int n = Integer.valueOf(strs[1]);
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    if (j == m || k == n) {
                        matrix[j][k] = 0;
                    }
                }
            }
        }
    }
}
