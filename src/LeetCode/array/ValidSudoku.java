package LeetCode.array;

import java.util.*;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board =
                       {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> Linemap = new HashMap<>(9);

        Map<Integer, Set<Character>> areaMap = new HashMap<>(9);
        for (int i = 0; i < board.length; i++) {
            Set<Character> boardRowChar = new HashSet<>(9);

            for (int j = 0; j < board[i].length; j++) {
                // row
                if (board[i][j] == '.') {
                    continue;
                }

                if (boardRowChar.contains(board[i][j])) {
                    return false;
                }
                boardRowChar.add(board[i][j]);
                // line
                Set<Character> boardLineChar = Linemap.get(j) == null ? new HashSet<>(9) : Linemap.get(j);
                if (boardLineChar.contains(board[i][j])) {
                    return false;
                }
                boardLineChar.add(board[i][j]);
                Linemap.put(j, boardLineChar);
                // area
                Integer index = 0;
                if (i / 3 == 0 && j / 3 == 0) {
                    index = 0;
                } else if (i / 3 == 0 && j / 3 == 1) {
                    index = 1;
                } else if (i / 3 == 0 && j / 3 == 2) {
                    index = 2;
                } else if (i / 3 == 1 && j / 3 == 0) {
                    index = 3;
                } else if (i / 3 == 1 && j / 3 == 1) {
                    index = 4;
                } else if (i / 3 == 1 && j / 3 == 2) {
                    index = 5;
                } else if (i / 3 == 2 && j / 3 == 0) {
                    index = 6;
                } else if (i / 3 == 2 && j / 3 == 1) {
                    index = 7;
                } else if (i / 3 == 2 && j / 3 == 2) {
                    index = 8;
                }
                Set<Character> boardAreaChar = areaMap.get(index) == null ? new HashSet<>(9) : areaMap.get(index);
                if (boardAreaChar.contains(board[i][j])) {
                    return false;
                }
                boardAreaChar.add(board[i][j]);
                areaMap.put(index, boardAreaChar);
            }
        }
        return true;
    }
}
