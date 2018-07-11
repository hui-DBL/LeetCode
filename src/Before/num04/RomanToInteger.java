package Before.num04;

/**
 * Created by zhonghui on 2017/6/30.
 */
public class RomanToInteger {
    public static void main(String[] args) {
        String s = "MMMDLXXXVI";
        Solution solution = new Solution();
        System.out.println(solution.romanToInt(s));
    }
}

class Solution {
    public int romanToInt(String s) {
        int len = s.length();
        int sum = 0;
        if (len == 1) {
            sum = romanNum(s.charAt(0));
        } else if (len > 1) {
            for (int i = 0; i < len; i++) {
                if (maxOfTwo(s.charAt(i), s.charAt(i + 1)) == 1) {
                    sum = sum + romanNum(s.charAt(i));
                    if (i + 1 == len - 1) {//注意这里
                        sum = sum + romanNum(s.charAt(i + 1));
                        return sum;
                    }
                } else if (maxOfTwo(s.charAt(i), s.charAt(i + 1)) == 2) {
                    sum = sum + romanNum(s.charAt(i + 1)) - romanNum(s.charAt(i));
                    if (i + 2 == len - 1) {//注意这里以及下面i+2,溢出判断
                        sum = sum + romanNum(s.charAt(i + 2));
                        return sum;
                    } else {
                        i++;
                    }
                }

            }
        }
        return sum;
    }

    public int romanNum(char s) {
        switch (s) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

    public int midIndix(char a, char b, char c) {
        int t1 = romanNum(a);
        int t2 = romanNum(b);
        int t3 = romanNum(c);
        if (t1 > t2) {
            if (t2 > t3) {
                return 2;
            } else {
                return 3;
            }
        } else {
            if (t1 > t3) {
                return 1;
            } else {
                return 3;
            }
        }
    }

    public int maxOfTwo(char a, char b) {
        if (romanNum(a) >= romanNum(b)) {
            return 1;
        } else if (romanNum(a) < romanNum(b)) {
            return 2;
        }
        return 0;
    }

}
/*-----------------------------------------------------------*/
