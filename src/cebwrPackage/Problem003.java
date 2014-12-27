package cebwrPackage;

public class Problem003 {
	public static void main(String[] args) {
		long theta = 600851475143L;
//		long theta = 13L;
		boolean[] primes = getPrimes(theta);
		int largest = 0;
		for (int i = 0; i < primes.length; i++)
		{
			if (primes[i])
			{
				if (theta == i)
					System.out.println(i);
				while (theta % i == 0)
					theta /= i;
			}
		}
		if (theta != 1)
			System.out.println(theta);
	}
	public static boolean[] getPrimes(long seed) 	{
		double limit = Math.sqrt(seed);
		int size = (int) Math.ceil(limit);

		boolean[] prime = new boolean[size];
		for (int q = 0; q < size; q++)
			prime[q] = true;
		
		prime[0] = false;
		prime[1] = false;
		
		for (int i = 2; i < size; i++)
			if (prime[i])
				for (int k = 2; k < prime.length/i; k++)
					prime[i*k] = false;
		return prime;
	}
}
