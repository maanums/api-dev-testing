package com.coa.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.json.JSONException;

import com.coa.coacore.stepdefs.Services.APIServices.CoaService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class BaseService {

	private static Properties CONFIG = new Properties();
	private static String custId;
	private static int propertiesLoadedFlag = 0;
	private static String postBody;

	public static String getPostBody() {
		return postBody;
	}

	public static void setPostBody(String postBody) {
		BaseService.postBody = postBody;
	}

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
		CONFIG.load(new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/ServiceResource.properties"));
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
			
		case "COA.PostCustomerInfo":
			coaservice.postCustInfo();
			break;

		default:
			System.out.println("Incorrect DSL format");
			break;
		}
	}

	@Given("^I select the CustomerId as \"([^\"]*)\"$")
	public void iSelectCustId(String custId) {
		setCustId(custId);
	}
	 
	@Given("^I create customization for \"([^\"]*)\"$")
	public void iCreateCustomizationForCustomer(String customer) {
		
		try {
			postBody = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader()
					.getResource(customer+".json").toURI())));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	

}
