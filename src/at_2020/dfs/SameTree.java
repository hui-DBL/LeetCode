package at_2020.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author hui.zhong
 * @date 2020-04-08
 */
public class SameTree {
	public static void main(String[] args) {
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);

		TreeNode q = new TreeNode(1);
		q.right = new TreeNode(2);

		isSameTree(p, q);
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		List<Integer> pList = new ArrayList<>();
		List<Integer> qList = new ArrayList<>();
		traverse(p, pList);
		traverse(q, qList);
		if (pList.size() != qList.size()) {
			return false;
		}

		for (int i = 0; i < pList.size(); i++) {
			if (!pList.get(i).equals(qList.get(i))) {
				return false;
			}
		}
		return true;
	}

	private static void traverse(TreeNode p, List<Integer> pList) {
		if (p == null) {
			pList.add(-1);
			return;
		}
		pList.add(p.val);
		if (isTail(p)) {
			return;
		}
		traverse(p.left, pList);
		traverse(p.right, pList);
	}

	private static boolean isTail(TreeNode p) {
		if (p.left == null && p.right == null) {
			return true;
		}
		return false;
	}

	private static boolean traverseAndCompare(TreeNode p, TreeNode q) {
		if ((p == null && q != null) || (p != null && q == null)) {
			return false;
		}
		if (Objects.equals(p.val ,q.val)) {
			return false;
		}
		if (!traverseAndCompare(p.left, q.left)) {
			return false;
		}
		if (!traverseAndCompare(p.right, q.right)) {
			return false;
		}
		return true;
	}
}