/**
 * @(#) AmazonIndiaTest.java
 *      Copyright © 2016 - Cognizant Technology Solutions. All rights reserved.
 *      Usage is subject to license terms. Any unauthorized usage will be prosecuted.
 */
package practice.hackerrank.challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Arka Ghosh
 * @since Jun 22, 2016
 * @version 1.0
 */
public class AmazonIndiaTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		int[] lockerXCoordinates = { 2, 4 };
		int[] lockerYCoordinates = { 3, 7 };
		AmazonIndiaTest.getLockerDistanceGrid(5, 7, lockerXCoordinates, lockerYCoordinates);

	}

	static int[][]
			getLockerDistanceGrid(int cityLength, int cityWidth, int[] lockerXCoordinates, int[] lockerYCoordinates)
	{
		int[][] grid = new int[cityLength][cityWidth];
		for (int l = 0; l < cityLength; l++) {
			for (int w = 0; w < cityWidth; w++) {
				int shortestLength = cityLength;
				int shortestWidth = cityWidth;
				for (int i = 0; i < lockerXCoordinates.length; i++) {
					if (Math.abs(lockerYCoordinates[i] - (w + 1)) + Math.abs(lockerXCoordinates[i] - (l + 1)) < shortestWidth
							+ shortestLength) {
						shortestWidth = Math.abs(lockerYCoordinates[i] - (w + 1));
						shortestLength = Math.abs(lockerXCoordinates[i] - (l + 1));
					}
				}
				grid[l][w] = shortestLength + shortestWidth;
			}
		}
		return grid;
	}

	public List<String> getDirectFriendsForUser(String user)
	{
		return null;
	}

	public List<String> getAttendedCoursesForUser(String user)
	{
		return null;
	}

	public List<String> getRankedCourses(String user)
	{
		List<String> directFriends = getDirectFriendsForUser(user);
		List<String> socialNetwork = new ArrayList<String>(directFriends);
		for (String friend : directFriends) {
			socialNetwork.addAll(getDirectFriendsForUser(friend));
		}
		List<String> coursesDone = getAttendedCoursesForUser(user);
		Map<String, Integer> courseMap = new HashMap<String, Integer>();
		for (String network : socialNetwork) {
			List<String> courses = getAttendedCoursesForUser(network);
			for (String course : courses) {
				if (!coursesDone.contains(course)) {
					if (courseMap.containsKey(course)) {
						courseMap.put(course, courseMap.get(course) + 1);
					} else {
						courseMap.put(course, 1);
					}
				}
			}
		}
		List<Map.Entry<String, Integer>> list = new LinkedList<>(courseMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
		{
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
			{
				int comp = (o2.getValue()).compareTo(o1.getValue());
				if (comp == 0) {
					return o2.getKey().compareTo(o1.getKey());
				} else {
					return comp;
				}
			}
		});
		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		for (Map.Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return new ArrayList<>(sortedMap.keySet());
	}

}
