package at_2017.Before.num18;

/**
 * Created by zhonghui on 2017/7/13.
 */
public class StringtoIntegerAtoi {
    public static void main(String[] args) {
        String s = "123 456";
        Solution solution = new Solution();
        System.out.println(solution.myAtoi(s));
    }
}

class Solution {
    public int myAtoi(String str) {//都是坑，不用看了，最垃圾的解法
        if (str.length() == 0) {
            return 0;
        }
        if (str.length() == 1) {
            if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
                return str.charAt(0) - 48;
            } else {
                return 0;
            }
        }
        int len = str.length();
        int start=0;
        int end=0;
        int flag=0;
        int re=0;
        int a=0;
        int b=0;
        for(int i=0;i<len;i++) {
            if (str.charAt(i) != ' ') {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    b=1;
                    if (str.charAt(i) != '0') {
                        if (re == 0) {
                            start = i;
                            re = 1;
                        }
                        end = i;
                    } else {
                        if (i > start && re == 1) {
                            end = i;
                        }
                    }
                } else if (str.charAt(i) == '+') {
                    b=1;
                    if (a == 1) {
                        return 0;
                    }
                    flag = 0;
                    a = 1;
                } else if (str.charAt(i) == '-') {
                    b=1;
                    if (a == 1) {
                        return 0;
                    }
                    flag = 1;
                    a = 1;
                } else {
                    if (re == 1) {
                        break;
                    } else {
                        return 0;
                    }
                }
            } else {
                if (b == 1&&re==0) {
                    return 0;
                } else if (b == 1 && re != 0) {
                    break;
                }
            }
        }
        double sum=0;
        for (int i = start; i <= end; i++) {
            sum = sum + Math.pow(10, end - i) * (str.charAt(i) - 48);
        }
        if (flag == 0) {
            return (int)sum;
        } else{
            return (int) (-sum);
        }
    }
}
/*-----------------------------------------------------------*/
