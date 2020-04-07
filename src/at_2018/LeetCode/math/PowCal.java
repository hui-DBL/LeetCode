package at_2018.LeetCode.math;

public class PowCal {
    public static void main(String[] args) {
        double x = 0.00001;
        int n = 2147483647;
        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        double result = x;
        boolean flag = n > 0;
        int N = Math.abs(n);
        for (int i = 1; i < N; i++) {
            result *= x;
        }
        if (!flag) {
            result = 1 / result;
        }
        return result;
    }
}
