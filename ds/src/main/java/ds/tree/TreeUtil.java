package ds.tree;

public class TreeUtil {
	
	public static boolean lookup(int data, Tree tree) {
		if (tree == null) {
			throw new IllegalArgumentException();
		}
		
		if (tree.top == null) {
			return false;
		}
		
		return lookupRec(tree.top, data);
	}
	
	private static boolean lookupRec(Node node, int data) {
		
		if (node == null) {
			return false;
		}
		
		if (node.data == data) {
			return true;
		}else if (data < node.data) {
			return lookupRec(node.left, data);
		} else {
			return lookupRec(node.right, data);
		}
	}
	
	public static int findSize(Tree tree) {
		return size(tree.top);
		
	}
	
	private static int size(Node node) {
		if (node == null) {
			return 0;
		}
		
		return size(node.left) + size(node.right) + 1;
	}
	
	public static int maxDepth(Tree tree) {
		return maxDepth(tree.top);
	}
	
	public static int minValue(Tree tree) {
		if (tree == null || tree.top == null) {
			throw new IllegalArgumentException();
		}
		
		Node node = tree.top;		
		while(node.left!=null) {
			node = node.left;
		}
		return node.data;
	}
	
	public static void printInOrder(Tree tree) {
		if (tree == null) {
			throw new IllegalArgumentException();
		}
		
		inOrder(tree.top);
		System.out.println("");
	}
	
	public static boolean sameTree(Tree tree1, Tree tree2) {
		if (tree1 == null || tree2 == null) {
			throw new IllegalArgumentException();
		}
		
		return sameTree(tree1.top, tree2.top);		
	}
	
	private static boolean sameTree(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return true;
		} else if (node1 == null || node2 == null) {
			return false;
		}
		
		if (node1.data != node2.data) {
			return false;
		} else {
			return sameTree(node1.left, node2.left) && sameTree(node1.right, node2.right);
		}
	}
	
	public static void postOrder(Tree tree) {
		if (tree == null) {
			throw new IllegalArgumentException();
		}
		
		postOrder(tree.top);
		System.out.println("");
	}
	
	public static boolean hasPathSum(Tree tree, int sum) {
		if (tree==null || tree.top == null) {
			throw new IllegalArgumentException();
		}
		
		return hasPathSum(tree.top, sum);
		
	}
	
	private static boolean hasPathSum(Node node, int sum) {
		if (node.left == null && node.right == null) {
		   return ((sum - node.data) == 0) ? true : false;		   
		}
		
		boolean left = (node.left != null) ? hasPathSum(node.left, (sum - node.data)) : false;
		return left || ( (node.right != null) ? hasPathSum(node.right, (sum - node.data)) : false );
	}

	private static void postOrder(Node node) {
		if (node==null) {
			return;
		}
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");
	}
	
	public static void printPaths(Tree tree) {
		if(tree == null || tree.top == null) {
			throw new IllegalArgumentException();
		}
		
		printPaths(tree.top, "");
		
	}
	
	public static void mirror(Tree tree) {
		if (tree == null || tree.top == null) {
			throw new IllegalArgumentException();
		}
		
		mirror(tree.top);
	}
	
	private static void mirror(Node node) {
		if (node == null) {
			return;
		}
		
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
		
		mirror(node.left);
		mirror(node.right);
	}
	
	private static void printPaths(Node node, String str) {
		
		String appendStr = str.isEmpty() ? String.valueOf(node.data) : (str + " " + node.data);
		if (node.left == null && node.right == null) {
			System.out.println(appendStr);
			return;
		}
		
		if (node.left != null) {
			printPaths(node.left, appendStr);
		}
		
		if (node.right != null) {
			printPaths(node.right, appendStr);
		}
	}
	
	private static void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}
	
	public static int countTrees(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		
		int sum = 0;
		for (int i=0; i<=(n-1); i++) {
			int left = countTrees(i);
			int right = countTrees( (n-1) - i );
			int middle = 1;
			sum = sum + (left * right * middle);
		}
		return sum;
	}
	
	public static boolean isBST(Tree tree) {
		if (tree == null) {
			throw new IllegalArgumentException();
		}
		
		return isBST(tree.top, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
	
	private static boolean isBST(Node node, int max, int min) {
		
		if (node == null) {
			return true;
		}
		
		if (node.data > min && node.data <= max) {
			return isBST(node.left, node.data, min) && isBST(node.right, max, node.data);
		} else {
			return false;
		}
	}
	
	private static int maxDepth(Node node) {
		if (node == null) {
			return 0;
		}
		
		int leftDepth = maxDepth(node.left);
		int rightDepth = maxDepth(node.right);
		return (leftDepth > rightDepth) ? (leftDepth + 1) : (rightDepth + 1);
	}

}
