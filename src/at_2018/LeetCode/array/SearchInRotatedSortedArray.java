package at_2018.LeetCode.array;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(binerySearch(nums, target));
    }

    public static int search(int[] nums, int target) {
        if (nums.length <= 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int binerySearch(int[] nums, int target) {
        if (nums.length <= 0) {
            return -1;
        }
        if (target > nums[nums.length / 2]) {
            int[] subNums = new int[nums.length / 2];
            System.arraycopy(nums, nums.length / 2 + 1, subNums, 0, nums.length / 2);
            return binerySearch(subNums, target);
        } else if (target < nums[nums.length / 2]) {
            int[] subNums = new int[nums.length / 2];
            System.arraycopy(nums, 0, subNums, 0, nums.length / 2);
            return binerySearch(subNums, target);
        } else {
            return nums.length / 2;
        }
    }
}
