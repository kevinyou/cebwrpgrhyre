package cebwrPackage;

import java.math.*;

public class Problem016 {
	public static void main(String[] args) {
		int exponent = 1000;
		BigInteger product = BigInteger.valueOf(2);
		product = product.pow(exponent);
		String line = product.toString();
		
		long sum = 0;
		
		for (int i = 0; i < line.length(); i++)
		{
			sum += Long.parseLong(line.substring(i, i + 1));
		}
		System.out.println(sum);
	}

}
