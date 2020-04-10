package at_2020.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hui.zhong
 * @date 2020-04-10
 */
public class ConvertSortedListtoBinarySearchTree {
	public static void main(String[] args) {
		ListNode node = new ListNode(-10);
		node.next = new ListNode(-3);
		node.next.next = new ListNode(0);
		node.next.next.next = new ListNode(5);
		node.next.next.next.next = new ListNode(9);
		sortedListToBST(node);
	}

	public static TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		// 展开
		List<Integer> list = traverseList(head);
		//确定root
		return buildTree(list);
	}

	private static TreeNode buildTree(List<Integer> list) {
		if (list.size() == 0) {
			return null;
		}
		int index = list.size() / 2;
		TreeNode root = new TreeNode(list.get(index));
		root.left = buildTree(list.subList(0, index));
		root.right = buildTree(list.subList(index + 1, list.size()));
		return root;
	}

	private static List<Integer> traverseList(ListNode head) {
		List<Integer> list = new ArrayList<>();
		for (; ; ) {
			if (head == null) {
				break;
			}
			list.add(head.val);
			head = head.next;
		}
		return list;
	}
}


class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}