package com.javacodegeeks.eclipse.question3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

public class ReadWordTest {

	public static void main(String[] args) throws FileNotFoundException {
		String path = "C:\\Users\\DURVIJAY\\Desktop\\testing.txt";
		ReadWordsFromFile readWordsFromFile = new ReadWordsFromFile(new File(path));
		Map<String,Integer> map=readWordsFromFile.process();
		printAllWordsWithCount(map);
		System.out.println("Total Unique Words are : "+map.size());
	}

	private static void printAllWordsWithCount(Map<String,Integer> map) {
		for (String string : map.keySet()) {
			System.out.println(string+" : "+map.get(string));
		}
		
	}

}
