package com.javalec.dto;

public class DtoPurchaseA {
	String menuname;
	int menuquantity;
	int totalprice;
	
	public DtoPurchaseA() {
		// TODO Auto-generated constructor stub
	}

	public DtoPurchaseA(String menuname, int menuquantity, int totalprice) {
		super();
		this.menuname = menuname;
		this.menuquantity = menuquantity;
		this.totalprice = totalprice;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public int getMenuquantity() {
		return menuquantity;
	}

	public void setMenuquantity(int menuquantity) {
		this.menuquantity = menuquantity;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	
	
	
	

}
