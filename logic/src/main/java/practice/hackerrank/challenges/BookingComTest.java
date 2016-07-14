/**
 * @(#) BookingComTest.java
 *      Copyright © 2016 - Cognizant Technology Solutions. All rights reserved.
 *      Usage is subject to license terms. Any unauthorized usage will be prosecuted.
 */
package practice.hackerrank.challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Arka Ghosh
 * @since Jun 30, 2016
 * @version 1.0
 */
public class BookingComTest
{

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		polygon();
	}

	/**
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	private static void polygon() throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String allSides;
		int squares = 0;
		int rectangles = 0;
		int others = 0;
		while ((allSides = br.readLine().trim()) != null) {
			String[] sides = allSides.split(" ");
			if (Integer.parseInt(sides[0]) > 0 && Integer.parseInt(sides[1]) > 0 && Integer.parseInt(sides[2]) > 0
					&& Integer.parseInt(sides[3]) > 0) {
				if (Integer.parseInt(sides[0]) == Integer.parseInt(sides[1])
						|| Integer.parseInt(sides[0]) == Integer.parseInt(sides[2])
						|| Integer.parseInt(sides[0]) == Integer.parseInt(sides[3])) {
					if (Integer.parseInt(sides[1]) == Integer.parseInt(sides[2])
							&& Integer.parseInt(sides[2]) == Integer.parseInt(sides[3])) {
						squares++;
					} else {
						rectangles++;
					}
				} else {
					others++;
				}
			} else {
				others++;
			}
		}
		System.out.print(squares + " " + rectangles + " " + others);
	}

	private static void hotelSort() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> keywords = Arrays.asList(br.readLine().split(" "));
		int reviewCount = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < reviewCount; i++) {
			int hotelId = Integer.parseInt(br.readLine());
			int mentions = 0;
			String comment = br.readLine().trim();
			comment = comment.replaceAll("\\.", "");
			comment = comment.replaceAll(",", "");
			List<String> words = Arrays.asList(comment.split(" "));
			for (String keyWord : keywords) {
				if (words.contains(keyWord)) {
					mentions++;
				}
			}
			map.put(hotelId, mentions);
		}
		List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>()
		{
			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
			{
				int comp = (o2.getValue()).compareTo(o1.getValue());
				if (comp == 0) {
					return o2.getKey().compareTo(o1.getKey());
				} else {
					return comp;
				}
			}
		});
		Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
		for (Map.Entry<Integer, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		for (int id : sortedMap.keySet()) {
			System.out.print(id + " ");
		}
	}

	private static void deltaEncoding() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> numbers = Arrays.asList(br.readLine().trim().split(" "));

	}
}
