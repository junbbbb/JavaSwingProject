package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.javalec.base.CoffeeOrder;
import com.javalec.base.MenuList;
import com.javalec.util.DBConnect;


public class DaoOrder {
	int menuquantity;
	
	
	
	
	
	public DaoOrder() {
		// TODO Auto-generated constructor stub
	}

	
	
	public DaoOrder(int menuquantity) {
		super();
		this.menuquantity = menuquantity;
	}



	public boolean insertCartAction() {
		PreparedStatement ps = null;
	      try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql,DBConnect.id_mysql,DBConnect.pw_mysql);
	          @SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
	
	          String A = "insert into cart (cartdate, cartquantity, customer_custid, menu_menuid, store_sname";
	          String B = ") value (curdate(),?, '1', (select menuid from menu where menuname = '"+MenuList.tkName+"'), ? )";
	          
	          //1 대신에 Login.id넣
	
	          ps = conn_mysql.prepareStatement(A+B);
	          
	          ps.setInt(1, menuquantity);
	          ps.setString(2, CoffeeOrder.tkStoreName);
	          
	         
	          
	          ps.executeUpdate();
	
	          conn_mysql.close();
	      } catch (Exception e){
	          e.printStackTrace();
	          return false;
	      }
		return true;
		
		
	}
	
}
