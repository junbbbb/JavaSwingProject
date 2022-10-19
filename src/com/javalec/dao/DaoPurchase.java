package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.base.CoffeeOrder;
import com.javalec.base.Login1;
import com.javalec.base.PurchaseA;
import com.javalec.util.DBConnect;

public class DaoPurchase {
	
	public DaoPurchase() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	public boolean insertAction() {
		String wkOrderid = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 연결
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			
			
			
			String squery = "select max(orderid) +1 from orders ";
			
			
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet ss = stmt_mysql.executeQuery(squery);
			
			if(ss.next()) {
				wkOrderid = ss.getString(1) ;
			}

			
			String query = "insert into orders ( store_storeseq, menu_menuid, customer_custid, customer_ctelno, orderid, oquantity, odate) "; // 인서트하는애임
			String query1= "select s.storeseq, ca.menu_menuid, ca.customer_custid, cu.ctelno, ? , ca.cartquantity, now() ";
			String query2= "from store s, cart ca, customer cu, orders o ";
			//String query3= "where  ca.store_sname = s.sname, ca.customer_custid = '1', cu.custid = ca.customer_custid";
			String query3= "where ca.store_sname = s.sname and ca.customer_custid = cu.custid and ca.customer_custid = '"+Login1.id+"' ";

			ps = conn_mysql.prepareStatement(query + query1 + query2 + query3);
			ps.setString(1,wkOrderid);
		

			ps.executeUpdate(); // 실행하기

			conn_mysql.close(); // 클로즈하기 내가쓰고 클로즈해야 다른사람도 들어간다.

			// JOptionPane.showMessageDialog(null, tfName.getText() + "님의 정보가 입력되었습니다.");

		} catch (Exception e) {
			e.printStackTrace(); // 개발할떈 이렇게 쓰지만 나중엔 메세지로 잠시만 기다려주세요 등 쓰면됨.
			return false;
		}
		return true;
	}
	
	public boolean DeleteCartListAction() {
	      PreparedStatement ps = null;
	      try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
						DBConnect.pw_mysql);
	          @SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
	
	          String A = "delete from cart where customer_custid ='"+Login1.id + "'" ;
	
	          ps = conn_mysql.prepareStatement(A);
	          
	         
	          ps.executeUpdate();
	
	          conn_mysql.close();
	      } catch (Exception e){
	          e.printStackTrace();
	          return false;
	      }
	      return true;
	}
	
	
	
	
	
}//End ------------------------------
