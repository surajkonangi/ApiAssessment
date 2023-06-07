package com.atmecs.ApiAssesment.testscritps;

import org.testng.annotations.Test;

import com.atmecs.ApiAutomation.utils.CommonMethods;



public class ScenarioThree {

	@Test(priority = 1)
	public void petImageUpload() {
		CommonMethods.petImageUpload();

	}

	@Test(priority = 2)
	public void updateExistingPet() throws Exception {
		CommonMethods.updateExistingPet();
	}

	@Test(priority = 3)
	public void deletePet() {
		CommonMethods.deletePet();

	}

}
