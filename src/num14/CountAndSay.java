package num14;

/**
 * Created by zhonghui on 2017/7/8.
 */
public class CountAndSay {
    public static void main(String[] args) {
        int n = 1;
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(n));
    }
}

class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return 1 + "";
        } else if (n == 0) {
            return null;
        }
        n = n - 1;
        String result = new String();
        int flag = 1;
        String s = new String();
        s = flag + "";
        while (flag <= n) {
            result = "";
            int j = 0;
            int[] count = new int[s.length()];
            int[] say = new int[s.length()];
            int m = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(m)) {
                    count[j]++;
                    say[j] = (int) (s.charAt(m) - 48);
                } else {
                    j++;
                    m = i;
                    i--;
                }
            }
            for (int ii = 0; ii <= j; ii++) {
                result = result + "" + count[ii] + "" + say[ii];
            }
            s = result;
            flag++;
        }
        return result;
    }
}
/*-----------------------------------------------------------*/