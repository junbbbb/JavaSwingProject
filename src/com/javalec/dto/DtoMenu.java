package com.javalec.dto;

public class DtoMenu {

	// F
	String menuid;
	String menuname;
	int menuprice;
	String menuimage;
	
	
	// C
	public DtoMenu() {
		// TODO Auto-generated constructor stub
	}

	
	
	public DtoMenu(String menuname, int menuprice) {
		super();
		this.menuname = menuname;
		this.menuprice = menuprice;
	}



	// M
	public String getMenuid() {
		return menuid;
	}


	public void setMenuid(String menuid) {
		this.menuid = menuid;
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


	public String getMenuimage() {
		return menuimage;
	}


	public void setMenuimage(String menuimage) {
		this.menuimage = menuimage;
	}
	
	
}
