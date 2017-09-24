package algo.numeric;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Assert;
import org.junit.Test;

public class NumericTest {
	
	@Test
	public void testSquareRoot() {
		double root = Numeric.findSquareRoot(100, 1);
		Math.sqrt(6);
		System.out.println("square root: " + root);
	}	
	
	@Test
	public void testClimbSteps() {
		System.out.println("climb steps");
		System.out.println(Numeric.climbStepsCorrect(5));
	}
	
	@Test
	public void testRoman() {
		System.out.println("test roman");
		Assert.assertEquals(10, Numeric.romanToInt("X"));
		Assert.assertEquals(9, Numeric.romanToInt("IX"));
		Assert.assertEquals(49, Numeric.romanToInt("xlix"));
		Assert.assertEquals(400, Numeric.romanToInt("CD"));
		Assert.assertEquals(36, Numeric.romanToInt("XXXVI"));
		Assert.assertEquals(1996, Numeric.romanToInt("MCMXCVI"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testRoman1() {
		System.out.println("test roman1");
		Numeric.romanToInt("XLIXZ");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testRoman2() {
		System.out.println("test roman2");
		Numeric.romanToInt("XLZIX");
	}
	
	
	@Test
	public void testNumBits() {
		System.out.println("test num bits");
		Assert.assertEquals(3, Numeric.numSetBits(11));
		Assert.assertEquals(1, Numeric.numSetBits(1));
		Assert.assertEquals(0, Numeric.numSetBits(0));
		Assert.assertEquals(1, Numeric.numSetBits(2));
		Assert.assertEquals(2, Numeric.numSetBits(3));
		Assert.assertEquals(1, Numeric.numSetBits(4));
		Assert.assertEquals(2, Numeric.numSetBits(5));
		Assert.assertEquals(2, Numeric.numSetBits(6));
		Assert.assertEquals(3, Numeric.numSetBits(7));
		Assert.assertEquals(5, Numeric.numSetBits(31));
		System.out.println(Numeric.numSetBits(4294967296L));
		
	}
	
	@Test
	public void testSwitch() {
		System.out.println("test switch");
		
		Assert.assertEquals(4, Numeric.bulbs(Arrays.asList(0,1,0,1)));
		Assert.assertEquals(2, Numeric.bulbs(Arrays.asList(0,1,1,1)));
		Assert.assertEquals(1, Numeric.bulbs(Arrays.asList(1,0,0,0)));
		Assert.assertEquals(1, Numeric.bulbs(Arrays.asList(0,0,0,0)));
		Assert.assertEquals(2, Numeric.bulbs(Arrays.asList(0,0,0,1)));
		Assert.assertEquals(0, Numeric.bulbs(Arrays.asList(1)));
		Assert.assertEquals(1, Numeric.bulbs(Arrays.asList(0)));
		Assert.assertEquals(0, Numeric.bulbs(Arrays.asList(1,1,1,1)));
	}
	
	@Test
	public void primeSum() {
		System.out.println("prime sum");
		Assert.assertEquals(Arrays.asList(3,97), Numeric.primesum(100));
		Assert.assertEquals(Arrays.asList(2,2), Numeric.primesum(4));
		System.out.println(Numeric.primesum(6));
		System.out.println(Numeric.primesum(8));
		System.out.println(Numeric.primesum(10));
		System.out.println(Numeric.primesum(12));
		System.out.println(Numeric.primesum(120));
	}
	
	@Test
	public void power() {
		System.out.println("test power");
		Assert.assertEquals(true, Numeric.isPower(4));
		Assert.assertEquals(false, Numeric.isPower(2));
		Assert.assertEquals(false, Numeric.isPower(3));
		Assert.assertEquals(false, Numeric.isPower(5));
		Assert.assertEquals(false, Numeric.isPower(6));
		Assert.assertEquals(true, Numeric.isPower(9));
		Assert.assertEquals(true, Numeric.isPower(1));
		Assert.assertEquals(true, Numeric.isPower(100));
		Assert.assertEquals(false, Numeric.isPower(99));
		Assert.assertEquals(true, Numeric.isPower(1024000000));
		Assert.assertEquals(true, Numeric.isPower(1000000000));
	}
	
	@Test
	public void testCoverPoints() {
		System.out.println("test cover points" );
		Assert.assertEquals(2, Numeric.coverPoints(Arrays.asList(0,1,1), Arrays.asList(0,1,2)));
		Assert.assertEquals(3, Numeric.coverPoints(Arrays.asList(1,2,1), Arrays.asList(1,2,0)));
		Assert.assertEquals(0, Numeric.coverPoints(Arrays.asList(1,1,1), Arrays.asList(1,1,1)));
		Assert.assertEquals(1, Numeric.coverPoints(Arrays.asList(1,1,2), Arrays.asList(1,1,0)));
		Assert.assertEquals(4, Numeric.coverPoints(Arrays.asList(0,2,0), Arrays.asList(0,2,0)));
		Assert.assertEquals(4, Numeric.coverPoints(Arrays.asList(4,3), Arrays.asList(4,0)));
		System.out.println(Numeric.coverPoints(Arrays.asList(4000,10000), Arrays.asList(4000,0)));
	}
	
	@Test
	public void testDiagnal() {
		System.out.println("test diagnal");
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> inner = new ArrayList<>();
		inner.add(1);
		inner.add(2);
		inner.add(3);
		list.add(inner);
		inner = new ArrayList<>();
		inner.add(4);
		inner.add(5);
		inner.add(6);
		list.add(inner);
		inner = new ArrayList<>();
		inner.add(7);
		inner.add(8);
		inner.add(9);
		list.add(inner);
		System.out.println(list);
		System.out.println(Numeric.diagonal(list));
		
	}
	
	@Test
	public void testDigits() {
		System.out.println("test digits");
		System.out.println(Numeric.digits(10));
		System.out.println(Numeric.digits(100));
		System.out.println(Numeric.digits(101));
		System.out.println(Numeric.digits(11001));
		System.out.println(Numeric.digits(1250));
	}

	@Test
	public void testGetNum() {
		System.out.println("test get number");
		System.out.println(Numeric.getNumber(Arrays.asList(0,1)));
		System.out.println(Numeric.getNumber(Arrays.asList(0,0,1)));
		System.out.println(Numeric.getNumber(Arrays.asList(1,0,1)));
		System.out.println(Numeric.getNumber(Arrays.asList(1,0,0,1,1)));
		System.out.println(Numeric.getNumber(Arrays.asList(0,5,2,1)));
	}
	
	@Test
	public void testIsStepping() {
		System.out.println("test stepping");
		System.out.println(Numeric.isStepping(Arrays.asList(0,1)));
		System.out.println(Numeric.isStepping(Arrays.asList(0,1,1)));
		System.out.println(Numeric.isStepping(Arrays.asList(0,1,2)));
		System.out.println(Numeric.isStepping(Arrays.asList(1,0,2,3)));
		System.out.println(Numeric.isStepping(Arrays.asList(4,3,2,3)));
				
	}
	
	@Test
	public void testNextBest() {
		System.out.println("test next best");
		System.out.println(Numeric.nextBest(Arrays.asList(9,2,1)));
		System.out.println(Numeric.nextBest(Arrays.asList(3,2,1)));
		System.out.println(Numeric.nextBest(Arrays.asList(2,2,1)));
		System.out.println(Numeric.nextBest(Arrays.asList(1,2,1)));
		System.out.println(Numeric.nextBest(Arrays.asList(0,2,1)));
		System.out.println(Numeric.nextBest(Arrays.asList(9,1,1)));
		System.out.println(Numeric.nextBest(Arrays.asList(9,0,1)));
		System.out.println(Numeric.nextBest(Arrays.asList(1,0,1)));
		System.out.println(Numeric.nextBest(Arrays.asList(0,0,1)));
		System.out.println(Numeric.nextBest(Arrays.asList(8,9)));
		System.out.println(Numeric.nextBest(Arrays.asList(7,9)));
		System.out.println(Numeric.nextBest(Arrays.asList(9,8)));
	}
	
	@Test
	public void testSteppings() {
		System.out.println("test steppigs");
		System.out.println(Numeric.countSteppings(83, 157));
		System.out.println(Numeric.countSteppings(83, 1067));
		System.out.println(Numeric.countSteppings(10, 100000));
		System.out.println(Numeric.countSteppings(0, 10));
		
		System.out.println(Numeric.countSteppings(-10, 10));
		System.out.println(Numeric.countSteppings(0, 21));
	}
	
	@Test
	public void testPrefixes() {
		System.out.println("test prefixes");
		System.out.println(Numeric.prefixes(Arrays.asList("a", "b")));
		System.out.println(Numeric.prefixes(Arrays.asList("a", "ab")));
		System.out.println(Numeric.prefixes(Arrays.asList("abd", "abc")));
		System.out.println(Numeric.prefixes(Arrays.asList("abcd", "abcef")));
		System.out.println(Numeric.prefixes(Arrays.asList("zebra", "dog")));
		System.out.println(Numeric.prefixes(Arrays.asList("zebra", "dog", "duck")));
		System.out.println(Numeric.prefixes(Arrays.asList("zebra", "dog", "duck", "dove")));
		System.out.println(Numeric.prefixes(Arrays.asList("a", "b", "c", "D")));
		System.out.println(Numeric.prefixes(Arrays.asList("a", "b", "c", "Da")));
		System.out.println(Numeric.prefixes(Arrays.asList("ae", "b", "ac", "Da")));
	}
	
	@Test
	public void isColorful() {
		System.out.println("is colorful");
		System.out.println(Numeric.isColorful(3));
		System.out.println(Numeric.isColorful(323));
		System.out.println(Numeric.isColorful(324));
		System.out.println(Numeric.isColorful(3245));
		System.out.println(Numeric.isColorful(324567899));
		System.out.println(Numeric.isColorful(0));
		System.out.println(Numeric.isColorful(-3245));
	}
	
	@Test
	public void testConvertToByte() {
		System.out.println("1: " + Numeric.convertToByte(1));
		System.out.println("2: " + Numeric.convertToByte(2));
		System.out.println("3: " + Numeric.convertToByte(3));
		System.out.println("4: " + Numeric.convertToByte(4));
		System.out.println("4: " + Numeric.convertToByte(14));
		System.out.println("15: " + Numeric.convertToByte(15));
		System.out.println("10: " + Numeric.convertToByte(10));
		System.out.println("20: " + Numeric.convertToByte(20));
		System.out.println("200: " + Numeric.convertToByte(200));
	}
	
	@Test
	public void testIsOne() {
		System.out.println("test is one");
		System.out.println(Numeric.isOne("00000000000"));
	}
	
	@Test
	public void testIsPower2() {
		System.out.println("test is power of 2");
 		System.out.println(Numeric.isPower2("1"));
 		System.out.println(Numeric.isPower2("2"));
 		System.out.println(Numeric.isPower2("4"));
 		System.out.println(Numeric.isPower2("16"));
 		System.out.println(Numeric.isPower2("15"));
 		System.out.println(Numeric.isPower2("127"));
 		System.out.println(Numeric.isPower2("128"));
 		System.out.println(Numeric.isPower2("147573952589676412928"));
 		System.out.println(Numeric.isPower2("105312291668557186697918027683670432318895095400549111254310877536"));
 		
	}
	
	@Test
	public void testGcd() {
		System.out.println("test gcd");
		System.out.println(Numeric.gcd(9,6));
	}
	
	@Test
	public void testSorted() {
		System.out.println("test sorted");
		int[] sorted = Numeric.sort(new int[]{2,1,3,4,0});
		print(sorted);
	}
	
	@Test
	public void testWave() {
		System.out.println("test sorted");
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(3,1)); 
		System.out.println(Numeric.waveSort(list));
	}
	
	@Test
	public void testAllocate() {
		System.out.println("test allocation");
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(12, 34, 67, 90)); 
		System.out.println(Numeric.allocate(list, 2));
	}
	
	private void print(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println("");
	}
	
	@Test
	public void testFibonacci() {
		System.out.println(Numeric.fibonacci(10000));
	}
	
	@Test
	public void testFibonacciItr() {
		System.out.println(Numeric.fibonacciItr(10000000));
	}
	
	@Test
	public void testSubsets() {
		System.out.println(Numeric.subsets(Arrays.asList("a")));
	}
	
	@Test
	public void testBinary() {
		System.out.println(Numeric.binarySearch(new int[]{0,1,7,10,12},11));
	}
	
	@Test
	public void testMissing() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("num.txt")));
		
		for (int i=Integer.MIN_VALUE; i<(Integer.MAX_VALUE-10000); i++) {
			bw.append(String.format("%d", ThreadLocalRandom.current().nextInt()));
			bw.newLine();
		}
		bw.close();
		
		
		/*int min = -21;
		int max = -10;
		int mid = (min + max) /2 ;
		System.out.println(mid);
		System.out.println((0 - min) + 1);*/
		//System.out.println(Numeric.findMissing("num.txt", Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
	
	@Test
	public void testMax() {
		equals(new int[]{-1}, Numeric.max(new int[]{-1}));
		equals(new int[]{5}, Numeric.max(new int[]{-1,5}));
		equals(new int[]{-1}, Numeric.max(new int[]{-1,-4}));
		equals(new int[]{100}, Numeric.max(new int[]{100, -101, 50}));
		equals(new int[]{59, 26, -53, 58, 97}, Numeric.max(new int[]{31, -41, 59, 26, -53, 58, 97, -93, -23, 84}));
	}
	
	private void equals(int[] arr1, int[] arr2) {
		for (int i=0; i<arr1.length; i++) {
			Assert.assertEquals(arr1[i], arr2[i]);
		}
	}
}
