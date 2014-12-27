package cebwrPackage;

import java.io.*;
import java.util.*;

public class Problem018 {

	public static void main(String[] args) throws IOException
	{
		String inputFileName = "Problem018.in";
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
		hist[numLines-1] = grid[numLines-1];
		
		Scanner numScan = new Scanner(nums);
		
		for (int i = 0; i < numLines; i++)
		{
			for (int j = 0; j <= i; j++)
			{
				grid[i][j] = numScan.nextInt();
			}
		}
		
		int greatest = traverse(0, 0, grid);
		
//
//		for (int[] x : grid)
//			System.out.println(Arrays.toString(x));
//		
//		for (int[] x : hist)
//			System.out.println(Arrays.toString(x));
		
		System.out.println(greatest);
		
		input.close();
	}
	
	public static int traverse(int r, int c, int[][] grid)
	{
		if (r == grid.length - 1)
			return hist[r][c];
		// branch 1
		int stay = traverse(r+1, c, grid);
		
		// branch 2
		int go = traverse(r+1, c+1, grid);
		
		hist[r][c] = grid[r][c] + Math.max(stay, go);
		return hist[r][c];
	}
	
	public static int[][] hist;
}
