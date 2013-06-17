package cebwrPackage;

import java.io.*;
import java.util.*;

public class Problem013 {
	public static void main(String[] args) throws IOException {
		// Handling IO
		String inputFileName = "Problem013.in";
		Scanner input = new Scanner(new File("bin/data/" + inputFileName));

		int numNumbers = 100;
		int numDigits = 50;
		
		int[][] grid = new int[numNumbers][numDigits]; // holds each digit
		int[] digits = new int[numDigits + 5];
		int digitPos = digits.length - 1;
		
		int lineNum = 0;
		while (input.hasNextLine()) {
			String line = input.nextLine();
			for (int i = 0; i < line.length(); i++)
				grid[lineNum][i] = Integer.parseInt(line.substring(i, i + 1));
			lineNum++;
		}
		
		int colSum = 0;
		int carryover = 0;
		
		for (int col = numDigits; col > 0; col--) {
			colSum = carryover;
			for (int a = 0; a < numNumbers; a++)
				colSum += grid[a][col - 1];

			int currentDigit = colSum % 10;
			carryover = (colSum - currentDigit) / 10;

			digits[digitPos] = currentDigit;
			digitPos--;
		}
		
		boolean trimming = true;
		
		System.out.print(carryover);
		
		for (int a : digits)
			if (a != 0 || !trimming) {
				trimming = false;
				System.out.print(a);
			}
		input.close();
	}

}
