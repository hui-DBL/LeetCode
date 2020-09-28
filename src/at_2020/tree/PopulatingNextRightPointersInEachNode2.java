package at_2020.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hui.zhong
 * @date 2020-09-28
 */
public class PopulatingNextRightPointersInEachNode2 {

	public static void main(String[] args) {
		Node node = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		Node node3 = new Node(4);
		Node node4 = new Node(5);
		Node node5 = new Node(6);
		Node node6 = new Node(7);
		Node node7 = new Node(8);
		node.left = node1;
		node.right = node2;

		node1.left = node3;
		node1.right = node4;

		node2.right = node5;

		node3.left = node6;

		node5.right = node7;

//		connect(node);
		connect1(node);
	}

	static Node last = null;
	static Node nextStart = null;

	public static Node connect1(Node root) {
		if (root == null) {
			return null;
		}
		Node start = root;
		while (start != null) {
			last = null;
			nextStart = null;
			for (Node p = start; p != null; p = p.next) {
				if (p.left != null) {
					handle(p.left);
				}
				if (p.right != null) {
					handle(p.right);
				}
			}
			start = nextStart;
		}
		return root;
	}

	public static void handle(Node p) {
		if (last != null) {
			last.next = p;
		}
		if (nextStart == null) {
			nextStart = p;
		}
		last = p;
	}

	public static Node connect(Node root) {
		if (root == null) {
			return null;
		}
		List<Node> list = new ArrayList<>();
		list.add(root);
		connect(list);
		return root;
	}

	private static void connect(List<Node> list) {
		int size = list.size();
		if (size == 0) {
			return;
		}
		List<Node> nextList = new ArrayList<>(size * 2);
		for (int i = 0; i < size; i++) {
			Node node = list.get(i);
			if (i + 1 < size) {
				node.next = list.get(i + 1);
			} else {
				node.next = null;
			}

			if (node.left != null) {
				nextList.add(node.left);
			}
			if (node.right != null) {
				nextList.add(node.right);
			}
		}
		connect(nextList);
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