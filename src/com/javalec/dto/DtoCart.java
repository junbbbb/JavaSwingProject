package com.javalec.dto;

public class DtoCart {
	String menuname;
	String filename;
	int cartquantity;
	int totalprice;
	
	
	public DtoCart(String menuname, String filename, int cartquantity, int totalprice) {
		super();
		this.menuname = menuname;
		this.filename = filename;
		this.cartquantity = cartquantity;
		this.totalprice = totalprice;
	}


	public String getMenuname() {
		return menuname;
	}


	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	public int getCartquantity() {
		return cartquantity;
	}


	public void setCartquantity(int cartquantity) {
		this.cartquantity = cartquantity;
	}


	public int getTotalprice() {
		return totalprice;
	}


	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	
	
	

}
