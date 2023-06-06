package com.atmecs.ApiAutomation.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ExcellToJsonConverter {
	public String jsondata() throws Exception {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\suraj.konangi\\eclipse-workspace\\ApiAssesment\\src\\main\\resources\\excellinputs\\testdata.xlsx");
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0); // Assuming the first sheet
		List<Row> rows = new ArrayList<>();
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			rows.add(rowIterator.next());
		}
		workbook.close();
		// Process the rows and convert to JSON
		// Code to convert rows to JSON using Jackson or Gson
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayNode jsonArray = objectMapper.createArrayNode();
		for (Row row : rows) {
			ObjectNode jsonObject = objectMapper.createObjectNode();
			// Assuming the first cell contains the key and the second cell contains the
			// value
			Cell keyCell = row.getCell(0);
			Cell valueCell = row.getCell(1);
			String key = keyCell.getStringCellValue();
			String value = valueCell.getStringCellValue();
			jsonObject.put(key, value);
			jsonArray.add(jsonObject);
		}
		String jsonOutput = jsonArray.toString();
		System.out.println(jsonOutput);
		return jsonOutput;
	}
}
