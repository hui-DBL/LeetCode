package at_2017.Before.num32;

/**
 * Create by hui on 2017/8/27
 */
public class RemoveDuplicatesfromSortedList {
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
        Solution solution = new Solution();
        ListNode outList = solution.deleteDuplicates(listNode);
        ListNode temp = outList;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        ListNode nextTemp = temp.next;
        while (nextTemp != null) {
            if (nextTemp.val == temp.val) {
                temp.next = nextTemp.next;
            } else {
                temp = nextTemp;
            }
            if (nextTemp.next == null) {
                nextTemp = null;
            } else {
                nextTemp = temp.next;
            }
        }
        return head;
    }
}