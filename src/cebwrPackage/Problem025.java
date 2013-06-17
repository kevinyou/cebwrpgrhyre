package cebwrPackage;

import java.math.BigInteger;
import java.util.ArrayList;

public class Problem025 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String a = "";
		int i = 1;
		ArrayList<BigInteger> fib = new ArrayList<BigInteger>();
		fib.add(BigInteger.ZERO);
		fib.add(BigInteger.ONE);
		while (a.length() < 1000) {
			i++;
			fib.add(fib.get(i - 1).add(fib.get(i - 2)));
			a = fib.get(i).toString();
		}
		System.out.println(i);

	}
}
