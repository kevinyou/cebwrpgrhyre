package cebwrPackage;

public class Problem003 {
	public static void main(String[] args) {
		long theta = 600851475143L;
		boolean[] primes = getPrimes(theta);
		int largest = 0;
		for (int i = 0; i < primes.length; i++)
			if (primes[i] && theta % i == 0)
				largest = i;
		System.out.println(largest);
	}
	public static boolean[] getPrimes(long seed) 	{
		double limit = Math.sqrt(seed);
		int size = (int) limit;
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
