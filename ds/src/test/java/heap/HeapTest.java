package heap;

import org.junit.Test;

import heaps.Heap;
import junit.framework.Assert;

public class HeapTest {

	@Test
	public void test() {
		System.out.println(Math.ceil(((double)3/2) - 1) );
	}
	
	
	@Test
	public void heapTest() {
		Heap heap = new Heap(new int[] { 5,4,3,2,1,0,-1, 9, 10 });
		heap.print();		
	}
	
	@Test
	public void testMin() {
		Heap heap = new Heap(new int[] { 5,4,3,2,1,0,-1, 9, 10 });
		Assert.assertEquals(-1, (int)heap.extractMin());
		Assert.assertEquals(0, (int)heap.extractMin());
		Assert.assertEquals(1, (int)heap.extractMin());
		Assert.assertEquals(2, (int)heap.extractMin());
		Assert.assertEquals(3, (int)heap.extractMin());
		Assert.assertEquals(4, (int)heap.extractMin());
		Assert.assertEquals(5, (int)heap.extractMin());
		Assert.assertEquals(9, (int)heap.extractMin());
		Assert.assertEquals(10, (int)heap.extractMin());
		Assert.assertEquals(null, heap.extractMin());
	}
	
	@Test
	public void testInsert() {
		System.out.println("==== test insert");
		Heap heap = new Heap(new int[] { 5,4,3,2,1,0,-1, 9, 10 });
		Assert.assertEquals(-1, (int)heap.extractMin());
		heap.insert(7);
		Assert.assertEquals(0, (int)heap.extractMin());
		heap.insert(-2);
		Assert.assertEquals(-2, (int)heap.extractMin());		
	}
	
	@Test
	public void testSum() {
		System.out.println("==== test sum");
		Assert.assertEquals(33, Heap.findSum(new int[] { 5,4,3,2,1,0,-1, 9, 10 }));
		Assert.assertEquals(3, Heap.findSum(new int[] { 1,1,1 }));
		Assert.assertEquals(2, Heap.findSum(new int[] { 1,1,1,0,-1 }));
	}
	
}
