/**
 * @(#) Problem_10.java
 *      Copyright © 2016 - Arka Ghosh. All rights reserved.
 *      Usage is subject to license terms. Any unauthorized usage will be prosecuted.
 */
package practice.euler.problems.fifty01;

/**
 * @author Arka Ghosh
 * @since Jun 28, 2016
 * @version 1.0
 */
public class Problem_010
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long sum = 0;
		int ceiling = 2000000;
		for (int i = 2; i < ceiling; i++) {
			if (isPrime(i)) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

	private static boolean isPrime(int number)
	{
		boolean flag = true;
		for (int i = 2; i <= (number / 2); i++) {
			if (number % i == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}

}
