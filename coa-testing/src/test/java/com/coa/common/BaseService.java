package com.coa.common;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import org.json.JSONException;
import org.json.JSONObject;

import com.coa.coacore.stepdefs.Services.APIServices.CoaService;

import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseService {

	private static Properties CONFIG = new Properties();
	private static String custId;
	private static int propertiesLoadedFlag = 0;

	public static String getCustId() {
		return custId;
	}

	public static void setCustId(String custId) {
		BaseService.custId = custId;
	}

	private static CoaService coaservice = new CoaService();

	public Properties getCONFIG() {
		return CONFIG;
	}

	private void loadProperties() throws IOException {
		CONFIG.load(new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/ServiceResource.properties"));
	}

	@When("^I access the service \"([^\"]*)\"$")
	public void iAccessTheService(String service) throws IOException,
			JSONException {
		if (propertiesLoadedFlag == 0) {
			loadProperties();
			propertiesLoadedFlag = 1;
		}

		switch (service) {

		case "COA.GetCustomerInfo":
			coaservice.getCustInfo();
			break;

		/*
		 * case "User.GetTheListOfADGrps": userservice.getADGrpdetails(); break;
		 * 
		 * case "User.InsertADGrpDetails": userservice.insertADGrp(); break;
		 * 
		 * case "Notification.GetAllNotifications":
		 * notificationservice.getAllNotifications(); break;
		 */

		default:
			System.out.println("Incorrect DSL format");
			break;
		}
	}

	@Given("^I select the CustomerId as \"([^\"]*)\"$")
	public void iSelectCustId(String custId) {
		setCustId(custId);
	}

}
