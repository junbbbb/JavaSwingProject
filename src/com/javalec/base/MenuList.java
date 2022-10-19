package com.javalec.base;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.javalec.dao.DaoMenuList;
import com.javalec.dto.Dto;
import com.javalec.style.Style;
import com.javalec.util.DBConnect;

import com.sun.tools.javac.Main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JList;
import java.util.HashMap;
import java.util.Map;
import java.awt.Color;

public class MenuList extends JDialog {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private JLabel lblNewLabel_2;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JList list;
	ArrayList<Dto> beanList = null;
	public static String tkName;
	private JLabel lblNewLabel_3;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuList dialog = new MenuList();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public MenuList() {
		getContentPane().setBackground(new Color(254, 255, 255));
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				TableInit();
				SearchAction();
			}
		});
		setBounds(600, 100, 375, 812);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getScrollPane());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getLblNewLabel_2());

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("MenuListTop");
			lblNewLabel.setIcon(new ImageIcon(MenuList.class.getResource("/com/javalec/loginimages/MenuList.png")));
			lblNewLabel.setBounds(18, 7, 330, 50);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					CoffeeOrder coffeorder = new CoffeeOrder();
					coffeorder.main(null);
					setVisible(false);
					//전 화면으로 이
				}
			});
			lblNewLabel_1.setBounds(20, 5, 48, 50);
		}
		return lblNewLabel_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(16, 90, 340, 604);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable(){ 								// <--****************
				public Class getColumnClass(int column) { 				// <--****************
			        return (column == 0) ? Icon.class : Object.class; 	// <--****************
			      }
			};
			Inner_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					TableClick();
				}
			});
//			Inner_Table.getColumnModel().getColumn(1).setCellRenderer(new JTextAreaColumn());
//			Inner_Table.getColumnModel().getColumn(1).setCellEditor(new JTextAreaColumn());
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setRowHeight(150);
	        // <--***************************************************
			Inner_Table.setModel(Outer_Table); 	// <--***************************************************
		}
		return Inner_Table;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(MenuList.class.getResource("/com/javalec/loginimages/MenuBar3.png")));
			lblNewLabel_2.setBounds(0, 688, 375, 96);
		}
		return lblNewLabel_2;
	}
	
	//----------------------function
	
	private void TableInit(){
        int i = Outer_Table.getRowCount();
        
//        Outer_Table.add("사진");
        Outer_Table.addColumn("");
        Outer_Table.addColumn("");
        Outer_Table.addColumn("");
       
        Outer_Table.setColumnCount(3);

        for(int j = 0 ; j < i ; j++){
            Outer_Table.removeRow(0);
        }

        Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
        

        int vColIndex = 0;
        TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
        int width = 135;
        col.setPreferredWidth(width);

        vColIndex = 1;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width = 120;
        col.setPreferredWidth(width);
 
        vColIndex = 1;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width = 110;
        col.setPreferredWidth(width);
//
//        vColIndex = 2;
//        col = Inner_Table.getColumnModel().getColumn(vColIndex);
//        width = 100;
//        col.setPreferredWidth(width);

       

	}
	
	
	//매장별 메뉴리스트를 카테고리별로..
		private void SearchAction(){
			Style style = new Style();
			DaoMenuList dbAction = new DaoMenuList();
			beanList = dbAction.SelectList();
			
			int listCount = beanList.size();
			
			for (int index = 0; index < listCount; index++) {
				ImageIcon icon = style.imageSize89("./"+beanList.get(index).getFilename());
				Object[] tempData = {icon, beanList.get(index).getMenuname(),beanList.get(index).getMenuprice()};
				Outer_Table.addRow(tempData);
			}

		}
	
	private void TableClick() {
        int i = Inner_Table.getSelectedRow();
         tkName= (String)Inner_Table.getValueAt(i, 1);
         System.out.println(tkName);
         Order order = new Order();
         order.setVisible(true);
         setVisible(false);
   
        
	}

	
	
	
	
	
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon(MenuList.class.getResource("/com/javalec/loginimages/CategoryBar.png")));
			lblNewLabel_3.setBounds(0, 55, 425, 35);
		}
		return lblNewLabel_3;
	}
}//End
