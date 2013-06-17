package cebwrPackage;

import java.math.BigInteger;

public class Problem020 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int argument = 100;
		BigInteger product = BigInteger.ONE;
		int sum = 0;
		for (int i = 1; i <= argument; i++)
		{
			product = product.multiply(BigInteger.valueOf(i));
		}
			
		String productString = "" + product;
		for (int j = 0; j < productString.length(); j++)
			sum += Integer.parseInt(productString.substring(j, j + 1));
		System.out.println(sum);
	}

}
