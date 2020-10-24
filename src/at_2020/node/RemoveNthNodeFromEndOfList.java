package at_2020.node;

import at_2018.util.ListNode;

/**
 * @author hui.zhong
 * @date 2020/10/18
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(removeNthFromEnd(node, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h = head;
        int len = traverse(head);
        if (len == 1) {
            return null;
        }
        if (len == n) {
            return h.next;
        }
        for (int i = 0; i < len - n - 1; i++) {
            head = head.next;
        }
        head.next = head.next.next;
        return h;
    }

    private static int traverse(ListNode head) {
        int len = 0;
        if (head != null) {
            len++;
        } else {
            return 0;
        }
        len = len + traverse(head.next);
        return len;
    }
}
