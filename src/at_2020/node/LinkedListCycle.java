package at_2020.node;

import at_2018.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hui.zhong
 * @date 2020-10-09
 */
public class LinkedListCycle {
	public static void main(String[] args) {

	}

	public static boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		Set<ListNode> vals = new HashSet<>();
		vals.add(head);
		boolean flag = false;
		while (head.next != null) {
			head = head.next;
			if (vals.contains(head)) {
				flag = true;
				break;
			} else {
				vals.add(head);
			}
		}
		return flag;
	}
}
