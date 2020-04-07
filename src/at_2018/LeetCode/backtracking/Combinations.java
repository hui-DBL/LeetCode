package at_2018.LeetCode.backtracking;

import at_2018.util.ListUtil;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        ListUtil.showLists(combine(n, k));
    }

    public static List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n <= 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> lists = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        List<Integer> list = new ArrayList<>();
        combineHelp(nums, 0, k, lists, list);

        return lists;
    }

    private static void combineHelp(int[] nums, int i, int k, List<List<Integer>> lists, List<Integer> list) {
        if (list.size() == k) {
            List<Integer> tmp = new ArrayList<>();
            for (Integer t : list) {
                tmp.add(t);
            }
            lists.add(tmp);
            return;
        }
        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            combineHelp(nums, j + 1, k, lists, list);
            list.remove(list.size() - 1);
        }
    }

}
