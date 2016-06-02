/**
 * @(#) Challenge1.java
 *      Copyright © 2016 - Cognizant Technology Solutions. All rights reserved.
 *      Usage is subject to license terms. Any unauthorized usage will be prosecuted.
 */
package com.salt.challenge;

/**
 * @author 403238
 * @since Feb 8, 2016
 * @version 1.0
 */
class Challenge1
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int result = 0;
		for (int i = 500; i <= 1000; i = i + 2) {
			if (i % 7 != 0) {
				result += i;
			}
		}
		System.out.println("Result: " + result);

	}

}
