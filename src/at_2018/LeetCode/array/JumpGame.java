package at_2018.LeetCode.array;

public class JumpGame {
    public static void main(String[] args) {
        //3,2,1,0,4
        int[] nums = {3, 0, 8, 2, 0, 0, 1};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int len = nums.length - 1;
        if (len <= 0) {
            return true;
        }
        int start = 0;
//        jump(len, start, nums);
        return false;
    }

    private static boolean jump(int start, int[] nums) {
        if (start + 1 >= nums.length - 1) {
            return true;
        }
        for (int i = start; i < start + 1; i++) {
            // direct
            if (nums[i] >= (nums.length - 1 - i)) {
                return true;
            }
        }
        return jump(start + 1, nums);
    }
}
