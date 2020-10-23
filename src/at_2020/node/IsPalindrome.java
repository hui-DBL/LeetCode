package at_2020.node;

import at_2018.util.ListNode;

/**
 * @Author libing
 * @Date 2020/10/23
 */
public class IsPalindrome {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(1);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println(isPalindrome(node));
    }

    public static boolean isPalindrome(ListNode head) {
        int len = calNodeLen(head, 0);
        if (len <= 1) {
            return true;
        }
        int mid = len / 2;
        return reverseNodeAndJudge(head, mid, len % 2 == 0);
    }

    private static boolean reverseNodeAndJudge(ListNode head, int mid, boolean flag) {
        int index = 0;
        ListNode pre = null;
        ListNode current = head;
        if (current.next != null) {
            current = current.next;
        }
        head.next = pre;
        pre = head;
        index++;
        while (index < mid) {
            head = current;
            if (current.next != null) {
                current = current.next;
            }
            head.next = pre;
            pre = head;
            index++;
        }
        if (!flag) {
            current = current.next;
        }
        while (current != null) {
            if (current.val == head.val) {
                current = current.next;
                head = head.next;
            } else {
                return false;
            }
        }
        return true;
    }

    private static int calNodeLen(ListNode head, int len) {
        if (head == null) {
            return len;
        }
        return calNodeLen(head.next, ++len);
    }
}
