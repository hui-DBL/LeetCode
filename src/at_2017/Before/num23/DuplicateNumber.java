package at_2017.Before.num23;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Create by hui on 2017/8/16
 * 题目1：找出数组中重复的数字
 * <p>
 * 在一个长度为n的数组里的所有数字都在0~n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * <p>
 * 例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，
 * 那么对应的输出是重复的数字2或者3。
 */

public class DuplicateNumber {
    public static void main(String[] args) {
        int[] test1 = {2, 3, 1, 0, 2, 5, 3};
        int[] test2 = {1, 0, 3, 2, 4, 5};
        int[] test3 = {1, 23, 5, 67, 68, 9};
        DuplicateNumber duplicateNumber = new DuplicateNumber();
//        duplicateNumber.findDuplicateNumber(test1);
//        duplicateNumber.findDuplicateNumber(test2);
//        duplicateNumber.findDuplicateNumber(test3);

//        duplicateNumber.findByHashMap(test1);
//        duplicateNumber.findByHashMap(test2);
//        duplicateNumber.findByHashMap(test3);

        duplicateNumber.findByLogic(test1);
        duplicateNumber.findByLogic(test2);
        duplicateNumber.findByLogic(test3);
    }

    /**
     * 方法一
     */
    public void findDuplicateNumber(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return;
        }
        Arrays.sort(nums);
        int se = nums[0];
        if (se >= nums.length) {
            return;
        }
        int[] out = new int[nums.length];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums.length) {
                if (nums[i] == se) {
                    out[index] = se;
                    index++;
                }
                se = nums[i];
            } else {
                return;
            }
        }
        for (int j = 0; j < index; j++) {
            System.out.println(out[j]);
        }
    }

    /**
     * 方法二
     */
    public void findByHashMap(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return;
        }
        int n = nums.length;
        int[] out = new int[nums.length];
        int index = 0;
        HashMap<Integer, Integer> number = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums.length) {
                if (number.containsKey(nums[i])) {
                    out[index] = nums[i];
                    index++;
                } else {
                    number.put(nums[i], i);
                }
            } else {
                return;
            }
        }
        for (int j = 0; j < index; j++) {
            System.out.println(out[j]);
        }
    }

    /**
     * 方法三
     */
    public void findByLogic(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return;
        }
        int n = nums.length;
        int[] out = new int[nums.length];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums.length) {
                if (nums[i] != i) {
                    if (nums[nums[i]] == nums[i]) {
                        out[index] = nums[i];
                        index++;
                    } else {
                        int temp = nums[i];
                        nums[i] = nums[nums[i]];
                        nums[temp] = temp;
                    }
                }
            } else {
                return;
            }
        }
        int i = 0;
//        while (i < n) {
//            if (nums[i] < nums.length) {
//                if (nums[i] != i) {
//                    if (nums[nums[i]] == nums[i]) {
//                        out[index] = nums[i];
//                        index++;
//                        i++;
//                    } else {
//                        int temp = nums[i];
//                        nums[i] = nums[nums[i]];
//                        nums[temp] = temp;
//                    }
//                } else {
//                    i++;
//                }
//            } else {
//                return;
//            }
//        }
        for (int j = 0; j < index; j++) {
            System.out.println(out[j]);
        }
    }
}
