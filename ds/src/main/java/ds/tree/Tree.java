package ds.tree;

public class Tree {	
	Node top;
	
	public Tree(int... datas) {
		for (int data: datas) {
			insert(data);
		}
	}
	
	public void insert(int data) {
		this.top = insertRec(top, data);
	}
	
	private Node insertRec(Node node, int data) {
		if (node == null) {
			return new Node(data, null, null);
		} else {
			if (data <= node.data) {
				node.left = insertRec(node.left, data);
			} else {
				node.right = insertRec(node.right, data);
			}
			return node;
		}
	}
}
