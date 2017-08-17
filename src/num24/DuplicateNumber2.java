package num24;

/**
 * Create by hui on 2017/8/17
 * 题目二：不修改数组找出重复的数字
 *
 * 在一个长度为n+1的数组里的所有数字都在1~n的范围内，所以数组中至少有一个数字是重复的。
 * 请找出数组中任意一个重复的数字，但不能修改输入的数组。
 *
 * 例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，
 * 那么对应的输出的重复数字是2或者3。
 */
public class DuplicateNumber2 {
    public static void main(String[] args) {
        int[] test1 = {2, 3, 5, 4, 3, 2, 6, 7};
        int[] test2 = {1, 0, 3, 2, 4, 5};
        int[] test3 = null;
        DuplicateNumber2 duplicateNumber2 = new DuplicateNumber2();
        System.out.println(duplicateNumber2.getDuplication(test1));
    }

    public int getDuplication(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int length = nums.length;
        int start =1;
        int end = length - 1;
        while (end >= start) {//二分查找算法
            int middle = ((end - start) >> 1) + start;
            int count = countRange(nums, start, middle);
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > middle - start + 1) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    public int countRange(int[] nums, int start, int end) {
        if (nums == null) {
            return 0;
        }
        int count = 0;
        for(int i=0;i<nums.length;i++) {
            if (nums[i] <= end && nums[i] >= start) {
                count++;
            }
        }
        return count;
    }

}
