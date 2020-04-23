package at_2020.backtrating;

import java.util.*;

/**
 * 全排列
 *
 * @author hui.zhong
 * @date 2020-04-23
 */
public class Permutations {

	public static void main(String[] args) {
		permute(new int[]{1, 2, 3});
	}

	public static List<List<Integer>> permute(int[] nums) {
		Set<List<Integer>> setResult = new HashSet<>();
		List<Integer> process = new ArrayList<>();
		solve(nums, process, setResult);
		List<List<Integer>> listResult = new ArrayList<>(setResult);
		return listResult;
	}

	private static boolean solve(int[] nums, List<Integer> process, Set<List<Integer>> setResult) {
		if (process.size() == nums.length) {
			Set<Integer> tmpProcess = new HashSet<>(process);
			if (tmpProcess.size() == nums.length) {
				setResult.add(process);
				return true;
			}
			return false;
		}
		if (process.size() > nums.length) {
			return false;
		}
		for (int i = 0; i < nums.length; i++) {
			List<Integer> tmp = new ArrayList<>(process);
			tmp.add(nums[i]);
			// 没有跳出的一说，只有合不合格
			solve(nums, tmp, setResult);
		}
		return false;
	}
}
