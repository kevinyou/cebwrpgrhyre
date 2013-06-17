package cebwrPackage;

public class Problem002 {
	public static void main(String[] args) {
		int sum = 0;
		int threshold = 4000000;
		int now = 1;
		for (int i = 1; now < threshold; i++) {
			now = fib(i);
			if (now % 2 == 0)
				sum += now;
//			System.out.println(now);
		}
		System.out.println(sum);	
	}
	
	public static int fib(int num) {
		if (num < 1)
			return 1;
		else if (num == 1)
			return 2;
		return fib(num - 1) + fib(num - 2);
	}
}
