package com.atmecs.ApiAutomation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class helper {

	public Properties prop;
	public FileInputStream path;;

	public String testdata(String key) {
		prop = new Properties();

		try {
			path = new FileInputStream(ConstantPaths.Testdata_Properties);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
}
