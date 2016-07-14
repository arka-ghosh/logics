/**
 * @(#) Problem_7.java
 *      Copyright © 2016 - Arka Ghosh. All rights reserved.
 *      Usage is subject to license terms. Any unauthorized usage will be prosecuted.
 */
package practice.euler.problems.fifty01;

/**
 * @author 403238
 * @since Jun 24, 2016
 * @version 1.0
 */
public class Problem_007
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int counter = 1;
		boolean flag = true;
		int prime = 3;
		while (true) {
			for (int i = 2; i <= (prime / 2); i++) {
				if (prime % i == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				counter++;
			}
			if (counter == 10001) {
				break;
			}
			prime++;
			flag = true;
		}
		System.out.println(prime);
	}

}
