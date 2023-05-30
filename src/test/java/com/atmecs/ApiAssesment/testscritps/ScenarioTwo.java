package com.atmecs.ApiAssesment.testscritps;

import org.testng.annotations.Test;

import com.atmecs.ApiAutomation.utils.CommonMethods;

public class ScenarioTwo {

	@Test(priority = 1)
	public void addPetToTheStore() throws Exception {
		CommonMethods.addPetToTheStore();

	}

	@Test(priority = 2)
	public void findPetById() {
		CommonMethods.findPetById();
	}

	@Test(priority = 3)
	public void findPetbyStatus() {
		CommonMethods.findPetbyStatus();

	}

	@Test(priority = 4)
	public void deletePet() {
		CommonMethods.deletePet();

	}

}
