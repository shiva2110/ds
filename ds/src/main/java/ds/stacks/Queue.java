package ds.stacks;

public class Queue<T> {
	
	Node<T> front;
	Node<T> back;
	
	public void enqueue(T data) {
		if (this.front == null) {
			this.front = new Node<T>(data, null);
			this.back = this.front;
		} else {
			this.back.next = new Node<T>(data, null);
			this.back = this.back.next;
		}
		
	}
	
	public Node<T> dequeue() {
		if (this.front == null) {
			return null;
		}
		
		Node<T> node = this.front;
		this.front = node.next;
		node.next = null;
		return node;		
	}
}
