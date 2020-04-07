package at_2018.LeetCode.array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        resultShow(combinationSum(candidates, target));
    }

    public static void resultShow(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.printf("" + i);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combination(candidates, target, lists, list);
        return lists;
    }

    private static void combination(int[] candidates, int target, List<List<Integer>> lists, List<Integer> list) {
        if (target == 0) {
            lists.add(list);
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            if (target < candidates[i]) {
                continue;
            }

            list.add(candidates[i]);
            combination(candidates, target - candidates[i], lists, list);
        }
    }
}
