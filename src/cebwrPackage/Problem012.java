/**	Java competition problem template
 *	Use for input/output problems
 */

package cebwrPackage;

import java.io.*;
import java.util.*;

public class Problem012 {
	public static void main(String[] args) throws IOException
	{
		int threshold = 500;
		int currentNumD = 0;
		TreeSet<Integer> divisors = new TreeSet<>();
		
		for (int i = 1; divisors.size() < threshold; i++)
		{
			int tri = triangle(i);
			divisors = getDivisors(tri);
			System.out.println(tri + "\t" + divisors);
			
		}
		
		
		
	}
	
	public static int triangle(int term)
	{
		return (term * (term + 1)) / 2;
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
