package LeetCode.linkedList;

import util.ListNode;
import util.ListNodeUtil;

public class PartitionList {
    public static void main(String[] args) {
        //1->4->3->2->5->2
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNodeUtil.show(listNode1);
        System.out.println();
        ListNodeUtil.show(partition(listNode1, 3));

    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode h1 = null;
        ListNode h2 = null;

        int len = ListNodeUtil.calListNodeLen(head);
        for (int i = 0; i < len; i++) {
            ListNode tmp = new ListNode(head.val);
            if (head.val < x) {
                if (h1 == null) {
                    h1 = tmp;
                } else {
                    ListNode t1 = h1;
                    while (t1.next != null) {
                        t1 = t1.next;
                    }
                    t1.next = tmp;
                }
            } else {
                if (h2 == null) {
                    h2 = tmp;
                } else {
                    ListNode t2 = h2;
                    while (t2.next != null) {
                        t2 = t2.next;
                    }
                    t2.next = tmp;
                }
            }

            head = head.next;
        }

        connectListNode(h1, h2);

        return h1;
    }

    private static void connectListNode(ListNode h1, ListNode h2) {
        ListNode tmp = h1;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = h2;
    }
}
