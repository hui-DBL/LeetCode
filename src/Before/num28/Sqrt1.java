package Before.num28;

/**
 * Create by hui on 2017/8/19
 */
public class Sqrt1 {
    public static void main(String[] args) {
        int x = 2147395599;
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.mySqrt(x));
    }
}

class Solution1 {
    public int mySqrt(int x) {
        long start = 1;
        long end = x;
        while (start + 1 < end) {
            long middle = start + (end - start) / 2;
            if (middle * middle <= x) {
                start = middle;
            } else {
                end = middle;
            }
        }

        if (end * end <= x) {
            return (int) end;
        }

        return (int) start;

    }
}

