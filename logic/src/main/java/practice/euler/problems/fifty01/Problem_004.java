/**
 * @(#) Problem_4.java
 *      Copyright © 2016 - Arka Ghosh. All rights reserved.
 *      Usage is subject to license terms. Any unauthorized usage will be prosecuted.
 */
package practice.euler.problems.fifty01;

/**
 * @author Arka Ghosh
 * @since Jun 24, 2016
 * @version 1.0
 */
public class Problem_004
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long palindrome = 0;
		for (int i = 100; i <= 999; i++) {
			for (int j = 100; j <= 999; j++) {
				if (new StringBuilder(String.valueOf(i * j)).reverse().toString().equals(String.valueOf(i * j))
						&& (i * j) > palindrome) {
					palindrome = i * j;
				}
			}
		}
		System.out.println(palindrome);
	}

}
