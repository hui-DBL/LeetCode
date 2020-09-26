package at_2020.dfs;

/**
 * @author hui.zhong
 * @date 2020-09-25
 */
public class ConstructBinaryTreeFromInOrderAndPostOrderTraversal {

	public static void main(String[] args) {
		int[] inorder = {9, 3, 15, 20, 7};
		int[] postorder = {9, 15, 7, 20, 3};
		System.out.println(buildTree(inorder, postorder));
	}

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || inorder.length == 0) {
			return null;
		}
		// 1
		if (inorder.length == 1) {
			return new TreeNode(inorder[0]);
		}
		// >1
		// 确定根节点
		int root = postorder[postorder.length - 1];
		TreeNode rootNode = new TreeNode(root);
		// 确定左右子树
		int separate = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (root == inorder[i]) {
				separate = i;
				break;
			}
		}
		int[] leftInorder = new int[separate];
		System.arraycopy(inorder, 0, leftInorder, 0, separate);

		int[] leftPostorder = new int[separate];
		System.arraycopy(postorder, 0, leftPostorder, 0, separate);

		rootNode.left = buildTree(leftInorder, leftPostorder);

		int[] rightInorder = new int[inorder.length - separate - 1];
		System.arraycopy(inorder, separate + 1, rightInorder, 0, inorder.length - separate - 1);

		int[] rightPostorder = new int[inorder.length - separate - 1];
		System.arraycopy(postorder, postorder.length - 1 - (inorder.length - separate - 1), rightPostorder, 0, inorder.length - separate - 1);

		rootNode.right = buildTree(rightInorder, rightPostorder);

		return rootNode;
	}
}
