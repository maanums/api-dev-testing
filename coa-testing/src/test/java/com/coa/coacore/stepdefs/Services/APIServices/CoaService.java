package com.coa.coacore.stepdefs.Services.APIServices;

import cucumber.api.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import gherkin.formatter.model.Feature;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import com.coa.coacore.model.Customer;
import com.coa.coacore.model.Views;
import com.coa.common.BaseService;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class CoaService {

	private static BaseService baseService = new BaseService();
	private static Properties CONFIG = baseService.getCONFIG();
	private static String URL;
	private static JSONObject requestParams = new JSONObject();
	private static RequestSpecification request;
	private static Response response;

	public static Response getResponse() {
		return response;
	}

	private static Customer customer = new Customer();
	private static List<Views> views = new ArrayList<Views>();
	private static Views view = new Views();

	public static Customer getCustomer() {
		return customer;
	}

	private void loadRequestUrlHeaders() {
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI = CONFIG.getProperty("BASEURI");
		RestAssured.basePath = CONFIG.getProperty("BASEPATH");
		RestAssured.port = Integer.parseInt(CONFIG.getProperty("PORT"));
		request = RestAssured.given();
		request.headers("Content-Type","application/json");
		request.headers("Accept","application/json");
	}
	
	public void getCustInfo() {
		loadRequestUrlHeaders();
		response = getResponse("COA.GetCustomerInfo");
		response.prettyPrint();

	}
	
	private Response getResponse(String service){
		Response res = null;
		switch (service) {
				
				case "COA.GetCustomerInfo":
					res = request.get("/customers/"+baseService.getCustId()).then().contentType(ContentType.JSON).extract().response();
					break;
		
				case "COA.PostCustomerInfo":
					res = request.post("/customers/")
							.then().contentType(ContentType.JSON).extract().response();
					break;
					
				default:
					System.out.println("Incorrect request format");
					break;
				}
		return res;
		}

	

	@Then("^I extract the customer information from response$")
	public void iExtractCustInfoFromResponse() {
		boolean status = checkStatusCode();
		if(status){
			getSuccessScenario();
		}
		else{
			getFailureScenario();
		}
	}

	private boolean checkStatusCode() {
		boolean status = true;
		if(response.getStatusCode() == 200 || response.getStatusCode() == 201){
			return true;
		}
		else{
			return false;
		}
	}

	private void getFailureScenario() {
		String responseString = response.asString();
		JSONObject jsonObject = new JSONObject(responseString);
		String errorMessage = jsonObject.getString("message");
		System.out.println(errorMessage + " With Status code: "+ response.getStatusCode());
	}

	private void getSuccessScenario() {
		String responseString = response.asString();
		JSONObject jsonObject = new JSONObject(responseString);
		try {
			customer.setCompId(jsonObject.getString("compId"));
			customer.setCompName(jsonObject.getString("compName"));
			customer.setCompCountry(jsonObject.getString("compCountry"));
			
			JSONArray jsonArray = jsonObject.getJSONArray("views");
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject resultObject = jsonArray.getJSONObject(i);
				view.setViewId(resultObject.getInt("viewId"));
				view.setViewType(resultObject.getString("viewType"));
				view.setViewHdr(resultObject.getString("viewHdr"));
				view.setNoOfFields(resultObject.getInt("noOfFields"));
				view.setCollapsable(resultObject.getBoolean("collapsable"));
				view.setDraggable(resultObject.getBoolean("draggable"));
				views.add(view);
			}
			customer.setViews(views);
		}
		catch (JSONException exception) {
			String errorMessage = jsonObject.getString("message");
			System.out.println(errorMessage + "With Status code: "+ response.getStatusCode());
		}		
	}

	public void postCustInfo() {
		loadRequestUrlHeaders();
		request.body(BaseService.getPostBody());
		//request.body(baseService.getCustomerId()+".json");
		response = getResponse("COA.PostCustomerInfo");
		response.prettyPrint();
	}
	
	@Then("^I extract the response information$")
	public void iExtractResponseInfo() {
		checkStatusCode();
		String responseString = response.asString();
		JSONObject jsonObject = new JSONObject(responseString);
		String errorMessage = jsonObject.getString("message");
		System.out.println(errorMessage + " With Status code: "+ response.getStatusCode());
		
	}

	
	
}