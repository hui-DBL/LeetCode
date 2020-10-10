package at_2020.node;

import at_2018.util.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hui.zhong
 * @date 2020/10/10
 */
public class LinkedListCycleii {

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<ListNode> nodes = new HashSet<>();
        nodes.add(head);
        while (head.next != null) {
            head = head.next;
            if (nodes.contains(head)) {
                return head;
            } else {
                nodes.add(head);
            }
        }
        return null;
    }
}
