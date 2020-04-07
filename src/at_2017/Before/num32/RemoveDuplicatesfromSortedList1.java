package at_2017.Before.num32;

/**
 * Create by hui on 2017/8/27
 */
public class RemoveDuplicatesfromSortedList1 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        Solution1 solution1 = new Solution1();
        ListNode outList = solution1.deleteDuplicates(listNode);
        ListNode temp = outList;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}


class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
