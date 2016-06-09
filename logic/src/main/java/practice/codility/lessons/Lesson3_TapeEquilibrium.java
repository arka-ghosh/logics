/**
 * @(#) Lesson3_TapeEquilibrium.java
 *      Copyright © 2016 - Cognizant Technology Solutions. All rights reserved.
 *      Usage is subject to license terms. Any unauthorized usage will be prosecuted.
 */
package practice.codility.lessons;

/**
 * @author Arka Ghosh
 * @since Jun 8, 2016
 * @version 1.0
 */
public class Lesson3_TapeEquilibrium
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Lesson3_TapeEquilibrium lesson = new Lesson3_TapeEquilibrium();
		// int[] A = { 3, 1, 2, 4, 3 };
		// int[] A = { -1000, 1000 };
		int[] A = { 1, 1, 1, 1, 1, -1, 1, -1, 1, -1, 1, -1 };
		System.out.println(lesson.solution(A));
	}

	public int solution(int[] A)
	{
		int leftSum = 0;
		int rightSum = 0;
		for (int y = 0; y < A.length; y++) {
			rightSum += A[y];
		}
		int value = -1;
		for (int i = 1; i < A.length; i++) {
			leftSum += A[i - 1];
			rightSum -= A[i - 1];
			if (value == -1 || Math.abs(leftSum - rightSum) < value) {
				value = Math.abs(leftSum - rightSum);
			}
		}
		return value;
	}
}
