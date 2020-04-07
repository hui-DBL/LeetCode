package at_2017.Before.num29;

/**
 * Create by hui on 2017/8/21
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 38;
        Solution solution = new Solution();
//        System.out.println(solution.computeCombin(12));
        System.out.println(solution.climbStairs(n));
    }
}

class Solution {
    public int climbStairs(int n) {
        int num2 = n / 2;
        int ways = 1;//i=0
        if (num2 > 0) {
            for (int i = 1; i <= num2; i++) {
                int num1 = n - 2 * i;//不会有负数
                int cm = i + num1;
                int cn = i;
                int step = combin2(cm, cn);
//                long Mo = computeCombin(i + num1);
//                long De = computeCombin(i) * computeCombin(num1);
//                long step =  (Mo / De);
                ways = (ways + step);
            }
        } else {
            return 1;
        }
        return ways;
    }

//    public long computeCombin(int n) {//最多计算12
//        if (n == 0 || n == 1) {
//            return 1;
//        } else {
//            return n * computeCombin(n - 1);
//        }
//    }

    public int combin2(int m, int n) {
        int[][] c = new int[m + 1][m + 1];
        c[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            c[0][i] = 0;
            c[i][0] = 1;
        }
        for (int j = 1; j <= m; j++) {
            for (int k = 1; k <= n; k++) {
                c[j][k] = c[j - 1][k - 1] + c[j - 1][k];
            }
        }
        return c[m][n];
    }
}
