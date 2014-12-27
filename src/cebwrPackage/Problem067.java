package cebwrPackage;

import java.io.*;
import java.util.*;

public class Problem067 {

	public static void main(String[] args) throws IOException
	{
		String inputFileName = "Problem067.in";
		Scanner input = new Scanner(new File("bin/data/" + inputFileName));
		//
		
		int numLines = 0;
		String nums = "";
		
		while(input.hasNextLine())
		{
			nums += input.nextLine() + "\n";
			numLines++;
		}
		
		
		int grid[][] = new int[numLines][numLines];
		hist = new int[numLines][numLines];
//		hist[numLines-1] = grid[numLines-1];
		
		Scanner numScan = new Scanner(nums);
		
		for (int i = 0; i < numLines; i++)
		{
			for (int j = 0; j <= i; j++)
			{
				hist[i][j] = numScan.nextInt();
			}
		}
		
		collapse(numLines-1);
		
		
		
		
		int greatest = hist[0][0];
		
//
//		for (int[] x : grid)
//			System.out.println(Arrays.toString(x));
//
//		for (int[] x : hist)
//			System.out.println(Arrays.toString(x));
		
		System.out.println(greatest);
		
		input.close();
	}
	
	public static int[][] hist;
	
	public static void collapse(int line)
	{
		if (line != 1)
		{
			int[] arr = hist[line];
			for (int i = 0; i < line - 1; i++)
				hist[line-1][i] += Math.max(arr[i], arr[i+1]);
			collapse(line-1);
		}
		else if (line == 1)
		{
			hist[line-1][0] += Math.max(hist[line][0], hist[line][1]);
		}
	}
}
