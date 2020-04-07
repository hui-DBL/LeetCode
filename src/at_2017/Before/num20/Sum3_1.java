package at_2017.Before.num20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhonghui on 2017/7/20.
 */
public class Sum3_1 {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
//        Arrays.sort(nums);
        Solution_1 solution_1 = new Solution_1();
        System.out.println(solution_1.threeSum(nums).toArray());
    }
}

class Solution_1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length - 2; i++) {//完美遍历
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            left = i + 1;
            right = nums.length - 1;
            int target = -nums[i];
            twoSum(left,right,target,nums,lists);
        }
        return lists;
    }

    private void twoSum(int left, int right, int target, int[] nums, List<List<Integer>> lists) {
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(-target);
                list.add(nums[left]);
                list.add(nums[right]);
                lists.add(list);

                left++;
                right--;

                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
/*-----------------------------------------------------------*/
