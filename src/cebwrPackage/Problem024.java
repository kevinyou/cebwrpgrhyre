package cebwrPackage;

import java.util.*;

public class Problem024 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String start = "0123456789";
		
		ArrayList<String> permutations = permute(start);
		System.out.println(permutations.get(1000000-1));
		
	}
	
	public static ArrayList<String>	permute(String str)
	{
		ArrayList<String> returning = new ArrayList<>();
		if (str.length() == 1)
		{
			returning.add(str);
			return returning;
		}
		for (int i = 0; i < str.length(); i++)
		{
			String meh = str.substring(0, i) + str.substring(i+1);
			ArrayList<String> rest = permute(meh);
			for (String x : rest)
				returning.add(str.charAt(i) + x);
		}
		
		return returning;
	}
	
}
