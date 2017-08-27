package ds;

public class Arrays {
	
	public static boolean isUniqueChars(String s) {
		
		byte[] bArr = new byte[16];
		for (char c : s.toCharArray()) {
			int index = c / 8;
			int bitIndex = c % 8;
			
			int mask = 1 << (bitIndex -1) ;
			int result = bArr[index] & mask;
			if (result >  0) {
				return false;
			}
			bArr[index] = (byte)(bArr[index] | mask);		
		}		
		return true;
	}
	
	public static String reverse(String s) {
		if (s == null) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=s.length()-1; i>=0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
	
	public static String removeDup(String s) {
		if (s==null) return null;
		
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			boolean dup = false;
			for (int i=0; i<sb.length(); i++) {
				if (c == sb.charAt(i)) {
					dup = true;
					break;
				}
			}
			if (!dup) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}
