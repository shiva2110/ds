package ds.stacks;

import org.junit.Assert;
import org.junit.Test;

public class StackTest {
	
	@Test
	public void testStack() {
		Stack<String> stack = new Stack<String>();
		Assert.assertEquals(null, stack.pop());
		stack.push("a");
		Assert.assertEquals("a", stack.pop().data);
		stack.push("b");
		stack.push("c");
		Assert.assertEquals("c", stack.pop().data);
		Assert.assertEquals("b", stack.pop().data);
		Assert.assertEquals(null, stack.pop());
	}

}
