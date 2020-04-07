package at_2018.LeetCode.linkedList;

import at_2018.util.ListNode;
import at_2018.util.ListNodeUtil;

public class RemoveDuplicatesfromSortedListII {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNodeUtil.show(listNode);
        ListNodeUtil.show(deleteDuplicates(listNode));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode re = new ListNode(-1);
        ListNode tmp = re;
        ListNode last2 = head;

        while (head.next != null) {
            last2 = head;
            if (head.val != head.next.val) {
                tmp.next = new ListNode(head.val);
                tmp = tmp.next;
                head = head.next;
            } else {
                while (head.next != null) {
                    last2 = head;
                    if (head.val != head.next.val) {
                        head = head.next;
                        break;
                    } else {
                        head = head.next;
                    }
                }
            }
        }

        if (head.val != last2.val) {
            tmp.next = head;
        }

        return re.next;
    }
}
