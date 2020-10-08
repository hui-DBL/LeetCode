package at_2020.string;

import java.util.*;

/**
 * @author hui.zhong
 * @date 2020-10-07
 */
public class SumOfDistancesInTree {

	public static void main(String[] args) {
		int[][] edges = {{1, 0}};
		sumOfDistancesInTree(2, edges);
	}

	public static int[] sumOfDistancesInTree(int N, int[][] edges) {
		if (edges.length == 0) {
			return new int[N];
		}
		Map<Integer, TreeNode> treeNodeMap = new HashMap<>(N);
		// 构造根（默认第一个）
		TreeNode head = new TreeNode(0);
		treeNodeMap.put(0, head);

		// 构造树
		for (int i = 0; i < edges.length; i++) {
			int[] edge = edges[i];
			int from = edge[0];
			int to = edge[1];
			if (edge[1] < edge[0]) {
				from = edge[1];
				to = edge[0];
			}
			TreeNode nodeFather = treeNodeMap.get(from);
			if (nodeFather == null) {
				nodeFather = new TreeNode(from);
				treeNodeMap.put(from, nodeFather);
			}

			TreeNode nodeSon = treeNodeMap.get(to);
			if (nodeSon == null) {
				nodeSon = new TreeNode(to);
				treeNodeMap.put(to, nodeSon);
			}

			nodeFather.subNodes.add(nodeSon);
		}
		// 遍历树（DFS），计算每一个节点被根节点遍历的路径
		Map<Integer, Set<Integer>> paths = new HashMap<>(N);
		Set<Integer> path = new HashSet<>(N);
		traverse(head, path, paths);
		// 确定，两两之间的差距
		int[] ans = new int[N];
		for (int i = 0; i < paths.size(); i++) {
			ans[i] = calAns(i, paths);
		}

		return ans;
	}

	private static int calAns(int i, Map<Integer, Set<Integer>> paths) {
		int ans = 0;
		Set<Integer> nodePath = paths.get(i);
		for (Map.Entry<Integer, Set<Integer>> entry : paths.entrySet()) {
			ans = ans + calAns(nodePath, entry.getValue());
		}
		return ans;
	}

	/**
	 * 寻找两个list之间的差异数字
	 *
	 * @param nodePath
	 * @param path
	 * @return
	 */
	private static int calAns(Set<Integer> nodePath, Set<Integer> path) {
		Set<Integer> vals = new HashSet<>(nodePath);
		vals.addAll(path);

		int num = 0;
		for (Integer val : vals) {
			if (nodePath.contains(val) && !path.contains(val)) {
				num++;
			}
			if (!nodePath.contains(val) && path.contains(val)) {
				num++;
			}
		}
		return num;
	}


	private static void traverse(TreeNode node, Set<Integer> path, Map<Integer, Set<Integer>> paths) {
		path.add(node.code);
		paths.put(node.code, new HashSet<>(path));
		if (node.subNodes.size() == 0) {
			path.remove(node.code);
		}
		for (TreeNode subNode : node.subNodes) {
			traverse(subNode, path, paths);
		}
	}
}

class TreeNode {
	public int code;

	public List<TreeNode> subNodes = new ArrayList<>();

	public TreeNode(int code) {
		this.code = code;
	}
}
