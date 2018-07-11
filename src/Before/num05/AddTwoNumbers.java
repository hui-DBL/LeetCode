package Before.num05;

/**
 * Created by usst609 on 2017/7/2.
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(4);

        Solution solution = new Solution();
        ListNode l4 = solution.addTwoNumbers(l1, l2);
        while (l4 != null) {
            System.out.println(l4.val);
            l4 = l4.next;
        }
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(l1.val + l2.val);
        int flag = 0;
        if (l3.val >= 10) {
            l3.val = l3.val - 10;
            flag = 1;
        }
        ListNode l4 = l3;//头结点
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            if (flag == 1) {
                l3.next = new ListNode(l1.val + l2.val + 1);//注意这里是l3.next,l3这里是标杆的作用
                flag = 0;
                if (l3.next.val >= 10) {
                    l3.next.val = l3.next.val - 10;
                    flag = 1;
                }
                l1 = l1.next;
                l2 = l2.next;
                l3 = l3.next;
            } else {
                l3.next = new ListNode(l1.val + l2.val);
                if (l3.next.val >= 10) {
                    l3.next.val = l3.next.val - 10;
                    flag = 1;
                }
                l1 = l1.next;
                l2 = l2.next;
                l3 = l3.next;
            }
        }
        while (l1 != null) {
            if (flag == 1) {
                l3.next = new ListNode(l1.val + 1);
                flag = 0;
                if (l3.next.val >= 10) {
                    l3.next.val = l3.next.val - 10;
                    flag = 1;
                }
                l1 = l1.next;
                l3 = l3.next;
            } else {
                l3.next = new ListNode(l1.val);
                if (l3.next.val >= 10) {
                    l3.next.val = l3.next.val - 10;
                    flag = 1;
                }
                l1 = l1.next;
                l3 = l3.next;
            }
        }

        while (l2 != null) {
            if (flag == 1) {
                l3.next = new ListNode(l2.val + 1);
                flag = 0;
                if (l3.next.val >= 10) {
                    l3.next.val = l3.next.val - 10;
                    flag = 1;
                }
                l2 = l2.next;
                l3 = l3.next;
            } else {
                l3.next = new ListNode(l2.val);
                if (l3.next.val >= 10) {
                    l3.next.val = l3.next.val - 10;
                    flag = 1;
                }
                l2 = l2.next;
                l3 = l3.next;
            }
        }
        if (flag == 1) {
            l3.next = new ListNode(1);
            flag = 0;
        }
        return l4;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
/*-----------------------------------------------------------*/


