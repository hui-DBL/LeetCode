package num14;

/**
 * Created by zhonghui on 2017/7/10.
 */
public class CountAndSay_1 {
    public static void main(String[] args) {
        int n = 1;
        Solution_1 solution_1 = new Solution_1();
        System.out.println(solution_1.countAndSay(n));
    }
}

class Solution_1 {
    public String countAndSay(int n) {
        String oldString = "1";
        while (--n > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] c = oldString.toCharArray();
            for (int i = 0; i < c.length; i++) {
                int count = 1;
                while ((i + 1) < c.length && c[i] == c[i + 1]) {
                    count++;
                    i++;//坑,i需要自加
                }
                stringBuilder.append(String.valueOf(count) + String.valueOf(c[i]));
            }
            oldString = stringBuilder.toString();
        }
        return oldString;
    }
}
/*-----------------------------------------------------------*/
