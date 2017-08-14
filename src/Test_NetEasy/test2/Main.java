package Test_NetEasy.test2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhonghui on 2017/8/12.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    x[j] = in.nextInt();
                }
                if (i == 1) {
                    y[j] = in.nextInt();
                }
            }
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {//控制结果的第几位
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int[] temp = new int[n];
                    for (int l = 0; l < n; l++) {//固定的点，与j,k的不同点求距离
                        temp[l] = Math.abs(x[l] - x[j]) + Math.abs(y[l] - y[k]);
                    }
                    Arrays.sort(temp);
                    int res = 0;
                    for (int l = 0; l < i + 1; l++) {
                        res = res + temp[l];//前i个最小的数相加，确保距离最短
                    }
                    result[i] = Math.min(result[i], res);
                }
            }
        }

        for (int j = 0; j < n; j++) {
            if (j != n - 1) {
                System.out.print(result[j] + " ");
            } else {
                System.out.println(result[j]);
            }
        }
    }
}


