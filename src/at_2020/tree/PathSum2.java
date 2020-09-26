package at_2020.tree;

import at_2020.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hui.zhong
 * @date 2020/9/26
 */
public class PathSum2 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        traverse(root, 0, sum, list, lists);
        return lists;
    }

    private void traverse(TreeNode root, int total, int sum, List<Integer> list, List<List<Integer>> lists) {
        total += root.val;
        list.add(root.val);
        // 是否为叶子节点
        if (root.left == null && root.right == null) {
            if (total == sum) {
                lists.add(new ArrayList<>(list));
            }
            return;
        }
        // 非叶子节点
        if (root.left != null) {
            traverse(root.left, total, sum, list, lists);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            traverse(root.right, total, sum, list, lists);
            list.remove(list.size() - 1);
        }
    }
}
