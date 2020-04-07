package at_2018.LeetCode.backtracking;

/**
 * String,Dynamic Programming,Backtracking
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        String s = "aaa";
        String p = "a*a";

//        s = "mississippi";
//        p = "mis*is*p*.";
//        s = "aab";
//        p = "c*a*b";
//        s = "ab";
//        p = ".*";
        s = "aa";
        p = "a";
//        s = "ab";
//        p = ".*";
//        s = "";
//        p = ".*";
//        s = "aa";
//        p = "a*";
//        s = "abcd";
//        p = "d*";
//        s = "aaa";
//        p = "ab*a*c*a";
//        s = "aaa";
//        p = "a*";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        return matchHelper(s, p, 0, 0);
    }

    private static boolean matchHelper(String s, String p, int i, int j) {

        if (j == p.length()) {
            return i == s.length();
        }

        // j+1 != *
        if (j == p.length() - 1||p.charAt(j+1) != '*') {

            if (i == s.length()||s.charAt(i) != p.charAt(j) && p.charAt(j) != '.') {
                return false;
            } else {
                return matchHelper(s, p, i + 1, j + 1);
            }
        }

        // j+1 = *
        while (i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) {
            if (matchHelper(s, p, i, j + 2)) {
                return true;
            }
            i++;
        }

        return matchHelper(s, p, i, j + 2);
    }
}
