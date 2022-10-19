package com.javalec.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.javalec.base.Login1;
import com.javalec.dto.Dtocustomer;
import com.javalec.util.DBConnect;

public class Daomypage {
	
	// Field 
	String custid;
	public static String ctelno;
	String cname;
	String custpw;
	String cnickname;	
	String caddress;
	String cquestion;
	String canswer;
	String cemail;
	String cindate;
	FileInputStream cimage;
	String cupdatedate;
	
	// Constructor
	public Daomypage() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public Daomypage(String custpw, String cname, String ctelno, String caddress, String cemail, String cnickname,
			String cquestion, String canswer, FileInputStream cimage) {
		super();
		this.ctelno = ctelno;
		this.cname = cname;
		this.custpw = custpw;
		this.cnickname = cnickname;
		this.caddress = caddress;
		this.cquestion = cquestion;
		this.canswer = canswer;
		this.cemail = cemail;
		this.cimage = cimage;
	}
	
	public Daomypage(String custpw, String cname, String ctelno, String caddress, String cemail, String cnickname,
			String cquestion, String canswer) {
		super();
		this.ctelno = ctelno;
		this.cname = cname;
		this.custpw = custpw;
		this.cnickname = cnickname;
		this.caddress = caddress;
		this.cquestion = cquestion;
		this.canswer = canswer;
		this.cemail = cemail;
	}





	// Method
	
	   public Dtocustomer selectList() {
		   Dtocustomer dtolist = null;
	      // sql문 선언
	      String whereStatement = "select custid, custpw, cname, ctelno, caddress, cemail, cnickname, cquestion, canswer, cimage from customer "; // DB에서 정보 불러오기
	      String whereStatement2 = "where custid = '" + Login1.id + "'"; // 
	      
	      // sql문 실행
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
	               DBConnect.pw_mysql); // sql에 접속
	         Statement stmt_mysql = conn_mysql.createStatement();

	         ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);
	         // ResultSet = db의 result set 데이터 테이블. 최초 커서는 첫 행에 위치됨

	         while (rs.next()) {

	            String wkCustId = rs.getString(1);
	            String wkCustpw = rs.getString(2);
	            String wkCname = rs.getString(3);
	            String wkCtelno = rs.getString(4);
	            String wkCaddress = rs.getString(5);
	            String wkCemail = rs.getString(6);
	            String wkCnickname = rs.getString(7);
	            String wkCquestion = rs.getString(8);
	            String wkCanswer = rs.getString(9);
//            	String wkFilename = rs.getString(10);
            	
            	// File
            	DBConnect.filename= DBConnect.filename + 1;
            	File file = new File(Integer.toString(DBConnect.filename));
            	FileOutputStream output = new FileOutputStream(file);
            	InputStream input = rs.getBinaryStream(10);
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }
            	

	            dtolist = new Dtocustomer(wkCustId, wkCustpw, wkCname, wkCtelno, wkCaddress, wkCemail, wkCnickname, wkCquestion, wkCanswer );

//	            dtoList.add(dto);
	         }
	         conn_mysql.close();

	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	      return dtolist;
	   }
	
	   // Update Action
		// 수정 (이미지를 변경했을때)
		public boolean UpdateAction() {
			  PreparedStatement ps = null;
			  try{
			      Class.forName("com.mysql.cj.jdbc.Driver");
			      Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			      @SuppressWarnings("unused")
					Statement stmt_mysql = conn_mysql.createStatement();
			
			      String A = "update customer set custpw = ?, cname = ?, ctelno = ?, caddress = ?, cemail = ?, cnickname = ?, cquestion = ?, canswer =?, cimage = ? , cupdatedate = curdate() ";
			      String B = " where custid = '" + Login1.id + "'"; 
			
			      ps = conn_mysql.prepareStatement(A+B);
			      
			      ps.setString(1, custpw);
			      ps.setString(2, cname);
			      ps.setString(3, ctelno);
			      ps.setString(4, caddress);
			      ps.setString(5, cemail);
			      ps.setString(6, cnickname);
			      ps.setString(7, cquestion);
			      ps.setString(8, canswer);
			      ps.setBinaryStream(9, cimage);
			      ps.executeUpdate();
			
			      conn_mysql.close();
			  } catch (Exception e){
			      e.printStackTrace();
			      return false;
			  }
			
			  return true;
		}
		// 수정 (이미지를 변경하지 않았을)
		public boolean UpdateActionnoimage() {
			PreparedStatement ps = null;
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
				@SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
				
				String A = "update customer set custpw = ?, cname = ?, ctelno = ?, caddress = ?, cemail = ?, cnickname = ?, cquestion = ?, canswer =?,  cupdatedate = curdate() ";
				String B = " where custid = '" + Login1.id + "'"; 
				
				ps = conn_mysql.prepareStatement(A+B);
				
				ps.setString(1, custpw);
				ps.setString(2, cname);
				ps.setString(3, ctelno);
				ps.setString(4, caddress);
				ps.setString(5, cemail);
				ps.setString(6, cnickname);
				ps.setString(7, cquestion);
				ps.setString(8, canswer);
				ps.executeUpdate();
				
				conn_mysql.close();
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
			
			return true;
		}
	
		public boolean deleteAction() {
			PreparedStatement ps = null; // sql 코드 에러 등
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
						DBConnect.pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();

				String query = "update customer set coutdate = curdate() "; // 끝에 띄어쓰기
				// 중요, sql
				// 에러걸
				String query2 = "where custid ='" + Login1.id + "'"; // 물음표 순대로 1,2... 밑에 ps.setint에 적용
				ps = conn_mysql.prepareStatement(query + query2); // 나누는 이유: 길어서

				ps.executeUpdate(); // 실행, 1이면 정상

				conn_mysql.close();

			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
	
	
	
	
	

} // END
