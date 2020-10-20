package at_2020.node;

import at_2018.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author libing
 * @Date 2020/10/20
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;

        reorderList(node);
    }

    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> listNodeList = new ArrayList<>();
        traverse(head, listNodeList);
        int i = 0;
        for (; i < listNodeList.size() / 2; i++) {
            ListNode h = listNodeList.get(i);
            int tail = listNodeList.size() - i - 1;
            h.next = listNodeList.get(tail);
            if (i + 1 < listNodeList.size()) {
                h.next.next = listNodeList.get(i + 1);
            } else {
                h.next.next = null;
            }
        }
        listNodeList.get(i).next = null;
    }

    private static void traverse(ListNode head, List<ListNode> listNodeList) {
        if (head != null) {
            listNodeList.add(head);
            head = head.next;
            traverse(head, listNodeList);
        }
    }
}
