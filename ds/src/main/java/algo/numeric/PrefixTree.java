package algo.numeric;

import java.util.HashMap;
import java.util.Map;

public class PrefixTree {

	Map<Character, Node> roots = new HashMap<>();

	public void insert(String s) {
		if(s.length()==0 || s=="") {
			return;
		}

		Node node = roots.get(s.charAt(0));
		if (node == null) {
			node = new Node();
			roots.put(s.charAt(0), node);
		}
		node.insert(s, 1);
	}

}
