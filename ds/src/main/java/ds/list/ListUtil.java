package ds.list;

import java.util.HashMap;
import java.util.Map;

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
			throw new IllegalArgumentException();
		}

		if (list.head == null || list.head.next == null) {
			return;
		}

		Node<T> current = list.head;
		Node<T> next = list.head.next;
		list.head.next = null;
		Node<T> lastNode = reverseNode(current, next);
		list.head = lastNode;

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
			list.insert(newData);
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

	public static LList<Integer> insertSort(LList<Integer> list) {
		LList<Integer> sortedList = new LList<>();
		Node<Integer> node = list.head;
		while(node != null) {
			ListUtil.sortedInsert(sortedList, node.data);
			node = node.next;
		}
		return sortedList;
	}

	public static LList<Integer> append(LList<Integer> list1, LList<Integer> list2) {
		if(list1 == null || list2 == null) {
			throw new IllegalArgumentException();
		}

		if (list1.head == null) {
			list1.head = list2.head;
			list2.head = null;
			return list1;
		}

		Node<Integer> node = list1.head;
		while(node.next!=null) {
			node = node.next;
		}
		node.next = list2.head;
		list2.head = null;
		return list1;

	}


	public static Map<String, LList<Integer>> frontBackSplit(LList<Integer> list) {

		if (list == null) {
			throw new IllegalArgumentException();
		}

		if (list.head == null) {
			return fbMap(list, new LList<Integer>());
		}

		Node<Integer> slow = list.head;
		Node<Integer> fast = list.head;

		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		Node<Integer> newHead = slow.next;
		LList<Integer> newList = new LList<Integer>();
		newList.head = newHead;
		slow.next = null;

		return fbMap(list, newList);
	}

	private static Map<String, LList<Integer>> fbMap(LList<Integer> front, LList<Integer> back) {
		Map<String, LList<Integer>> map = new HashMap<>();
		map.put("front", front);
		map.put("back", back);
		return map;
	}

	public static void sortedDupRemove(LList<Integer> list) {
		if (list == null || list.head == null) {
			return;
		}

		Node<Integer> node = list.head;
		while(node.next != null) {
			if (node.next.data == node.data) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}
	}

	public static Map<String, LList<Integer>> alternatingSplit(LList<Integer> list){
		if (list == null) {
			throw new IllegalArgumentException();
		}

		if (list.head == null) {
			return fbMap(list, new LList<Integer>());
		}

		Node<Integer> node = list.head;

		LList<Integer> list2 = new LList<Integer>();
		while(node!= null && node.next != null) {
			Node<Integer> next = node.next;
			node.next = node.next.next;
			next.next = null;
			list2.insertNode(next);
			node = node.next;
		}
		return fbMap(list, list2);
	}

	public static <T> LList<T> shuffleMerge(LList<T> list1, LList<T> list2) {

		if (list1 == null || list2==null) {
			throw new IllegalArgumentException();
		}

		if (list1.head == null) {
			list1.head = list2.head;
			list2.head = null;
			return list1;
		}

		if (list2.head == null) {
			return list1;
		}

		Node<T> node1 = list1.head;
		Node<T> node2 = list2.head;

		while (node1 != null && node2 != null) {
			Node<T> next1 = node1.next;
			Node<T> next2 = node2.next;

			node1.next = node2;
			if (next1 != null) {
				node2.next = next1;
			}

			node1 = next1;
			node2 = next2;
		}

		return list1;
	}

	public static LList<Integer> sortedMerge(LList<Integer> list1, LList<Integer> list2) {
		if (list1 == null || list2 == null) {
			throw new IllegalArgumentException();
		}

		if (list1.head == null) {
			return list2;
		}

		if (list2.head == null) {
			return list1;
		}

		LList<Integer> listToReturn = null;
		Node<Integer> smallNode = null;
		Node<Integer> bigNode = null;

		if (list1.head.data <= list2.head.data) {
			listToReturn = list1;
			smallNode = list1.head;
			bigNode = list2.head;
		} else {
			listToReturn = list2;
			smallNode = list2.head;
			bigNode = list1.head;
		}

		while(smallNode.next != null && bigNode != null) {
			if (smallNode.next.data <= bigNode.data) {
				smallNode = smallNode.next;
			} else {
				Node<Integer> smallNext = smallNode.next;
				smallNode.next = bigNode;
				smallNode = bigNode;
				bigNode = smallNext;
			}
		}

		if (smallNode.next == null) {
			smallNode.next = bigNode;
		}
		return listToReturn;
	}

	public static LList<Integer> mergeSort(LList<Integer> list) {

		if (list == null) {
			throw new IllegalArgumentException();
		}


		if (list.head == null || list.head.next == null) {
			return list;
		}

		Map<String, LList<Integer>> fb = frontBackSplit(list);
		LList<Integer> sortedFront = mergeSort(fb.get("front"));
		LList<Integer> sortedBack = mergeSort(fb.get("back"));
		return sortedMerge(sortedFront, sortedBack);
	}

	public static LList<Integer> sortedIntersect(LList<Integer> list1, LList<Integer> list2) {
		if (list1==null || list2==null) {
			throw new IllegalArgumentException();
		}

		LList<Integer> list3 = new LList<Integer>();
		if (list1.head.data == null || list2.head.data == null) {
			return list3;
		}

		Node<Integer> smallNode = null;
		Node<Integer> bigNode = null;
		if (list1.head.data <= list2.head.data) {
			smallNode = list1.head;
			bigNode = list2.head;
		} else {
			smallNode = list2.head;
			bigNode = list1.head;
		}

		while(smallNode!=null && bigNode!=null) {
			if(smallNode.data < bigNode.data) {
				smallNode = smallNode.next;
			} else if (smallNode.data == bigNode.data) {
				list3.insertT(smallNode.data);
				smallNode = smallNode.next;
				bigNode = bigNode.next;
			} else {
				Node<Integer> temp = smallNode;
				smallNode = bigNode;
				bigNode = temp;
			}
		}

		return list3;
	}

	public static <T> void reverseItr(LList<T> list) {
		if (list == null) {
			throw new IllegalArgumentException();
		}

		if (list.head == null || list.head.next == null) {
			return;
		}

		Node<T> p1 = list.head;
		Node<T> p2 = list.head.next;
		Node<T> p3 = list.head.next.next;

		p1.next = null;

		while (p3 != null) {
			p2.next = p1;
			p1 = p2;
			p2 = p3;
			p3 = p3.next;
		}

		p2.next = p1;
		list.head = p2;   	
	}




	public static Node deleteDuplicates(Node a) {

		if (a == null) {
			throw new IllegalArgumentException();
		}
		
		Node head = a;

		int curVal = (int) a.data;
		while (a.next != null) {
			if ((int)a.next.data == curVal) {
				Node temp = a.next.next;
				a.next.next = null;
				a.next = temp;
			} else {
				a = a.next;
				curVal = (int) a.data;
			}
		}
		
		return head;

	}

}
