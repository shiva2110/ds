package algo.numeric;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Node {
	Map<Character, Node> map = new HashMap<>();
	Set<String> leafStrings = new HashSet<>();
	int leaves;

	public void insert(String str, int index) {
		if (index == str.length()) {
			leafStrings.add(str);
			leaves++;
			return;
		}

		char c = str.charAt(index); 
		Node node = map.get(c);
		leaves++;

		if (node == null) {
			node = new Node();
		} 
		map.put(c, node);
		node.insert(str, index+1);
	}

}