/**
 * @(#) Lesson2_Arrays.java
 *      Copyright © 2016 - Cognizant Technology Solutions. All rights reserved.
 *      Usage is subject to license terms. Any unauthorized usage will be prosecuted.
 */
package practice.codility.lessons;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Arka Ghosh
 * @since Jun 2, 2016
 * @version 1.0
 */
public class Lesson2_Arrays
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Lesson2_Arrays lesson = new Lesson2_Arrays();
		int[] A = { 2, 3, 4, 5, 6, 7, 1 };
		System.out.println(Arrays.toString(lesson.solution(A, 0)));
		System.out.println(Arrays.toString(lesson.solution(A, 3)));
		System.out.println(Arrays.toString(lesson.solution(A, 5)));
		System.out.println(Arrays.toString(lesson.solution(A, 6)));
		System.out.println(Arrays.toString(lesson.solution(A, 50)));
	}

	public int[] solution(int[] A, int K)
	{
		int[] B = new int[A.length];
		if (K == 0) {
			return A;
		}
		if (A.length > 0) {
			Stack<Integer> stack = new Stack<Integer>();
			if (K < A.length) {
				for (int x = A.length - K; x < A.length; x++) {
					stack.push(A[x]);
				}
				for (int x = 0; x < A.length - K; x++) {
					stack.push(A[x]);
				}
			} else {
				B = solution(A, K - A.length);
			}
			for (int i = 0; i < stack.size(); i++) {
				B[i] = stack.get(i);
			}
		}
		return B;
	}
}
