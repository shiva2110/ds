package ds.list;

import java.util.Map;

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
		System.out.println("testing");
	}
	
	@Test
	public void testReverseList() {
	    System.out.println("test reverse list");
	    LList<String> list = new LList<>();
	    list.insert("a").insert("b");
	    System.out.println(ListUtil.printList(list));
	    ListUtil.reverse(list);
	    System.out.println(ListUtil.printList(list));
	}
	
	@Test
    public void testReverseList1() {
        System.out.println("test reverse list");
        LList<String> list = new LList<>();
        list.insert("a");
        System.out.println(ListUtil.printList(list));
        ListUtil.reverse(list);
        System.out.println(ListUtil.printList(list));
    }
	
	@Test
    public void testReverseList2() {
        System.out.println("test reverse list");
        LList<String> list = new LList<>();
        list.insert("a").insert("b").insert("c");
        System.out.println(ListUtil.printList(list));
        ListUtil.reverse(list);
        System.out.println(ListUtil.printList(list));
    }
	
	@Test
    public void testReverseList3() {
        System.out.println("test reverse list");
        LList<String> list = new LList<>();
        list.insert("a").insert("b").insert("c").insert("d");
        System.out.println(ListUtil.printList(list));
        ListUtil.reverse(list);
        System.out.println(ListUtil.printList(list));
    }
	
	@Test
	public void testInsertAt() {
	    System.out.println("testInsertAt");
	    LList<String> list = new LList<>();
	    list.insertT("a").insertT("b").insertT("c");
	    ListUtil.insertAt(list, 0, "z");
	    System.out.println(ListUtil.printList(list));
	    
	    list = new LList<>();
        list.insertT("a").insertT("c").insertT("d");
	    ListUtil.insertAt(list, 1, "b");
        System.out.println(ListUtil.printList(list));
        
        list = new LList<>();
        list.insertT("a").insertT("b").insertT("c");
        ListUtil.insertAt(list, 3, "d");
        System.out.println(ListUtil.printList(list));
	}
	
	@Test (expected = IllegalArgumentException.class)
    public void testInsertAt1() {        
        LList<String> list = new LList<>();
        list.insertT("a").insertT("b").insertT("c");
        ListUtil.insertAt(list, 4, "d");
        System.out.println(ListUtil.printList(list));
    }
	
	@Test
	public void testSortedInsert() {
		System.out.println("test sorted insert!");
		LList<Integer> list = new LList<>();
		list.insertT(4).insertT(5).insertT(6);
		ListUtil.sortedInsert(list, 3);
		System.out.println(ListUtil.printList(list));
		
		list = new LList<>();
		list.insertT(4).insertT(6).insertT(7);
		ListUtil.sortedInsert(list, 5);
		System.out.println(ListUtil.printList(list));
		
		list = new LList<>();
		list.insertT(4).insertT(5).insertT(7);
		ListUtil.sortedInsert(list, 6);
		System.out.println(ListUtil.printList(list));
		
		list = new LList<>();
		list.insertT(4).insertT(5).insertT(7);
		ListUtil.sortedInsert(list, 8);
		System.out.println(ListUtil.printList(list));
		
		list = new LList<>();
		ListUtil.sortedInsert(list, 8);
		System.out.println(ListUtil.printList(list));
		
	}
	
	@Test
	public void testInsertSort() {
		System.out.println("testInsertSort");
		LList<Integer> list = new LList<>();
		list.insertT(5).insertT(4).insertT(3).insertT(2);
		LList<Integer> sortedList = ListUtil.insertSort(list);
		System.out.println(ListUtil.printList(sortedList));
		
		list = new LList<>();
		list.insertT(2).insertT(4).insertT(5).insertT(7);
		sortedList = ListUtil.insertSort(list);
		System.out.println(ListUtil.printList(sortedList));
		
		list = new LList<>();
		list.insertT(2);
		sortedList = ListUtil.insertSort(list);
		System.out.println(ListUtil.printList(sortedList));
		
		list = new LList<>();
		list.insertT(2).insertT(1);
		sortedList = ListUtil.insertSort(list);
		System.out.println(ListUtil.printList(sortedList));
	}
	
	@Test
	public void testAppend() {
		System.out.println("test append");
		LList<Integer> list1 = new LList<Integer>(1,2,3);
		LList<Integer> list2 = new LList<Integer>(4,5);
		LList<Integer> list3 = ListUtil.append(list1, list2);
		System.out.println(ListUtil.printList(list3));
		
		list1 = new LList<Integer>();
		list2 = new LList<Integer>(4,5);
		list3 = ListUtil.append(list1, list2);
		System.out.println(ListUtil.printList(list3));
		
		list1 = new LList<Integer>(1,2,3);
		list2 = new LList<Integer>();
		list3 = ListUtil.append(list1, list2);
		System.out.println(ListUtil.printList(list3));
		
		list1 = new LList<Integer>(1);
		list2 = new LList<Integer>(2);
		list3 = ListUtil.append(list1, list2);
		System.out.println(ListUtil.printList(list3));
		
		list1 = new LList<Integer>();
		list2 = new LList<Integer>();
		list3 = ListUtil.append(list1, list2);
		System.out.println(ListUtil.printList(list3));
	}
	
	@Test
	public void testFBSplit() {
		System.out.println("test FB split");
		LList<Integer> list = new LList<Integer>(1);
		Map<String, LList<Integer>> map = ListUtil.frontBackSplit(list);
		System.out.println("front: " + ListUtil.printList(map.get("front")));
		System.out.println("back: " + ListUtil.printList(map.get("back")));
		
		list = new LList<Integer>(1,2);
		map = ListUtil.frontBackSplit(list);
		System.out.println("front: " + ListUtil.printList(map.get("front")));
		System.out.println("back: " + ListUtil.printList(map.get("back")));
		
		list = new LList<Integer>(1,2,3);
		map = ListUtil.frontBackSplit(list);
		System.out.println("front: " + ListUtil.printList(map.get("front")));
		System.out.println("back: " + ListUtil.printList(map.get("back")));
		
		list = new LList<Integer>(1,2,3,4);
		map = ListUtil.frontBackSplit(list);
		System.out.println("front: " + ListUtil.printList(map.get("front")));
		System.out.println("back: " + ListUtil.printList(map.get("back")));
		
		list = new LList<Integer>(1,2,3,4,5);
		map = ListUtil.frontBackSplit(list);
		System.out.println("front: " + ListUtil.printList(map.get("front")));
		System.out.println("back: " + ListUtil.printList(map.get("back")));
		
		list = new LList<Integer>();
		map = ListUtil.frontBackSplit(list);
		System.out.println("front: " + ListUtil.printList(map.get("front")));
		System.out.println("back: " + ListUtil.printList(map.get("back")));
	}
	
	@Test
	public void testSortedDupRemove() {
		System.out.println("testSortedDupRemove");
		LList<Integer> list = new LList<Integer>(1);
		ListUtil.sortedDupRemove(list);
		System.out.println(ListUtil.printList(list));
		
		list = new LList<Integer>(1,1);
		ListUtil.sortedDupRemove(list);
		System.out.println(ListUtil.printList(list));
		
		list = new LList<Integer>(1,1,2,2);
		ListUtil.sortedDupRemove(list);
		System.out.println(ListUtil.printList(list));
		
		list = new LList<Integer>(1,1,2);
		ListUtil.sortedDupRemove(list);
		System.out.println(ListUtil.printList(list));
		
		list = new LList<Integer>(1,1,2,2,3);
		ListUtil.sortedDupRemove(list);
		System.out.println(ListUtil.printList(list));
		
		list = new LList<Integer>(1,1,2,2,3,4,5,5);
		ListUtil.sortedDupRemove(list);
		System.out.println(ListUtil.printList(list));
	}
	
	@Test
	public void testAlternatingSplit() {
		System.out.println("test alternating split");
		LList<Integer> list = new LList<Integer>(1,2,3);
		Map<String, LList<Integer>> map = ListUtil.alternatingSplit(list);
		System.out.println("front: " + ListUtil.printList(map.get("front")));
		System.out.println("back: " + ListUtil.printList(map.get("back")));
		
		list = new LList<Integer>(1,2);
		map = ListUtil.alternatingSplit(list);
		System.out.println("front: " + ListUtil.printList(map.get("front")));
		System.out.println("back: " + ListUtil.printList(map.get("back")));
		
		list = new LList<Integer>(1,2,3,4);
		map = ListUtil.alternatingSplit(list);
		System.out.println("front: " + ListUtil.printList(map.get("front")));
		System.out.println("back: " + ListUtil.printList(map.get("back")));
		
		list = new LList<Integer>(1,2,3,4,5);
		map = ListUtil.alternatingSplit(list);
		System.out.println("front: " + ListUtil.printList(map.get("front")));
		System.out.println("back: " + ListUtil.printList(map.get("back")));
		
		list = new LList<Integer>(1,2,3,4,5,6);
		map = ListUtil.alternatingSplit(list);
		System.out.println("front: " + ListUtil.printList(map.get("front")));
		System.out.println("back: " + ListUtil.printList(map.get("back")));
		
		list = new LList<Integer>(1);
		map = ListUtil.alternatingSplit(list);
		System.out.println("front: " + ListUtil.printList(map.get("front")));
		System.out.println("back: " + ListUtil.printList(map.get("back")));
	}
	
	@Test
	public void testShuffleMerge() {
		System.out.println("test shuffle merge");
		LList<String> list1 = new LList<>("a", "b", "c");
		LList<String> list2 = new LList<>("d", "e", "f");
		ListUtil.shuffleMerge(list1, list2);
		System.out.println(ListUtil.printList(list1));
		
		list1 = new LList<>("a", "b", "c");
		list2 = new LList<>("d", "e");
		ListUtil.shuffleMerge(list1, list2);
		System.out.println(ListUtil.printList(list1));
		
		list1 = new LList<>("a", "b");
		list2 = new LList<>("d", "e", "f");
		ListUtil.shuffleMerge(list1, list2);
		System.out.println(ListUtil.printList(list1));
		
		list1 = new LList<>("a");
		list2 = new LList<>("d", "e", "f");
		ListUtil.shuffleMerge(list1, list2);
		System.out.println(ListUtil.printList(list1));
		
		list1 = new LList<>("a", "b", "c");
		list2 = new LList<>("d");
		ListUtil.shuffleMerge(list1, list2);
		System.out.println(ListUtil.printList(list1));
		
		list1 = new LList<>("a", "b", "c");
		list2 = new LList<>();
		ListUtil.shuffleMerge(list1, list2);
		System.out.println(ListUtil.printList(list1));
		
		list1 = new LList<>();
		list2 = new LList<>("d", "e", "f");
		ListUtil.shuffleMerge(list1, list2);
		System.out.println(ListUtil.printList(list1));
		
		list1 = new LList<>();
		list2 = new LList<>();
		ListUtil.shuffleMerge(list1, list2);
		System.out.println(ListUtil.printList(list1));
	}
	
	@Test
	public void testSortedMerge() {
		System.out.println("test sorted merge");
		LList<Integer> list1 = new LList<>(1, 3, 5);
		LList<Integer> list2 = new LList<>(2, 4, 6);
		LList<Integer> result = ListUtil.sortedMerge(list1, list2);
		System.out.println(ListUtil.printList(result));
		
		list1 = new LList<>(1, 3, 5);
		list2 = new LList<>(2);
		result = ListUtil.sortedMerge(list1, list2);
		System.out.println(ListUtil.printList(result));
		
		list1 = new LList<>(3, 3, 5);
		list2 = new LList<>(2);
		result = ListUtil.sortedMerge(list1, list2);
		System.out.println(ListUtil.printList(result));
		
		list1 = new LList<>(3);
		list2 = new LList<>(2, 5, 6);
		result = ListUtil.sortedMerge(list1, list2);
		System.out.println(ListUtil.printList(result));
		
		list1 = new LList<>(3);
		list2 = new LList<>(2);
		result = ListUtil.sortedMerge(list1, list2);
		System.out.println(ListUtil.printList(result));
		
		list1 = new LList<>(3);
		list2 = new LList<>();
		result = ListUtil.sortedMerge(list1, list2);
		System.out.println(ListUtil.printList(result));
		
	}
	
	@Test
	public void testMergeSort() {
		System.out.println("test merge sort");
		LList<Integer> list = new LList<>(5,3,7);
		LList<Integer> sorted = ListUtil.mergeSort(list);
		System.out.println(ListUtil.printList(sorted));
		
		list = new LList<>(5);
		sorted = ListUtil.mergeSort(list);
		System.out.println(ListUtil.printList(sorted));
		
		list = new LList<>(5,4,3,2,1);
		sorted = ListUtil.mergeSort(list);
		System.out.println(ListUtil.printList(sorted));
	}
	
	@Test
	public void testIntersect() {
		System.out.println("test intersect");
		LList<Integer> list1 = new LList<>(3,3,7);
		LList<Integer> list2 = new LList<>(3,3,7);
		LList<Integer> result = ListUtil.sortedIntersect(list1, list2);
		System.out.println(ListUtil.printList(result));
		
		list1 = new LList<>(3,3,7);
		list2 = new LList<>(2,3,7, 7, 8);
		result = ListUtil.sortedIntersect(list1, list2);
		System.out.println(ListUtil.printList(result));
		
		list1 = new LList<>(3,3,7, 7);
		list2 = new LList<>(2,3,4, 7, 7, 8);
		result = ListUtil.sortedIntersect(list1, list2);
		System.out.println(ListUtil.printList(result));
		
		list1 = new LList<>(2,4,6,8,10);
		list2 = new LList<>(10);
		result = ListUtil.sortedIntersect(list1, list2);
		System.out.println(ListUtil.printList(result));
		
		list1 = new LList<>(2,4,6,8,10,11,13,14,15);
		list2 = new LList<>(10,11,12,15);
		result = ListUtil.sortedIntersect(list1, list2);
		System.out.println(ListUtil.printList(result));
		
	}
	
	@Test
	public void testReverseItr() {
		System.out.println("reverse itr");
		LList<Integer> list1 = new LList<>(3);
		ListUtil.reverseItr(list1);
		System.out.println(ListUtil.printList(list1));
		
		list1 = new LList<>(3,4);
		ListUtil.reverseItr(list1);
		System.out.println(ListUtil.printList(list1));
		
		list1 = new LList<>(3,4,5);
		ListUtil.reverseItr(list1);
		System.out.println(ListUtil.printList(list1));
		
		list1 = new LList<>(3,4,5,6);
		ListUtil.reverseItr(list1);
		System.out.println(ListUtil.printList(list1));
		
		list1 = new LList<>(3,4,5,6,7);
		ListUtil.reverseItr(list1);
		System.out.println(ListUtil.printList(list1));

	}
	
	@Test
	public void testReverseRec() {
		System.out.println("reverse recursive");
		LList<Integer> list1 = new LList<>(3);
		ListUtil.reverse(list1);
		System.out.println(ListUtil.printList(list1));
		
		list1 = new LList<>(3,4);
		ListUtil.reverse(list1);
		System.out.println(ListUtil.printList(list1));
		
		list1 = new LList<>(3,4,5);
		ListUtil.reverse(list1);
		System.out.println(ListUtil.printList(list1));
		
		list1 = new LList<>(3,4,5,6);
		ListUtil.reverse(list1);
		System.out.println(ListUtil.printList(list1));
		
		list1 = new LList<>(3,4,5,6,7);
		ListUtil.reverse(list1);
		System.out.println(ListUtil.printList(list1));
	}
	
}
