package ds.list;

public class LList<T> {
	Node<T> head;
	Node<T> tail;
	
	public LList() {
		
	}
	
	public LList(T... datas) {
		if (datas == null) {
			return;
		}
		
		for( T data : datas) {
			insertT(data);
		}
	}
	
	public LList<T> insertNode(Node<T> node) {
		if (node == null) {
			throw new IllegalArgumentException("node cannot be null!");
		}
		node.next = this.head;
		this.head = node;
		return this;
	}
	
	public LList<T> insert(T data) {
	    if (head == null) {
	        initiateHead(data);
	    } else {
	        head = new Node<T>(data, head);
	    }		
		return this;
	}
	
	private void initiateHead(T data) {
	    head = new Node<T>(data, null);
        tail = head;
	}
	
	public LList<T> insertT(T data) {
	    if (head == null) {
	        initiateHead(data);
	    } else {
	        tail.next = new Node<>(data, null);
	        tail = tail.next;
	    }
	    return this;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other.getClass() != this.getClass()) {
			return false;
		}
		
		if (other == this) {
			return true;
		}
		
		LList<T> otherList = (LList) other;
		Node<T> node = this.head;
		Node<T> node2 = otherList.head;
		while (node != null && node2 != null) {
			if (!node.data.equals(node2.data)) {
				return false;
			}
			node = node.next;
			node2 = node2.next;
		}
		
		if (node != null || node2 != null) {
			return false;
		}
		
	    return true;
	}
	
	@Override
	public int hashCode() {
		Node<T> node = this.head;
		int code = node.data.hashCode();
		while(node != null) {
			code = (31 * code) + node.data.hashCode();
			node = node.next;
		}
		return code;
	}

}
