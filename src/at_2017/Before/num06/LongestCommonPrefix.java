package at_2017.Before.num06;

/**
 * Created by zhonghui on 2017/7/3.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] s = new String[2];
        s[0] = "aca";
        s[1] = "acba";
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(s));
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        } else if (len == 1) {//坑，数组只有一个
            return strs[0];
        }
        int index = -1;
        for (int i = 0; i < strs[0].length(); i++) {
            int temp = 0;
            int flag=0;
            for (int j = 1; j < len; j++) {
                if (strs[j].length() == 0) {
                    return "";
                } else {
                    if (i >= strs[j].length()) {
                        i = strs[0].length();
                        break;
                    } else {
                        if (strs[0].charAt(i) == strs[j].charAt(i)) {//坑，要都相等才算
                            temp++;
                        } else {//一个不相等就跳
                            flag++;
                        }
                    }

                }
            }
            if (temp == len-1) {//坑，要都相等才算
                index = i;
            }
            if (flag >= 0) {//一个不相等就跳
                i=i = strs[0].length();
            }
        }
        if (index == 0) {//第一个相等的话，char+"" 转化为String
            return strs[0].charAt(0) + "";
        } else if (index == -1) {
            return "";
        } else {
            return strs[0].substring(0, index + 1);//substring的范围不包括后面的
        }

    }
}
/*-----------------------------------------------------------*/

