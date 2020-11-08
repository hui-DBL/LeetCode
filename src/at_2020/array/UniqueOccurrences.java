package at_2020.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author libing
 * @Date 2020/10/28
 */
public class UniqueOccurrences {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences(nums));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        if (arr.length <= 1) {
            return true;
        }
        Arrays.sort(arr);
        int[] times = new int[arr.length];
        int pre = 0;
        int curr = 1;
        while (curr < arr.length) {
            while (curr < arr.length && arr[curr] == arr[pre]) {
                curr++;
            }
            int time = curr - pre;
            if (times[time] == 1) {
                return false;
            } else {
                times[time] = 1;
            }
            pre = curr;
        }
        return true;
    }
}
