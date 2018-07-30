package com.mock.coa.model;

import java.util.List;

import javax.validation.constraints.NotNull;

public class Customer {

	@NotNull
	private String compId;
	private String compCountry;
	private String compName;
	private List<Views> views;

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCompId() {
		return compId;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	public String getCompCountry() {
		return compCountry;
	}

	public void setCompCountry(String compCountry) {
		this.compCountry = compCountry;
	}

	public List<Views> getViews() {
		return views;
	}

	public void setViews(List<Views> views) {
		this.views = views;
	}

	
}
