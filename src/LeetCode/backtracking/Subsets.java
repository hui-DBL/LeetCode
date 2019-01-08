package LeetCode.backtracking;

import util.ListUtil;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ListUtil.showLists(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        if (nums.length <= 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        subsetsHelp(nums, 0, list, lists);
        return lists;
    }

    private static void subsetsHelp(int[] nums, int i, List<Integer> list, List<List<Integer>> lists) {
        if (list.size() <= nums.length) {
            List<Integer> tmpList = new ArrayList<>();
            for (int tmp : list) {
                tmpList.add(tmp);
            }
            lists.add(tmpList);
        } else {
            return;
        }

        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            subsetsHelp(nums, j + 1, list, lists);
            list.remove(list.size() - 1);
        }
    }
}
