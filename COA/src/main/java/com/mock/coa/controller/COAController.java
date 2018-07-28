package com.mock.coa.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseCookie.ResponseCookieBuilder;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mock.coa.model.Customer;
import com.mock.coa.model.View;

@RestController
@RequestMapping("/coa")
public class COAController {

	@PostMapping(value = "/customers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveCustomerInfo(@RequestBody Customer custInfo) {
		String response = "{\"message\":\"Saved successfully\"}";
		return new ResponseEntity<String>(response, HttpStatus.CREATED);
	}

	@GetMapping(value = "/customers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getCustomerInfo(@PathVariable("id") String custId) {
		String response = "";
		try {
			response = StreamUtils.copyToString(new ClassPathResource(custId + ".json").getInputStream(),
					Charset.defaultCharset());

		} catch (IOException e) {
			e.printStackTrace();
			String returnMsg = "{\"message\":\"Company not found\"}";
			return new ResponseEntity<String>(returnMsg, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/getJSON", produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer getJSON(@PathVariable("id") String custId) {
		Customer cust = new Customer();
		View view1 = new View();
		view1.setViewId(1);
		view1.setViewHdr("MainHdr");
		view1.setViewType("Main View");
		view1.setNoOfFields(2);
		view1.setCollapsable(true);
		view1.setDraggable(false);
		View view2 = new View();
		view2.setViewId(2);
		view2.setViewHdr("SubHdr");
		view2.setViewType("Sub View");
		view2.setNoOfFields(3);
		view2.setCollapsable(false);
		view2.setDraggable(true);
		List<View> totviews = new ArrayList<View>();
		totviews.add(view1);
		totviews.add(view2);
		cust.setCompId("1");
		cust.setCompName("Zycus");
		cust.setCompCountry("India");
		cust.setViews(totviews);
		return cust;
	}

}
