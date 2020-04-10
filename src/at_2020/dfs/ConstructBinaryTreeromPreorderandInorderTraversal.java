package at_2020.dfs;

import java.util.List;

/**
 * @author hui.zhong
 * @date 2020-04-09
 */
public class ConstructBinaryTreeromPreorderandInorderTraversal {

	public static void main(String[] args) {
		int[] preorder = {1, 2};
		int[] inorder = {1,2};
		TreeNode treeNode = buildTree(preorder, inorder);
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || inorder.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[0]);
		int pos = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == root.val) {
				pos = i;
				break;
			}
		}
		int[] leftPre = new int[pos];
		int[] leftIn = new int[pos];
		for (int i = 0; i < pos; i++) {
			leftPre[i] = preorder[i + 1];
			leftIn[i] = inorder[i];
		}

		int[] rightPre = new int[inorder.length - pos - 1];
		int[] rightIn = new int[inorder.length - pos - 1];
		for (int i = 0; i < inorder.length - pos - 1; i++) {
			rightPre[i] = preorder[pos + i + 1];
			rightIn[i] = inorder[pos + i + 1];
		}

		if (leftPre.length != 0) {
			root.left = new TreeNode(leftPre[0]);
			root.left = buildTree(leftPre, leftIn);
		}
		if (rightPre.length != 0) {
			root.right = new TreeNode(rightPre[0]);
			root.right = buildTree(rightPre, rightIn);
		}


		return root;
	}
}
