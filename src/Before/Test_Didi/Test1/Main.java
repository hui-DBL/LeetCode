package Before.Test_Didi.Test1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhonghui on 2017/8/26.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int k = scanner.nextInt();
        scanner.close();
        int[] num = new int[s.length];
        int i = 0;
        for (String tempStr : s) {
            num[i] = (int) Integer.valueOf(tempStr);
            i++;
        }
        Arrays.sort(num);
        System.out.println(num[s.length-k]);
    }
}
