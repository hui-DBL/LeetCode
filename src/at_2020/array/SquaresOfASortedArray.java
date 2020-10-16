package at_2020.array;

/**
 * @Author libing
 * @Date 2020/10/16
 */
public class SquaresOfASortedArray {

    public static int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int curr = A[i] * A[i];
            A[i] = curr;

            int currIndex = i;
            while (currIndex > 0 && A[currIndex] < A[currIndex - 1]) {
                int tmp = A[currIndex];
                A[currIndex] = A[currIndex - 1];
                A[currIndex - 1] = tmp;
                currIndex--;
            }
        }
        return A;
    }
}
