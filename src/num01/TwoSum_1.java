package num01;

import java.util.HashMap;

/**
 * Created by zhonghui on 2017/6/28.
 */
public class TwoSum_1 {
    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        int target = 9;
        Solution_1 solution_1 = new Solution_1();
        int[] a = new int[2];
        a = solution_1.twoSum(array, target);
        System.out.println(a[0]);
        System.out.println(a[1]);
    }
}

class Solution_1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.get(nums[i]) != null) {
                int[] result = {hashMap.get(nums[i]), i};
                return result;
            }
            hashMap.put(target - nums[i], i);
        }
        int[] result = {};
        return result;
    }
}
/*-----------------------------------------------------------*/