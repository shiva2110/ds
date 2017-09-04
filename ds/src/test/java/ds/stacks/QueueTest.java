package ds.stacks;

import org.junit.Assert;
import org.junit.Test;

public class QueueTest {
	
	@Test
	public void testQueue() {
		Queue<String> queue = new Queue<>();
		Assert.assertEquals(null, queue.dequeue());
		queue.enqueue("a");
		Assert.assertEquals("a", queue.dequeue().data);
		queue.enqueue("b");
		queue.enqueue("c");
		Assert.assertEquals("b", queue.dequeue().data);
		Assert.assertEquals("c", queue.dequeue().data);
		Assert.assertEquals(null, queue.dequeue());
	}

}
