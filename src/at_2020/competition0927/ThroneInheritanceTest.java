package at_2020.competition0927;

import java.util.*;

/**
 * @author hui.zhong
 * @date 2020-09-27
 */
public class ThroneInheritanceTest {

	public static void main(String[] args) {
		ThroneInheritance1 t = new ThroneInheritance1("king"); // 继承顺序：king
		t.birth("king", "andy"); // 继承顺序：king > andy
		t.birth("king", "bob"); // 继承顺序：king > andy > bob
		t.birth("king", "catherine"); // 继承顺序：king > andy > bob > catherine
		t.birth("andy", "matthew"); // 继承顺序：king > andy > matthew > bob > catherine
		t.birth("bob", "alex"); // 继承顺序：king > andy > matthew > bob > alex > catherine
		t.birth("bob", "asha"); // 继承顺序：king > andy > matthew > bob > alex > asha > catherine
		t.getInheritanceOrder(); // 返回 ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
		t.death("bob"); // 继承顺序：king > andy > matthew > bob（已经去世）> alex > asha > catherine
		t.getInheritanceOrder(); // 返回 ["king", "andy", "matthew", "alex", "asha", "catherine"]
	}
}

class ThroneInheritance {

	String kingName;
	Map<String, List<String>> relation = new HashMap<>();
	Map<String, String> fatherRelation = new HashMap<>();
	Set<String> deathSet = new HashSet<>();

	public ThroneInheritance(String kingName) {
		this.kingName = kingName;
	}

	public void birth(String parentName, String childName) {
		List<String> childs = relation.get(parentName);
		if (childs == null) {
			childs = new ArrayList<>();
		}
		childs.add(childName);
		fatherRelation.put(childName, parentName);
		relation.put(parentName, childs);
	}

	public void death(String name) {
		deathSet.add(name);
	}

	public List<String> getInheritanceOrder() {
		List<String> order = new ArrayList<>();
		order.add(kingName);

		int index = 0;
		String name = successor(order.get(index), relation, fatherRelation, order);
		while (name != null) {
			order.add(name);
			index++;
			name = successor(order.get(index), relation, fatherRelation, order);
		}
		List<String> result = new ArrayList<>();
		for (String o : order) {
			if (deathSet.contains(o)) {
				continue;
			}
			result.add(o);
		}
		return result;
	}

	private String successor(String name, Map<String, List<String>> relation, Map<String, String> fatherRelation, List<String> order) {
		List<String> childs = relation.get(name);
		if (childs == null || order.containsAll(childs)) {
			if (name.equals(kingName)) {
				return null;
			} else {
				return successor(fatherRelation.get(name), relation, fatherRelation, order);
			}
		} else {
			String o = null;
			for (String child : childs) {
				if (order.contains(child)) {
					continue;
				} else {
					o = child;
					break;
				}
			}
			return o;
		}

	}
}

class ThroneInheritance1 {

	TreeNode treeNode;

	Map<String, TreeNode> treeNodeMap = new HashMap<>();

	public ThroneInheritance1(String kingName) {
		treeNode = new TreeNode(kingName, false);
		treeNodeMap.put(treeNode.name, treeNode);
	}

	public void birth(String parentName, String childName) {
		TreeNode node = treeNodeMap.get(parentName);
		List<TreeNode> nodes = node.treeNodes;
		if (nodes == null) {
			nodes = new LinkedList<>();
		}
		TreeNode newNode = new TreeNode(childName, false);
		nodes.add(newNode);
		treeNodeMap.put(newNode.name, newNode);
		node.treeNodes = nodes;
	}

	public void death(String name) {
		TreeNode node = treeNodeMap.get(name);
		node.death = true;
	}

	public List<String> getInheritanceOrder() {
		List<String> order = new LinkedList<>();
		getOrder(treeNode, order);
		return order;
	}

	private void getOrder(TreeNode treeNode, List<String> order) {
		if (!treeNode.death) {
			order.add(treeNode.name);
		}
		List<TreeNode> treeNodes = treeNode.treeNodes;
		if (treeNodes != null) {
			for (TreeNode child : treeNodes) {
				getOrder(child, order);
			}
		}

	}

//	private TreeNode findNodeByName(TreeNode treeNode, String name) {
//		if (treeNode.name.equals(name)) {
//			return treeNode;
//		}
//		List<TreeNode> nodes = treeNode.treeNodes;
//		if (nodes != null) {
//			for (TreeNode node : nodes) {
//				TreeNode tmp = findNodeByName(node, name);
//				if (tmp == null) {
//					continue;
//				}
//				return tmp;
//			}
//		}
//		return null;
//	}

	class TreeNode {
		String name;

		boolean death;

		List<TreeNode> treeNodes;

		public TreeNode(String name, boolean death) {
			this.name = name;
			this.death = death;
		}
	}
}

