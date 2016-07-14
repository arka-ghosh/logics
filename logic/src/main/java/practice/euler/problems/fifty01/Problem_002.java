/**
 * @(#) Problem_2.java
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
public class Problem_002
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
	 * 
	 */
	private static void solution(long num)
	{
		long sum = 0;
		long thisNum = 1;
		long nextNum = 2;
		while (nextNum <= num) {
			if (nextNum % 2 == 0) {
				sum += nextNum;
			}
			long tempNum = thisNum;
			thisNum = nextNum;
			nextNum += tempNum;
		}
		System.out.println(sum);
	}

}
