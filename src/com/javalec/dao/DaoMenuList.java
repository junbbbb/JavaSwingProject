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

import com.javalec.base.CoffeeOrder;
import com.javalec.base.MenuList;
import com.javalec.dto.Dto;
import com.javalec.util.DBConnect;



public class DaoMenuList {
	String name;
	String filename;
	
	public DaoMenuList(String name) {
		super();
		this.name = name;
	}



	public DaoMenuList() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	// 검색 결과를 Table로 
	public ArrayList<Dto> SelectList(){
		
		ArrayList<Dto> BeanList = new ArrayList<Dto>();
		
		String WhereDefault1 = "select m.menuname, m.menuprice, m.menufilename, m.menuimage from menu m, menumanage mm, store s ";
		String WhereDefault2 = "where mm.store_storeseq = s.storeseq and m.menuid = mm.menu_menuid and s.sname = '"+CoffeeOrder.tkStoreName+"' and mm.mmenddate is null ";
		
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql,DBConnect.id_mysql,DBConnect.pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();

            ResultSet rs = stmt_mysql.executeQuery(WhereDefault1 +WhereDefault2);

            while(rs.next()){
            	
            	
            	String wkMenuname = rs.getString(1);
            	int wkMenupricce = rs.getInt(2);
            	String wkFilename = rs.getString(3);
            	
            	// File
            	File file = new File("./" + wkFilename);
            	FileOutputStream output = new FileOutputStream(file);
            	InputStream input = rs.getBinaryStream(4);
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }
                Dto dto = new Dto(wkMenuname, wkMenupricce, wkFilename);
            	BeanList.add(dto);
            }
            
            conn_mysql.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
		return BeanList;
	
	}
	
	public Dto TableClick() {
		Dto bean = null;
		String WhereDefault1 = "select menuname, menuprice, menufilename, menuimage from menu ";
		String WhereDefault2 = "where menuname = '" + MenuList.tkName+ "'" ;
		
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql,DBConnect.id_mysql,DBConnect.pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();

            ResultSet rs = stmt_mysql.executeQuery(WhereDefault1 + WhereDefault2);
            
            

            if(rs.next()){
            	
            	String wkMenuname = rs.getString(1);
            	int wkMenuprice = rs.getInt(2);
            	String wkFilename = rs.getString(3);
            	// File
            	DBConnect.filename = DBConnect.filename + 1;
            	File file = new File(Integer.toString(DBConnect.filename));
            	FileOutputStream output = new FileOutputStream(file);
            	InputStream input = rs.getBinaryStream(4);
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }
            	
            bean = new Dto(wkMenuname, wkMenuprice, wkFilename);
            }
            
            conn_mysql.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
		
		return bean;
	}
		
	
	
	        
	        
	        
}//DAO
	
	
	
	
	
	


