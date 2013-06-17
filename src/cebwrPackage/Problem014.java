package cebwrPackage;

import java.util.ArrayList;

public class Problem014 {
	public static void main(String[] args) {
		int max = 1000000;
		int greatest = Integer.MIN_VALUE;
		int[] next = new int[5*max];
		int answer = 1;
		for (int i = 1; i <= max; i++)
		{
			int test = i;
			int count = 0;
			System.out.print(test + ": ");
			while (next[test] != 0)
			{
				test = next[test];
				count++;
			}
			boolean ran = false;
			while (test != 1)
			{
				test = makeStep(test);
				count++;
				ran = true;
				System.out.print(test + " ");
			}
			
			System.out.println();
			if (count > greatest)
			{
				greatest = count;
				answer = i;
			}
		}
		System.out.println(answer);
	}

	public static int makeStep(int on) {
		String check = "" + on;
		if (Integer.parseInt(check.substring(check.length() - 1)) % 2 == 0)
			return (on/2);
		else
			return 3*on + 1;
	}
}
