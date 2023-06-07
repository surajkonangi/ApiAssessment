package com.atmecs.ApiAutomation.utils;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;

public class JsonDataToJsonFile {
	public static void main(String[] args) throws Exception {

		JSONArray jsonData = ExcellToJsonConverter.jsondata();
		String filePath = "C:\\Users\\suraj.konangi\\eclipse-workspace\\ApiAssesment\\src\\main\\resources\\properties\\output.json";
		try (FileWriter fileWriter = new FileWriter(filePath)) {
			fileWriter.write(jsonData.toString());
			System.out.println("JSON data has been written to the file.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
