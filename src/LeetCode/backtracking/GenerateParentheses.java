package LeetCode.backtracking;

import util.ListUtil;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        ListUtil.showList(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        parenthesisHelp("(", i, j, n, sb, list);
        return list;
    }

    private static void parenthesisHelp(String s, int i, int j, int n, StringBuilder sb, List<String> list) {
        if (i == n) {
            StringBuilder tmp = new StringBuilder();
            tmp.append(sb);
            list.add(tmp.toString());
            return;
        }

        for (int k = i; k < n; k++) {
            sb.append(s);
            parenthesisHelp("(", k + 1, 0, n, sb, list);
            parenthesisHelp(")", k + 1, n - k, n, sb, list);
        }
    }
}