//package LeetCode.array;
//
//import java.util.Arrays;
//
//public class FindFirstAndLastPositionOfElementInSortedArray {
//    public static void main(String[] args) {
//        int nums[] = {1, 4};
//        int target = 4;
//        showNums(searchRange(nums, target));
//    }
//
//    private static void showNums(int[] ints) {
//        for (int i = 0; i < ints.length; i++) {
//            System.out.println(ints[i]);
//        }
//    }
////todo 找范围
//    public static int[] searchRange(int[] nums, int target) {
//        if (nums.length <= 0) {
//            return new int[]{-1, -1};
//        }
//        int index = 0;
//        int[] tmp = new int[nums.length+1];
//
//        for (int i = 0; i < nums.length; i++) {
//            if (target == nums[i]) {
//                tmp[index++] = i;
//            }
//        }
//
//
//        if (index == 0) {
//            return new int[]{-1, -1};
//        } else if (index == 1) {
//            int tm = tmp[index - 1];
//            tmp[index++] = tm;
//        }
//        int[] result = new int[2];
//        result[0] = finMin();
//        result[1]
//
//        return result;
//    }
//
//}
