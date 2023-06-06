package com.atmecs.ApiAutomation.utils;

import java.io.FileWriter;
import java.io.IOException;
public class JsonDataToJsonFile {
    public static void main(String[] args) throws Exception {
        ExcellToJsonConverter json = new ExcellToJsonConverter();
        String jsonData = json.jsondata(); // Replace with your JSON data
        String filePath = "C:\\Users\\suraj.konangi\\eclipse-workspace\\ApiAssesment\\src\\main\\resources\\properties\\output.json"; // Replace with the desired file path
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(jsonData);
            System.out.println("JSON data has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

