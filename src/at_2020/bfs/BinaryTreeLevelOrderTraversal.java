package at_2020.bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hui.zhong
 * @date 2020-06-04
 */
public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		TreeNode treeNode1 = new TreeNode(2);
		treeNode.left = treeNode1;
		TreeNode treeNode2 = new TreeNode(3);
		treeNode.right = treeNode2;
		TreeNode treeNode3 = new TreeNode(4);
		TreeNode treeNode4 = new TreeNode(5);
		treeNode1.left = treeNode3;
		treeNode2.right = treeNode4;

		levelOrder(treeNode);
		zigzagLevelOrder(treeNode);

	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}

		List<List<Integer>> lists = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		list.add(root.val);
		lists.add(list);

		List<TreeNode> treeNodes = new ArrayList<>();
		if (root.left != null) {
			treeNodes.add(root.left);
		}
		if (root.right != null) {
			treeNodes.add(root.right);
		}
		traverse(lists, treeNodes);
		return lists;
	}

	private static void traverse(List<List<Integer>> lists, List<TreeNode> treeNodes) {
		if (treeNodes.size() == 0) {
			return;
		}

		List<Integer> list = new ArrayList<>();
		List<TreeNode> treeNodeTmp = new ArrayList<>();

		for (TreeNode treeNode : treeNodes) {
			list.add(treeNode.val);

			if (treeNode.left != null) {
				treeNodeTmp.add(treeNode.left);
			}
			if (treeNode.right != null) {
				treeNodeTmp.add(treeNode.right);
			}
		}
		lists.add(list);
		traverse(lists, treeNodeTmp);
	}


	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}

		List<List<Integer>> lists = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		list.add(root.val);
		lists.add(list);

		List<TreeNode> treeNodes = new ArrayList<>();
		if (root.left != null) {
			treeNodes.add(root.left);
		}
		if (root.right != null) {
			treeNodes.add(root.right);
		}

		traverse(lists, treeNodes, 2);
		return lists;
	}

	private static void traverse(List<List<Integer>> lists, List<TreeNode> treeNodes, int order) {
		if (treeNodes.size() == 0) {
			return;
		}
		List<Integer> list = new ArrayList<>();

		if (order % 2 == 0) {
			for (int i = treeNodes.size() - 1; i >= 0; i--) {
				TreeNode treeNode = treeNodes.get(i);
				list.add(treeNode.val);
			}
		} else {
			for (int i = 0; i < treeNodes.size(); i++) {
				TreeNode treeNode = treeNodes.get(i);
				list.add(treeNode.val);
			}
		}

		List<TreeNode> treeNodeTmp = new ArrayList<>();

		for (TreeNode treeNode : treeNodes) {
			if (treeNode.left != null) {
				treeNodeTmp.add(treeNode.left);
			}
			if (treeNode.right != null) {
				treeNodeTmp.add(treeNode.right);
			}
		}

		lists.add(list);
		traverse(lists, treeNodeTmp, ++order);
	}
}
