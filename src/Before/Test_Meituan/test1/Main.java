package Before.Test_Meituan.test1;

import java.util.Scanner;

/**
 * Create by hui on 2017/8/31
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] chars = new int[n];
        for (int i = 0; i < n; i++) {
            chars[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        Main main = new Main();
        main.combination(chars, k);
    }

    public void combination(int[] chars, int k) {

        if (chars == null || chars.length == 0) {
            return;
        }
        int len = chars.length;
        int n = 1 << len;//2^n
        int max = 0;
        for (int i = 1; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                int temp = i;
                if ((temp & (1 << j)) > 0) {
                    sum = sum + chars[j];
                    if (sum % k == 0) {
                        if (max <= j) {
                            max = j;
                        }
                    }
                }
            }
            System.out.println();
        }
        System.out.println(max + 1);
    }
}
