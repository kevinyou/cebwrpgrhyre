package cebwrPackage;


public class Problem007 {
	public static void main(String[] args) {
		int requestedIndex = 10001;
		int count = 1;
		int i = 3;
		int recent = 2;
		
		while (count < requestedIndex)
		{
			boolean prime = true;
			for (int j = 2; j < i; j++)
			{
				if (i % j == 0)
					prime = false;
			}
			if (prime)
			{
//				System.out.println(i);
				recent = i;
				count++;
			}
			i++;
		}
		System.out.println(recent);
	}

}
