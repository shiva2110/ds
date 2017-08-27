package ds.list;

import junit.framework.Assert;

import org.junit.Test;

public class ListUtilTest {

	@Test
	public void testEquals() {
		LList<String> list = new LList<>();
		list.insert("a");
		LList<String> list2 = new LList<>();
		list2.insert("a");		
		Assert.assertEquals(list, list2);
		
		list = new LList<>();
		list.insert("a").insert("b");
		list2 = new LList<>();
		list2.insert("a").insert("b");
		Assert.assertEquals(list, list2);
		
		list = new LList<>();
		list.insert("b").insert("a");
		list2 = new LList<>();
		list2.insert("a").insert("b");
		Assert.assertFalse(list.equals(list2));
		
		list = new LList<>();
		list.insert("b").insert("a");
		list2 = new LList<>();
		list2.insert("b").insert("a").insert("c");
		Assert.assertFalse(list.equals(list2));
		
		list = new LList<>();
		list.insert("b").insert("a").insert("c").insert("d");
		list2 = new LList<>();
		list2.insert("b").insert("a").insert("c");
		Assert.assertFalse(list.equals(list2));
		
		Assert.assertEquals(list, list);
		Assert.assertFalse(list.equals("A"));
	}
	
	@Test
	public void testRemoveDup() {
		LList<String> list = new LList<>();
		Assert.assertEquals(new LList<String>(), ListUtil.removeDup(list));
		
		list = new LList<>();
		list.insert("a");
		Assert.assertEquals(list, ListUtil.removeDup(list));
		
		list = new LList<>();
		list.insert("a").insert("b");
		Assert.assertEquals(list, ListUtil.removeDup(list));
		
		list = new LList<>();
		list.insert("a").insert("a");		
		LList<String> list2 = new LList<>();
		list2.insert("a");
		Assert.assertEquals(list2, ListUtil.removeDup(list));
		
		list = new LList<>();
		list.insert("a").insert("b").insert("a").insert("b").insert("c");
	    list2 = new LList<>();
		list2.insert("a").insert("b").insert("c");
		Assert.assertEquals(list2, ListUtil.removeDup(list));
		
		list = new LList<>();
		list.insert("a").insert("b").insert("c").insert("d").insert("d");
	    list2 = new LList<>();
		list2.insert("a").insert("b").insert("c").insert("d");
		Assert.assertEquals(list2, ListUtil.removeDup(list));
		
		list = new LList<>();
		list.insert("a").insert("b").insert("c").insert("d").insert("e");
	    list2 = new LList<>();
		list2.insert("a").insert("b").insert("c").insert("d").insert("e");
		Assert.assertEquals(list2, ListUtil.removeDup(list));
		
		list = new LList<>();
		list.insert("a").insert("b").insert("c").insert("c").insert("d").insert("e");
	    list2 = new LList<>();
		list2.insert("a").insert("b").insert("c").insert("d").insert("e");
		Assert.assertEquals(list2, ListUtil.removeDup(list));
		
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	public void testNthLast() {
		LList<String> list = new LList<>();
		ListUtil.findNth(list, 1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testNthLast1() {
		LList<String> list = new LList<>();
		list.insert("a");
		ListUtil.findNth(list, 1);
	}
	
	@Test
	public void testNthLast2() {
		LList<String> list = new LList<>();
		list.insert("a");
		Assert.assertEquals("a", ListUtil.findNth(list, 0));
		
	    list = new LList<>();
		list.insert("a").insert("b");
		Assert.assertEquals("b", ListUtil.findNth(list, 1));
		
		list = new LList<>();
		list.insert("a").insert("b");
		Assert.assertEquals("a", ListUtil.findNth(list, 0));
		
		list = new LList<>();
		list.insert("a").insert("b").insert("c");
		Assert.assertEquals("c", ListUtil.findNth(list, 2));
	}
	
	@Test
	public void testPrint() {
		LList<String> list = new LList<>();
		list.insert("a").insert("b").insert("c");
		System.out.println(ListUtil.printList(list));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testDeleteNode() {
		LList<String> list = new LList<>();
		list.insert("a").insert("b");
		ListUtil.deleteNode(list.head.next);
	}
	
	@Test
	public void testDeleteNode1() {
		LList<String> list = new LList<>();
		list.insert("a").insert("b");
		ListUtil.deleteNode(list.head);
		Assert.assertEquals("a", list.head.data);
		Assert.assertEquals(null, list.head.next);
	}
	
	@Test
	public void testDeleteNode2() {
		LList<String> list = new LList<>();
		list.insert("a").insert("b").insert("c");
		ListUtil.deleteNode(list.head.next);
		Assert.assertEquals("c", list.head.data);
		Assert.assertEquals("a", list.head.next.data);
		Assert.assertEquals(null, list.head.next.next);
	}
	
	@Test
	public void testFindNumber() {
		LList<Integer> list = new LList<>();
		list.insert(5).insert(1).insert(3);
		Assert.assertEquals(513.0, ListUtil.findNumber(list));
		
		list = new LList<>();
		Assert.assertEquals(0.0, ListUtil.findNumber(list));
		
		list = new LList<>();
		list.insert(5);
		Assert.assertEquals(5.0, ListUtil.findNumber(list));
		
		list = new LList<>();
		list.insert(5).insert(0);
		Assert.assertEquals(50.0, ListUtil.findNumber(list));	
	}
	
	@Test
	public void testFindSum() {
		LList<Integer> list = new LList<>();
		list.insert(0);
		LList<Integer> list2 = new LList<>();
		list2.insert(11);
		LList<Integer> sumList = ListUtil.findSum(list, list2);
		System.out.println("sum list: " + ListUtil.printList(sumList));
		
	}
	
	@Test
	public void testNumberList() {
		LList list = ListUtil.numberList(11);
		System.out.println(ListUtil.printList(list));
	}
}
