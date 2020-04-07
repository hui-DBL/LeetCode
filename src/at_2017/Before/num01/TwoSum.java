package at_2017.Before.num01;

/**
 * Created by zhonghui on 2017/6/28.
 */
public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {2, 7, 11, 15};
        int target = 9;
        int[] a = new int[2];
        a = solution.twoSum(array, target);
        System.out.println(a[0]);
        System.out.println(a[1]);
    }
}

 class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        return index;
    }

}
/*-----------------------------------------------------------*/
