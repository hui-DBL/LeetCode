package at_2020.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hui.zhong
 * @date 2020/10/25
 */
public class CheckArithmeticSubarrays {

    public static void main(String[] args) {

    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> results = new ArrayList<>(l.length);
        for (int i = 0; i < l.length; i++) {
            int st = l[i];
            int en = r[i];
            int[] arrays = new int[en - st + 1];
            int index = 0;
            for (int j = st; j <= en; j++, index++) {
                arrays[index] = nums[j];
            }
            results.add(canMakeArithmeticProgression(arrays));
        }
        return results;
    }

    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length - 1; ++i) {
            if (arr[i] * 2 != arr[i - 1] + arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
