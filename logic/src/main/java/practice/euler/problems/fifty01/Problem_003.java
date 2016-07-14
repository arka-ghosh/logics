/**
 * @(#) Problem_3.java
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
public class Problem_003
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		for (int j = 1; j <= i; j++) {
			long number = scan.nextLong();
			solution(number);
		}
		scan.close();
	}

	/**
	 * @param number
	 */
	private static void solution(long number)
	{
		while (number % 2 == 0) {
			number = number / 2;
		}
		for (long i = 3; i < Math.sqrt(number); i += 2) {
			while (number % i == 0) {
				number = number / i;
			}
		}
		System.out.println(number);
	}
}
