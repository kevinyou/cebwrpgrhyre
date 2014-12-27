package cebwrPackage;

import java.util.*;

public class Problem021 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int sum = 0;
		
		for (int i = 2; i < 10000; i++)
		{
			int query = isAmicable(i);
			if (query != -1)
				sum += query + i;
		}
		
		sum /= 2;
		System.out.println(sum);
		
		
//		System.out.println(isAmicable(220));
		
		
	}
	
	private static int isAmicable (int n)
	{
		TreeSet<Integer> set = getDivisors(n);
		
		int sum = -1 * n;
		for (int x : set)
			sum += x;
		
		TreeSet<Integer> set2 = getDivisors(sum);
		
		int sum2 = -1 * sum;
		for (int x : set2)
			sum2 += x;
		
		
		if (sum2 == n && n != sum)
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
	
	
}
