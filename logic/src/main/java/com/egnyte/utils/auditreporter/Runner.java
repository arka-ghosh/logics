package com.egnyte.utils.auditreporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Runner
{

	private List<List<String>> users;
	private List<List<String>> files;
	private List<List<String>> csvContent = new ArrayList<List<String>>();
	private String fileName;
	private static boolean csvFlag = false; // if true, then write to CSV file.

	public static void main(String[] args) throws IOException
	{
		boolean topFiles = false;
		int topFileCount = 0;
		Runner r = new Runner();
		r.loadData(args[0], args[1]);
		if (args.length > 2) {
			for (int i = 2; i < args.length; i++) {
				if (args[i].equals("-c")) {
					csvFlag = true;
				}
				if (args[i].equals("--top")) {
					try {
						topFileCount = Integer.parseInt(args[i + 1]);
						topFiles = true;
					} catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
						System.out.println("Number of records to be shown is mandatory when using the --top option.");
						throw ex;
					}
				}
			}
		}
		if (topFiles) {
			r.runForTopFiles(topFileCount);
		} else {
			r.run();
		}
	}

	private void run() throws IOException
	{
		printHeader();
		for (List<String> userRow : users) {
			long userId = Long.parseLong(userRow.get(0));
			String userName = userRow.get(1);

			printUserHeader(userName);
			for (List<String> fileRow : files) {
				long size = Long.parseLong(fileRow.get(1));
				String fileName = fileRow.get(2);
				long ownerUserId = Long.parseLong(fileRow.get(3));
				if (ownerUserId == userId) {
					printFile(fileName, size);
					if (csvFlag) {
						List<String> csvRow = new ArrayList<String>();
						csvRow.add(userName);
						csvRow.add(fileName);
						csvRow.add(fileRow.get(1));
						csvContent.add(csvRow);
					}
				}
			}
		}
		if (csvFlag) {
			fileName = "Audit_Report.csv";
			writeCSV(csvContent);
		}
	}

	private void runForTopFiles(int topFileCount) throws IOException
	{
		printTopReportHeader(topFileCount);
		Collections.sort(files, new FileComparator());
		for (int i = 0; i < topFileCount; i++) {
			long size = Long.parseLong(files.get(i).get(1));
			long ownerUserId = Long.parseLong(files.get(i).get(3));
			String fileName = files.get(i).get(2);
			for (List<String> userRow : users) {
				long userId = Long.parseLong(userRow.get(0));
				String userName = userRow.get(1);
				if (ownerUserId == userId) {
					printTopReport(fileName, userName, size);
					if (csvFlag) {
						List<String> csvRow = new ArrayList<String>();
						csvRow.add(fileName);
						csvRow.add(userName);
						csvRow.add(files.get(i).get(1));
						csvContent.add(csvRow);
					}
				}
			}
		}
		if (csvFlag) {
			fileName = "Top_Files_Report.csv";
			writeCSV(csvContent);
		}
	}

	private void loadData(String userFn, String filesFn) throws IOException
	{
		String line;

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(userFn));
			users = new ArrayList<List<String>>();

			reader.readLine(); // skip header

			while ((line = reader.readLine()) != null) {
				users.add(Arrays.asList(line.split(",")));
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

		reader = null;
		try {
			reader = new BufferedReader(new FileReader(filesFn));
			files = new ArrayList<List<String>>();

			reader.readLine(); // skip header

			while ((line = reader.readLine()) != null) {
				files.add(Arrays.asList(line.split(",")));
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	private void printHeader()
	{
		System.out.println("Audit Report");
		System.out.println("============");
	}

	private void printTopReportHeader(int topFileCount)
	{
		System.out.println("Top #" + topFileCount + " Report");
		System.out.println("=============");
	}

	private void printUserHeader(String userName)
	{
		System.out.println("## User: " + userName);
	}

	private void printFile(String fileName, long fileSize)
	{
		System.out.println("* " + fileName + " ==> " + fileSize + " bytes");
	}

	private void printTopReport(String fileName, String userName, long fileSize)
	{
		System.out.println("* " + fileName + " ==> user " + userName + ", " + fileSize + " bytes");
	}

	/**
	 * Method to write a content to a CSV file.
	 * 
	 * @param content - content of the CSV
	 * @param fileName - the name of teh csv file
	 * @throws IOException
	 */
	private void writeCSV(List<List<String>> content) throws IOException
	{
		File csvFile = new File(fileName);
		csvFile.createNewFile();
		PrintStream output = new PrintStream(csvFile);
		for (List<String> csvRow : content) {
			for (int i = 0; i < csvRow.size(); i++) {
				output.print(csvRow.get(i));
				if (!(i == csvRow.size() - 1)) {
					output.print(",");
				}
			}
			output.println();
		}
		output.flush();
		output.close();
		System.out.println("CSV File has been created successfully at: " + csvFile.getAbsolutePath());
	}

	private class FileComparator implements Comparator<List<String>>
	{

		/**
		 * compare
		 * 
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		public int compare(List<String> o1, List<String> o2)
		{
			long fileSize1 = Long.parseLong(o1.get(1));
			long fileSize2 = Long.parseLong(o2.get(1));

			if (fileSize1 > fileSize2) {
				return -1;
			} else if (fileSize1 < fileSize2) {
				return 1;
			} else {
				return 0;
			}
		}

	}
}
