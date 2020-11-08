package at_2020.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author libing
 * @Date 2020/10/29
 */
public class SumNumbers {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        node.left = node1;
        node.right = node2;

        System.out.println(sumNumbers(node));
    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> sumList = new ArrayList<>();
        traverse(root, list, sumList);
        int sum = 0;
        for (int i = 0; i < sumList.size(); i++) {
            sum += sumList.get(i);
        }
        return sum;
    }

    private static void traverse(TreeNode root, List<Integer> list, List<Integer> sumList) {
        list.add(root.val);
        if (root.left != null) {
            traverse(root.left, list, sumList);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            traverse(root.right, list, sumList);
            list.remove(list.size() - 1);
        }
        if (root.left == null && root.right == null) {
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(list.size() - i - 1) * Math.pow(10, i);
            }
            sumList.add(sum);
        }
    }


}
