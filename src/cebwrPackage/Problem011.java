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
		
		// Testing Horizontals only
		for (int r = 0; r < 20; r++)
			for (int c = 0; c < 17; c++)
			{
				int product = grid[r][c] * grid[r][c+1] * grid[r][c+2] * grid[r][c+3];
				if (product > greatest)
					greatest = product;
			}
		
		// Testing Verticals only
		for (int c = 0; c < 20; c++)
			for (int r = 0; r < 17; r++)
			{
				int product = grid[r][c] * grid[r+1][c] * grid[r+2][c] * grid[r+3][c];
				if (product > greatest)
					greatest = product;
			}
		
		// TL to BR Diagonals
		for (int c = 0; c < 17; c++)
			for (int r = 0; r < 17; r++)
			{
				int product = grid[r][c] * grid[r+1][c+1] * grid[r+2][c+2] * grid[r+3][c+3];
				if (product > greatest)
					greatest = product;
			}
		
		// TR to BL Diagonals
				for (int c = 19; c > 2; c--)
					for (int r = 0; r < 17; r++)
					{
						int product = grid[r][c] * grid[r+1][c-1] * grid[r+2][c-2] * grid[r+3][c-3];
						if (product > greatest)
							greatest = product;
					}
		
		System.out.println(greatest);
		
		
		output.write("\n"); // Add to output
		output.close(); // End output
	}

	public static boolean adjacent (int row1, int col1, int row2, int col2)
	{
		if (Math.abs(row1 - row2) <= 1 && Math.abs(col1 - col2) <= 1)
			return true;
		return false;
	}
	
}
