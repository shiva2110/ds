package bits;

public class BitsMap {

	private static int MAX_BYTE_ARR_SIZE = 1125000;
	private static int MASK_MIN = 1 << 7; //10000000

	byte[] bArr = new byte[MAX_BYTE_ARR_SIZE];


	public BitsMap add(int i) {
		int bucket = i / 8;
		if (bucket >= MAX_BYTE_ARR_SIZE) {
			throw new IllegalArgumentException("The number is too big " + i);
		}
		int bitIndex = i % 8;
		byte mask = (byte) (MASK_MIN >> bitIndex); // { 10000000 >= mask >= 00000001 }
		bArr[bucket] = (byte) (bArr[bucket] | mask); //{ bucket < MAX_BYTE_ARR_SIZE }
		return this;
	}
	
	public void printSorted() {
		for (int bucket=0; bucket<MAX_BYTE_ARR_SIZE; bucket++) {
			for (int bitIndex=0; bitIndex < 8; bitIndex++) {
				byte mask = (byte) (MASK_MIN >> bitIndex); //{10000000, 01000000, 00100000, ..., 00000001}
				boolean exists = (bArr[bucket] & mask) > 0;
				if (exists) {
					int num = (bucket * 8) + bitIndex;
					System.out.println(num);
				}					
			}			
		}
	}

}
