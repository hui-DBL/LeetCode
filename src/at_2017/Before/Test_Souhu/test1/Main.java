package at_2017.Before.Test_Souhu.test1;


import java.util.Scanner;

/**
 * kolakoski序列
 * Create by hui on 2017/8/28
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] num = new int[m];
        for (int i = 0; i < m; i++) {
            num[i] = scanner.nextInt();
        }

        int[] list = new int[n + 1];
        int count = 0;//m个循环放
        int sum = 0;

        for (int j = 0; j <= n; j++) {
            int listnum = 0;
            if (j == 0) {
                listnum = num[0];
            } else {
                listnum = list[j];
            }
            int temp = 0;
            while (temp < listnum) {
                if (sum > n) {
                    break;
                }
                list[sum] = num[count % m];
                System.out.println(list[sum]);
                temp++;
                sum++;
            }
            count++;

        }
    }
}
