package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.util.DBConnect;

public class Daofindpw {
	
	// Field
	String custid;
	String cquestion;
	String canswer;
	
	// Constructor
	public Daofindpw() {
		// TODO Auto-generated constructor stub
	}

	public Daofindpw(String custid, String cquestion, String canswer) {
		super();
		this.custid = custid;
		this.cquestion = cquestion;
		this.canswer = canswer;
	}
	
	
	// Method
	


	//  Password Find
	public String findPw() {
		PreparedStatement ps = null;
		String findCPw = "";
		
		 String whereStatement = "select custpw from customer ";
		 String whereStatement2 ="where custid='"+ custid + "'";
		 String whereStatement3 =" and cquestion ='"+ cquestion + "'";
		 String whereStatement4 =" and canswer ='"+ canswer + "'";
	      try {
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          // 연결
	          Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
	          // 데이터베이스에 접근을 하겠다 선언한것이다.

	          // 입력할떄 필요없음 검색할떄 필요함
	          Statement stmt_mysql = conn_mysql.createStatement();

	          ResultSet rs = stmt_mysql.executeQuery(whereStatement+whereStatement2+whereStatement3+whereStatement4);
	          
	           while (rs.next()) {
	        	   findCPw = rs.getString(1);
	           }
	           
	           conn_mysql.close();


	       } catch (Exception e) {
	          e.printStackTrace(); // 개발할떈 이렇게 쓰지만 나중엔 메세지로 잠시만 기다려주세요 등 쓰면됨.
	       }
	      return findCPw;
	}
	
	
	
	
	

} //END
