package LeetCode.linkedList;

import util.ListNode;

public class SwapNodesinPairs {
    public static void main(String[] args) {

    }

    public static ListNode swapPairs(ListNode head) {
        int len = RemoveNthNodeFromEndofList.calListNodeLen(head, 0);
        ListNode re = head;
        for (int i = 0; i < len / 2; i++) {
            int index = 2 * i + 1;
            ListNode toSwapHead = RemoveNthNodeFromEndofList.direct2Node(re, index);
            ListNode newHead = swap(toSwapHead);
            if (i == 0) {
                re = newHead;
            } else {
                ListNode curNode = RemoveNthNodeFromEndofList.direct2Node(re, index - 1);
                curNode.next = newHead;
            }
        }
        return re;
    }

    private static ListNode swap(ListNode head) {
        ListNode tmp = head.next;
        head.next = head.next.next;
        tmp.next = head;
        head = tmp;
        return head;
    }
}
