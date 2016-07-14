/**
 * @(#) Stdin_Stdout_I.java
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
public class Stdin_Stdout_I
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

		scan.close();
	}

}
