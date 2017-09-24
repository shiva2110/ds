package heaps;

public class Heap {
	
	Integer[] arr;
	int elementsCount ;
	
	public Heap(int[] arr) {
		this.arr = new Integer[arr.length];
		for (int i=0; i<arr.length; i++) {
			this.arr[i] = arr[i];
		}
		elementsCount = arr.length;
		heapify();		
	}
	
	public int extractMin() {
		int min = arr[0];
		arr[0] = arr[elementsCount - 1];
		arr[elementsCount - 1] = null;
		elementsCount --;
		
		siftDown(0);
		return min;		
	}

	public void heapify() {
		if (elementsCount == 1) {
			return;
		}

		int parent = parent(elementsCount-1);
		for (int i=parent; i>=0; i--) {
			siftDown(i);
		}
	}

	public void siftDown(int i) {

		int left = left(i);
		int right = right(i);

		int min = i;
		if (left < elementsCount && arr[left] < arr[min]) {
			min = left;
		}

		if (right < elementsCount && arr[right] < arr[min]) {
			min = right;
		}

		if (min != i) {
			swap(min, i);
			siftDown(min);
		}   
	}

	public int left(int i) {
		return (i*2) + 1;
	}


	public int right(int i) {
		return (i*2) + 2;
	}

	public int parent(int i) {
		double d = Math.ceil((i/2) - 1);
		return (int) d;  
	}

	public void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


}
