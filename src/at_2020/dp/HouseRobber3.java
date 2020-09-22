package at_2020.dp;


/**
 * @author hui.zhong
 * @date 2020-09-21
 */
public class HouseRobber3 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(2);
		root.left = node1;
		TreeNode node2 = new TreeNode(3);
		node1.right = node2;
		TreeNode node3 = new TreeNode(3);
		root.right = node3;
		TreeNode node4 = new TreeNode(1);
		node3.right = node4;

		System.out.println(rob(root));
	}

	public static int rob(TreeNode root) {
		int[] res = help(root);
		return Math.max(res[0], res[1]);
	}

	private static int[] help(TreeNode root) {
		int[] res = new int[2];
		if (root == null) {
			return res;
		}
		int[] res1 = help(root.left);
		int[] res2 = help(root.right);

		//选
		res[0] = root.val + res1[1] + res2[1];
		//不选
		res[1] = Math.max(res1[0], res1[1]) + Math.max(res2[0], res2[1]);

		return res;
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
