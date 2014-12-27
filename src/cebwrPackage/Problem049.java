package cebwrPackage;

import java.util.*;

public class Problem049 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int threshold = 10000;
		
		boolean[] primes = new boolean[threshold];
		
		for (int i = 2; i < threshold; i++)
			primes[i] = true;
		
		// true = prime;
		for (int i = 2; i < threshold; i++) {
			if (primes[i])
			{
				for (int j = 2; i*j < threshold; j++)
				{
					primes[i*j] = false;
				}
			}
		}
		
		HashSet<String> all = new HashSet<String>();
		
		for (int thousand = 1; thousand < 10; thousand++)
		{
			for (int hundred = 0; hundred < 10; hundred++)
			{
				for (int ten = 0; ten < 10; ten++)
				{
					for (int one = 0; one < 10; one++)
					{
						if (primes[thousand*1000 + hundred*100 + ten*10 + one])
						{

							all.add(thousand + "" + hundred + "" + ten + "" + one);
						}
					}
				}
			}
		}
		
		
		for (String x : all)
		{
			if (x.equals("1487"))
				System.out.println("what");
			ArrayList<String> permutations = permute(x);
			TreeSet<String> found = new TreeSet<>();
			for (String y : permutations)
			{
				if (primes[Integer.parseInt(y)])
				{
					found.add(y);
				}
			}
			String arr[] = new String[found.size()];
			
			found.toArray(arr);
			
//			System.out.println(Arrays.toString(arr));
			
			HashMap<Integer, String> differences = new HashMap<>();
			
			for (int i = 0; i < arr.length; i++)
			{
				int diff = Math.abs(Integer.parseInt(arr[i]) - Integer.parseInt(x));
				if (differences.containsKey(diff))
				{
					System.out.println("waaa");
					if(checkTriple(Integer.parseInt(arr[i]), 
							Integer.parseInt(differences.get(diff)), 
							Integer.parseInt(differences.get(diff)) + diff))
					{
						System.out.println(arr[i]);
						System.out.println(differences.get(diff));
						System.out.println(Integer.parseInt(differences.get(diff)) + diff);
						
					}
				}
				else
				{
					differences.put(diff, arr[i]);
				}
			}
			
		}
		
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
	
	public static boolean checkTriple(int a, int b, int c)
	{
		int[] arr = new int[3];
		arr[0] = a; arr[1] = b; arr[2] = c;
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println((arr[2] - arr[1]) == (arr[1] - arr[0]));
		
		return ((arr[2] - arr[1]) == (arr[1] - arr[0])) ? true : false;
	}
	
}
