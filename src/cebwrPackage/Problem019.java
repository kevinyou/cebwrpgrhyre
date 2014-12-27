package cebwrPackage;

import java.math.BigInteger;

public class Problem019 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int count = 0;
		int month = 1;
		int year = 1901;
		int day = 1;
		int[] numDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		for (int i = 365; !(year == 2000 && month == 12 && day == 31); i++)
		{
			if (day == 1 && isSunday(i))
				count++;
			
			day++;
			if (day > numDays[month])
			{
				day = 1;
				month++;
				if (month > 12)
				{
					month = 1;
					year++;
					if (isLeapYear(year))
						numDays[2] = 29;
					else
						numDays[2] = 28;
				}
			}
			System.out.println(day);
		}
		
		System.out.println(count);
		
	}
	
	public static boolean isSunday(int day)
	{
		return ((day + 1) % 7 == 0) ? true : false;
	}
	
	public static boolean isLeapYear(int year)
	{
		return (year % 4 == 0) && (!(year % 100 == 0) || year % 400 == 0);
	}

}
