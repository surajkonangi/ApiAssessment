package com.atmecs.ApiAutomation.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileInputStream;

public class ExcellToJsonConverter {
	public static JSONArray jsondata() throws Exception {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\suraj.konangi\\eclipse-workspace\\ApiAssesment\\src\\main\\resources\\excellinputs\\testdata.xlsx");
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0); 
		workbook.close();

		JSONArray jsonArray = new JSONArray();
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			JSONObject jsonObject = new JSONObject();
			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);

				DataFormatter values = new DataFormatter();
				String key = values.formatCellValue(sheet.getRow(0).getCell(j));
				String value = values.formatCellValue(cell);
				jsonObject.put(key, value);

			}
			jsonArray.put(jsonObject);
		}

		String jsonOutput = jsonArray.toString();
		System.out.println(jsonOutput);
		return jsonArray;
	}
}
