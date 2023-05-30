package com.atmecs.ApiAutomation.utils;

import java.io.File;

public class ConstantPaths {
	public final static String USER_HOME = System.getProperty("user.dir") + File.separator;
	public final static String Testdata_Properties = USER_HOME + File.separator + "src/main/resources" + File.separator
			+ "properties" + File.separator + "Scenario.properties";
	public final static String AddPet_Properties = USER_HOME + File.separator + "src/main/resources" + File.separator
			+ "jsoninputs" + File.separator + "AddPet.json";
	public final static String UpdatePet_Properties = USER_HOME + File.separator + "src/main/resources" + File.separator
			+ "jsoninputs" + File.separator + "UpdatePet.json";

}
