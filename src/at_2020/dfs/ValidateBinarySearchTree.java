package at_2020.dfs;

/**
 * @author hui.zhong
 * @date 2020-03-31
 */
public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(20);
		System.out.println(isValidBST(root));
	}

	/**
	 * 了解dfs
	 *
	 * @param root
	 * @return
	 */
	public static boolean isValidBST(TreeNode root) {
		// 遍历所有节点(同时校验，有问题直接返回)
		return dfs(root, null, null);
	}

	private static boolean dfs(TreeNode root, Integer lower, Integer upper) {
		if (root == null) {
			return true;
		}
		// 是否结束
		if (isEnd(root, lower, upper)) {
			return false;
		}
		if (!dfs(root.left, lower, root.val)) {
			return false;
		}
		if (!dfs(root.right, root.val, upper)) {
			return false;
		}
		// 遍历完没有结束则为正确
		return true;
	}

	private static boolean isEnd(TreeNode node, Integer lower, Integer upper) {
		// 过滤叶子节点
		if (node.left != null) {
			if (node.left.val >= node.val) {
				return true;
			}
			if (upper != null) {
				if (node.left.val >= upper) {
					return true;
				}
			}
			if (lower != null) {
				if (node.left.val <= lower) {
					return true;
				}
			}
		}

		if (node.right != null) {
			if (node.right.val <= node.val) {
				return true;
			}
			if (upper != null) {
				if (node.right.val >= upper) {
					return true;
				}
			}
			if (lower != null) {
				if (node.right.val <= lower) {
					return true;
				}
			}
		}
		return false;
	}
}


class TreeNode {
	int val;

	TreeNode left;

	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
