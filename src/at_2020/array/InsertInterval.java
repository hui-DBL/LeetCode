package at_2020.array;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author libing
 * @Date 2020/11/4
 */
public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newIntervals = {2, 5};
        System.out.println(insert(intervals, newIntervals));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] result = new int[1][2];
            result[0] = newInterval;
            return result;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            min = Math.min(intervals[i][0], min);
            max = Math.max(intervals[i][1], max);
        }
        min = Math.min(newInterval[0], min);
        max = Math.max(newInterval[1], max);

        int[] nums = new int[max - min + 1];
        for (int i = 0; i < intervals.length; i++) {
            int[] num = intervals[i];
            // 归一化
            int start = num[0] - min;
            nums[start] = Math.max(nums[start], num[1] - min);
        }
        nums[newInterval[0] - min] = Math.max(nums[newInterval[0] - min], newInterval[1] - min);

        List<List<Integer>> lists = new ArrayList<>(nums.length);
        List<Integer> list = new ArrayList<>();
        int last = nums[0];
        list.add(0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (i <= last && nums[i] <= last) {
                continue;
            } else if (i <= last && nums[i] > last) {
                last = nums[i];
            } else if (i > last) {
                list.add(last);
                lists.add(new ArrayList<>(list));
                list.clear();
                list.add(i);
                last = nums[i];
            }
        }
        list.add(last);
        lists.add(new ArrayList<>(list));
        int[][] result = new int[lists.size()][2];
        for (int i = 0; i < lists.size(); i++) {
            result[i][0] = lists.get(i).get(0) + min;
            result[i][1] = lists.get(i).get(1) + min;
        }
        return result;
    }
}
