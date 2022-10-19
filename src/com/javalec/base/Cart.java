package com.javalec.base;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.DaoMenuList;
import com.javalec.dao.DaoCart;
import com.javalec.dao.DaoCoffeeOrder;
import com.javalec.dto.Dto;
import com.javalec.dto.DtoCart;
import com.javalec.dto.DtoPurchase;
import com.javalec.style.Style;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class Cart extends JDialog {
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	ArrayList<DtoCart> beanList = null;
	ArrayList<DtoPurchase> beanList2 =null;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_8;
	private JLabel lblTotalQuantity;
	int sumquantity;
	int sumprice;
	private JLabel lblTotal;
	private JButton btnNewButton;
//수정테스
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cart dialog = new Cart();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cart() {
		getContentPane().setBackground(new Color(233, 233, 233));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				TableInit();
				SearchAction();
				
			}
			@Override
			public void windowClosing(WindowEvent e) {
				closingAction();
			}
		});
		setBounds(600, 100, 375, 812);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel_8());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getLblNewLabel_4());
		getContentPane().add(getScrollPane());
		
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_5());
		getContentPane().add(getLblNewLabel_6());
		getContentPane().add(getLblTotalQuantity());
		getContentPane().add(getLblTotal());
		getContentPane().add(getBtnNewButton());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(48, 215, 290, 373);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable() { 								// <--****************
				public Class getColumnClass(int column) { 				// <--****************
			        return (column == 0) ? Icon.class : Object.class; 	// <--****************
			      }
			};
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setRowHeight(120); 		// <--***************************************************
			Inner_Table.setModel(Outer_Table); 	// <--***************************************************
		}
		return Inner_Table;
	}
	//----------------function
	
	private void TableInit(){
        int i = Outer_Table.getRowCount();
        
//        Outer_Table.add("사진");
        Outer_Table.addColumn("사진");
        Outer_Table.addColumn("이름");
        Outer_Table.addColumn("갯수");
       
        Outer_Table.setColumnCount(3);

        for(int j = 0 ; j < i ; j++){
            Outer_Table.removeRow(0);
        }

        Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
        

        int vColIndex = 0;
        TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
        int width = 120;
        col.setPreferredWidth(width);

        vColIndex = 1;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width = 80;
        col.setPreferredWidth(width);
 
        vColIndex = 2;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width =30;
        col.setPreferredWidth(width);
//
//        vColIndex = 2;
//        col = Inner_Table.getColumnModel().getColumn(vColIndex);
//        width = 100;
//        col.setPreferredWidth(width);

       

	}
	
//	테이블에 넣는값 ..
	private void SearchAction(){
		DaoCart dbAction = new DaoCart();
		beanList = dbAction.SelectList();
		
		int listCount = beanList.size();
		
		for (int index = 0; index < listCount; index++) {
			Style style = new Style();
			ImageIcon icon = style.imageSize89("./"+beanList.get(index).getFilename());
			Object[] tempData = {icon, beanList.get(index).getMenuname(),
					Integer.toString(beanList.get(index).getCartquantity())};
			
			sumquantity += beanList.get(index).getCartquantity();
			sumprice += beanList.get(index).getTotalprice();
			
			
			Outer_Table.addRow(tempData);
		
		}
		
		lblTotalQuantity.setText("총"+Integer.toString(sumquantity)+"개");
		lblTotal.setText(Integer.toString(sumprice)+"원");
		
	}
	private void closingAction() {
		
		for(int index=0; index < beanList.size(); index++) {
			File file = new File("./" + beanList.get(index).getFilename());
			file.delete();
			
		}
		
	}
	
	
	
	private void openPurchase() {
		
			DaoCart dbAction2 = new DaoCart();
			dbAction2.PurchaseSelectList();
			
//			int listCount = beanList.size();
//			
//			for (int index = 0; index < listCount; index++) {
//				
//				String[] tempData = {beanList.get(index).getMenuname(),
//						Integer.toString(beanList.get(index).getCartquantity())};
//				Outer_Table.addRow(tempData);
			}

		
		
		
		
		
		
		
		
	
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(Cart.class.getResource("/com/javalec/loginimages/CartStorename.png")));
			lblNewLabel_1.setBounds(23, 80, 330, 64);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(Cart.class.getResource("/com/javalec/loginimages/CartTop.png")));
			lblNewLabel_2.setBounds(14, 16, 343, 50);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Order order = new Order();
					order.setVisible(true);
					setVisible(false);
				}
			});
			lblNewLabel_3.setBounds(14, 18, 48, 43);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "목록에서 제거되었습니다!");
				}
			});
			lblNewLabel_4.setBounds(309, 18, 52, 43);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("");
			lblNewLabel_5.setIcon(new ImageIcon(Cart.class.getResource("/com/javalec/loginimages/CartBack.png")));
			lblNewLabel_5.setBounds(0, 0, 375, 171);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("");
			lblNewLabel_6.setIcon(new ImageIcon(Cart.class.getResource("/com/javalec/loginimages/CartBottom.png")));
			lblNewLabel_6.setBounds(0, 720, 375, 64);
		}
		return lblNewLabel_6;
	}
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("");
			lblNewLabel_8.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					openPurchase();
					PurchaseA purchase = new PurchaseA();
					purchase.setVisible(true);
					setVisible(false);
				}
			});
			lblNewLabel_8.setBounds(0, 720, 188, 64);
		}
		return lblNewLabel_8;
	}
	private JLabel getLblTotalQuantity() {
		if (lblTotalQuantity == null) {
			lblTotalQuantity = new JLabel("총");
			lblTotalQuantity.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblTotalQuantity.setBounds(58, 608, 303, 29);
		}
		return lblTotalQuantity;
	}
	private JLabel getLblTotal() {
		if (lblTotal == null) {
			lblTotal = new JLabel("3000원");
			lblTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblTotal.setBounds(230, 611, 131, 23);
		}
		return lblTotal;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("전체 삭제");
			btnNewButton.setBounds(254, 666, 94, 35);
		}
		return btnNewButton;
	}
}//End ------------------------------------
