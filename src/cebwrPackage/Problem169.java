package cebwrPackage;

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Problem169 {

	public static void main(String[] args)
	{
//		for (int i = 0; i <= 84; i++)
//		{
//			a.add(BigInteger.valueOf(2).pow(i));
//			
//		}
//		
//		BigInteger theta = BigInteger.valueOf(10).pow(15);
//		BigInteger theta = BigInteger.valueOf(10).pow(25);
		
		for (BigInteger i = BigInteger.ONE; true; i = i.multiply(BigInteger.valueOf(10)))
		{
			System.out.println(change(i));
			thist = new HashSet<Turn>();
		}
		
		
		
//		BigInteger theta = BigInteger.valueOf(10000);
//		
//		System.out.println(change(theta));
	}
	
	public static int change(BigInteger n)
	{
		String a = n.toString(2);
		String b = "";
		for (int i = a.length() - 1; i >= 0; i--)
		{
			b += a.charAt(i);
		}
		int total = 1;
		
		Queue<Turn> queue = new LinkedList<Turn>();
		for (int i = 1; i < a.length(); i++)
		{
			if (b.charAt(i) >= '1' && b.charAt(i-1) == '0')
				queue.add(new Turn(b, i, new HashSet<Integer>()));
		}
		while (!queue.isEmpty())
		{
			Turn curr = queue.poll();
			if (thist.contains(curr))
			{
				continue;
			}
			else
			{
				String triedMove = move(curr.state, curr.index);
				if (triedMove == null)
				{
					System.out.println(curr.state);
				}
				thist.add(curr);
				total++;
				
				for (int i = 1; i < a.length(); i++)
				{
					if (triedMove.charAt(i) >= '1' && triedMove.charAt(i-1) == '0')
						queue.add(new Turn(triedMove, i, curr.soFar));
				}
			}
			
		}
		
		
		return total;
	}
	
	
	public static String move(String state, int index)
	{
		if (state.charAt(index) < '1' || state.charAt(index-1) > '0')
			return null;
		
		String returning = state.substring(0, index-1) + '2' + (state.charAt(index) - '1') + state.substring(index+1);
		return returning;
	}
	
	public static HashSet<Turn> thist = new HashSet<>();
	
	public static class Turn
	{
		String state;
		int index;
		HashSet<Integer> soFar;
		
		public Turn(String s, int x, HashSet<Integer> f)
		{
			state = s + "";
			
			index = x;
			this.soFar = new HashSet<Integer>();
			this.soFar.add(index);
			this.soFar.addAll(f);
		}
		
		public int hashCode()
		{
			return soFar.hashCode();
		}
		
		public String toString()
		{
			return soFar.toString();
		}
		
		public boolean equals(Object obj)
		{
			return soFar.equals(((Turn )obj).soFar);
		}
	}
}

