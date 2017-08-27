package num29.Test2;

import java.util.Scanner;

/**
 * Created by zhonghui on 2017/8/26.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        scanner.close();
        int[] num = new int[s.length];
        int i = 0;
        for (String tempStr : s) {
            num[i] = (int) Integer.valueOf(tempStr);
            i++;
        }

        if (num == null || num.length <= 0) {
            return;
        }
        int nSum = 0;
        int nMaxSum = Integer.MIN_VALUE;
        for(int j=0;j<num.length;j++) {
            if (nSum <= 0) {
                nSum = num[j];
            } else {
                nSum += num[j];
            }

            if (nSum > nMaxSum) {
                nMaxSum = nSum;
            }
        }
        System.out.println(nMaxSum);
    }
}
