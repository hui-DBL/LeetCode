package at_2018.LeetCode.linkedList;

import at_2018.util.ListNode;

public class RotateList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
        RemoveNthNodeFromEndofList.showListNode(listNode1);
        RemoveNthNodeFromEndofList.showListNode(rotateRight(listNode1, 2000000000));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        int len = RemoveNthNodeFromEndofList.calListNodeLen(head, 0);
        if (len <= 1 || k == 0 || (k % len) == 0) {
            return head;
        }
        int times = len > k ? k : k % len;
        for (int i = 0; i < times; i++) {
            head = rotate(head, len);
        }
        return head;
    }

    private static ListNode rotate(ListNode head, Integer len) {
        ListNode tmp = head;
        ListNode preEnd = RemoveNthNodeFromEndofList.direct2Node(head, len - 1);
        ListNode end = preEnd.next;
        end.next = tmp;
        preEnd.next = null;
        return end;
    }
}
