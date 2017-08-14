package num15;

/**
 * Created by zhonghui on 2017/7/10.
 */
public class LongestPalindromicSubstring_2 {
    public static void main(String[] args) {
        String s = "abcbad";
        Solution_2 solution_2 = new Solution_2();
        System.out.println(solution_2.longestPalindrome(s));
    }
}

class Solution_2 {
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i >= j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        int k;
        int rt=0;
        int rl=0;
        int max=1;
        for(k=1;k<s.length();k++) {
            for(int i=0;k+i<s.length();i++) {
                int j=k+i;
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                    if (dp[i][j]) {
                        if (j - i + 1 > max) {
//                            result = s.substring(i, j + 1);//耗时较长
                            rt=i;
                            rl=j;
                            max = j - i + 1;
                        }
                    }
                }
            }
        }
        return s.substring(rt,rl+1);
    }
}
/*-----------------------------------------------------------*/