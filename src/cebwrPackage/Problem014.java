package cebwrPackage;

// solved with code from a UVa problem, #100 "The 3n + 1 problem"
import java.io.*;
import java.util.*;

public class Problem014 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		HashMap<Long, Long> map = new HashMap<Long, Long>();
		
		while (sc.hasNext())
		{
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			
			int bot = Math.min(n1, n2);
			int top = Math.max(n1, n2);
			long maxLength = -1;
			
			for (long i = bot; i <= top; i++)
			{
				long n = i;
				long count = 1;
				
				while (n != 1)
				{
					if (n % 2 == 0)
					{
						if (map.containsKey(n/2))
						{
							count += map.get(n/2);
							n = 1;
						}
						else
						{
							n /= 2;
							count++;
						}
					}
					else
					{
						if (map.containsKey(3*n+1))
						{
							count += map.get(3*n+1);
							n = 1;
						}
						else
						{
							n = 3 * n + 1;
							count++;
						}
					}
				}
				map.put(i, count);
			}
			
			int culprit = -1;
			
			for (int i = bot; i <= top; i++)
			{
				long l = map.get((long) i);
				if (l > maxLength)
				{
					maxLength = l;
					culprit = i;
				}
			}
			
			System.out.printf("%d %d %d %d\n", n1, n2, maxLength, culprit);
		}
	}

}

