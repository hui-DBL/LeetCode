package at_2020.node;

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {

    }

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        root.next = null;
        connectNext(root, root.left);
        return root;
    }

    private static void connectNext(Node root, Node subStart) {
        while (root != null) {
            if (root.left != null) {
                root.left.next = root.right;
            }
            if (root.right != null) {
                if (root.next != null) {
                    root.right.next = root.next.left;
                } else {
                    root.right.next = null;
                }
            }
            root = root.next;
        }
        if (subStart != null) {
            connectNext(subStart, subStart.left);
        }
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
