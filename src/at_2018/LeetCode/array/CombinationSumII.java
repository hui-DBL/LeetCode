package at_2018.LeetCode.array;

import java.util.*;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = {3, 1, 3, 5, 1, 1};
        int target = 8;
        CombinationSum.resultShow(combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int left = 0;
        Set<List<Integer>> sets = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        exactSum(candidates, left, target, sets, list);
        List<List<Integer>> result = new ArrayList<>(sets);
        return result;
    }

    private static void exactSum(int[] candidates, int left, int target, Set<List<Integer>> sets, List<Integer> list) {
        if (candidates.length <= left) {
            if (list.size() > 0) {
                list.remove(list.size() - 1);
            }
            return;
        }

        for (int i = left; i < candidates.length; i++) {
            if (target > candidates[i]) {
                list.add(candidates[i]);
                left++;
                exactSum(candidates, left, target - candidates[i], sets, list);
            } else if (target == candidates[i]) {
                List<Integer> tmp = new ArrayList<>(list);
                tmp.add(candidates[i]);
                sets.add(tmp);
            } else {
                if (list.size() > 0) {
                    list.remove(list.size() - 1);
                }
                return;
            }
        }
        if (list.size() > 0) {
            list.remove(list.size() - 1);
        }
    }
}
