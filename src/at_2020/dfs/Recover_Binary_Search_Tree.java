package at_2020.dfs;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hui.zhong
 * @date 2020-04-03
 */
public class Recover_Binary_Search_Tree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		recoverTree(root);
		recoverTree2(root);
	}

	private static void recoverTree2(TreeNode root) {
		List<TreeNode> treeNodes = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		traverseMid(root, treeNodes, list);
		list = list.stream().sorted(Integer::compareTo).collect(Collectors.toList());
		for (int i = 0; i < list.size(); i++) {
			TreeNode tmp = treeNodes.get(i);
			tmp.val = list.get(i);
		}
	}

	private static void traverseMid(TreeNode root, List<TreeNode> treeNodes, List<Integer> list) {
		if (root == null) {
			return;
		}
		if (isTail(root)) {
			treeNodes.add(root);
			list.add(root.val);
			return;
		}
		traverseMid(root.left, treeNodes, list);
		treeNodes.add(root);
		list.add(root.val);
		traverseMid(root.right, treeNodes, list);
	}

	public static void recoverTree(TreeNode root) {
		// 展开
		List<Integer> list = new ArrayList<>();
		traverse(root, list);
		// 排序
		list = list.stream().sorted(Integer::compareTo).collect(Collectors.toList());
		// 中序遍历，赋值
		traverseAndSet(root, list);
//		traverse(root, list);
	}

	private static void traverseAndSet(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		if (isTail(root)) {
			root.val = list.get(0);
			list.remove(0);
			return;
		}
		traverseAndSet(root.left, list);
		root.val = list.get(0);
		list.remove(0);
		traverseAndSet(root.right, list);
	}

	private static void traverse(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		System.out.println(root.val);
		list.add(root.val);
		// isEnd
		if (isTail(root)) {
			return;
		}
		traverse(root.left, list);
		traverse(root.right, list);
	}

	private static boolean isTail(TreeNode root) {
		if (root.left == null && root.right == null) {
			return true;
		}
		return false;
	}
}
