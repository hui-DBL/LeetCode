package at_2018.LeetCode.backtracking;

import at_2018.util.ListUtil;

import java.util.*;

public class SubsetsII {

    public static void main(String[] args) {
        int[] nums = {2, 2, 6};
        ListUtil.showLists(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        Set<List<Integer>> sets = new HashSet<>();
        // 构造二进制
        for (int i = 0; i < (int) Math.pow(2, nums.length); i++) {
            List<Integer> list = new ArrayList<>();
            if (i == 0) {
                sets.add(list);
            } else {
                // 确定位数
                List<Integer> bitNums = calBitNums(i, nums.length);
                for (Integer bit : bitNums) {
                    list.add(nums[bit]);
                }
                Collections.sort(list);
                sets.add(list);
            }
        }
        List<List<Integer>> lists = new ArrayList<>(sets);
        return lists;
    }

    private static List<Integer> calBitNums(int i, int j) {
        List<Integer> bitNums = new ArrayList<>();
        for (int k = j - 1; k >= 0; k--) {
            int max = (int) Math.pow(2, k);
            if (max <= i) {
                bitNums.add(k);
                i = i - max;
            }
        }
        return bitNums;
    }
}
