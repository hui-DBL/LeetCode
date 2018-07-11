package Before.num03;

/**
 * Created by zhonghui on 2017/6/30.
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        int x = 121;
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(x));
    }
}


class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int reverseInteger = 0;
        int target=x;
        while (x != 0) {
            int temp = reverseInteger * 10 + x % 10;
            x = x / 10;
            reverseInteger = temp;
        }

        if (reverseInteger == target) {
            return true;
        } else {
            return false;
        }
    }
}
/*-----------------------------------------------------------*/
