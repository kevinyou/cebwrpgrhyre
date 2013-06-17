package cebwrPackage;

public class Problem010 {
	public static void main(String[] args) {
		int threshold = 2000000;
		long sum = 0L;
		
		boolean[] primes = new boolean[threshold];
		
		for (int i = 2; i < threshold; i++)
			primes[i] = true;
		
		// true = prime;
		for (int i = 2; i < threshold; i++) {
			if (primes[i])
			{
				for (int j = 2; i*j < threshold; j++)
				{
					primes[i*j] = false;
				}
			}
		}
		
		for (int z = 2; z < threshold; z++)
			if (primes[z])
				sum += z;
		
		
		System.out.println(sum);

	}

}
