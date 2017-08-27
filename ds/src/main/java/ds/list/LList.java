package ds.list;

public class LList<T> {
	Node<T> head;
	
	public LList<T> insert(T data) {
		head = new Node<T>(data, head);
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
