package com.atmecs.ApiAutomation.utils;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CommonMethods {
	public final static Logger LOGGER = LogManager.getLogger(CommonMethods.class);
	public static Response response;
	public static JSONObject input;
	public static Properties prop;
	public static helper help;

	public static void addPetToTheStore() throws Exception {
		help = new helper();
		JSONParser data = new JSONParser();
		FileReader jsondata = new FileReader(ConstantPaths.AddPet_Properties);
		Object obj = data.parse(jsondata);
		input = (JSONObject) obj;

		response = RestAssured.given().baseUri(help.testdata("url")).contentType(help.testdata("content"))
				.body(input.toJSONString()).when().post(help.testdata("addpetpostendpoint")).then().log().all()
				.extract().response();
		assertThat(response.getStatusCode(), is(Integer.parseInt(help.testdata("statuscode"))));
		assertThat(response.getStatusLine(), equalTo((help.testdata("statusline"))));
		assertThat(response.body(), notNullValue());
		response.then().assertThat().body("id", Matchers.equalTo(Integer.parseInt(help.testdata("petid"))));
		LOGGER.info("Successfully added a pet to the store");

	}

	public static void petImageUpload() {
		help = new helper();
		response = RestAssured.given().baseUri(help.testdata("url")).contentType(help.testdata("contenttypeimage"))
				.multiPart("file", new File(help.testdata("imagepath"))).when().post(help.testdata("imagepostendpoint"))
				.then().log().all().extract().response();
		assertThat(response.getStatusCode(), is(Integer.parseInt(help.testdata("statuscode"))));
		assertThat(response.getStatusLine(), equalTo((help.testdata("statusline"))));
		assertThat(response.body(), notNullValue());
		LOGGER.info("image uploaded Successfully");
	}

	public static void updateExistingPet() throws Exception {
		help = new helper();
		JSONParser data = new JSONParser();
		FileReader jsondata = new FileReader(ConstantPaths.UpdatePet_Properties);
		Object obj = data.parse(jsondata);
		input = (JSONObject) obj;

		response = RestAssured.given().baseUri(help.testdata("url")).contentType(help.testdata("content"))
				.body(input.toJSONString()).when().put(help.testdata("updatepetendpoint")).then().log().all().extract()
				.response();
		assertThat(response.getStatusCode(), is(Integer.parseInt(help.testdata("statuscode"))));
		assertThat(response.getStatusLine(), equalTo((help.testdata("statusline"))));
		assertThat(response.body(), notNullValue());
		response.then().assertThat().body("id", Matchers.equalTo(Integer.parseInt(help.testdata("petid"))));
		LOGGER.info("details updated successful");

	}

	public static void findPetById() {
		help = new helper();
		response = RestAssured.given().baseUri(help.testdata("url")).when().get(help.testdata("findpetgetbyidendpoint"))
				.then().log().all().extract().response();
		assertThat(response.getStatusCode(), is(Integer.parseInt(help.testdata("statuscode"))));
		assertThat(response.getStatusLine(), equalTo((help.testdata("statusline"))));
		assertThat(response.body(), notNullValue());
		response.then().assertThat().body("id", Matchers.equalTo(Integer.parseInt(help.testdata("petid"))));
		LOGGER.info("Fetched the required pet successful");
	}

	public static void findPetbyStatus() {
		help = new helper();
		response = RestAssured.given().baseUri(help.testdata("url")).param("status", help.testdata("findpetbystatus"))
				.when().get(help.testdata("getbystatusendpoint")).then().log().all().extract().response();
		assertThat(response.getStatusCode(), is(Integer.parseInt(help.testdata("statuscode"))));
		assertThat(response.getStatusLine(), equalTo((help.testdata("statusline"))));
		assertThat(response.body(), notNullValue());
		LOGGER.info("Fetched the list with given criteria");
	}

	public static void deletePet() {

		response = RestAssured.given().baseUri(help.testdata("url")).when().delete(help.testdata("deletepetendpoint"))
				.then().log().all().extract().response();
		assertThat(response.getStatusCode(), is(Integer.parseInt(help.testdata("statuscode"))));
		assertThat(response.getStatusLine(), equalTo((help.testdata("statusline"))));
		assertThat(response.body(), notNullValue());
		response.then().assertThat().body("message", Matchers.equalTo((help.testdata("deletemessage"))));
		System.out.println("deleted successful");
		LOGGER.info("successfully deleated");

	}

}
