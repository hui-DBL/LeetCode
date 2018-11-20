package LeetCode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        showList(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        if (nums.length == 1) {
            return new ArrayList<>(new ArrayList<>(nums[0]));
        }
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int[] counter = new int[nums.length];
        while (calSum(counter) < calSumMax(counter)) {
            return null;
        }
        return null;
    }

    private static int calSumMax(int[] counter) {
        int sum = 0;
        for (int i = 0; i < counter.length; i++) {
            sum += (counter.length) * Math.pow(counter.length, i);
        }
        return sum;
    }

    private static int calSum(int[] counter) {
        int sum = 0;
        for (int i = 0; i < counter.length; i++) {
            sum += counter[i] * Math.pow(counter.length, i);
        }
        return sum;
    }

    public static void showList(List<List<Integer>> permute) {
        for (List<Integer> list : permute) {
            for (Integer i : list) {
                System.out.printf(String.valueOf(i));
            }
            System.out.println();
        }
    }
}
