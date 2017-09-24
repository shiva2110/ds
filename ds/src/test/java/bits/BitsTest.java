package bits;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

public class BitsTest {

	@Test
	public void testBitsMap() {
		BitsMap m = new BitsMap();
		
		int totalNumbers = 100;
		int min = 10000000;
		int max = 100000000;
		
		for(int i=0; i<totalNumbers; i++) {
			int num = ThreadLocalRandom.current().nextInt(min, max);
			m.add(num);
		}
		
		m.printSorted();
	}
}
