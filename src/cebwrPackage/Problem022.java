package cebwrPackage;

import java.util.*;
import java.io.*;

public class Problem022 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		String inputFileName = "Problem022.in";
		Scanner input = new Scanner(new File("bin/data/" + inputFileName));
	
		String large = input.nextLine();
		
		String[] trimmed = large.replaceAll("\\\"", "").split(",");
		Arrays.sort(trimmed);
		System.out.println(Arrays.toString(trimmed));
		
		
		int sum = 0;
		
		for (int i = 0; i < trimmed.length; i++)
		{
			int score = 0;
			for (char c : trimmed[i].toCharArray())
				score += (int) (c - 'A') + 1;
			sum += (i+1) * score;
		}
		
		System.out.println(sum);
	}
	
	
}
