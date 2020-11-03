package at_2020.array;

/**
 * @Author libing
 * @Date 2020/11/3
 */
public class ValidMountainArray {
    public static void main(String[] args) {

    }

    public static boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        boolean findMid = false;
        int pre = 0;
        for (int i = 1; i < A.length; i++, pre++) {
            if (!findMid) {
                if (A[i] > A[pre]) {
                    continue;
                } else if (A[i] == A[pre]) {
                    return false;
                } else {
                    if (i == 1) {
                        return false;
                    } else {
                        findMid = true;
                    }
                }
            } else {
                if (A[i] < A[pre]) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return findMid;
    }
}
