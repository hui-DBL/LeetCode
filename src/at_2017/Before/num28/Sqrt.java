package at_2017.Before.num28;

/**
 * Create by hui on 2017/8/19
 */
public class Sqrt {
    public static void main(String[] args) {
        int x = 2147395599;
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(x));
    }
}

class Solution {
    public int mySqrt(int x) {
        //负数先不考虑
        long start = 0;
        long end = x;
        if (start * start == x) {//0 & 1
            return (int) start;
        } else if (end * end == x) {
            return (int) end;
        }
        while (start <= end) {
            long middle = ((start + end) >> 1);
            int flag = isSqrt(x, middle);
            if (flag == 0) {
                return (int) middle;
            } else if (flag == 1) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return (int) end;
    }

    public int isSqrt(int x,long end) {
        long temp = end * end;
        if (temp == x) {
            return 0;
        } else if (temp > x) {
            return -1;
        } else {
            return 1;
        }
    }
}