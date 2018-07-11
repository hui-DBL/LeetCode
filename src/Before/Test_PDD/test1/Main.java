package Before.Test_PDD.test1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            int[] arrays = new int[4];

            for(int i=0;i<a;i++) {
                arrays[i] = in.nextInt();
            }

            Arrays.sort(arrays);

            int max = arrays[0];
            int temp = max;
            for(int i=0;i<arrays.length;i++) {
                temp = arrays[i];
                max = Math.max(max, temp);
                for(int j=i+1; j<arrays.length;j++) {
                    temp = temp * arrays[j];
                    max = Math.max(max, temp);
                }
            }

            System.out.println(max);
        }
    }
}