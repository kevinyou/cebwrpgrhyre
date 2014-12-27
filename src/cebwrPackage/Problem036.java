package cebwrPackage;

import java.math.BigInteger;
import java.util.ArrayList;

public class Problem036 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sumOfBoth = 0;
		
		for (int i = 1; i < 1000000; i++)
		{
			if (isPalindrome(i + ""))
				if (isPalindrome(Integer.toBinaryString(i)))
					sumOfBoth += i;
		}
		System.out.println(sumOfBoth);
	}
	
	public static boolean isPalindrome(String x)
	{
		for (int i = 0; i < x.length()/2; i++)
		{
			if (x.charAt(i) != x.charAt(x.length() - i - 1))
				return false;
		}
		
		return true;
	}
	
}
