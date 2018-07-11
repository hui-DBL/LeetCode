package Before.num05;

/**
 * Created by usst609 on 2017/7/2.
 */
public class AddTwoNumbers_1 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(4);

        Solution_1 solution_1 = new Solution_1();
        ListNode l4 = solution_1.addTwoNumbers(l1, l2);
        while (l4 != null) {
            System.out.println(l4.val);
            l4 = l4.next;
        }
    }
}

class Solution_1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode l3 = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            l3.next = new ListNode(l1.val + l2.val + carry);
            carry = l3.next.val / 10;
            l3.next.val = l3.next.val % 10;
            l3 = l3.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            l3.next = new ListNode(l1.val + carry);
            carry = l3.next.val / 10;
            l3.next.val = l3.next.val % 10;
            l3 = l3.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            l3.next = new ListNode(l2.val + carry);
            carry = l3.next.val / 10;
            l3.next.val = l3.next.val % 10;
            l3 = l3.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            l3.next = new ListNode(carry);
        }
        return head.next;
    }
}
