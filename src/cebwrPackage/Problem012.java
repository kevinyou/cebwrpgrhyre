/**	Java competition problem template
 *	Use for input/output problems
 */

package cebwrPackage;

import java.io.*;
import java.util.*;

public class Problem012 {
	public static void main(String[] args) throws IOException
	{
		int threshold = 5;
		int currentNumD = 0;
		int term = 0;
		int tri = 0;
		
		while (currentNumD < threshold)
		{
			currentNumD = 0;
			term++;
			tri = triangle(term);
			for (int j = 1; j <= tri; j++)
				if (tri % j == 0)
					currentNumD++;
			
			System.out.println(tri);
		}
		System.out.println(tri);
	}
	
	public static int triangle(int term)
	{
		return (term * (term + 1)) / 2;
	}
}
