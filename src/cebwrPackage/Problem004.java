package cebwrPackage;

public class Problem004 {
	public static void main(String[] args) {

		int largest = 0;
		int threshold = 1000;
		for (int r = 0; r < threshold; r++) {
			for (int c = 0; c < threshold; c++) {
				int product = r * c;
				if (product > largest && isPalindrome(product)) {
					largest = product;
				}
			}
		}	
		System.out.println(largest);	
	}
	
	public static boolean isPalindrome(int test) {
		int length = 0;
		int lengthC = test;
		while (lengthC > 0) {
			lengthC /= 10;
			length++;
		}
		int[] digits = new int[length];
		int testA = test;
		for (int i = 0; i < length; i++) {
			digits[i] = testA % 10;
			testA /= 10;
		}
		
		boolean well = false;
		
		int midpoint = length / 2;
		int count = 0;
		for (int change = 0; change < midpoint; change++) {
			if (digits[change] == digits[digits.length - change - 1])
				count++;
		}
		if (count == midpoint)
			well = true;
		return well;
	}
}
