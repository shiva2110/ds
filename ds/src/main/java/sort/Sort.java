package sort;

import java.util.concurrent.ThreadLocalRandom;

public class Sort {
	public static void quickSort(int[] arr, int l, int u) {
		if (l >= u) {
			return;
		}
		int p = u;
		int j = u - 1;
		int i = l;
		while (i < j) {
			if (arr[i] < arr[p] && arr[j] > arr[p]) {
				i++;
				j--;
			} else if (arr[i] < arr[p]) {
				i++;
			} else if (arr[j] > arr[p]) {
				j--;
			} else {
				swap(arr, j, i);
				i++;
				j--;
			}
		}
		int mid = i;
		if (i==j && arr[i] <= arr[p]) {
			swap(arr, i+1, p);
			mid = i+1;
		} else {
			swap(arr, i, p);
		}
		quickSort(arr, l, mid-1);  // l<=i<u-1,  l<=mid<=u
		quickSort(arr, mid+1, u); // l<=mid<=u
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	public static int[] rand1(int n, int m) {
		   
		   int buckets = m;  //5M
		   int countPerBucket = n / buckets;  //200

		   
		   int[] result = new int[buckets];

		   for(int i=0; i<buckets; i++) {
		     int mod = (i==buckets-1) ? (n%buckets + countPerBucket) : countPerBucket;
		     result[i] = (i*countPerBucket) + (rand() % mod);     
		   }

		   return result;
		}
	
	private static int rand() {
		return ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);
	}
}
