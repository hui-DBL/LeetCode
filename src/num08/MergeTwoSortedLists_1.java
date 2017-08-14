package num08;

/**
 * Created by zhonghui on 2017/7/5.
 */
public class MergeTwoSortedLists_1 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(5);

        Solution_1 solution_1 = new Solution_1();
        ListNode l = solution_1.mergeTwoLists(l1, l2);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }
}

class Solution_1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode lastNode = l;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;

            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode=lastNode.next;//公共的操作可以提取
        }
        if (l1 != null) {//直接续上
            lastNode.next = l1;
        }
        if (l2 != null) {
            lastNode.next = l2;
        }
        return l.next;
    }
}
/*-----------------------------------------------------------*/

