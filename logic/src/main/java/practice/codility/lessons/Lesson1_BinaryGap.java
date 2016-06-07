/**
 * @(#) Lesson1_BinaryGap.java
 *      Copyright © 2016 - Cognizant Technology Solutions. All rights reserved.
 *      Usage is subject to license terms. Any unauthorized usage will be prosecuted.
 */
package practice.codility.lessons;

/**
 * @author Arka Ghosh
 * @since Jun 2, 2016
 * @version 1.0
 */
public class Lesson1_BinaryGap
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Lesson1_BinaryGap lesson = new Lesson1_BinaryGap();
		System.out.println("Binary gap for 20: " + lesson.solution(20));
		System.out.println("Binary gap for 529: " + lesson.solution(529));
		System.out.println("Binary gap for 9: " + lesson.solution(9));
		System.out.println("Binary gap for 15: " + lesson.solution(15));
		System.out.println("Binary gap for 1041: " + lesson.solution(1041));

	}

	public int solution(int N)
	{
		int gap = 0;
		int tempgap = 0;
		char[] binary = Integer.toBinaryString(N).toCharArray();
		for (char x : binary) {
			if ("1".equals(String.valueOf(x))) {
				if (tempgap > gap) {
					gap = tempgap;
				}
				tempgap = 0;
			} else {
				tempgap++;
			}
		}
		return gap;
	}
}
