package at_2020.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author hui.zhong
 * @date 2020/10/11
 */
public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        // nums全排列
        List<List<Integer>> totalNums = permute(nums);

        // 判断每一个排列的nums
        for (List<Integer> num : totalNums) {
            if (numCanPartition(num)) {
                return true;
            }
        }
        return false;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    public static boolean numCanPartition(List<Integer> nums) {
        int left = 0;
        int right = 0;
        for (int num : nums) {
            left += num;
        }

        for (int i = nums.size() - 1; i > 0; i--) {
            // left
            left = left - nums.get(i);
            // right
            right = right + nums.get(i);
            if (left == right) {
                return true;
            }
        }
        return false;
    }
}
