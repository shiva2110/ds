package ds.list;

public class ListUtil {
	
	public static LList<String> removeDup(LList<String> list) {
		if (list == null || list.head == null) {
			return list;
		}
		
		Node<String> node = list.head;
		while (node != null && node.next != null) {
			Node<String> node2 = list.head;
			boolean dup = false;
			while(node2 != node.next) {
				if (node2.data.equals(node.next.data)) {
					dup = true;
					break;
				}
				node2 = node2.next;
			}
			
			if (dup) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}
		
		return list;
	}
	
	public static <T> T findNth(LList<T> list, int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n cannot be negative");
		}
		
		if (list == null) {
			return null;
		}
		
		Node<T> ptr = list.head;
		while(n > 0 && ptr!=null) {
			ptr = ptr.next;
			n--;
		}
		
		if (ptr == null) {
			throw new IllegalArgumentException("the list does not contain n elements");
		}
		
		Node<T> ptr2 = list.head;
		while (ptr.next != null) {
			ptr = ptr.next;
			ptr2 = ptr2.next;
		}
		return ptr2.data;
	}
	
	public static <T> void deleteNode(Node<T> nodeToDelete) {
		if (nodeToDelete == null) {
			return;
		}
		
		if (nodeToDelete.next == null) {
			throw new IllegalArgumentException("nodeToDelete cannot be at the end of this list");
		}
		
		nodeToDelete.data = nodeToDelete.next.data;
		nodeToDelete.next = nodeToDelete.next.next;
	}
	
	public static LList<Integer> findSum(LList<Integer> list1, LList<Integer> list2) {
		int number1 = (int)findNumber(list1);
		int number2 = (int)findNumber(list2);
		int sum = number1 + number2;
		return numberList(sum);		
	}
	
	protected static double findNumber(LList<Integer> list) {
		if (list == null || list.head == null) {
			return 0;
		}
		
		int power = 0;
		double result = 0;
		Node<Integer> node = list.head;
		while(node != null) {
			result = result + (node.data * (Math.pow(10, power)) );
			power++;
			node = node.next;
		}
		return result;
	}
	
	protected static LList<Integer> numberList(int number) {
		LList<Integer> list = new LList<>();
		
		if (number < 1) {
			return list;
		}
		
		int power = 1;
		while (!(number < (Math.pow(10, power)))) {
			power++;
		}
		power--;
		
		while(power >= 0) {
			int digit = (int) (number / Math.pow(10, power)) % 10;
			list.insert(digit);
			power--;
		}
		return list;
	}
	
	public static <T> String printList(LList<T> list) {
		StringBuilder sb = new StringBuilder();
		Node<T> node = list.head;
		while (node != null) {
			sb.append(node.data).append("->");
			node = node.next;
		}
		return sb.toString();
	}
	
	public static <T> void reverse(LList<T> list) {
	    if (list == null) {
	        return;
	    }
	    Node<T> head = list.head;
	    list.head = reverseNode(head, head.next);
	    head.next = null;
	}
	
	private static <T> Node<T> reverseNode(Node<T> current, Node<T> next) {
	    if (next == null) {
	        return current;
	    }
	    
	    Node<T> nextNext = next.next;
	    next.next = current;
	    return reverseNode(next, nextNext);
	}
	
	public static <T> void insertAt(LList<T> list, int index, T data) {
	   if (index < 0) {
	       throw new IllegalArgumentException();
	   }
	   
	   if (index == 0) {
	       list.head = new Node<T>(data, list.head);
	       return;
	   }
	   
	   Node<T> node = list.head;
	   int i = 0;
	   while(node != null) {
	       if (i == (index-1)) {
	           node.next = new Node<>(data, node.next);
	           return;
	       }
	       node = node.next;
	       i++;
	   }
	   throw new IllegalArgumentException("index is out of bound!");
	}
	
	public static void sortedInsert(LList<Integer> list, int newData) {
	    if (list == null) {
	        throw new IllegalArgumentException();
	    }
	    
	    if (list.head == null || list.head.data >= newData) {
	       list.head = new Node<>(newData, list.head);
	       return;
	    }
	    
	    Node<Integer> node = list.head;
	    while(node.next != null) {
	        if (node.next.data >= newData) {
	            node.next = new Node<>(newData, node.next);
	            return;
	        }
	        node = node.next;
	    }
	    list.insertT(newData);
	}
}
