package algo.numeric;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Numeric {

	static Map<String, Integer> romanMap = new HashMap<String, Integer>() {{ 
		put("I", 1); 
		put("IV", 4);
		put("V", 5);
		put("IX", 9);
		put("X", 10);
		put("XL", 40);
		put("L", 50);
		put("XC", 90);
		put("C", 100);
		put("CD", 400);
		put("D", 500);
		put("CM", 900);
		put("M", 1000);		
	}};


	public static double findSquareRoot(double num, int precision) {
		double min = 0;
		double max = num;
		double mid = (max + min) / 2;
		double approxNum = mid * mid;

		int itr = 0;
		while (!close(approxNum, num, precision)) {
			if (approxNum > num) {
				max = mid;
			} else {
				min = mid;
			}

			mid = (max + min) / 2;
			approxNum = mid * mid;
			itr++;
		}

		System.out.println("Number of iterations: " + itr);
		return mid;
	}

	private static double diff(double num1, double num2) {
		return (num1 > num2) ? (num1 - num2) : (num2 - num1);
	}

	private static boolean close(double num1, double num2, double precision) {
		double diff = diff(num1, num2);
		double precisionMin = (1 / Math.pow(10, precision));
		double precisionMax = (1 / Math.pow(10, precision-1));
		if (diff > precisionMin  && diff < precisionMax) {
			return true;
		} else {
			return false;
		}
	}

	public static int climbSteps(int steps) {
		int[] climbSteps = new int[] {1, 1, 2, 4 };
		int threeSteps = steps / 3;
		int remainingSteps = steps % 3;


		return (int) (Math.pow(4, threeSteps) * climbSteps[remainingSteps]);
	}


	private static int[] cache;
	public static int climbStepsCorrect(int steps) {
		cache = new int[steps + 1];
		return climbStepsRec(steps);

	}

	private static int climbStepsRec(int steps) {
		if (steps == 0) {
			return 0;
		} else if (steps == 1) {
			return 1;
		} else if (steps == 2) {
			return 2;
		} else if (steps == 3) {
			return 4;
		} else {
			if (cache[steps] != 0) {
				return cache[steps];
			} else {
				return climbStepsRec(steps - 3) + climbStepsRec(steps - 2) + climbStepsRec(steps -1);
			}
		}
	}

	public static int romanToInt(String str) {
		if (str == null || str == "") {
			throw new IllegalArgumentException();
		}

		str = str.toUpperCase();

		String curStr = "";
		int curValue = 0;
		int sum = 0;
		for (char c : str.toCharArray()) {
			curStr = curStr + c;
			if (romanMap.containsKey(curStr)) {
				curValue = romanMap.get(curStr);
				continue;
			} else {
				sum = sum + curValue;
				curStr = String.valueOf(c);
				if (!romanMap.containsKey(curStr)) {
					throw new IllegalArgumentException("the input contains some invalid roman chars");
				}
				curValue = romanMap.get(curStr);
			}
		}
		sum = sum + curValue;
		return sum;
	}

	public static int numSetBits(long a) {
		if (a < 0 || a > 4294967295L) {
			throw new IllegalArgumentException();
		}

		if (a == 0) {
			return 0;
		}

		long mask = 1;
		int count = 0;
		while (mask >= 0) {
			if ((a & mask) > 0) {
				count++;
			}
			mask = mask << 1;
		}
		return count;
	}

	public static int bulbs(List<Integer> a) {
		if (a == null) {
			throw new IllegalArgumentException();
		}

		int numOfSwitch = 0;
		for (int x : a) {
			if(x < 0 || x > 1) {
				throw new IllegalArgumentException();
			}

			x = ((numOfSwitch % 2) == 0) ? x : (x==0 ? 1 : 0);
			if (x == 0) {
				numOfSwitch++;
			}     
		}

		return numOfSwitch;
	}

	public static ArrayList<Integer> primesum(int a) {
		if (a < 0 || a % 2 > 0) {
			throw new IllegalArgumentException();
		}

		int mid = a / 2;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 2; i<=mid; i++) {
			if (isPrime(i) && isPrime(a-i)) {
				list.add(i);
				list.add(a-i);
				break;
			}			
		}
		return list;
	}

	private static boolean isPrime(int num) {
		int root = (int) Math.sqrt(num);
		for (int j = 2; j <= root; j++) {
			if (num%j == 0) {
				return false;
			} 
		}
		return true;
	}



	public static boolean isPower(int a) {
		if (a < 0) {
			return false;
		}

		if (a == 1) {
			return true;
		}

		int root = (int) Math.sqrt(a);
		for (int i = 2; i <=root; i++) {
			long product = i * i;
			while (product <= a) {
				product = product * product;         
			}
			if ((product % a) == 0) {
				return true;
			}
		}
		return false;
	}


	public static int coverPoints(List<Integer> X, List<Integer> Y) {
		if (X == null || Y == null) {
			throw new IllegalArgumentException();
		}

		int size = X.size();

		if (size != Y.size()) {
			throw new IllegalArgumentException();
		}

		if (size == 0 || size == 1) {
			return 0;
		}

		int count = 0; 

		int i = 0;
		int curX = X.get(i);
		int curY = Y.get(i);     

		while(i!=size-1) { 
			int nextX = X.get(i+1);
			int nextY = Y.get(i+1);

			if (curX < nextX && curY < nextY) {
				curX++;
				curY++;
				count++;
			} else if (curX > nextX && curY > nextY) {
				curX--;
				curY--;
				count++;
			} else if (curX < nextX && curY > nextY){
				curX++;
				curY--;
				count++;
			} else if (curX > nextX && curY < nextY) {
				curY++;
				curX--;
				count++;
			} else if (curX < nextX) {
				curX++;
				count++;
			} else if (curX > nextX) {
				curX--;
				count++;
			} else if (curY < nextY) {
				curY++;
				count++;
			} else if (curY > nextY) {
				curY--;
				count++;     
			} else {
				i = i + 1;
			}
		}

		return count;

	}


	public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
		if (a == null) {
			throw new IllegalArgumentException();
		}

		if (a.size() == 0) {
			return new ArrayList<>();
		}

		ArrayList<ArrayList<Integer>> outerList = new ArrayList<>();
		ArrayList<Integer> inner = new ArrayList<>();
		inner.add(get(a,0,0));
		outerList.add(inner);

		if (a.size() == 1 && a.get(0).size() == 1) {
			return outerList;
		}

		int[] ptr1 = new int[]{0,1};
		int[] ptr2 = new int[]{1,0};

		while(!isSame(ptr1, ptr2)) {
			inner = new ArrayList<>();
			int[] ptr = new int[] {ptr1[0], ptr1[1]};
			while (!isSame(ptr, ptr2)) {
				inner.add(get(a,ptr));
				moveDiagnal(ptr);
			}
			inner.add(get(a,ptr2));
			outerList.add(inner);
			moveRightAndDown(a, ptr1);
			moveDownAndRight(a, ptr2);
		}

		inner = new ArrayList<>();
		inner.add(get(a, ptr2));
		outerList.add(inner);

		return outerList;
	}

	public static int get(ArrayList<ArrayList<Integer>> a, int i, int j) {
		return a.get(i).get(j);
	}

	public static int get(ArrayList<ArrayList<Integer>> a, int[] ptr) {
		return a.get(ptr[0]).get(ptr[1]);
	}

	public static  void moveDiagnal(int[] ptr) {
		ptr[0]++;
		ptr[1]--;
	}

	public static void moveDownAndRight(ArrayList<ArrayList<Integer>> a, int[] ptr1) {
		if (ptr1[0] == a.size()-1) {
			ptr1[1]++;
		} else {
			ptr1[0]++;
		}
	}

	public static void moveRightAndDown(ArrayList<ArrayList<Integer>> a, int[] ptr2) {
		if (ptr2[1] == a.size()-1) {
			ptr2[0]++;
		} else {
			ptr2[1]++;
		}
	}

	public static boolean isSame(int[] ptr1, int[] ptr2) {
		if(ptr1[0] == ptr2[0] && ptr2[1] == ptr2[1]) {
			return true;
		}

		return false;
	}

	public static List<Integer> countSteppings(int min, int max) {

		if (min > max) {
			throw new IllegalArgumentException();
		}

		if (min < 0) {
			min = 0;
		}

		ArrayList<Integer> steppings = new ArrayList<>();
		List<Integer> digits = digits(max);
		if (isStepping(digits)) {
			steppings.add(max);
		}
		while(true) {
			digits = nextBest(digits);
			int num = getNumber(digits);
			if (num < min) {
				break;
			}

			if (isStepping(digits)) {
				steppings.add(getNumber(digits));
			}
		}

		Collections.sort(steppings);
		return (steppings);

	}

	public static List<Integer> digits(int num) {
		List<Integer> list = new ArrayList<>();
		int div = num ;

		while (div > 0) {
			int mod = div % 10;
			list.add(mod);
			div = (int) div / 10;
		}

		return list;

	}

	public static int getNumber(List<Integer> list) {
		int sum = 0;
		for(int i=0; i<list.size(); i++) {
			sum = sum + (int)(list.get(i) * Math.pow(10, i));
		}
		return sum;
	}

	public static boolean isStepping(List<Integer> list) {
		if (list.size() == 0 || list.size() == 1) {
			return true;
		}
		int previous = list.size() - 1;

		for(int cur=list.size()-2; cur>=0; cur--) {
			int diff = list.get(cur) - list.get(previous);
			if (diff == -1 || diff == 1) {
				previous = cur;
				continue;
			} else {
				return false;
			}
		}

		return true;
	}

	public static List<Integer> nextBest(List<Integer> num) {

		if (num.size() == 1) {
			num.set(0, num.get(0)-1);
			return num;
		}

		if (num.size() == 0) {
			throw new IllegalArgumentException();
		}

		int updatedIndex = -1;
		int previous = num.size()-1;

		for(int cur=num.size()-2; cur>=0; cur--) {
			int diff = num.get(cur) - num.get(previous);
			if (diff == 1 || diff == -1) {
				previous = cur;
				continue;
			} else if (diff > 0) {
				num.set(cur, num.get(previous) + 1);
				updatedIndex = cur;
				break;
			} else if (diff < 0) {				
				num.set(previous, num.get(previous)-1);
				updatedIndex = previous;
				break;       
			} else { // diff == 0
				if (num.get(previous) == 0) {
					break;
				}
				num.set(cur,num.get(previous) - 1);
				updatedIndex = cur;
				break;
			}
		}

		if (updatedIndex == -1) {
			return reduceByOne(num);
		} else if (updatedIndex > 0) {
			for(int i=updatedIndex-1; i>=0; i--) {
				num.set(i, 9);
			}
			return num;
		} else {
			return num;
		}

	}

	public static List<Integer> reduceByOne(List<Integer> list) {
		int  num = getNumber(list);
		return digits(num-1);
	}

	public static List<String> prefixes(List<String> words) {
		PrefixTree pTree = new PrefixTree();
		for (String s : words) {
			pTree.insert(s);
		}

		List<String> list = new ArrayList<>();
		for (String s : words) {
			if (s.length() == 1) {
				list.add(s);
				continue;
			}

			Node node = pTree.roots.get(s.charAt(0));
			list.add(findPrefixWithOneLeaf(node, s, 1));
		}

		return list;
	}

	public static String findPrefixWithOneLeaf(Node node, String word, int index) {
		if (node.leaves == 1) {
			return word.substring(0, index);
		} else {
			Node nextNode = node.map.get(word.charAt(index));
			return findPrefixWithOneLeaf(nextNode, word, index+1);
		}
	}

	public static int isColorful(int n) {
		if (n < 0) {
			n = n * -1;
		}

		List<Integer> digits = digits(n);
		Set<Integer> set = new HashSet<>();
		for (int i=0; i < digits.size(); i++) {			
			if (colorful(1, i, digits, set) == 0) {
				return 0;
			}
		}
		return 1;
	}

	private static int colorful(int product, int index, List<Integer> digits, Set<Integer> set) {
		if (digits.size() == index) {
			return 1;
		}

		product = product * digits.get(index);
		if (set.contains(product)) {
			return 0;
		}
		set.add(product);
		return colorful(product, index+1, digits, set);
	}

	public static String convertToByte(int num) {

		int div = num / 2;
		int mod = num % 2;
		String s = "";
		while(div >= 1) {
			s = String.format("%s%s", mod, s);			
			mod = div % 2;
			div = div / 2;
		}

		s = String.format("%s%s", mod, s);	
		return s;		
	}


	public static int isPower2(String s) {		
		checkNum(s);

		if (s.length() == 1) {
			if (s.charAt(0) == '1' || s.charAt(0) == '0') {
				return 0;
			}
		}

		String res = s;
		while(!isOdd(res)) {
			StringBuilder sb = new StringBuilder();
			int carry = 0;
			for (int i=0; i<res.length(); i++) {
				char c = res.charAt(i);
				int num = carry + getInt(c);

				if (isOdd(num)) {
					carry = 10;
				} else {
					carry = 0;
				}

				int div = num / 2;
				sb.append(String.valueOf(div));
			}
			res = sb.toString();
		}

		if (isOne(res)) {
			return 1;
		} else {
			return 0;
		}
	}

	private static void checkNum(String s) {		
		if (s == null || s.length()==0) {
			throw new IllegalArgumentException();
		}

		try {
			for(int i=0; i<s.length(); i++) {
				getInt(s.charAt(i));			
			}	
		} catch(Exception e) {
			throw new IllegalArgumentException();
		}		
	}

	private static boolean isOdd(String s) {
		char c = s.charAt(s.length()-1);
		return isOdd(c);
	}

	private static boolean isOdd(char c) {
		int val = getInt(c);
		return isOdd(val);
	}

	private static boolean isOdd(int i) {
		return i % 2 == 1;
	}

	private static int getInt(char c) {
		String s = String.valueOf(c);
		return Integer.valueOf(s);
	}

	public static boolean isOne(String s) {
		for (int i=0; i<s.length(); i++) {
			if (i == s.length()-1) {
				if (s.charAt(i) == '1') {
					return true;
				}
			}

			if (s.charAt(i) != '0') {
				return false;
			}
		}

		return false;
	}


	public static int gcd(int m, int n) {
		if (m < 0 || n < 0) {
			throw new IllegalArgumentException();
		}

		if (m==0) {
			return n;
		} else if (n==0) {
			return m;
		}

		int small = m;
		int big = n;
		if (n < m) {
			small = n;
			big = m;
		}

		int div = 1;
		int gcd = small;
		while(gcd > 1) {
			if (small % gcd == 0 && big % gcd == 0) {
				break;
			}
			div++;
			gcd = small / div;
		}

		return gcd;

	}

	public static int[] sort(int[] arr) {
		return sort(arr, 0, arr.length-1);
	}

	public static ArrayList<Integer> waveSort(ArrayList<Integer> list) {
		int[] arr = toArr(list);

		if (arr.length == 1 || arr.length==0) {
			return toList(arr);
		}

		arr = sort(arr, 0, arr.length-1);
		int[] waveSorted = new int[arr.length];

		int i=0;
		int j=1;
		int k =0;

		while(j < arr.length) {
			waveSorted[k] = arr[j];
			k++;
			j = j + 2;

			waveSorted[k] = arr[i];
			k++;
			i = i + 2;
		}

		if (i < arr.length) {
			waveSorted[k] = arr[i];
		}

		return toList(waveSorted);
	}

	private static int[] toArr(ArrayList<Integer> list) {
		int[] arr = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}

	public static int allocate(ArrayList<Integer> list, int students) {  
		int[] pages = toArr(list);
		if (pages.length < students) {
			return -1;
		}
		return allocate(pages, students, 0, pages.length-1, new HashMap<String, Integer>());
	}

	public static int allocate(int[] pages, int students, int left, int right, Map<String, Integer> map) {
		Integer cached = getFromCache(left, right, students, map);
		if (cached!=null) {
			return cached;
		}

		if (students == 1) {
			int sum = 0;
			for(int i=left; i<=right; i++) {
				sum = sum + pages[i];
			}
			map(left, right, students, sum, map);
			return sum;
		}

		int bestMax = Integer.MAX_VALUE;

		for(int i=left; i<=right-1; i++) {
			int curStudentPg = allocate(pages, 1, left, i, map);
			int otherStudentPg = allocate(pages, students-1, i+1, right, map);
			int curMax = max(curStudentPg, otherStudentPg);
			if (curMax < bestMax) {
				bestMax = curMax;
			}
		}

		map(left, right, students, bestMax, map);
		return bestMax;

	}

	private static void map(int left, int right, int students, int result, Map<String, Integer> map) {
		String key = key(left, right, students);
		map.put(key, result);
	}

	private static Integer getFromCache(int left, int right, int students, Map<String, Integer> map) {
		String key = key(left, right, students);
		return map.get(key);
	}

	private static String key(int left, int right, int students) {
		return String.format("%s#%s#%s", left, right, students);
	}

	private static int max(int pg1, int pg2) {
		if (pg1 >= pg2) {
			return pg1;
		} else {
			return pg2;
		}
	}

	private static ArrayList<Integer> toList(int[] arr) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			list.add(arr[i]);
		}
		return list;
	}

	public static int[] sort(int[] arr, int left, int right) {		
		if (left >= right) {
			int[] sortedArr = new int[1];
			sortedArr[0] = arr[right];
			return sortedArr;
		}

		int mid = (left + right) / 2;
		int[] leftSorted = sort(arr, left, mid);
		int[] rightSorted = sort(arr, mid+1, right);

		return merge(leftSorted, rightSorted);
	}

	private static int[] merge(int[] left, int[] right) {
		int[] merged = new int[left.length + right.length] ;
		int i = 0;
		int j = 0;
		int k = 0;

		while(i<left.length && j<right.length) {
			if (left[i] <= right[j]) {
				merged[k] = left[i];
				k++;
				i++;
			} else {
				merged[k] = right[j];
				j++;
				k++;
			}
		}

		while(i<left.length) {
			merged[k] = left[i];
			i++;
			k++;
		}

		while(j<right.length) {
			merged[k] = right[j];
			j++;
			k++;
		}

		return merged;		
	}

	public static int fibonacci(int n) {
		Map<Integer, Integer> cache = new HashMap<>();
		return fibonacci(n, cache);

	}

	public static  int fibonacci(int n, Map<Integer, Integer> map) {
		if(n ==0) {
			return 0;
		}

		if (n==1) {
			return 1;
		}

		Integer result = map.get(n);
		if (result != null) {
			return result;
		}

		result = fibonacci(n-1, map) + fibonacci(n-2, map);
		map.put(n, result);
		return result;
	}


	public static long fibonacciItr(int n) {
		if (n == 1) {
			return 1;
		}

		long p = 1;
		long pp = 0;
		long result = 0;

		for(int i=1; i<n; i++) {
			result = p + pp;
			pp = p;
			p = result;			
		}

		return result;
	}


	public static void subsets(List<String> set, List<List<String>> subsets, List<String> curSubset, int index) {
		if (index == set.size()) {
			if(curSubset.size() > 0) {
				subsets.add(curSubset);
			}     
			return;
		}

		List<String> snapshot = new ArrayList<>();
		for (String str: curSubset) {
			snapshot.add(str);
		}

		curSubset.add(set.get(index));
		subsets(set, subsets, curSubset, index+1);
		subsets(set, subsets, snapshot, index+1);
	}


	public static List<List<String>> subsets(List<String> set) {
		List<List<String>> subsets = new ArrayList<>();
		List<String> curSubset = new ArrayList<>();
		int index = 0;
		subsets(set, subsets, curSubset, index);
		return subsets;
	}

	public static boolean binarySearch(int[] arr, int val) {
		return binarySearch(arr, val, 0, arr.length-1);
	}

	private static boolean binarySearch(int[] arr, int val, int minIndex, int maxIndex) {
		if (minIndex == maxIndex && arr[minIndex] == val) {
			return true;
		} else if (minIndex == maxIndex) {
			return false;
		}

		int mid = (minIndex + maxIndex) / 2;
		if (val <= arr[mid]) {
			return binarySearch(arr, val, minIndex, mid);
		} else {
			return binarySearch(arr, val, mid+1, maxIndex);
		}
	}

	public static long findMissing(String fileName, long min, long max) throws NumberFormatException, IOException {
		if (min == max) {  // { mid <= max }
			return min;
		}

		String leftFileName = ThreadLocalRandom.current().nextInt() + "_left.txt";
		BufferedWriter leftFile = new BufferedWriter(new FileWriter(leftFileName));
		String rightFileName = ThreadLocalRandom.current().nextInt() + "_right.txt";
		BufferedWriter rightFile = new BufferedWriter(new FileWriter(rightFileName));

		long mid = getMedian(min, max);  // {0,1->0  9,10->9 9,10,11->10  9,10,11,12->10}
		long totalLeft = (mid - (min)) + 1; // {0,1->1  9,10->1  9,10,11->2  9,10,11,12->2}
		long countLeft = 0;

		try ( BufferedReader reader = new BufferedReader(new FileReader(fileName)) ) {     
			String line = null;	

			while ( (line=reader.readLine())!=null ) {  // while loop terminates
				if (line.length()==0 || line == "") {continue;}

				int num = Integer.valueOf(line);

				if (num <= mid) {
					countLeft++;
					leftFile.append(String.format("%d", num));
					leftFile.append('\n');
				} else {
					rightFile.append(String.format("%d", num));
					rightFile.append('\n');
				}
			}
		} finally {
			leftFile.close();
			rightFile.close();
		}

		if (countLeft < totalLeft) {
			return findMissing(leftFileName, min, mid);  // {shrinks, hasMissing}
		} else {
			return findMissing(rightFileName, mid+1, max); // {shrinks, hasMissing}
		}
	}

	private static long getMedian(long min, long max) {
		double total = (max - min) + 1;
		return (long) (min +  Math.ceil((total/2)-1));

	}



	public static int[] max(int[] vector) {
		if (vector.length == 0) {
			return new int[]{};
		}

		int[] best = new int[]{0, 0};
		int bestSum = Integer.MIN_VALUE;

		int curSum = 0;
		int[] cur = new int[]{0, 0};

		for (int i=0; i<vector.length; i++) {
			if (curSum < 0) {
				cur = new int[]{i, i};
				curSum = vector[i];
			} else {
				cur[1] = i;
				curSum = curSum + vector[i];
			}

			if (curSum > bestSum) {
				bestSum = curSum;
				best = new int[]{cur[0], cur[1]};
			}
		}

		int size = best[1] - best[0] + 1;
		int[] result = new int[size];
		int index = 0;
		for(int i=best[0]; i<=best[1]; i++) {
			result[index] = vector[i];
			index++;
		}
		return result;
	}
}
