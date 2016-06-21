/**
 * @(#) Lessson3_PermMissingElem.java
 *      Copyright © 2016 - Cognizant Technology Solutions. All rights reserved.
 *      Usage is subject to license terms. Any unauthorized usage will be prosecuted.
 */
package practice.codility.lessons;

import java.util.Arrays;

/**
 * @author Arka Ghosh
 * @since Jun 9, 2016
 * @version 1.0
 */
public class Lesson3_PermMissingElem
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Lesson3_PermMissingElem lesson = new Lesson3_PermMissingElem();
		int[] A = { 2, 3, 1, 5 };
		System.out.println(lesson.solution(A));
	}

	public int solution(int[] A)
	{
		if (A.length != 0) {
			Arrays.sort(A);
			for (int i = 0; i < A.length - 1; i++) {
				if (A[i] + 1 != A[i + 1]) {
					return A[i] + 1;
				}
			}
			if (A[A.length - 1] != A.length + 1) {
				return A.length + 1;
			}
		}
		return 1;
	}
}
