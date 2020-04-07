package at_2017.Before.num11;

/**
 * Created by zhonghui on 2017/7/6.
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        Solution solution = new Solution();
        System.out.println(solution.removeElement(nums, val));
    }
}


class Solution {
    public int removeElement(int[] nums, int val) {//并没有实现真正的消除，只是头向尾逼近
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[size] = nums[i];
                size++;
            }
        }
        return size;
    }
}
/*-----------------------------------------------------------*/