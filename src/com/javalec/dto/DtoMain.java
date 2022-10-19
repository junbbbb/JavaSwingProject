package com.javalec.dto;

public class DtoMain {

	// F
	String custid;
	String custpw;
	String custname;
	String custtelno;
	String custaddress;
	String custemail;
	String custnickname;
	int count;
	
	String menuname;
	int quantity;
	int totalprice;
	
	// C
	public DtoMain() {
		// TODO Auto-generated constructor stub
	}

	public DtoMain(String custnickname) {
		super();
		this.custnickname = custnickname;
	}

	public DtoMain(String menuname, int quantity, int totalprice) {
		super();
		this.menuname = menuname;
		this.quantity = quantity;
		this.totalprice = totalprice;
	}

	// M

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getCustpw() {
		return custpw;
	}

	public void setCustpw(String custpw) {
		this.custpw = custpw;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getCusttelno() {
		return custtelno;
	}

	public void setCusttelno(String custtelno) {
		this.custtelno = custtelno;
	}

	public String getCustaddress() {
		return custaddress;
	}

	public void setCustaddress(String custaddress) {
		this.custaddress = custaddress;
	}

	public String getCustemail() {
		return custemail;
	}

	public void setCustemail(String custemail) {
		this.custemail = custemail;
	}

	public String getCustnickname() {
		return custnickname;
	}

	public void setCustnickname(String custnickname) {
		this.custnickname = custnickname;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	


	
	
	
}
