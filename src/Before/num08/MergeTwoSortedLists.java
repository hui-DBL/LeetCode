package Before.num08;

/**
 * Created by zhonghui on 2017/7/5.
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(5);

        Solution solution = new Solution();
        ListNode l = solution.mergeTwoLists(l1, l2);
        while (l != null) {
            System.out.println(l.val);
            l=l.next;
        }
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode l = new ListNode(0);
        ListNode head = l;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {//降序或升序
                l.next = new ListNode(0);
                l.next.val = l1.val;
                l1 = l1.next;
                l = l.next;
            } else if (l1.val == l2.val) {//元素是否唯一
                l.next = new ListNode(0);
                l.next.val = l1.val;
                l1 = l1.next;
                l = l.next;
                l.next = new ListNode(0);
                l.next.val = l2.val;
                l2 = l2.next;
                l = l.next;
            } else {
                l.next = new ListNode(0);
                l.next.val = l2.val;
                l2 = l2.next;
                l = l.next;
            }
        }
        while (l1 != null) {
            l.next = new ListNode(0);
            l.next.val = l1.val;
            l1 = l1.next;
            l = l.next;
        }

        while (l2 != null) {
            l.next = new ListNode(0);
            l.next.val = l2.val;
            l2 = l2.next;
            l = l.next;
        }
        return head.next;
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
