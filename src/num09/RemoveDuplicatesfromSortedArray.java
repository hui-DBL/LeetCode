package num09;

/**
 * Created by zhonghui on 2017/7/5.
 */
public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2,2,2, 3, 4, 5, 6};
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(nums));
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int numLen = nums.length;
        int len = numLen;
        if (len == 0) {
            return 0;
        }
        int temp = nums[0];
        int flag = 0;//指向可替换的标志位
        for (int i = 1; i < numLen; i++) {
            if (temp == nums[i]) {
                len--;
            } else {
                temp = nums[i];
                flag++;
                if (i > flag) {//如果不一样，且有位置则往前移动
                    nums[flag] =nums[i];
                }

            }
        }
        return len;
    }
}
/*-----------------------------------------------------------*/
