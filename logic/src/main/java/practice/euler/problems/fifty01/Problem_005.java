/**
 * @(#) Problem_5.java
 *      Copyright © 2016 - Arka Ghosh. All rights reserved.
 *      Usage is subject to license terms. Any unauthorized usage will be prosecuted.
 */
package practice.euler.problems.fifty01;

/**
 * @author Arka Ghosh
 * @since Jun 24, 2016
 * @version 1.0
 */
public class Problem_005
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long lcm = 1;
		for (int i = 1; i <= 20; i++) {
			lcm = lcm(i, lcm);
		}
		System.out.println(lcm);
	}

	private static long gcd(long a, long b)
	{
		while (b > 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	private static long lcm(long a, long b)
	{
		return a * (b / gcd(a, b));
	}
}
