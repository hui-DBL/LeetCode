package at_2020.backtrating;

import java.util.*;

/**
 * @author hui.zhong
 * @date 2020-04-22
 */
public class CombinationSum {
	public static void main(String[] args) {
		int[] candidates = {2, 3, 6, 7};
		int target = 7;
		combinationSum(candidates, target);
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		// 求解
		List<Integer> process = new ArrayList<>();
		Set<List<Integer>> result = new HashSet<>();
		solve(candidates, target, process, result);
		// 排序去重
		List<List<Integer>> r = new ArrayList<>(result);
		return r;
	}

	private static void solve(int[] candidates, int target, List<Integer> process, Set<List<Integer>> result) {
		// 当前是否满足条件
		int sum = 0;
		for (int tmp : process) {
			sum += tmp;
		}
		if (sum == target) {
			// 排序
			Collections.sort(process);
			result.add(process);
			return;
		}
		if (sum > target) {
			return;
		}

		for (int i = 0; i < candidates.length; i++) {
			int candidate = candidates[i];
			// 存档点
			List<Integer> savePoint = new ArrayList<>(process);
			savePoint.add(candidate);
			solve(candidates, target, savePoint, result);
		}
	}
}
