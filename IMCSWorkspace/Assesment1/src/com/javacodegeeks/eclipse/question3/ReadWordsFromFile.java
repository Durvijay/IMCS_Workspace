package com.javacodegeeks.eclipse.question3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class ReadWordsFromFile {
	private Reader reader;

	
	public ReadWordsFromFile(File file) throws FileNotFoundException {
		super();
		this.reader = new FileReader(file);
	}


	public Map<String,Integer> process() {
		Map<String,Integer> map=new HashMap<String,Integer>();
		try (BufferedReader br=new BufferedReader(reader)){
			String line="test";
			while (true) {
				line=br.readLine();
				if(line==null || line==""){
					break;
				}
				String [] arr=line.split(" ");
				for (String string : arr) {
					int count=1;
					if(map.containsKey(string)){
						count=map.get(string)+1;
					}
					if(!string.trim().equals(""))
					map.put(string, count);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}
}
