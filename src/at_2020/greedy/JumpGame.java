package at_2020.greedy;

/**
 * @author hui.zhong
 * @date 2020-06-09
 */
public class JumpGame {

	public static void main(String[] args) {
		int[] nums = {3,2,1,0,4};
		System.out.println(canJump(nums));
	}

//	public static boolean canJump(int[] nums) {
//		if (nums.length == 0) {
//			return true;
//		}
//		int[] numArr = new int[nums.length];
//		// init array
//		numArr[0] = 1;
//		for (int i = 0; i < nums.length; i++) {
//			int val = nums[i];
//			boolean flag = numArr[i] == 1;
//			for (int j = 0; j <= val; j++) {
//				if (i + j >= nums.length) {
//					continue;
//				}
//				if (flag) {
//					numArr[i + j] = 1;
//				}
//			}
//		}
//		return numArr[nums.length - 1] == 1;
//	}

	public static boolean canJump(int[] nums) {
		int lastPos = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (i + nums[i] >= lastPos) {
				lastPos = i;
			}
		}
		return lastPos == 0;
	}
}
