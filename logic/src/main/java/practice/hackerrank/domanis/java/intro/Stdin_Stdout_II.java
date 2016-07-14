/**
 * @(#) Stdin_Stdout_II.java
 *      Copyright © 2016 - Arka Ghosh. All rights reserved.
 *      Usage is subject to license terms. Any unauthorized usage will be prosecuted.
 */
package practice.hackerrank.domanis.java.intro;

import java.util.Scanner;

/**
 * @author Arka Ghosh
 * @since Jun 30, 2016
 * @version 1.0
 */
public class Stdin_Stdout_II
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		double b = scan.nextDouble();
		scan.nextLine();
		String c = scan.nextLine();

		System.out.println("String: " + c);
		System.out.println("Double: " + b);
		System.out.println("Int: " + a);

		scan.close();
	}

}
