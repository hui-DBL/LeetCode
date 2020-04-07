package at_2017.Before.Test_Meituan.test2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Create by hui on 2017/9/1
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Arrays.sort(nums);
        int sum = 0;
        sum = nums[n - 1];
        int first = sum;
        for (int i = n - 2; i >= 0; i--) {
            sum -= nums[i];
            first -= nums[i];//第一次给的要花完
            if (sum >= 0) {//每次要够
                sum += nums[i];
            } else {
                System.out.println("No");
                break;
            }
        }
        if (first <= 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
