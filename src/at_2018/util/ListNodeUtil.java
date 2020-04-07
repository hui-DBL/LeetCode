package at_2018.util;

import at_2018.LeetCode.linkedList.RemoveNthNodeFromEndofList;

public class ListNodeUtil {

    public static void show(ListNode listNode) {
        RemoveNthNodeFromEndofList.showListNode(listNode);
    }

    public static int calListNodeLen(ListNode listNode) {
        return RemoveNthNodeFromEndofList.calListNodeLen(listNode, 0);
    }
}
