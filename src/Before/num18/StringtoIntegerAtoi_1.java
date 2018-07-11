package Before.num18;

/**
 * Created by zhonghui on 2017/7/13.
 */
public class StringtoIntegerAtoi_1 {
    public static void main(String[] args) {
        String s = "+";
        Solution_1 solution_1 = new Solution_1();
        System.out.println(solution_1.myAtoi(s));
    }
}

class Solution_1 {
    public int myAtoi(String str) {//理解题意很重要
        if (str.length() == 0) {
            return 0;
        }
        String s = str.trim();
        int signal = 1;
        int index = 0;
        if (s.charAt(index) == '+') {
            signal = 1;
            index++;
        } else if (s.charAt(index) == '-') {
            signal = -1;
            index++;
        }
        long sum = 0;//防止越界
        for (; index < s.length(); index++) {
            if (s.charAt(index) < '0' || s.charAt(index) > '9') {
                break;
            }
            sum = sum * 10 + s.charAt(index) - 48;
            if (sum > Integer.MAX_VALUE) {
                break;
            }
        }
        if (sum * signal > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (sum * signal < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)(sum * signal);
    }
}
/*-----------------------------------------------------------*/


