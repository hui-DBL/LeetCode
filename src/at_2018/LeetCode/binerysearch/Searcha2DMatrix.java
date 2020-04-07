package at_2018.LeetCode.binerysearch;

public class Searcha2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0 || n == 0) {
            return false;
        }
        int r = 0;
        for (int i = 0; i < m; i++) {
            int tmp = matrix[i][0];

            if (target <= tmp) {
                if (target == tmp) {
                    return true;
                }
                if (i == 0) {
                    return false;
                }
                r = i - 1;
                break;
            } else {
                if (i == m - 1) {
                    r = i;
                }
            }
        }

        int min = 0;
        int max = n;
        while (true) {
            if (min > max) {
                break;
            }
            int halfN = (max + min) / 2;
            if (halfN > n-1) {
                return false;
            }
            int tmp = matrix[r][halfN];
            if (tmp > target) {
                max = halfN - 1;
            } else if (tmp == target) {
                return true;
            } else {
                min = halfN + 1;
            }
        }
        return false;
    }
}
