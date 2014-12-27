package cebwrPackage;
import java.math.BigInteger;

public class Problem015 {

	/**
	 * @param args
	 */
	
	public static final int len = 20 + 1;
	
	public static void main(String[] args) {
		BigInteger count = move(0, 0);
		
		System.out.println(count);
	}
	
	public static BigInteger move(int x, int y) {
		if (x == len - 1 && y == len - 1)
			return BigInteger.ONE;
		if (x >= len || y >= len)
			return BigInteger.ZERO;
		if (x < len - 1 && y < len - 1)
			return move(x+1, y).add(move(x, y+1));
		if (x < len - 1)
			return move(x+1, y);
		return move(x, y+1);
	}

}
