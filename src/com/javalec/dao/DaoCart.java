package com.javalec.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.base.Login1;
import com.javalec.dto.Dto;
import com.javalec.dto.DtoCart;
import com.javalec.dto.DtoPurchase;
import com.javalec.util.DBConnect;

public class DaoCart {
	
	public DaoCart() {
		// TODO Auto-generated constructor stub
	}

	
	// 검색 결과를 Table로 
		public ArrayList<DtoCart> SelectList(){
			
			ArrayList<DtoCart> BeanList = new ArrayList<DtoCart>();
			
			String WhereDefault1 = "select  menuname, menufilename, menuimage, sum(cartquantity) ,sum(menuprice*cartquantity) from menu, cart ";
			String WhereDefault2 = "where menuid = menu_menuid and customer_custid = '"+Login1.id+"' ";
			String WhereDefault3 = "group by menu_menuid";
			//order by 할필요없는게 seqno순번대로 뽑아준다...
			//1 대신 Login.id, 시간차정렬하
			
	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql,DBConnect.id_mysql,DBConnect.pw_mysql);
	            Statement stmt_mysql = conn_mysql.createStatement();

	            ResultSet rs = stmt_mysql.executeQuery(WhereDefault1+ WhereDefault2+WhereDefault3);

	            while(rs.next()){
	            	
	            	
	            	String wkMenuname = rs.getString(1);
	            	String wkFilename = rs.getString(2);
	            	int wkCartquantity = rs.getInt(4);
	            	int wkTotalPrice = rs.getInt(5);
	            	
	            	// File
	            	File file = new File("./" + wkFilename);
	            	FileOutputStream output = new FileOutputStream(file);
	            	InputStream input = rs.getBinaryStream(3);
	                byte[] buffer = new byte[1024];
	                while (input.read(buffer) > 0) {
	                    output.write(buffer);
	                }
	            	
	            	DtoCart dto = new DtoCart(wkMenuname, wkFilename ,wkCartquantity, wkTotalPrice);
	            	BeanList.add(dto);
	            	
	            	
	            }
	            
	            conn_mysql.close();
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
			return BeanList;
		}
	
		
public ArrayList<DtoPurchase> PurchaseSelectList(){
			
			ArrayList<DtoPurchase> BeanList = new ArrayList<DtoPurchase>();
			
			String WhereDefault1 = "select  menuname, sum(cartquantity), sum(menuprice*cartquantity) from menu, cart ";
			String WhereDefault2 = "where menuid = menu_menuid and customer_custid = '"+Login1.id+"' ";
			String WhereDefault3 = "group by menuname";
			//order by 할필요없는게 seqno순번대로 뽑아준다...
			//1 대신 Login.id, 시간차정렬하
			
			
	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql,DBConnect.id_mysql,DBConnect.pw_mysql);
	            Statement stmt_mysql = conn_mysql.createStatement();

	            ResultSet rs = stmt_mysql.executeQuery(WhereDefault1+ WhereDefault2+WhereDefault3);

	            while(rs.next()){
	            	
	            	
	            	String wkMenuname = rs.getString(1);
	            	
	            	int wkCartquantity = rs.getInt(2);
	            	int wkTotalPrice = rs.getInt(3);
	            	// File
	            	
	            	
	            	DtoPurchase dtopurchase = new DtoPurchase(wkMenuname, wkCartquantity ,wkTotalPrice);
	            	BeanList.add(dtopurchase);
	            }
	            
	            conn_mysql.close();
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
			return BeanList;
		}
	
	
}//End
