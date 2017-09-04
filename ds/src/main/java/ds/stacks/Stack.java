package ds.stacks;

public class Stack<T> {
	
	Node<T> top;
	
	public void push(T data) {
		this.top = new Node<T>(data, top);
	}
	
	public Node<T> pop() {
		if (this.top == null) {
			return null;
		}
		
		Node<T> top = this.top;
		this.top = this.top.next;
		return top;
	}
}
