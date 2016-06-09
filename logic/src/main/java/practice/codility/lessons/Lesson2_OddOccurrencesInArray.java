/**
 * @(#) Lesson2_OddOccurrencesInArray.java
 *      Copyright © 2016 - Cognizant Technology Solutions. All rights reserved.
 *      Usage is subject to license terms. Any unauthorized usage will be prosecuted.
 */
package practice.codility.lessons;

import java.util.Arrays;

/**
 * @author Arka Ghosh
 * @since Jun 8, 2016
 * @version 1.0
 */
public class Lesson2_OddOccurrencesInArray
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Lesson2_OddOccurrencesInArray lesson = new Lesson2_OddOccurrencesInArray();
		int[] A = { 9, 7, 9, 3, 7 };
		System.out.println(lesson.solution(A));
	}

	public int solution2(int[] A)
	{
		for (int x = 0; x < A.length; x++) {
			if (A[x] == 0) {
				continue;
			}
			for (int i = x + 1; i < A.length; i++) {
				if (A[i] != 0 && A[i] == A[x]) {
					A[x] = 0;
					A[i] = 0;
					break;
				}
			}
			if (A[x] != 0) {
				return A[x];
			}
		}
		return 0;
	}

	/**
	 * faster solution
	 * The sorting is a Dual-Pivot Quicksort with complexity of O(n log(n))
	 * 
	 * @param A
	 * @return
	 */
	public int solution(int[] A)
	{
		Arrays.sort(A);
		for (int x = 0; x < A.length - 1; x++) {
			if (A[x] != 0 && A[x] != A[x + 1]) {
				return A[x];
			} else if (A[x] != 0) {
				A[x] = 0;
				A[x + 1] = 0;
			}
		}
		return A[A.length - 1];
	}
}
