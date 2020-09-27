package at_2020.tree;

import at_2020.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hui.zhong
 * @date 2020-09-27
 */
public class LowestCommonAncestor {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(5);
		TreeNode treeNode1 = new TreeNode(3);
		treeNode.left = treeNode1;
		TreeNode treeNode2 = new TreeNode(6);
		treeNode.right = treeNode2;
		TreeNode treeNode3 = new TreeNode(2);
		treeNode1.left = treeNode3;
		TreeNode treeNode4 = new TreeNode(4);
		treeNode1.right = treeNode4;
		TreeNode treeNode5 = new TreeNode(1);
		treeNode3.left = treeNode5;

		lowestCommonAncestor(treeNode, new TreeNode(1), new TreeNode(4));
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		List<List<Integer>> lists = new LinkedList<>();
		List<Integer> list = new LinkedList<>();

		traverse(root, p, q, list, lists);
		if (lists.size() == 0) {
			return null;
		}
		if (lists.size() == 1) {
			list = lists.get(0);
		}
		if (lists.size() == 2) {
			lists.get(0).retainAll(lists.get(1));
			list = lists.get(0);
		}
		for (Integer integer : list) {
			if (integer == p.val || integer == q.val) {
				return new TreeNode(integer);
			}
		}
		if (list.size() == 1) {
			return new TreeNode(list.get(0));
		} else {
			return new TreeNode(list.get(list.size() - 1));
		}
	}

	private static void traverse(TreeNode root, TreeNode p, TreeNode q, List<Integer> list, List<List<Integer>> lists) {
		list.add(root.val);
		if (root.val == p.val || root.val == q.val) {
			lists.add(new ArrayList<>(list));
		}
		if (root.left != null) {
			traverse(root.left, p, q, list, lists);
			list.remove(list.size() - 1);
		}
		if (root.right != null) {
			traverse(root.right, p, q, list, lists);
			list.remove(list.size() - 1);
		}
	}
}
