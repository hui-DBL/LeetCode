package Before.Test_Meituan.test1;

import java.util.Scanner;

/**
 * Create by hui on 2017/9/1
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] chars = new int[n];
        for (int i = 0; i < n; i++) {
            chars[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int l = i; l <= j; l++) {
                    sum += chars[l];
                }
                if (sum != 0 && sum % k == 0) {
                    int temp = j - i + 1;
                    if (temp >= maxLen) {
                        maxLen = temp;
                    }
                }
            }
        }
        System.out.println(maxLen);
    }
}
