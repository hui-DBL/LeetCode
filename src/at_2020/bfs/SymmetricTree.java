package at_2020.bfs;


/**
 * @author hui.zhong
 * @date 2020-05-27
 */
public class SymmetricTree {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);

//		TreeNode treeNode1 = new TreeNode(2);
//		treeNode.left = treeNode1;
//		TreeNode treeNode2 = new TreeNode(2);
//		treeNode.right = treeNode2;
//
//
//		TreeNode treeNode4 = new TreeNode(3);
//		treeNode1.right = treeNode4;
//
//
//		TreeNode treeNode6 = new TreeNode(3);
//		treeNode2.left = treeNode6;

		System.out.println(isSymmetric(treeNode));
	}

	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		TreeNode[] treeNodes = new TreeNode[2];
		if (root.left != null) {
			treeNodes[0] = root.left;
		} else {
			treeNodes[0] = null;
		}

		if (root.right != null) {
			treeNodes[1] = root.right;
		} else {
			treeNodes[1] = null;
		}

		return throughLayer(treeNodes);
	}

	private static boolean throughLayer(TreeNode[] treeNodes) {
		// 本层
		if (treeNodes.length % 2 != 0) {
			return false;
		}

		TreeNode[] nextTreeNodes = new TreeNode[treeNodes.length * 2];
		for (int i = 0; i < treeNodes.length; i++) {
			if (treeNodes[i] == null && treeNodes[treeNodes.length - 1 - i] == null) {
				continue;
			}
			if (!compareSym(treeNodes[i], treeNodes[treeNodes.length - 1 - i])) {
				return false;
			}

			TreeNode treeNode = treeNodes[i];
			if (treeNode.left != null) {
				nextTreeNodes[i * 2] = treeNode.left;
			} else {
				nextTreeNodes[i * 2] = null;
			}

			if (treeNode.right != null) {
				nextTreeNodes[i * 2 + 1] = treeNode.right;
			} else {
				nextTreeNodes[i * 2 + 1] = null;
			}
		}

		boolean allNull = true;
		for (TreeNode treeNode : nextTreeNodes) {
			if (treeNode != null) {
				allNull = false;
			}
		}
		if (allNull) {
			return true;
		}
		return throughLayer(nextTreeNodes);
	}

	private static boolean compareSym(TreeNode treeNode, TreeNode treeNode1) {
		if (treeNode == null && treeNode1 != null) {
			return false;
		}

		if (treeNode != null && treeNode1 == null) {
			return false;
		}

		return treeNode.val == treeNode1.val;
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
