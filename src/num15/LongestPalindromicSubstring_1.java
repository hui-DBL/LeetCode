package num15;

/**
 * Created by zhonghui on 2017/7/10.
 */
public class LongestPalindromicSubstring_1 {
    public static void main(String[] args) {
        String s = "aba";
        Solution_1 solution_1 = new Solution_1();
        System.out.println(solution_1.longestPalindrome(s));
    }
}

class Solution_1 {
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s == null) {
            return "";
        }
        int len = s.length();
        int max = 0;
        String result = "";
        for (int i = 1; i <= 2 * len - 1; i++) {
            int count=1;
            while (i - count >= 0 && i + count <= 2*len && getChar(s, i - count) == getChar(s, i + count)) {//确保都能比对到
                count++;
            }
            count--;
            if (count > max) {
                result = s.substring((i - count )/ 2, (i + count )/ 2);
                max=count;
            }
        }
        return result;
    }

    public char getChar(String s, int i) {
        if (i % 2 == 0) {//相邻的不比较
            return '#';
        } else {
            return s.charAt(i / 2);
        }
    }
}
/*-----------------------------------------------------------*/

