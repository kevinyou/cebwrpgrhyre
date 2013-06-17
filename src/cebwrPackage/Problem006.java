package cebwrPackage;

public class Problem006 {
	public static void main(String[] args) {
		int low = 1;
		int high = 100;

		// sum of squares
		int sumSq = 0;
		int sum = 0;
		for (int i = low; i <= high; i++)
		{
			sum += i;
			sumSq += i*i;
		}
		
		int difference = sumSq - (sum * sum);
		System.out.println(Math.abs(difference));
		
	}

}
