package at_2020.tree;

import java.util.*;

/**
 * @author hui.zhong
 * @date 2020-09-30
 */
public class InsertIntoABinarySearchTree {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(4);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(7);
		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(3);

		node.left = node1;
		node.right = node2;
		node1.left = node3;
		node1.right = node4;

		insertIntoBST(node, 5);
;
	}

	public static TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		// 遍历
		List<Integer> list = new ArrayList<>();
		list.add(root.val);
		traverse(root, list);
		list.add(val);
		Collections.sort(list);
		// 树化
		int len = list.size();
		return list2Tree(list, 0, len - 1);
	}

	private static TreeNode list2Tree(List<Integer> list, int start, int end) {
		if (end < start) {
			return null;
		}
		if (start == end) {
			return new TreeNode(list.get(start));
		}
		int mid = (end + start) / 2;
		int midVal = list.get(mid);
		TreeNode midNode = new TreeNode(midVal);
		midNode.left = list2Tree(list, start, mid - 1);
		midNode.right = list2Tree(list, mid + 1, end);
		return midNode;
	}

	private static void traverse(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		traverse(root.left, list);
		if (root.left != null) {
			list.add(root.left.val);
		}
		traverse(root.right, list);
		if (root.right != null) {
			list.add(root.right.val);
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
