package Before.num13;

/**
 * Created by zhonghui on 2017/7/9.
 */
public class SearchInsertPosition_1 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        Solution_1 solution_1 = new Solution_1();
        System.out.println(solution_1.searchInsert(nums, target));
    }
}

class Solution_1 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;//binary search
            if (nums[mid] < target) {
                start = mid;
            } else if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
            }
        }
        if (nums[start] >= target) {//注意其中大小关系
            return start;
        } else if (nums[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
    }
}
/*-----------------------------------------------------------*/

