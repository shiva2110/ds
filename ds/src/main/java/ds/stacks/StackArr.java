package ds.stacks;

public class StackArr {
	
	public static class StackArrNode {
		String data;
		int nextIndex;
		
		public StackArrNode(String data, int nextIndex) {
			this.data = data;
			this.nextIndex = nextIndex;
		}
	}
	
	StackArrNode[] dataArr;
	Stack<Integer> freeList = new Stack<>();
	int[] topIndex = new int[] {-1, -1, -1};
	
	public StackArr(int size) {
		dataArr = new StackArrNode[size];		
	}
	
	public void push(String data, int stackNum) {
		checkStackNum(stackNum);
		
		Node<Integer> freeIndex = freeList.pop();
		if (freeIndex == null) {
			throw new IllegalArgumentException("No free space available!");
		}
		
		dataArr[freeIndex.data] = new StackArrNode(data, topIndex[stackNum]);
		topIndex[stackNum] = freeIndex.data;		
	}
	
	public String pop(int stackNum) {
		checkStackNum(stackNum);
		if (topIndex[stackNum] == -1) {
			throw new IllegalArgumentException("stack is empty!");
		}
		
		// get topNode and set the array index to null as it is now free
		StackArrNode topNode = dataArr[topIndex[stackNum]];
		dataArr[topIndex[stackNum]] = null;
		
		// add the index to free list
		freeList.push(topIndex[stackNum]);
		
		//set the topIndex to next index
		topIndex[stackNum] = topNode.nextIndex;
		
		return topNode.data;
	}
	
	private void checkStackNum(int stackNum) {
		if (stackNum > 2 || stackNum < 0) {
			throw new IllegalArgumentException("Only upto 3 stacks are allowed!");
		}
	}

}
