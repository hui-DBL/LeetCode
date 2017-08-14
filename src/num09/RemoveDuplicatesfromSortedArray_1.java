package num09;

/**
 * Created by zhonghui on 2017/7/5.
 */
public class RemoveDuplicatesfromSortedArray_1 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 2, 3, 4, 5, 6};
        int i = 0;
        int j = 0;
        System.out.println("i++:" + i++);
        System.out.println("++j:" + ++j);
        Solution_1 solution_1 = new Solution_1();
        System.out.println(solution_1.removeDuplicates(nums));
    }
}

class Solution_1 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = 0;//往前挪的标志位，不随i变化，为不重复元素的长度
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[size]) {
                nums[++size] = nums[i];//+在前先加
            }
        }
        return size + 1;//size是下标
    }
}
/*-----------------------------------------------------------*/
