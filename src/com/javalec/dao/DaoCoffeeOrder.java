package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import com.javalec.dto.DtoOrder;
import com.javalec.util.DBConnect;

	public class DaoCoffeeOrder {
		// F
		int Storeseq;
		String sname;
		String saddress;
		String stelno;
		String scrn;
		String sopendate;
		String sclosedate;
		public static int count;
		
		String conname; 
		String condata;
		
		
	
		// C
		public DaoCoffeeOrder() {
			// TODO Auto-generated constructor stub
		}
	
		
		public DaoCoffeeOrder(String conname, String condata) {
			super();
			this.conname = conname;
			this.condata = condata;
		}
	
		// M
	
		// 지점리스트 가져오기
		public DefaultListModel<String> storeList(){
			
			DefaultListModel<String> storeName = new DefaultListModel<String>();
			String query = "select sname from store ";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
				ResultSet rs = stmt_mysql.executeQuery(query);
	
				while(rs.next()) {
					String randomMenu = rs.getString(1);
					storeName.addElement(randomMenu);
				}
	
				conn_mysql.close();
	
			} catch (Exception e) {
				e.printStackTrace(); 
			}
			
			return storeName;
			
		}
	
		public ArrayList<DtoOrder> selectList(){
			
			ArrayList<DtoOrder> BeanList = new ArrayList<DtoOrder>();
			
			String WhereDefault = "select storeseq, sname from store ";
			
	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
	            Statement stmt_mysql = conn_mysql.createStatement();
	            ResultSet rs = stmt_mysql.executeQuery(WhereDefault);
	
	            while(rs.next()){
	            	
	            	int wkSeq = rs.getInt(1);
	            	String wkName = rs.getString(2);
	            	
	            	DtoOrder dto = new DtoOrder(wkSeq, wkName);
	            	BeanList.add(dto);
	            }
	            
	            conn_mysql.close();
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
			return BeanList;
		}
		
		public int countStore() {
			String query = "select count(*) from store ";
			
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
		
	public ArrayList<String> conditionList(){ 
			
			ArrayList<String>storeName = new ArrayList<String>();
			
			String whereStatement = "select sname from store ";
			String whereStatement2 = "where "+ conname + " like '%" + condata + "%'";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
	
				Statement stmt_mysql = conn_mysql.createStatement();
	
				ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);
	
				// while은 false 하면 끝나버림
				while (rs.next()) {
					storeName.add(rs.getString(1));
				}
	
				conn_mysql.close(); // 클로즈하기 내가쓰고 클로즈해야 다른사람도 들어간다.
	
			} catch (Exception e) {
				e.printStackTrace(); // 개발할떈 이렇게 쓰지만 나중엔 메세지로 잠시만 기다려주세요 등 쓰면됨.
			}
			return storeName;
		}

	
	


}
