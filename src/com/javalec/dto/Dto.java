package com.javalec.dto;

public class Dto {
	int seq;
	String menuname;
	int menuprice;
	String filename;
	
	public Dto() {
		// TODO Auto-generated constructor stub
	}

	public Dto(String menuname, String filename) {
		super();
		this.menuname = menuname;
		this.filename = filename;
	}

	public Dto(String menuname, int menuprice, String filename) {
		super();
		this.menuname = menuname;
		this.menuprice = menuprice;
		this.filename = filename;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public int getMenuprice() {
		return menuprice;
	}

	public void setMenuprice(int menuprice) {
		this.menuprice = menuprice;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	
	

}
