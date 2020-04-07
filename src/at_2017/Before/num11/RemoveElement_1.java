package at_2017.Before.num11;

/**
 * Created by zhonghui on 2017/7/6.
 */
public class RemoveElement_1 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        Solution_1 solution_1 = new Solution_1();
        System.out.println(solution_1.removeElement(nums, val));
    }
}


class Solution_1 {
    public int removeElement(int[] nums, int val) {//也没有实现真正的消除，只是头和尾相互逼近，但速度并没有更快。。。
        int len = nums.length - 1;
        int i=0;
        while (i <= len) {
            if (nums[i] == val) {
                nums[i] = nums[len];
                len--;
            } else {
                i++;
            }
        }
        return i;
    }
}
/*-----------------------------------------------------------*/


