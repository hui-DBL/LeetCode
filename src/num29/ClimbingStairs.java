package num29;

/**
 * Create by hui on 2017/8/21
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 4;
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(n));;
    }
}

class Solution {
    public int climbStairs(int n) {
        int num2 = n / 2;
        int ways = 1;
        if (num2 > 0) {
            for (int i = 1; i <= num2; i++) {
                int num1 = n - 2 * i;//不会有负数
                int Mo = computeCombin(i + num1);
                int De = computeCombin(i) * computeCombin(num1);
                int step = Mo / De;
                ways = ways + step;
            }
        } else {
            return 1;
        }
        return ways;
    }

    public int computeCombin(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * computeCombin(n - 1);
        }
    }
}
