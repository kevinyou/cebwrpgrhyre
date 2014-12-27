package cebwrPackage;

import java.util.*;

public class Problem026 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int greatest = -1;
		int seed = -1;
		for (int i = 1; i < 1000; i++)
		{
			int d = doesItRepeat(i);
			if (d > 0)
			{
				if (d > greatest)
				{
					seed = i;
					greatest = d;
				}
			}
		}
		System.out.println(greatest);
		System.out.println(seed);
	}
	
	
	public static int doesItRepeat(int n)
	{
		
		int num = 10;
		int den = n;
		HashMap<Integer, Integer> hist = new HashMap<>();
		int count = 0;
		
		while (num % den != 0)
		{
			if (hist.containsKey(100000*num + den))
			{
				return count - hist.get(100000*num + den);
			}
			hist.put(num*100000 + den, count);
			num = (num % den)*10;
			count++;
		}
		
		return -1;
		
		
		
	}
}
