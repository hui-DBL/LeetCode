package at_2020.node;

import at_2018.util.ListNode;

public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;

        System.out.println(swapPairs(node));
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode re = null;

        ListNode pPre = null;
        ListNode pre = null;
        int index = 0;
        ListNode curr = head;
        ListNode tmp = curr.next;
        while (tmp != null) {
            pre = curr;
            curr = tmp;
            tmp = tmp.next;
            if (index % 2 == 0) {
                curr.next = pre;
                pre.next = tmp;
                if (pPre != null) {
                    pPre.next = curr;
                } else {
                    re = curr;
                }
                pPre = pre;
            }
            index++;
        }
        if (re == null) {
            re = curr;
        }
        return re;
    }
}
