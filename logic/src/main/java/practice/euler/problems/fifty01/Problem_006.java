/**
 * @(#) Problem_6.java
 *      Copyright © 2016 - Arka Ghosh. All rights reserved.
 *      Usage is subject to license terms. Any unauthorized usage will be prosecuted.
 */
package practice.euler.problems.fifty01;

/**
 * @author Arka Ghosh
 * @since Jun 24, 2016
 * @version 1.0
 */
public class Problem_006
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int number = 100;
		long sumOfSquare = (number * (number + 1) * ((number * 2) + 1)) / 6;
		long squareofSum = (long) Math.pow((number * (number + 1)) / 2, 2);
		System.out.println(squareofSum - sumOfSquare);
	}
}
