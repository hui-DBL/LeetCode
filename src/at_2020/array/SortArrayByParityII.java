package at_2020.array;

/**
 * @Author libing
 * @Date 2020/11/12
 */
public class SortArrayByParityII {

    public static void main(String[] args) {

    }

    public static int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int j = 1;
        int i_s = 0;
        int j_s = 0;
        while (i < A.length - 1 && j < A.length) {
            if ((i % 2 == 0 && A[i] % 2 == 0) || (i % 2 != 0 && A[i] % 2 != 0)) {
                i = i + 2;
            } else {
                i_s++;
            }
            if ((j % 2 == 0 && A[j] % 2 == 0) || (j % 2 != 0 && A[j] % 2 != 0)) {
                j = j + 2;
            } else {
                j_s++;
            }
            if (i_s > 0 && j_s > 0) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                i_s--;
                j_s--;
            }
        }
        return A;
    }
}
