package at_2020.DivideAndConquer;

import at_2018.util.ListNode;
import at_2018.util.ListNodeUtil;

/**
 * @author hui.zhong
 * @date 2020-07-20
 */
public class MergeKSortedLists {

	public static void main(String[] args) {
		ListNode[] listNodes = new ListNode[3];

		ListNode listNode0 = new ListNode(1);
		ListNode listNode1 = new ListNode(4);
		listNode0.next = listNode1;
		ListNode listNode2 = new ListNode(5);
		listNode1.next = listNode2;

		ListNode listNode00 = new ListNode(1);
		ListNode listNode11 = new ListNode(3);
		listNode00.next = listNode11;
		ListNode listNode22 = new ListNode(4);
		listNode11.next = listNode22;

		ListNode listNode000 = new ListNode(2);
		ListNode listNode111 = new ListNode(6);
		listNode000.next = listNode111;

		listNodes[0] = listNode0;
		listNodes[1] = listNode00;
		listNodes[2] = listNode000;
		ListNodeUtil.show(mergeKLists(listNodes));
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		ListNode head = new ListNode(1);
		ListNode tem = new ListNode(1);
		int index = 0;
		for (; ; ) {
			ListNode minValNode = getMinNode(lists);
			if (minValNode == null) {
				break;
			}
			if (index == 0) {
				head = minValNode;
				tem = minValNode;
			} else {
				tem.next = minValNode;
				tem = tem.next;
			}
			index++;
		}
		if (index == 0) {
			return null;
		}
		return head;
	}

	private static ListNode getMinNode(ListNode[] lists) {
		ListNode min = null;
		int index = 0;
		for (int i = 0; i < lists.length; i++) {
			ListNode tmp = lists[i];
			if (tmp == null) {
				continue;
			}
			if (min == null) {
				min = tmp;
				index = i;
			} else {
				if (min.val > lists[i].val) {
					min = tmp;
					index = i;
				}
			}
		}
		if (lists[index] == null) {
			return null;
		}
		lists[index] = lists[index].next;
		return min;
	}

//	private static int getTotal(ListNode[] lists) {
//		int total = 0;
//		for (int j = 0; j < lists.length; j++) {
//			int i = 0;
//			int len = getLen(lists[j], i);
//			total += len;
//		}
//		return total;
//	}

	private static int getLen(ListNode list, int i) {
		if (list == null) {
			return i;
		}
		return getLen(list, ++i);
	}


}
