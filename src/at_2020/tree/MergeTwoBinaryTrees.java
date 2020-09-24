package at_2020.tree;


import at_2020.TreeNode;

/**
 * @author hui.zhong
 * @date 2020-09-23
 */
public class MergeTwoBinaryTrees {
	public static void main(String[] args) {

	}

	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		// 遍历t1，t2
		if (t1 == null) {
			return t2;
		} else if (t2 == null) {
			return t1;
		}
		TreeNode newTreeHead = new TreeNode(t1.val + t2.val);
		newTreeHead.left = mergeTrees(t1.left, t2.left);
		newTreeHead.right = mergeTrees(t1.right, t2.right);
		return newTreeHead;
	}
}
