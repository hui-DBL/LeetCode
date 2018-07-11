package Before.num07;

/**
 * 相当于实现一个简易的栈，实现栈的话，用数组还是链表？
 * 这里用链表实现比较好，因为链表本来就是反向的，出栈的情况刚好适合。
 * 怎么判定这个是括号的左右
 *
 * Created by zhonghui on 2017/7/4.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String s = new String("(([[{{}}]]))");
        Solution solution = new Solution();
        System.out.println(solution.isValid(s));
    }
}

class Solution {
    public boolean isValid(String s) {//
        int len = s.length();
        if (len == 0 || s == null || len % 2 != 0) {
            return false;
        }
        NodeList nodeList = new NodeList();

        for (int i = 0; i < len; i++) {
            if (toNum(s.charAt(i)) <= 3) {
                nodeList.push(toNum(s.charAt(i)));
            } else {
                if (nodeList.len > 0 && toNum(s.charAt(i)) - nodeList.head.val == 3) {//坑
                    nodeList.pop();
                } else {
                    return false;
                }
            }
        }
        if (nodeList.len == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int toNum(char c) {
        if (c == '(') {
            return 1;
        } else if (c == '[') {
            return 2;
        } else if (c == '{') {
            return 3;
        } else if (c == ')') {
            return 4;
        } else if (c == ']') {
            return 5;
        } else if (c == '}') {
            return 6;
        } else {
            return 7;
        }
    }
}

class NodeList {//实现栈
    int len;
    Node head;
    Node temp;

    NodeList() {
        len = 0;
        head = null;
        temp = null;
    }

    void push(int n) {
        temp = new Node(n);
        len++;
        temp.next = head;//坑
        head = temp;
    }

    void pop() {
        len--;
        head = head.next;
    }

}

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        next = null;
    }
}
//进栈，出栈
/*-----------------------------------------------------------*/

