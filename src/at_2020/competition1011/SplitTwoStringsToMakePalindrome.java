package at_2020.competition1011;

/**
 * @author hui.zhong
 * @date 2020/10/11
 */
public class SplitTwoStringsToMakePalindrome {

    public static void main(String[] args) {
        System.out.println(checkPalindromeFormation("xbdef", "xecab"));
    }

    public static boolean checkPalindromeFormation(String a, String b) {
        if (isPalindrome(a) || isPalindrome(b)) {
            return true;
        }
        int len = a.length();
        for (int i = 0; i <= len; i++) {
            String aPre = a.substring(0, i);
            String aSuf = a.substring(i, len);

            String bPre = b.substring(0, i);
            String bSuf = b.substring(i, len);
            if (isPalindrome(aPre + bSuf) || isPalindrome(bPre + aSuf)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
