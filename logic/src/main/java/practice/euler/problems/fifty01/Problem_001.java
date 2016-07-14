/**
 * @(#) Problem_1.java
 *      Copyright © 2016 - Arka Ghosh. All rights reserved.
 *      Usage is subject to license terms. Any unauthorized usage will be prosecuted.
 */
package practice.euler.problems.fifty01;

import java.util.Scanner;

/**
 * @author Arka Ghosh
 * @since Jun 24, 2016
 * @version 1.0
 */
public class Problem_001
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		for (int j = 1; j <= i; j++) {
			int number = scan.nextInt();
			solution(number);
		}
		scan.close();
	}

	/**
	 * 
	 */
	private static void solution(int n)
	{
		long three = (n - 1) / 3;
		long five = (n - 1) / 5;
		long fifteen = (n - 1) / 15;
		long sum = (3 * (three * (three + 1)) + 5 * (five * (five + 1)) - 15 * (fifteen * (fifteen + 1))) / 2;
		System.out.println(sum);
	}
}
