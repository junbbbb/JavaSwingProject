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

import com.javalec.base.CoffeeMain;
import com.javalec.base.Login1;
import com.javalec.base.OnePurchase;
import com.javalec.dto.DtoMain;
import com.javalec.dto.DtoMenu;
import com.javalec.dto.DtoPurchase;
import com.javalec.util.DBConnect;

public class DaoMain {

	// F	
		String custid;
		String custpw;
		String custname;
		String custnickname;
		
		public static String mname;
		public static int quantity = 1;
		public static int price;
		
		FileInputStream file;
		
		public static String menuid;
		public static int i;

		String sname;
		String menuname;
		String orderid;
		
		
		
		// C
		public DaoMain() {
			// TODO Auto-generated constructor stub
		}


		public DaoMain(String custid) {
			super();
			this.custid = custid;
		}

		
		public DaoMain(String custid, String sname, String menuname, String orderid) {
			super();
			this.custid = custid;
			this.sname = sname;
			this.menuname = menuname;
			this.orderid = orderid;
		}


		// M
		
		// 닉네임 가져오기
		public DtoMain getNicname() {
			
			DtoMain dto = null;
			
			String query = "select cnickname from customer ";
			String query1 = "where custid = '" + custid + "'";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
				ResultSet rs = stmt_mysql.executeQuery(query + query1);

				if (rs.next()) {
					String nickname = rs.getString(1);
					dto = new DtoMain(nickname); 
				}

				conn_mysql.close();

			} catch (Exception e) {
				e.printStackTrace(); 
			}
			
			return dto;
			
		}
		
		// DB에서 menuid 가져오기
		public ArrayList<String> selectRandomMenu() {
			
			ArrayList<String> menuId = new ArrayList<String>();
			String query = "select menuid from menu ";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
				ResultSet rs = stmt_mysql.executeQuery(query);

				while(rs.next()) {
					String randomMenu = rs.getString(1);
					menuId.add(randomMenu);
				}

				conn_mysql.close();

			} catch (Exception e) {
				e.printStackTrace(); 
			}
			
			return menuId;
			
		}
		
		// DB에서 menuid에 해당하는 정보 가져오기
		
		public DtoMenu selectMenuInfo() {

				DtoMenu dto = null;
				
				String query = "select menuname, menuprice, menuimage from menu ";
				String query1 = "where menuid = '" + menuid + "'";
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
					Statement stmt_mysql = conn_mysql.createStatement();
					ResultSet rs = stmt_mysql.executeQuery(query + query1);
		
					if(rs.next()) {
						String menuName = rs.getString(1);
						int menuPrice = Integer.parseInt(rs.getString(2));
						
						DBConnect.filename = DBConnect.filename + 1; //파일 이름
			        	File file = new File(Integer.toString(DBConnect.filename)); // 1번 파일 생성
			        	FileOutputStream output = new FileOutputStream(file);
			        	InputStream input = rs.getBinaryStream(3);
			            byte[] buffer = new byte[1024];
			            while (input.read(buffer) > 0) {
			                output.write(buffer);
			            }
						
						dto = new DtoMenu(menuName, menuPrice);
					}
		
					conn_mysql.close();
		
				} catch (Exception e) {
					e.printStackTrace(); 
				}
				
				return dto;
				
			}
		
		public void adverImage() {
			String query = "select adverimage from advertise ";
			String query1 = "where adverseq = " + i;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
				ResultSet rs = stmt_mysql.executeQuery(query + query1);
				

				if(rs.next()) {
					DBConnect.filename = DBConnect.filename + 1; //파일 이름
		        	File file = new File(Integer.toString(DBConnect.filename)); // 1번 파일 생성
		        	FileOutputStream output = new FileOutputStream(file);
		        	InputStream input = rs.getBinaryStream(1);
		            byte[] buffer = new byte[1024];
		            while (input.read(buffer) > 0) {
		                output.write(buffer);
		            }
					
				}

				conn_mysql.close();

			} catch (Exception e) {
				e.printStackTrace(); 
			}
		}
		
		public int countImage() {
			int count = 0;
			String query = "select count(*) from advertise ";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
				ResultSet rs = stmt_mysql.executeQuery(query);

				if(rs.next()) {
					count = Integer.parseInt(rs.getString(1));
				}

				conn_mysql.close();

			} catch (Exception e) {
				e.printStackTrace(); 
			}
			return count;
		}
		
		public DtoPurchase recommendMenu() {
			
			DtoPurchase dto = new DtoPurchase(mname, quantity, quantity*price);
			
			return dto;
		}
	
		public boolean insertAction() {
			PreparedStatement ps = null;
			String wkSname = "";
			String wkMname = "";
			String wkCtelno = "";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				// 연결
				Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
				
				String squery = "select storeseq from store "; // 인서트하는애임
				String squery1 = "where sname = '" + sname + "'";
				
				Statement stmt_mysql = conn_mysql.createStatement();
				ResultSet ss = stmt_mysql.executeQuery(squery + squery1);
				
				if(ss.next()) {
					wkSname = ss.getString(1);
				}
				
				String mquery = "select menuid from menu "; // 인서트하는애임
				String mquery1 = "where menuname = '" + menuname + "'";
				
				Statement mstmt_mysql = conn_mysql.createStatement();
				ResultSet ms = mstmt_mysql.executeQuery(mquery + mquery1);
				
				if(ms.next()) {
					wkMname = ms.getString(1);
				}
				
				String cquery = "select ctelno from customer "; // 인서트하는애임
				String cquery1 = "where custid = '" + Login1.id + "'";
				
				Statement cstmt_mysql = conn_mysql.createStatement();
				ResultSet cs = cstmt_mysql.executeQuery(cquery + cquery1);
				
				if(ms.next()) {
					wkCtelno = cs.getString(1);
				}
				
				String query = "insert into orders (store_storeseq, menu_menuid, customer_custid, customer_ctelno, orderid, oquantity, odate ) "; // 인서트하는애임
				String query1 = "values (?, ?, ?, ?, ?, ?, curdate()) ";

				ps = conn_mysql.prepareStatement(query + query1);
				ps.setString(1, wkSname);
				ps.setString(2, wkMname);
				ps.setString(3, Login1.id);
				ps.setString(4, wkCtelno);
				ps.setString(5, orderid);
				ps.setInt(6, quantity);

				ps.executeUpdate(); // 실행하기

				conn_mysql.close(); // 클로즈하기 내가쓰고 클로즈해야 다른사람도 들어간다.

				// JOptionPane.showMessageDialog(null, tfName.getText() + "님의 정보가 입력되었습니다.");

			} catch (Exception e) {
				e.printStackTrace(); // 개발할떈 이렇게 쓰지만 나중엔 메세지로 잠시만 기다려주세요 등 쓰면됨.
				return false;
			}
			return true;
		}
		
		
} // End
