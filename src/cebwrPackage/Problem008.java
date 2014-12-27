package cebwrPackage;

import java.io.*;
import java.util.*;

public class Problem008 {
	public static void main(String[] args) throws IOException
	{
		// Handling IO
		String inputFileName = "Problem008.in";
		Scanner input = new Scanner(new File("src/data/" + inputFileName));
		// Trim off file name for use as output file name
		inputFileName = inputFileName.substring(0, inputFileName.indexOf(".")); 
		FileWriter fstream = new FileWriter("src/data/" + inputFileName + ".out");
		BufferedWriter output = new BufferedWriter(fstream);
		
		int length = 1000;
		long greatest = 0;
		int position = 0;
		int[] digits = new int[length];
		
		while (input.hasNext())	{
			String line = input.nextLine();
			for (int j = 0; j < line.length(); j++) {
				digits[position] = Integer.parseInt(line.substring(j, j+1));
				position++;
			}
		}
		
		for (int i = 0; i < length - 13; i++)
		{
			if(!hasZeroes(i, digits))
			{
				greatest = Math.max(greatest, compute(i, digits));
			}
		}
		
		System.out.println(greatest);
		
		output.write("" + greatest); // Add to output
		
		output.close(); // End output
	}
	
	public static boolean hasZeroes(int index, int[] digits)
	{
		for (int i = index; i < index + 13; i++)
			if (digits[i] == 0)
				return true;
		return false;
	}
	
	public static long compute(int index, int[] digits)
	{
		long product = 1;
		for (int i = index; i < index + 13; i++)
			product *= digits[i];
		return product;
	}

}
