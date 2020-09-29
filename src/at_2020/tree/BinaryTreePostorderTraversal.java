package at_2020.tree;

import at_2020.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hui.zhong
 * @date 2020-09-29
 */
public class BinaryTreePostorderTraversal {

	public static void main(String[] args) {

	}

	public static List<Integer> postorderTraversal(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}
		List<Integer> list = new LinkedList<>();
		postorderTraversal(root, list);
		list.add(root.val);
		return list;
	}

	private static void postorderTraversal(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		postorderTraversal(root.left, list);
		if (root.left != null) {
			list.add(root.left.val);
		}
		postorderTraversal(root.right, list);
		if (root.right != null) {
			list.add(root.right.val);
		}
	}
}
