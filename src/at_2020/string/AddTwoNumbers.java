package at_2020.string;

/**
 * @author hui.zhong
 * @date 2020-10-04
 */
public class AddTwoNumbers {

	public static void main(String[] args) {

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode();
		ListNode head = result;
		int addNum = 0;
		while (l1 != null && l2 != null) {
			int tmp = l1.val + l2.val + addNum;
			if (tmp >= 10) {
				result.next = new ListNode(tmp - 10);
				addNum = 1;
			} else {
				result.next = new ListNode(tmp);
				addNum = 0;
			}
			l1 = l1.next;
			l2 = l2.next;
			result = result.next;
		}
		while (l1 != null) {
			int tmp = l1.val + addNum;
			if (tmp >= 10) {
				result.next = new ListNode(tmp - 10);
				addNum = 1;
			} else {
				result.next = new ListNode(tmp);
				addNum = 0;
			}
			l1 = l1.next;
			result = result.next;
		}
		while (l2 != null) {
			int tmp = l2.val + addNum;
			if (tmp >= 10) {
				result.next = new ListNode(tmp - 10);
				addNum = 1;
			} else {
				result.next = new ListNode(tmp);
				addNum = 0;
			}
			l2 = l2.next;
			result = result.next;
		}
		if (addNum > 0) {
			result.next = new ListNode(addNum);
		}
		return head.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
