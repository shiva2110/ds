package ds.tree;

import org.junit.Assert;
import org.junit.Test;

public class TreeUtilTest {
	
	@Test
	public void testLookup() {
		Tree tree = new Tree(5,4);
		Assert.assertTrue(TreeUtil.lookup(4, tree));
		Assert.assertTrue(TreeUtil.lookup(5, tree));
		Assert.assertFalse(TreeUtil.lookup(6, tree));
		
		tree = new Tree(4);
		Assert.assertTrue(TreeUtil.lookup(4, tree));
		Assert.assertFalse(TreeUtil.lookup(5, tree));
		Assert.assertFalse(TreeUtil.lookup(6, tree));
		
		tree = new Tree(8,7,10,9);
		Assert.assertTrue(TreeUtil.lookup(9, tree));
		Assert.assertTrue(TreeUtil.lookup(8, tree));
		Assert.assertTrue(TreeUtil.lookup(10, tree));
		Assert.assertTrue(TreeUtil.lookup(7, tree));
		Assert.assertFalse(TreeUtil.lookup(6, tree));
	}
	
	@Test
	public void testSize() {
		Tree tree = new Tree(5);
		Assert.assertEquals(1, TreeUtil.findSize(tree));
		
		tree = new Tree(5,10,7,9);
		Assert.assertEquals(4, TreeUtil.findSize(tree));
		
		tree = new Tree(5,10,7,9,3,4);
		Assert.assertEquals(6, TreeUtil.findSize(tree));	
		
	}
	
	@Test
	public void testMaxDepth() {
		Tree tree = new Tree(5);
		Assert.assertEquals(1, TreeUtil.maxDepth(tree));
		
		tree = new Tree(5,10,7,9);
		Assert.assertEquals(4, TreeUtil.maxDepth(tree));
		
		tree = new Tree(5,10,7,9,3,4);
		Assert.assertEquals(4, TreeUtil.maxDepth(tree));	
		
		tree = new Tree(5,10,7,9,3,4,2,1);
		Assert.assertEquals(4, TreeUtil.maxDepth(tree));
		
		tree = new Tree(5,10,7,9,3,4,2,0,1);
		Assert.assertEquals(5, TreeUtil.maxDepth(tree));
	}
	
	@Test
	public void testMinValue() {
		Tree tree = new Tree(10, 8, 15, 9, 3, 5, 4, 2);
		Assert.assertEquals(2, TreeUtil.minValue(tree));
		
		tree = new Tree(10);
		Assert.assertEquals(10, TreeUtil.minValue(tree));
		
		tree = new Tree(10,13,15,12,11);
		Assert.assertEquals(10, TreeUtil.minValue(tree));
	}
	
	@Test
	public void testInOrder() {
		System.out.println("in order");
		Tree tree = new Tree(10, 8, 15, 9, 3, 5, 4, 2);
		TreeUtil.printInOrder(tree);
		
		tree = new Tree(4,2,5,1,3);
		TreeUtil.printInOrder(tree);
		
		tree = new Tree(10,17,15,16,20);
		TreeUtil.printInOrder(tree);
	}
	
	@Test
	public void testPostOrder() {
		System.out.println("post order");
		Tree tree = new Tree(10, 8, 15, 9, 3, 5, 4, 2);
		TreeUtil.postOrder(tree);
		
		tree = new Tree(4,2,5,1,3);
		TreeUtil.postOrder(tree);
		
		tree = new Tree(10,17,15,16,20);
		TreeUtil.postOrder(tree);
	}
	
	@Test
	public void testHasPathSum() {
		System.out.println("has path sum");
		Tree tree = new Tree(5,4,8,11,7,2,13,4,1);
		Assert.assertTrue(TreeUtil.hasPathSum(tree, 15));
		Assert.assertTrue(TreeUtil.hasPathSum(tree, 12));
		Assert.assertTrue(TreeUtil.hasPathSum(tree, 20));
		Assert.assertFalse(TreeUtil.hasPathSum(tree, 24));
		Assert.assertTrue(TreeUtil.hasPathSum(tree, 37));
	}
	
	@Test
	public void testPrintPaths() {
		System.out.println("print paths");
		Tree tree = new Tree(5,4,8,11,7,2,13,4,1);
		TreeUtil.printPaths(tree);
		
		System.out.println("----");
		tree = new Tree(5,11,13,15);
		TreeUtil.printPaths(tree);
	}
	
	@Test
	public void testMirror() {
		System.out.println("Mirror");
		Tree tree = new Tree(5,4,8);
		TreeUtil.mirror(tree);
		TreeUtil.printInOrder(tree);
		
		tree = new Tree(5,4,8,11,7,2,13,4,1);
		TreeUtil.mirror(tree);
		TreeUtil.printInOrder(tree);
	}
	
	@Test
	public void testSameTree() {
		System.out.println("same tree");
		Tree tree1 = new Tree(5,4,8,11,7,2,13,4,1);
		Tree tree2 = new Tree(5,4,8,11,7,2,13,4,1);
		Assert.assertTrue(TreeUtil.sameTree(tree1, tree2));
		
		tree1 = new Tree(5,4,8,11,7,2,13,4,1);
		tree2 = new Tree(5,4,8,11,7,13,4,1,2);
		Assert.assertFalse(TreeUtil.sameTree(tree1, tree2));
	}
	
	@Test
	public void testIsBST() {
		System.out.println("Is BST");
		Tree tree = new Tree(5,2,7);
		Assert.assertTrue(TreeUtil.isBST(tree));
		
		tree = new Tree(5);
		tree.top.left = new Node(6, null, null);
		tree.top.right = new Node(7, null, null);
		TreeUtil.printInOrder(tree);
		Assert.assertFalse(TreeUtil.isBST(tree));
		
		tree = new Tree(5,2,7,1);
		Assert.assertTrue(TreeUtil.isBST(tree));
		
		tree = new Tree(5);
		tree.top.left = new Node(2, null, null);
		tree.top.right = new Node(7, null, null);
		tree.top.left.left = new Node(1, null, null);
		tree.top.left.right = new Node(6, null, null);
		TreeUtil.printInOrder(tree);
		Assert.assertFalse(TreeUtil.isBST(tree));				
	}
	
	@Test
	public void testCount() {
		System.out.println("test count");
		Assert.assertEquals(14, TreeUtil.countTrees(4));
	}

}
