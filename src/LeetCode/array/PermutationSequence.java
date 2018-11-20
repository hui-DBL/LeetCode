package LeetCode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
    }

    public static String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        int l = 0;
        List<List<Integer>> result = new ArrayList<>();
        permutation(nums, l, result);
        result.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                for (int i = 0; i < o1.size(); i++) {
                    if (o1.get(i) - o2.get(i) == 0) {
                        continue;
                    } else {
                        return o1.get(i) - o2.get(i);
                    }
                }
                return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.get(k - 1).size(); i++) {
            sb.append(result.get(k - 1).get(i));
        }
        return sb.toString();
    }

    private static void permutation(int[] nums, int l, List<List<Integer>> result) {
        if (l == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            result.add(list);
            return;
        }
        for (int i = l; i < nums.length; i++) {
            exchange(nums, l, i);
            permutation(nums, l + 1, result);
            exchange(nums, l, i);
        }
    }

    private static void exchange(int[] nums, int l, int i) {
        int tmp = nums[l];
        nums[l] = nums[i];
        nums[i] = tmp;
    }
}
