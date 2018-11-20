package LeetCode.math;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
                if ((dividend / divisor) < 0) {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return dividend / divisor;
    }
}
