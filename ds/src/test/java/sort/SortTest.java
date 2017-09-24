package sort;

import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;

public class SortTest {
	
	@Test
	public void testSort() {
		int[] arr = new int[]{6,5,5};
		Sort.quickSort(arr, 0, arr.length-1);
		equal(new int[]{5,5,6}, arr);
		
		arr = new int[]{5};
		Sort.quickSort(arr, 0, arr.length-1);
		equal(new int[]{5}, arr);
		
		arr = new int[]{5,6};
		Sort.quickSort(arr, 0, arr.length-1);
		equal(new int[]{5,6}, arr);
		
		arr = new int[]{6,5};
		Sort.quickSort(arr, 0, arr.length-1);
		equal(new int[]{5,6}, arr);
		
		arr = new int[]{6,6};
		Sort.quickSort(arr, 0, arr.length-1);
		equal(new int[]{6,6}, arr);
		
		arr = new int[]{5,5,5};
		Sort.quickSort(arr, 0, arr.length-1);
		equal(new int[]{5,5,5}, arr);
		
		arr = new int[]{5,6,5};
		Sort.quickSort(arr, 0, arr.length-1);
		equal(new int[]{5,5,6}, arr);
		
		arr = new int[]{6,5,5};
		Sort.quickSort(arr, 0, arr.length-1);
		equal(new int[]{5,5,6}, arr);
		
		arr = new int[]{4,3,2,1};
		Sort.quickSort(arr, 0, arr.length-1);
		equal(new int[]{1,2,3,4}, arr);
		
		arr = new int[]{-1,0,1,2,3};
		Sort.quickSort(arr, 0, arr.length-1);
		equal(new int[]{-1,0,1,2,3}, arr);
		
		arr = new int[]{-1,-1,-1,-1};
		Sort.quickSort(arr, 0, arr.length-1);
		equal(new int[]{-1,-1,-1,-1}, arr);
	}
	
	private void equal(int[] a, int[] b) {
		for (int i=0; i<a.length; i++) {
			Assert.assertEquals(a[i], b[i]);
		}
	}
	
	@Test
	public void testRand1() {
		int[] rand = Sort.rand1(1000, 10);
		assertRand(rand, 10);
		
		rand = Sort.rand1(10000000, 1000000);
		assertRand(rand, 1000000);
		
		rand = Sort.rand1(5, 3);
		assertRand(rand,3);
		print(rand);
	}
	
	private void assertRand(int[] rand, int expected) {
		if (expected != rand.length ) {
			Assert.assertEquals("size of result should be " + expected, "but it was " + rand.length);
		}
		Set<Integer> set = new HashSet<>();
		int prev = Integer.MIN_VALUE;
		
		for (int i=0; i<rand.length; i++) {
			if (rand[i] <= prev) {
				Assert.assertEquals("should be increasing order", "not in order");
			}
			if (set.contains(rand[i])) {
				Assert.assertEquals("should be unique", "not unique");
			}
			set.add(rand[i]);
			prev = rand[i];
		}
	}
	
	private void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + ",");
		}
		System.out.println();
	}
	
	@Test
	public void test() {
		System.out.println(5%3);
	}

}
