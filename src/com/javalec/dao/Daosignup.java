package com.javalec.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.util.DBConnect;

public class Daosignup {
	// Field
	String custid;
	String ctelno;
	String cname;
	String custpw;
	String cnickname;	
	String caddress;
	String cquestion;
	String canswer;
	String cemail;
	String cindate;
	FileInputStream cimage;

	
	
	
	// Constructor
	public Daosignup() {
		// TODO Auto-generated constructor stub
	}
	
	// ID check
	public Daosignup(String custid) {
		super();
		this.custid = custid;
	}
	
	public Daosignup(String custid, String ctelno, String cname, String custpw, String cnickname, String caddress,
			String cquestion, String canswer, String cemail, String cindate, FileInputStream cimage) {
		super();
		this.custid = custid;
		this.ctelno = ctelno;
		this.cname = cname;
		this.custpw = custpw;
		this.cnickname = cnickname;
		this.caddress = caddress;
		this.cquestion = cquestion;
		this.canswer = canswer;
		this.cemail = cemail;
		this.cindate = cindate;
		this.cimage = cimage;
	}
	
	public Daosignup(String custid, String ctelno, String cname, String custpw, String cnickname, String caddress,
			String cquestion, String canswer, String cemail, FileInputStream cimage) {
		super();
		this.custid = custid;
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
	
	// Method



	// ID check
	public int idDuplicatedCheck(){
		int check =0;

		// 워크벤치 작성할 것 DB 연결하여 여기서 적용할 수 있도록 함
		String query = "select count(*) from customer "; // sql에서는 띄우고 하기때문에 한줄 끝나면 꼭 스페이스바 하나 넣어줘야한다 !!
		String query1 = "where custid = '" + custid + "'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// class선언자
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); // 검색할때 쓴다 미리 만들어놓음
			ResultSet rs = stmt_mysql.executeQuery(query + query1);// 워크벤치로 치면 알트앤터쳐서 표시된상태

			while (rs.next()) { // SQL문을 통해 얻은 데이터에서 첫번째행에서 마지막 행까지 추출할때나 행이 있는지 없는지 판단할때 주로 while문을 통해
								// rs.next()가 사용된다. # rs.next : 첫번째 행 의미(next() 메소드 사용하기 위해서)
				check = rs.getInt(1);
			}

			//
			// 끝나면 연결끊어줘야한다 동시접속 5명이제한이기때문에 ..꼭
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();

			// 리턴은 여기서 끝 밑에것 실행안함
		}
		return check;

	}
	
	
	// Insert Action
	public boolean insertAction() {
		PreparedStatement ps = null;
		
		try {
			// DB 연결
			Class.forName("com.mysql.cj.jdbc.Driver");  // 객체 생성(내 드라이버에 연결한다) -> 생성된 객체 드라이브매니저에 등록 -> 커넥션 활성화(만드는)하는 객체 # 그냥 복붙해서 사용하기
		
			// class선언자(통로 생성하고 연결)
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);  // DriverManager.getConnection() 메소드로 Connection 객체(DB 연결하는 객체) 생성 -> DriverManager.getConnection은 매개변수(url_mysql,id_mysql,pw_mysql) 가짐
			Statement stmt_mysql = conn_mysql.createStatement(); // createStatement() 메소드에 sql 전달하여 Statement(sql 실행하고 결과 반환하는 기능을 하는 캡슐화된 인터페이스 객체 생성   (객체 이름이 달라서 내용도 달라지니 https://cobook.tistory.com/6 확인하고 지금은 저렇게 대충 흐름만 알고 있기)  # 검색할때 쓴다 미리 만들어놓음
			
			// 실행할 sql 작성 및 sql 실행
			String query = "insert into customer (custid, ctelno, cname, cnickname, caddress, cquestion, canswer, cemail, cimage, custpw, cindate) ";  // sql에서는 띄우고 하기때문에 한줄 끝나면 꼭 스페이스바 하나 넣어줘야한다 !!
			String query1 = "values (?,?,?,?,?,?,?,?,?,?,curdate())";
			
			ps = conn_mysql.prepareStatement(query+query1);
			ps.setString(1, custid);// setString 메소드로 ?값 넣어주기 (첫번쨰물음표에넣는다)
			ps.setString(2, ctelno);
			ps.setString(3, cname);
			ps.setString(4, cnickname);
			ps.setString(5, caddress);
			ps.setString(6, cquestion);
			ps.setString(7, canswer);
			ps.setString(8, cemail);
			ps.setBinaryStream(9, cimage);
			ps.setString(10, custpw);
			
			
			//실행
			ps.executeUpdate(); // executeUpdate 메소드로 sql 쿼리 실행 후 결과값 저장 (select, insert 따라 값 가져오는 방법 다르므로 위 링크 참고)  # 1값을 반환한다,, 중복값체크도 해야한다.
			
			//
			// 통로 닫아주기(통로 열었던 순서 역순으로 닫기, 닫아야 할 자원 null값일 경우 에러 생기므로 if문으로 조건 걸기 - 위 링크 참고)  # 끝나면 연결끊어줘야한다 동시접속 5명이제한이기때문에 ..꼭
			conn_mysql.close();
			
			
			
		}catch(Exception e) {  // 예외처리
			e.printStackTrace();
			return false;//리턴은 여기서 끝 밑에것 실행안함
		}
		return true;
		
	}
	
	
	
	
	
	
	
	
	
} //End
