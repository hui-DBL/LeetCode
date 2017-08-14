package num15;

/**
 * Created by zhonghui on 2017/7/10.
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "ab";
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome(s));
    }
}

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return null;
        }
//        String a = new String();
        int st = 0;
        int sl = 0;
        int flag;
        for (flag = 0; flag < s.length(); flag++) {
//            if (s.length() - flag < sl - st + 1) {
////                return a;
//                return s.substring(st, sl + 1);
//            }
            for (int i = s.length(); i >= flag; i--) {
//                if (i - flag < sl - st + 1) {
//                    break;
//                }
                if (isPalindrome(s.substring(flag, i))) {//三层循环超时
//                    if (i - flag > a.length()) {
//                        a = s.substring(flag, i);
                    if (i - flag > sl - st) {
                        st = flag;
                        sl = i;
                    }
                }
            }
        }
        return s.substring(st, sl);
    }

    public boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        int mid = s.length() / 2;
        int start = 0;
        int end = 0;
        if (s.length() % 2 == 0) {
            start = mid - 1;
            end = mid;
        } else {
            start = mid - 1;
            end = mid + 1;
        }
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            } else {
                start--;
                end++;
            }
        }
        return true;
//        int start = 0;
//        int end = s.length() - 1;
//        for (int i = 0; i < s.length(); i++) {
//            if (start >= end) {
//                return true;
//            }
//            if (s.charAt(start) == s.charAt(end)) {
//                start++;
//                end--;
//            } else {
//                return false;
//            }
//        }
//        return false;
    }
}
