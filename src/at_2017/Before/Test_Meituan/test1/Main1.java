package at_2017.Before.Test_Meituan.test1;

import java.util.Scanner;

/**
 * Create by hui on 2017/8/31
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] chars = new int[n];
        for (int i = 0; i < n; i++) {
            chars[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();

        int max = 0;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = n - 1; j >= i; j--) {
                temp += chars[j];
            }
            if (temp % k == 0) {
                if (max <= n - i) {
                    max = n - i;
                }
            }
        }
        System.out.println(max);
    }
}
