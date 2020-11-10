package at_2020.array;

/**
 * @Author libing
 * @Date 2020/11/10
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
    }

    public static void nextPermutation(int[] nums) {
        int left = 0;
        int leftIndex = -1;
        int right = 0;
        int rightIndex = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] <= nums[i - 1]) {
                continue;
            } else {
                left = nums[i - 1];
                leftIndex = i - 1;
                break;
            }
        }
        if (leftIndex == -1) {
            // reverse [0,len-1]
            reverse(nums, 0, nums.length - 1);
        } else {
            for (int i = nums.length - 1; i >= 1; i--) {
                if (nums[i] > left) {
                    right = nums[i];
                    rightIndex = i;
                    break;
                }
            }
            int tmp = left;
            nums[leftIndex] = right;
            nums[rightIndex] = tmp;
            // reverse [leftIndex+1,len-1]
            reverse(nums, leftIndex + 1, nums.length - 1);
        }
    }

    private static void reverse(int[] nums, int left, int right) {
        while (right > left) {
            int tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
            right--;
            left++;
        }
    }
}
