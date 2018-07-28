package com.mock.coa.model;

public class View {
	private int viewId;
	private String viewType;
	private String viewHdr;
	private int noOfFields;
	private boolean draggable;
	private boolean collapsable;

	public int getViewId() {
		return viewId;
	}

	public void setViewId(int viewId) {
		this.viewId = viewId;
	}

	public String getViewType() {
		return viewType;
	}

	public void setViewType(String viewType) {
		this.viewType = viewType;
	}

	public String getViewHdr() {
		return viewHdr;
	}

	public void setViewHdr(String viewHdr) {
		this.viewHdr = viewHdr;
	}

	public boolean isDraggable() {
		return draggable;
	}

	public void setDraggable(boolean draggable) {
		this.draggable = draggable;
	}

	public boolean isCollapsable() {
		return collapsable;
	}

	public void setCollapsable(boolean collapsable) {
		this.collapsable = collapsable;
	}

	public int getNoOfFields() {
		return noOfFields;
	}

	public void setNoOfFields(int noOfFields) {
		this.noOfFields = noOfFields;
	}
}
