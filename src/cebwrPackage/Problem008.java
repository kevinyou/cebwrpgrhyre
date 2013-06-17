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
		int greatest = 0;
		int position = 0;
		int[] digits = new int[length];
		
		while (input.hasNext())	{
			String line = input.nextLine();
			for (int j = 0; j < line.length(); j++) {
				digits[position] = Integer.parseInt(line.substring(j, j+1));
				position++;
			}
		}
		
		for (int q = 0; q < length - 2; q++) {
			if (digits[q] == 0 || digits[q + 1] == 0 || digits[q + 2] == 0 || digits[q + 3] == 0 || digits[q + 4] == 0)
				continue;
			else {
				int product = digits[q] * digits[q + 1] * digits[q + 2] * digits[q + 3] * digits[q + 4];
				if (product > greatest)
					greatest = product;
			}
		}
		
		System.out.println(greatest);
		
		output.write("" + greatest); // Add to output
		
		output.close(); // End output
	}

}
