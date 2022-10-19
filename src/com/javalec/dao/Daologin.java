package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.util.DBConnect;

public class Daologin {
	
	// Field
	String custid;
	String custpw;
	String cindate;
	String coutdate;
	
	
	
	// Constructor
	public Daologin() {
		// TODO Auto-generated constructor stub
	}



	public Daologin(String custid, String custpw) {
		super();
		this.custid = custid;
		this.custpw = custpw;
	}

	
	
	
	
	
	// Method
	
		// Id Pw Check
	   public int customerCheck() {
		      PreparedStatement ps = null;
		      int check=0;
		      
		       String whereStatement = "select count(*) from customer where custid='"+custid+"' and custpw='"+custpw+"' and coutdate is null ";
		         try {
		             Class.forName("com.mysql.cj.jdbc.Driver");
		             // 연결
		             Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
		             // 데이터베이스에 접근을 하겠다 선언한것이다.

		             // 입력할떄 필요없음 검색할떄 필요함
		             Statement stmt_mysql = conn_mysql.createStatement();

		             ResultSet rs = stmt_mysql.executeQuery(whereStatement);
		             
		              while (rs.next()) {
		                 check = rs.getInt(1);
		                  
		              }
		              
		              conn_mysql.close();

		          } catch (Exception e) {
		             e.printStackTrace(); // 개발할떈 이렇게 쓰지만 나중엔 메세지로 잠시만 기다려주세요 등 쓰면됨.
		          }
		         return check;
		   }
	   
	   
	   // 탈퇴된 회원 로그인 방지
	   public int customerCheck1() {
		      PreparedStatement ps = null;
		      int check1=0;
		      
		       String whereStatement = "select count(*) from customer ";
		       String whereStatement2 ="where custid='"+custid+"' and coutdate is not null " ;
		      
		         try {
		             Class.forName("com.mysql.cj.jdbc.Driver");
		             // 연결
		             Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
		             // 데이터베이스에 접근을 하겠다 선언한것이다.

		             // 입력할떄 필요없음 검색할떄 필요함
		             Statement stmt_mysql = conn_mysql.createStatement();

		             ResultSet rs = stmt_mysql.executeQuery(whereStatement+whereStatement2);
		             
		              while (rs.next()) {
		                 check1 = rs.getInt(1);
		                  
		                  
		              }
		              
		              conn_mysql.close();


		          } catch (Exception e) {
		             e.printStackTrace(); // 개발할떈 이렇게 쓰지만 나중엔 메세지로 잠시만 기다려주세요 등 쓰면됨.
		          }
		         return check1;
		   }
	
	
} //END
