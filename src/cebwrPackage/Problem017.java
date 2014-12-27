package cebwrPackage;

import java.util.*;

public class Problem017 {

	
	public static void main(String[] args)
	{
		int total = 0;
		HashMap<Integer, String> dict = new HashMap<>();
		dict.put(0, "zero");
		dict.put(1, "one");
		dict.put(2, "two");
		dict.put(3, "three");
		dict.put(4, "four");
		dict.put(5, "five");
		dict.put(6, "six");
		dict.put(7, "seven");
		dict.put(8, "eight");
		dict.put(9, "nine");
		dict.put(10, "ten");
		dict.put(11, "eleven");
		dict.put(12, "twelve");
		dict.put(13, "thirteen");
		dict.put(14, "fourteen");
		dict.put(15, "fifteen");
		dict.put(16, "sixteen");
		dict.put(17, "seventeen");
		dict.put(18, "eighteen");
		dict.put(19, "nineteen");
		dict.put(20, "twenty");
		dict.put(30, "thirty");
		dict.put(40, "forty");
		dict.put(50, "fifty");
		dict.put(60, "sixty");
		dict.put(70, "seventy");
		dict.put(80, "eighty");
		dict.put(90, "ninety");
		dict.put(1000, "onethousand");
		dict.put(-1, "hundredand");
		dict.put(-2, "hundred");
		
		for (int i = 1; i <= 1000; i++)
		{
			if (!dict.containsKey(i))
			{
				if (i < 100)
				{
					int tens = i / 10;
					int ones = i % 10;
					
					dict.put(i, dict.get(tens*10) + dict.get(ones));
				}
				else
				{
					int hundreds = i / 100;
					int rest = i % 100;
					
					if (rest == 0)
						dict.put(i, dict.get(hundreds) + dict.get(-2));
					else
						dict.put(i, dict.get(hundreds) + dict.get(-1) + dict.get(rest));
				}
			}
			
			System.out.println(dict.get(i));
			
			total += dict.get(i).length();
		}
		
		System.out.println(total);
	}
}
