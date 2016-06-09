/**
 * @(#) Lesson3_FrogJmp.java
 *      Copyright © 2016 - Cognizant Technology Solutions. All rights reserved.
 *      Usage is subject to license terms. Any unauthorized usage will be prosecuted.
 */
package practice.codility.lessons;

/**
 * @author Arka Ghosh
 * @since Jun 8, 2016
 * @version 1.0
 */
public class Lesson3_FrogJmp
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Lesson3_FrogJmp lesson = new Lesson3_FrogJmp();
		System.out.println(lesson.solution(10, 10, 30));
		System.out.println(lesson.solution(10, 85, 30));

	}

	public int solution(int X, int Y, int D)
	{
		if (Y == X) {
			return 0;
		}
		int rem = (Y - X) % D;
		if (rem == 0) {
			return (Y - X) / D;
		} else {
			return ((Y - X) / D) + 1;
		}
	}
}
