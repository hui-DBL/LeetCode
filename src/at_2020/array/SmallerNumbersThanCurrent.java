package at_2020.array;

/**
 * @Author libing
 * @Date 2020/10/26
 */
public class SmallerNumbersThanCurrent {
    public static void main(String[] args) {

    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[j] < nums[i]) {
                    index++;
                }
            }
            count[i] = index;
        }
        return count;
    }
}
