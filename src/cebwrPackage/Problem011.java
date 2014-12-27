/**	Java competition problem template
 *	Use for input/output problems
 */

package cebwrPackage;

import java.io.*;
import java.util.*;

public class Problem011 {
	public static void main(String[] args) throws IOException
	{
		// Handling IO
		String inputFileName = "Problem011.in";
		Scanner input = new Scanner(new File("src/data/" + inputFileName));
		// Trim off file name for use as output file name
		inputFileName = inputFileName.substring(0, inputFileName.indexOf(".")); 
		FileWriter fstream = new FileWriter("src/data/" + inputFileName + ".out");
		BufferedWriter output = new BufferedWriter(fstream);
		
		int[][] grid = new int[20][20];		
		for (int r = 0; r < grid.length; r++)
			for (int c = 0; c < grid[r].length; c++)
				grid[r][c] = input.nextInt();
		int greatest = Integer.MIN_VALUE;
		
		for (int r = 0; r < grid.length - 3; r++)
			for (int c = 0; c < grid[0].length - 3; c++)
				greatest = Math.max(greatest, multiply(r, c, grid));
		
		for (int r = grid.length - 1; r >= 3; r--)
			for (int c = 0; c < grid[0].length - 3; c++)
				greatest = Math.max(greatest, multiply2(r, c, grid));
		
		
//		// Testing Horizontals only
//		for (int r = 0; r < 20; r++)
//			for (int c = 0; c < 17; c++)
//			{
//				int product = grid[r][c] * grid[r][c+1] * grid[r][c+2] * grid[r][c+3];
//				if (product > greatest)
//					greatest = product;
//			}
//		
//		// Testing Verticals only
//		for (int c = 0; c < 20; c++)
//			for (int r = 0; r < 17; r++)
//			{
//				int product = grid[r][c] * grid[r+1][c] * grid[r+2][c] * grid[r+3][c];
//				if (product > greatest)
//					greatest = product;
//			}
//		
//		// TL to BR Diagonals
//		for (int c = 0; c < 17; c++)
//			for (int r = 0; r < 17; r++)
//			{
//				int product = grid[r][c] * grid[r+1][c+1] * grid[r+2][c+2] * grid[r+3][c+3];
//				if (product > greatest)
//					greatest = product;
//			}
//		
//		// TR to BL Diagonals
//				for (int c = 19; c > 2; c--)
//					for (int r = 0; r < 17; r++)
//					{
//						int product = grid[r][c] * grid[r+1][c-1] * grid[r+2][c-2] * grid[r+3][c-3];
//						if (product > greatest)
//							greatest = product;
//					}
		
		System.out.println(greatest);
		
		
		output.write("\n"); // Add to output
		output.close(); // End output
	}
	
	public static int multiply(int r, int c, int grid[][])
	{
		int right = 1;
		int diag = 1;
		int left = 1;
		for (int i = 0; i < 4; i++)
		{
			right *= grid[r][c+i];
			left *= grid[r+i][c];
			diag *= grid[r+i][c+i];
		}
		
		return Math.max(right, Math.max(left, diag));
	}
	
	public static int multiply2(int r, int c, int grid[][])
	{
		int diag = 1;
		for (int i = 0; i < 4; i++)
			diag *= grid[r-i][c+i];
		return diag;
	}
	
}
