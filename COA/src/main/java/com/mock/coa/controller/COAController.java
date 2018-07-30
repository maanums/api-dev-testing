package com.mock.coa.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
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
import com.mock.coa.model.Views;

@RestController
@RequestMapping("/coa")
public class COAController {

	@PostMapping(value = "/customers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveCustomerInfo(
			@RequestBody @Valid Customer custInfo) {
		String response = "{\"message\":\"Saved successfully\"}";
		return new ResponseEntity<String>(response, HttpStatus.CREATED);

	}

	@GetMapping(value = "/customers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getCustomerInfo(@PathVariable("id") String custId) {
		String response = "";
		try {

			if (custId.equals("03_Test_401")) {
				response = "{\"message\":\"You do not have access\"}";
				return new ResponseEntity<String>(response,
						HttpStatus.UNAUTHORIZED);
			} else if (custId.equals("04_Test_500")) {
				response = "{\"message\":\"Oops! Something went wrong\"}";
				return new ResponseEntity<String>(response,
						HttpStatus.INTERNAL_SERVER_ERROR);
			}

			response = StreamUtils.copyToString(new ClassPathResource(custId
					+ ".json").getInputStream(), Charset.defaultCharset());

		} catch (IOException e) {
			e.printStackTrace();
			String returnMsg = "{\"message\":\"Company not found\"}";
			return new ResponseEntity<String>(returnMsg, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

}
