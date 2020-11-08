package at_2020.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author libing
 * @Date 2020/10/27
 */
public class PreorderTraversal {
    public static void main(String[] args) {

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
    }

    private static void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left != null) {
            traverse(root.left, list);
        }
        if (root.right != null) {
            traverse(root.right, list);
        }
    }
}
