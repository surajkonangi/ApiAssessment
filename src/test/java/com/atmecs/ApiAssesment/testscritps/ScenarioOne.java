package com.atmecs.ApiAssesment.testscritps;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.atmecs.ApiAutomation.utils.CommonMethods;
import com.atmecs.ApiAutomation.utils.ExcellToJsonConverter;

public class ScenarioOne {

//	@BeforeSuite
//	public void jsonreader() throws Exception {
//		ExcellToJsonConverter.jsondata();
//	}

	@Test(priority = 1)
	public void addPetToTheStore() throws Exception {
		CommonMethods.addPetToTheStore();
	}

	@Test(priority = 2)
	public void petImageUpload() {
		CommonMethods.petImageUpload();
	}

	@Test(priority = 3)
	public void findPetById() {
		CommonMethods.findPetById();

	}

	@Test(priority = 4)
	public void findPetbyStatus() {
		CommonMethods.findPetbyStatus();

	}
}
