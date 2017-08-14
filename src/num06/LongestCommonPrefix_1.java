package num06;

/**
 * Created by zhonghui on 2017/7/3.
 */
public class LongestCommonPrefix_1 {
    public static void main(String[] args) {
        String[] s = new String[3];
        s[0] = "a";
        s[1] = "a";
        s[2] = "b";
        Solution_1 solution_1 = new Solution_1();
        System.out.println(solution_1.longestCommonPrefix(s));
    }
}

class Solution_1 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String s = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < strs[i].length() && j < s.length() && strs[i].charAt(j) == s.charAt(j)) {
                j++;
            }
            if (j == 0) {
                return "";
            }
            s = s.substring(0, j);//注意这一步，一步一步扩大前缀，步步为营，不是前缀即跳出
        }
        return s;
    }
}
/*-----------------------------------------------------------*/