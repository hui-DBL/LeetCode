package at_2020.tree;

import at_2020.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hui.zhong
 * @date 2020-09-24
 */
public class FindModeInBinarySearchTree {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		TreeNode nodeR = new TreeNode(2);
		node.right = nodeR;
		System.out.println(findMode(node));
	}

	public static int[] findMode(TreeNode root) {
		if (root == null) {
			return new int[0];
		}
		Map<Integer, Integer> map = new HashMap<>();
		// 遍历树，确定数量
		traverse(root, map);
		int max = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > max) {
				max = entry.getValue();
			}
		}
		int len = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == max) {
				len++;
			}
		}
		int[] result = new int[len];
		int index = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == max) {
				result[index] = entry.getKey();
				index++;
			}
		}
		return result;
	}

	private static void traverse(TreeNode root, Map<Integer, Integer> map) {
		if (root == null) {
			return;
		}
		if (map.containsKey(root.val)) {
			map.put(root.val, map.get(root.val) + 1);
		} else {
			map.put(root.val, 1);
		}
		traverse(root.left, map);
		traverse(root.right, map);
	}
}
