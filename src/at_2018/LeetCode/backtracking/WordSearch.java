package at_2018.LeetCode.backtracking;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCDE";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        if (word == null || "".equals(word)) {
            return true;
        }
        int m = board.length;
        if (m == 0) {
            return false;
        }
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    // 开头
                    int[][] validBoard = new int[m][n];
                    validBoard[i][j] = 1;
                    if (stSearch(i, j, board, word, 1, validBoard)) {
                        return true;
                    }
                    validBoard[i][j] = 0;
                }
            }
        }
        return false;
    }

    private static boolean stSearch(int i, int j, char[][] board, String word, int k, int[][] validBoard) {
        int m = board.length;
        int n = board[0].length;

        if (k > word.length()) {
            return false;
        }

        if (k == word.length()) {
            return true;
        }

        if (i - 1 >= 0) {
            if (board[i - 1][j] == word.charAt(k) && validBoard[i - 1][j] != 1) {
                validBoard[i - 1][j] = 1;
                if (stSearch(i - 1, j, board, word, k + 1, validBoard)) {
                    return true;
                }
                validBoard[i - 1][j] = 0;
            }
        }

        if (j - 1 >= 0) {
            if (board[i][j - 1] == word.charAt(k) && validBoard[i][j - 1] != 1) {
                validBoard[i][j - 1] = 1;
                if (stSearch(i, j - 1, board, word, k + 1, validBoard)) {
                    return true;
                }
                validBoard[i][j - 1] = 0;
            }
        }

        if (i + 1 <= m - 1) {
            if (board[i + 1][j] == word.charAt(k) && validBoard[i + 1][j] != 1) {
                validBoard[i + 1][j] = 1;
                if (stSearch(i + 1, j, board, word, k + 1, validBoard)) {
                    return true;
                }
                validBoard[i + 1][j] = 0;
            }
        }

        if (j + 1 <= n - 1) {
            if (board[i][j + 1] == word.charAt(k) && validBoard[i][j + 1] != 1) {
                validBoard[i][j + 1] = 1;
                if (stSearch(i, j + 1, board, word, k + 1, validBoard)) {
                    return true;
                }
                validBoard[i][j + 1] = 0;
            }
        }

        return false;
    }
}
