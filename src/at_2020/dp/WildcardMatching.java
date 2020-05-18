package at_2020.dp;


/**
 * @author hui.zhong
 * @date 2020-04-27
 */
public class WildcardMatching {

    public static void main(String[] args) {
        System.out.println(isMatch_1("aa", "a"));
    }

    public static boolean isMatch_1(String s, String p) {
        int s_len = s.length();
        int p_len = p.length();
        boolean[][] match = new boolean[s_len + 1][p_len + 1];
        match[0][0] = true;
        for (int i = 1; i <= p_len; i++) {
            if (p.charAt(i - 1) == '*') {
                // 无限延伸
                match[0][i] = match[0][i - 1];
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    // 任意或空
                    match[i][j] = match[i - 1][j] || match[i][j - 1];
                } else if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    match[i][j] = match[i - 1][j - 1];
                }
            }
        }
        return match[s_len][p_len];
    }

    public static boolean isMatch(String s, String p) {
        int s_i = 0;
        int p_i = 0;
        int s_star = -1;
        int p_star = -1;
        int s_len = s.length();
        int p_len = p.length();

        // 匹配完所有的s
        while (s_i < s_len) {
            if (p_i < p_len && (s.charAt(s_i) == p.charAt(p_i) || p.charAt(p_i) == '?')) {
                s_i++;
                p_i++;
            } else if (p_i < p_len && (p.charAt(p_i) == '*')) {
                s_star = s_i;
                p_star = ++p_i;
            } else if (s_star >= 0) {
                p_i = p_star;
                s_i = ++s_star;
            } else {
                break;
            }
        }

        // p中不能有剩余
        while (p_i < p_len && p.charAt(p_i) == '*') {
            p_i++;
        }

        return p_i == p_len && s_i == s_len;
    }

}
