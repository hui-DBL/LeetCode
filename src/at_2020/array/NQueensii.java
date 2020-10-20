package at_2020.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hui.zhong
 * @date 2020/10/17
 */
public class NQueensii {
    public static void main(String[] args) {
        System.out.println(totalNQueens(4));

    }

    public static int totalNQueens(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        }

        Set<Integer> left = new HashSet<>(n);
        Set<Integer> right = new HashSet<>(n);
        Set<Integer> decLine = new HashSet<>(n);
        Set<Integer> addLine = new HashSet<>(n);
        return calNext(left, right, decLine, addLine, n, 0);
    }

    private static int calNext(Set<Integer> left, Set<Integer> right, Set<Integer> decLine, Set<Integer> addLine,
                               int n, int line) {
        if (line == n) {
            if (left.size() == n) {
                return 1;
            } else {
                return 0;
            }
        }
        int result = 0;
        for (int j = 0; j < n; j++) {
            if (left.contains(line) || right.contains(j)
                    || decLine.contains(j - line) || addLine.contains(line + j)) {
                continue;
            }
            left.add(line);
            right.add(j);
            decLine.add(j - line);
            addLine.add(line + j);

            result = result + calNext(left, right, decLine, addLine, n, line + 1);
            left.remove(line);
            right.remove(j);
            decLine.remove(j - line);
            addLine.remove(line + j);
        }
        return result;
    }
}
