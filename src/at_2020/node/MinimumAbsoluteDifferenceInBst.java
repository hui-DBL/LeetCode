package at_2020.node;

import at_2020.TreeNode;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author hui.zhong
 * @date 2020/10/12
 */
public class MinimumAbsoluteDifferenceInBst {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);

        treeNode.right = treeNode1;
        treeNode1.left = treeNode2;

        System.out.println(getMinimumDifference(treeNode));
    }

    public static int getMinimumDifference(TreeNode root) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        traverseTree(root, treeSet);
        int min = Integer.MAX_VALUE;
        Iterator<Integer> iterator = treeSet.iterator();
        int pre = iterator.next();
        while (iterator.hasNext()) {
            int curr = iterator.next();
            int gap = Math.abs(pre - curr);
            min = Math.min(gap, min);
            pre = curr;
        }
        return min;
    }

    private static void traverseTree(TreeNode root, TreeSet<Integer> treeSet) {
        if (root == null) {
            return;
        }
        treeSet.add(root.val);
        if (root.left != null) {
            traverseTree(root.left, treeSet);
        }
        if (root.right != null) {
            traverseTree(root.right, treeSet);
        }
    }
}
