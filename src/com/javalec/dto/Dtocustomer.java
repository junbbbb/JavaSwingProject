package com.javalec.dto;

public class Dtocustomer {
	
	// Field
	String custid;
	String ctelno;
	String cname;
	String cnickname;
	String caddress;
	String cquestion;
	String canswer;
	String cemail;
	String cindate;
	String coutdate;
	String cupdatedate;
	int membership;
	String custpw;
	String cimage;
	
	
	// Constructor
	
	public Dtocustomer() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Dtocustomer(String custid, String custpw, String cname, String ctelno, String caddress, String cemail,
			String cnickname, String cquestion, String canswer) {
		super();
		this.custid = custid;
		this.custpw = custpw;
		this.cname = cname;
		this.ctelno = ctelno;
		this.caddress = caddress;
		this.cemail = cemail;
		this.cnickname = cnickname;
		this.cquestion = cquestion;
		this.canswer = canswer;
	}
	



	// Method
	


	public String getCustid() {
		return custid;
	}


	public void setCustid(String custid) {
		this.custid = custid;
	}


	public String getCtelno() {
		return ctelno;
	}


	public void setCtelno(String ctelno) {
		this.ctelno = ctelno;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getCnickname() {
		return cnickname;
	}


	public void setCnickname(String cnickname) {
		this.cnickname = cnickname;
	}


	public String getCaddress() {
		return caddress;
	}


	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}


	public String getCquestion() {
		return cquestion;
	}


	public void setCquestion(String cquestion) {
		this.cquestion = cquestion;
	}


	public String getCanswer() {
		return canswer;
	}


	public void setCanswer(String canswer) {
		this.canswer = canswer;
	}


	public String getCemail() {
		return cemail;
	}


	public void setCemail(String cemail) {
		this.cemail = cemail;
	}


	public String getCindate() {
		return cindate;
	}


	public void setCindate(String cindate) {
		this.cindate = cindate;
	}


	public String getCoutdate() {
		return coutdate;
	}


	public void setCoutdate(String coutdate) {
		this.coutdate = coutdate;
	}


	public String getCupdatedate() {
		return cupdatedate;
	}


	public void setCupdatedate(String cupdatedate) {
		this.cupdatedate = cupdatedate;
	}


	public int getMembership() {
		return membership;
	}


	public void setMembership(int membership) {
		this.membership = membership;
	}


	public String getCustpw() {
		return custpw;
	}


	public void setCustpw(String custpw) {
		this.custpw = custpw;
	}

	public String getCimage() {
		return cimage;
	}

	public void setCimage(String cimage) {
		this.cimage = cimage;
	}




}
