package Before.Test_NetEasy.test1;

import java.util.Scanner;

/**
 * Created by zhonghui on 2017/8/12.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rent = 0;
        int f = 0;
        int allMoney = 0;
        int fruit = 0;
        while (in.hasNextInt()) {//注意while处理多个case
            rent = in.nextInt();
            f = in.nextInt();
            allMoney = in.nextInt();
            fruit = in.nextInt();
            break;
        }
        int days = 0;
        while (allMoney >= 0) {
            if (days < f) {
                days++;
                allMoney = allMoney - rent;
            } else {
                days++;
                allMoney = allMoney - (rent + fruit);
            }
        }
        System.out.println(days-1);
    }
}


