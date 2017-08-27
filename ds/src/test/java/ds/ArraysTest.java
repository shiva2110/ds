package ds;

import org.junit.Assert;
import org.junit.Test;

public class ArraysTest {
	
	@Test
	public void testIsUniqueChars() {
		Assert.assertEquals(true, Arrays.isUniqueChars("a"));
		Assert.assertEquals(true, Arrays.isUniqueChars("abc"));
		Assert.assertEquals(false, Arrays.isUniqueChars("aabc"));
		Assert.assertEquals(false, Arrays.isUniqueChars("abcda"));
		Assert.assertEquals(true, Arrays.isUniqueChars(""));
	}
	
	@Test
	public void testReverse() {
		Assert.assertEquals(null, Arrays.reverse(null));
		Assert.assertEquals("", Arrays.reverse(""));
		Assert.assertEquals("a", Arrays.reverse("a"));
		Assert.assertEquals("ba", Arrays.reverse("ab"));
		Assert.assertEquals("cba", Arrays.reverse("abc"));
		Assert.assertEquals("baba", Arrays.reverse("abab"));
	}
	
	@Test
	public void testRemoveDup() {
		Assert.assertEquals(null, Arrays.removeDup(null));
		Assert.assertEquals("", Arrays.removeDup(""));
		Assert.assertEquals("a", Arrays.removeDup("a"));
		Assert.assertEquals("ab", Arrays.removeDup("ab"));
		Assert.assertEquals("abc", Arrays.removeDup("abc"));
		Assert.assertEquals("ab", Arrays.removeDup("abab"));
		Assert.assertEquals("abcdg", Arrays.removeDup("abcdadbcg"));
	}

}
