package com.javalec.dto;

public class DtoPurchase {
	
	// F
	String menuname;
	int menuquantity;
	int totalprice;
	
	// C
	private void DtoPurchase() {
		// TODO Auto-generated method stub

	}
	
	public DtoPurchase(String menuname, int menuquantity, int totalprice) {
		super();
		this.menuname = menuname;
		this.menuquantity = menuquantity;
		this.totalprice = totalprice;
	}

	// M
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
	
	
	
	
	
	
} // End
