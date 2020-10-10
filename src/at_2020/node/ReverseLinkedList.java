package at_2020.node;

import at_2018.util.ListNode;

/**
 * @author hui.zhong
 * @date 2020/10/9
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        reverseList(node);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode next = head.next;
        head.next = pre;
        pre = head;

        while (next != null) {
            head = next;
            next = head.next;
            head.next = pre;
            pre = head;
        }
        return head;
    }
}

