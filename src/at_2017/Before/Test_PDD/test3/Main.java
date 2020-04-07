package at_2017.Before.Test_PDD.test3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Create by hui on 2017/9/2
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] candies = new int[m];
        for (int i = 0; i < m; i++) {
            candies[i] = scanner.nextInt();
        }
        Arrays.sort(candies);
        int[][] candy = new int[m][2];
        for (int i = 0; i < m; i++) {
            candy[i][0] = candies[m - 1 - i];
            candy[i][1] = 1;
        }

        int[] bears = new int[100];
        int[] mark = new int[n];
        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            if (bears[temp] > 0) {
                temp--;
            }
            bears[temp] = scanner.nextInt();
            mark[i] = temp;
        }

        for (int i = 99; i >= 0; i--) {
            if (bears[i] != 0) {
                for (int j = 0; j < m; j++) {
                    if (candy[j][0] <= bears[i] && candy[j][1] == 1) {
                        bears[i] = bears[i] - candy[j][0];
                        candy[j][1] = 0;//eat
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(bears[mark[i]]);
        }
    }
}
