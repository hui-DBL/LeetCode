package at_2017.Before.Test_Souhu.test2;

import java.util.Scanner;

/**
 * Create by hui on 2017/9/1
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] num = new int[6];
        while (scanner.hasNext()) {
            int sum = 0;
            for (int i = 0; i < 6; i++) {
                num[i] = scanner.nextInt();
                sum += num[i];
            }

            if (sum == 0) {
                break;
            }

            int count = num[5];//initial

            count += num[4];//1 5*5 + 11 1*1
            num[0] = num[0] - 11 * num[4];//remain 1*1

            count += num[3];//1 4*4 + 5 3*3
            num[1] = num[1] - 5 * num[3];//remain 2*2
            if (num[1] < 0) {
                num[0] = num[0] - 4 * (-num[1]);
            }

            count += num[2] / 4;
            num[2] = num[2] % 4;//remain 3*3

            if (num[2] == 1) {
                count++;
                if (num[1] > 0) {
                    num[1] = num[1] - 5;
                }
                num[0] = num[0] - 7;
                if (num[1] < 0) {
                    num[0] = num[0] - 4 * (-num[1]);
                }
            } else if (num[2] == 2) {
                count++;
                if (num[1] > 0) {
                    num[1] = num[1] - 3;
                }
                num[0] = num[0] - 6;
                if (num[1] < 0) {
                    num[0] = num[0] - 4 * (-num[1]);
                }
            } else if (num[2] == 3) {
                count++;
                if (num[1] > 0) {
                    num[1] = num[1] - 1;
                }
                num[0] = num[0] - 5;
                if (num[1] < 0) {
                    num[0] = num[0] - 4 * (-num[1]);
                }
            }

            if (num[1] > 0) {
                count += num[1] / 9;
                num[1] = num[1] % 9;//remain 2*2
                if (num[1] > 0) {
                    count++;
                    num[0] = num[0] - (36 - 4 * num[1]);
                }
            }

            if (num[0] > 0) {
                count += num[0] / 36;
                num[0] = num[0] % 36;
                if (num[0] > 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
