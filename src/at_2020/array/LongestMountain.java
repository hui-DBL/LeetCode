package at_2020.array;

/**
 * @author hui.zhong
 * @date 2020/10/25
 */
public class LongestMountain {

    public static void main(String[] args) {
        int[] A = {875, 884, 239, 731, 723, 685};
        System.out.println(longestMountain(A));
    }

    public static int longestMountain(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int longest = 0;
        int point = 0;
        while (point < A.length - 1) {
            int start = point;
            while (start + 1 < A.length && A[start] < A[start + 1]) {
                start++;
            }
            int i = start;
            if (start == point) {
                point = start + 1;
                continue;
            }
            while (start + 1 < A.length &&A[start] > A[start + 1]) {
                start++;
            }
            if (start > i) {
                longest = Math.max(longest, start - point + 1);
            }
            point = start;
        }
        return longest;
    }
}
