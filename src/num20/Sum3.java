package num20;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhonghui on 2017/7/19.
 */
public class Sum3 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        Arrays.sort(nums);
        Solution solution = new Solution();
        System.out.println(solution.threeSum(nums).toArray());
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        quickSort(nums);
        int len = nums.length;
        int head = 0;
        int end = len - 1;
        while (head +1 < end) {//遍历有问题，需要一个完美遍历。。。
            int temp = nums[head] + nums[end];
            int max = Integer.MIN_VALUE;
            for(int i=head+1;i<end;i++) {
                if (temp + nums[i] > max) {
                    max = temp + nums[i];
                }
                if (temp + nums[i] == 0) {
                    List<Integer> list = new LinkedList<Integer>();
                    list.add(nums[head]);
                    list.add(nums[i]);
                    list.add(nums[end]);
                    lists.add(list);
                }
            }
            if (max > 0) {
                end--;
            } else {
                head++;
            }
        }
        HashSet h = new HashSet(lists);
        lists.clear();
        lists.addAll(h);//去重复
        return lists;
    }

    public void quickSort(int[] nums) {
        int len = nums.length;
        qsort(nums, 0, len - 1);
    }

    private void qsort(int[] nums, int low, int high) {
        if (low < high) {
            int pivot = partition(nums, low, high);
            qsort(nums, low, pivot - 1);
            qsort(nums, pivot + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }
}
/*-----------------------------------------------------------*/

