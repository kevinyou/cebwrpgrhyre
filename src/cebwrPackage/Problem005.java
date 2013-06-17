package cebwrPackage;

public class Problem005 {
	public static void main(String[] args) {
		int start = 1;
		int end = 20;
		
		int[] masterList = new int[end + 1];
		for (int composite = start; composite <= end; composite++)
		{
			int[] temp = new int[end + 1];
			int dividend = composite;
			for (int j = 2; j < end; j++)
			{
				while (dividend % j == 0)
				{
					temp[j]++;
					dividend = dividend / j;
				}
			}			
			
			for (int factor = 2; factor < end; factor++)
			{
				if (temp[factor] > masterList[factor])
					masterList[factor] = temp[factor];
			}
		}
		
		int product = 1;
		
		for (int factor = 2; factor <= end; factor++)
		{
			System.out.println(factor + ": " + masterList[factor]);
			if (masterList[factor] > 0)
				product *= Math.pow(factor, masterList[factor]);
		}
		System.out.println(product);
	}
}
