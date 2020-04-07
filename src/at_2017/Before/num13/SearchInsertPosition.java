package at_2017.Before.num13;

/**
 * Created by hui on 2017/7/7.
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 0;
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(nums, target));
    }
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int min = 0;
        int max = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) {
                min = i;
                result=i+1;
            } else if (nums[i] == target) {
                result = i;
                return result;
            } else {
                max = i;
                result=max;
                break;
            }
        }
        return result;
    }
}
/*-----------------------------------------------------------*/
