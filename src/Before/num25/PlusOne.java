package Before.num25;

/**
 * Create by hui on 2017/8/17
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {1,9};
        Solution solution = new Solution();
        int[] result = solution.plusOne(digits);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0 || digits == null) {
            int[] result = {1};
            return result;
        }
        int sign = 1;
        boolean isCarry =false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (sign == 1) {
                digits[i] = digits[i] + 1;
                sign = 0;
                if (digits[i] > 9) {
                    digits[i] = digits[i] % 10;
                    sign = 1;
                    if (i == 0) {
                        isCarry = true;
                    }
                }
            }
        }
        if (isCarry) {
            digits = carry(digits);
        }
        return digits;
    }

    public int[] carry(int[] digits) {
        int n = digits.length;
        int len = n + 1;
        int[] result = new int[len];
        result[0] = 1;
        for (int i = 0; i < n; i++) {
            result[i + 1] = digits[i];
        }
        return result;
    }
}
/*-----------------------------------------------------------*/
