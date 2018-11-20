package LeetCode.linkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(7);
        head.next = node1;
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(6);
        node2.next = node3;
        ListNode node4 = new ListNode(6);
        node3.next = node4;
        ListNode node5 = new ListNode(8);
        node4.next = node5;
        ListNode node6 = new ListNode(0);
        node5.next = node6;
        ListNode node7 = new ListNode(3);
        node6.next = node7;
        int n = 5;
        showListNode(head);
        ListNode newHead = SwapNodesinPairs.swapPairs(head);
        showListNode(newHead);
        showListNode(removeNthFromEnd(head, n));
    }

    public static void showListNode(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        System.out.println(listNode.val);
        showListNode(listNode.next);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int len = calListNodeLen(head, 0);
        int toDelIndex = len - n + 1;
        ListNode preDelNode = direct2Node(head, toDelIndex - 1);
        if (preDelNode != null) {
            if (preDelNode.next != null) {
                preDelNode.next = preDelNode.next.next;
            }
        } else {
            head = head.next;
        }
        return head;
    }

    public static ListNode direct2Node(ListNode head, int i) {
        if (head == null || i == 1) {
            return head;
        }
        head = head.next;
        i = i - 1;
        return direct2Node(head, i);
    }

    public static int calListNodeLen(ListNode listNode, int n) {
        if (listNode == null) {
            return n;
        }
        int re = n + 1;
        ListNode next = listNode.next;
        re = calListNodeLen(next, re);
        return re;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}