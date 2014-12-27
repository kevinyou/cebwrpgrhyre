package cebwrPackage;

import java.util.*;

public class Problem023 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		int sumOfUnwritable = 0;
		for (int i = 1; i <= 28123; i++)
		{
			int query = isAbundant(i);
			if (query != -1)
				abundant.put(i, query);
		}
		
		TreeSet<Integer> writable = new TreeSet<Integer>();
		
		for (int a : abundant.keySet())
		{
			for (int b : abundant.keySet())
			{
				int sum = a + b;
				if (a + b > 28123)
					break;
				writable.add(a + b);
			}
		}
		
		for (int i = 1; i <= 28123; i++)
		{
			if (!writable.contains(i))
				sumOfUnwritable += i;
		}
		
		
		System.out.println(sumOfUnwritable);
	}

	public static int isAbundant(int n)
	{
		int sum = -1 * n;
		for (Object a : getDivisors(n))
			sum += (Integer) a;
		if (sum > n)
			return sum;
		
		return -1;
	}

	public static TreeSet getDivisors(int n)
	{
		TreeSet<Integer> returning = new TreeSet<Integer>();
		
		returning.add(1);
		returning.add(n);
		for (int i = 2; i < (int) (Math.ceil(Math.sqrt(n))); i++)
		{
			if (n % i == 0)
			{
				if (!history.containsKey(i))
					history.put(i, getDivisors(i));
				returning.addAll(history.get(i));
				
				
				if (!history.containsKey(n/i))
					history.put(n/i, getDivisors(n/i));
				returning.addAll(history.get(n/i));
			}
		}
		
		history.put(n, returning);
		return returning;
		
	}
	
	public static HashMap<Integer, TreeSet<Integer>> history = new HashMap<>();
	public static TreeMap<Integer, Integer> abundant = new TreeMap<>();
}
