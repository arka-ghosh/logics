/**
 * @(#) Problem_9.java
 *      Copyright © 2016 - Arka Ghosh. All rights reserved.
 *      Usage is subject to license terms. Any unauthorized usage will be prosecuted.
 */
package practice.euler.problems.fifty01;

/**
 * @author Arka Ghosh
 * @since Jun 28, 2016
 * @version 1.0
 */
public class Problem_009
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int ceiling = 1000;
		for (int a = 3; a <= (ceiling - 3); a++) {
			for (int b = 2; b < a; b++) {
				for (int c = 1; c < b; c++) {
					if (Math.pow(a, 2) == (Math.pow(b, 2) + Math.pow(c, 2))) {
						if ((a + b + c) == ceiling) {
							System.out.println(a * b * c);
						}
					}
				}
			}
		}
	}

}
