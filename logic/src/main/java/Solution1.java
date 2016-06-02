import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @(#) Solution1.java
 *      Copyright © 2016 - Cognizant Technology Solutions. All rights reserved.
 *      Usage is subject to license terms. Any unauthorized usage will be prosecuted.
 */

/**
 * @author 403238
 * @since Feb 12, 2016
 * @version 1.0
 */
public class Solution1
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner in = new Scanner("6\nHilary\nJames\nSarah Fred\nSarah Paul\nFred Hilary\nFred Jenny\nJenny James");
		int _count;
		_count = Integer.parseInt(in.nextLine());

		OutputMostPopularDestination(_count, in);
	}

	/**
	 * @param _count
	 * @param in
	 */
	private static void OutputMostPopularDestination(int _count, Scanner in)
	{
		String empOne = in.nextLine();
		String empTwo = in.nextLine();
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		String result = "";
		while (in.hasNextLine()) {
			String[] relation = in.nextLine().split(" ");
			if (empOne.equals(relation[0])) {
				list1.add(relation[0]);
			} else if (empTwo.equals(relation[0])) {
				list2.add(relation[0]);
			}
		}
		System.out.println(result);

	}

}
