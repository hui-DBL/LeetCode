package Before.num25;

/**
 * Create by hui on 2017/8/17
 */
public class PlusOne1 {
    public static void main(String[] args) {
        int[] digits = {0};
        Solution1 solution1 = new Solution1();
        int[] result = solution1.plusOne(digits);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }
}

class Solution1 {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0 || digits == null) {
            int[] result = {1};
            return result;
        }
        int isCarry = 1;
        for (int i = digits.length - 1; i >= 0 && isCarry == 1; i--) {
            int temp = digits[i];
            temp = temp + 1;
            digits[i] = temp % 10;
            isCarry = temp / 10;
        }
        if (isCarry == 1) {
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
