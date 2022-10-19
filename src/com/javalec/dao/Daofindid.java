package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.util.DBConnect;

public class Daofindid {

	
	// Field
	String cname;
	String ctelno;
	String cemail;
	
	// Constructor
	public Daofindid() {
		// TODO Auto-generated constructor stub
	}

	public Daofindid(String cname, String cemail) {
		super();
		this.cname = cname;
		this.cemail = cemail;
	}

	
	
	
	// Method
	
	// ID Search
	public String findId() {
		PreparedStatement ps = null;
		String findCId = "";
		
		 String whereStatement = "select custid from customer ";
		 String whereStatement2 ="where cname='"+ cname + "'" ;
		 String whereStatement3 =" and cemail ='"+ cemail + "'";
	      try {
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          // 연결
	          Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
	          // 데이터베이스에 접근을 하겠다 선언한것이다.

	          // 입력할떄 필요없음 검색할떄 필요함
	          Statement stmt_mysql = conn_mysql.createStatement();

	          ResultSet rs = stmt_mysql.executeQuery(whereStatement+whereStatement2+whereStatement3);
	          
	           while (rs.next()) {
	        	   findCId = rs.getString(1);
	           }
	           
	           conn_mysql.close();


	       } catch (Exception e) {
	          e.printStackTrace(); // 개발할떈 이렇게 쓰지만 나중엔 메세지로 잠시만 기다려주세요 등 쓰면됨.
	       }
	      return findCId;
	}
	
	
	
} //END
