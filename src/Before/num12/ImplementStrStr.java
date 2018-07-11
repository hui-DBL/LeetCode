package Before.num12;

/**
 * Created by zhonghui on 2017/7/6.
 */
public class ImplementStrStr {
    public static void main(String[] args) {
        String haystack = "abcdefg";
        String needle = "cd";
        Solution solution = new Solution();
        System.out.println(solution.strStr(haystack, needle));
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
        } else if (needle.length() == 0) {//空集为任何非空集的子集
            return 0;
        }
        int lenHay = haystack.length();
        int lenNeedle = needle.length();
        int j = 0;
        int temp = 0;
        int result = -1;
        for (int i = 0; i < lenHay; i++) {
            temp = i;
            while (j < lenNeedle && temp < lenHay) {
                if (haystack.charAt(temp) == needle.charAt(j)) {//首字母相等才有往后走的必要
                    j++;
                    temp++;
                    if (j == lenNeedle) {
                        return i;
                    }
                } else {
                    j = lenNeedle;
                }
            }
            j = 0;
        }
        return result;
    }
}
/*-----------------------------------------------------------*/