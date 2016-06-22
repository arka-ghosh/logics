/**
 * @(#) Demo.java
 *      Copyright © 2016 - Cognizant Technology Solutions. All rights reserved.
 *      Usage is subject to license terms. Any unauthorized usage will be prosecuted.
 */
package practice.hackerrank.challenges;

/**
 * @author Arka Ghosh
 * @since Jun 21, 2016
 * @version 1.0
 */
public class Demo
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// Demo.StairCase(6);
		// int[] numbers = { 5, 1, 2, 3, 4, 5 };
		int[] numbers = { 12, 12 };
		System.out.println(Demo.sum(numbers));
	}

	static void StairCase(int n)
	{
		int i = 1;
		while (i <= n) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("#");
			}
			if (i != n) {
				System.out.println("");
			}
			i++;
		}
	}

	static int sum(int[] numbers)
	{
		if (numbers.length == 0) {
			return 0;
		}
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		return sum;
	}
}
