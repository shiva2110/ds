package ds.stacks;

import junit.framework.Assert;

import org.junit.Test;

public class StackArrTest {

	@Test (expected = IllegalArgumentException.class)
	public void testStackArr() {
		StackArr stack = new StackArr(5);
		stack.pop(0);
	}
	
	@Test
	public void testStackArr1() {
		StackArr stack = new StackArr(5);
		stack.push("speaker", 0);
		stack.push("laptop", 0);
		stack.push("iphone", 0);
		
		stack.push("nail polish", 1);
		
		stack.push("police car", 2);
		
		Assert.assertEquals("iphone", stack.pop(0));
		Assert.assertEquals("laptop", stack.pop(0));
		
		stack.push("fire truck", 2);
		stack.push("ambulance", 2);
		
		Assert.assertEquals("ambulance", stack.pop(2));
		Assert.assertEquals("fire truck", stack.pop(2));
		
		Assert.assertEquals("nail polish", stack.pop(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testStackArr2() {
		StackArr stack = new StackArr(5);
		stack.push("speaker", 0);
		stack.push("laptop", 0);
		stack.push("iphone", 0);
		
		stack.push("nail polish", 1);
		
		stack.push("police car", 2);
		stack.push("ambulance", 2);
	}
}
