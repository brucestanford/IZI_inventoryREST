package com.IZI.rest;






public class Feed {


	
	int Feed_ID;
	String Feed_Name;
	String Description;
	int Quantity_Left;
	int Reorder_Quanty;
	int OnReorder;
	String note;
	public int getFeed_ID() {
		return Feed_ID;
	}
	public void setFeed_ID(int feed_ID) {
		Feed_ID = feed_ID;
	}
	public String getFeed_Name() {
		return Feed_Name;
	}
	public void setFeed_Name(String feed_Name) {
		Feed_Name = feed_Name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getQuantity_Left() {
		return Quantity_Left;
	}
	public void setQuantity_Left(int quantity_Left) {
		Quantity_Left = quantity_Left;
	}
	public int getReorder_Quanty() {
		return Reorder_Quanty;
	}
	public void setReorder_Quanty(int reorder_Quanty) {
		Reorder_Quanty = reorder_Quanty;
	}
	public int getOnReorder() {
		return OnReorder;
	}
	public void setOnReorder(int onReorder) {
		OnReorder = onReorder;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	
	

}
