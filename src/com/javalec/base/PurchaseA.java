package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.DaoCart;
import com.javalec.dao.DaoPurchase;
import com.javalec.dto.DtoPurchase;
import com.javalec.style.Style;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PurchaseA extends JDialog {

	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JButton btnNewButton;
	ArrayList<DtoPurchase> beanList= new ArrayList<DtoPurchase>();
	DaoCart dao = new DaoCart();
	int sumquantity;
	int sumprice;
	private JLabel lblTotal;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JLabel lblTotalQuantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseA dialog = new PurchaseA();
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
	public PurchaseA() {
		getContentPane().setBackground(Color.WHITE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				TableInit();
				SearchAction();
			}
		});
		setTitle("Purchase");
		setBounds(600, 100, 375, 812);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel_4());
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getScrollPane());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getLblTotal());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblTotalQuantity());

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(PurchaseA.class.getResource("/com/javalec/loginimages/CardImage.png")));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(26, 136, 321, 213);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("<주문내역>");
			lblNewLabel_1.setIcon(new ImageIcon(PurchaseA.class.getResource("/com/javalec/loginimages/TotalPrice.png")));
			lblNewLabel_1.setBounds(51, 368, 99, 19);
		}
		return lblNewLabel_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(51, 406, 267, 256);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setRowHeight(15); 		// <--***************************************************
			Inner_Table.setModel(Outer_Table); 
		}
		return Inner_Table;
	}
	
	private void TableInit(){
        int i = Outer_Table.getRowCount();
        
//        Outer_Table.add("사진");
        Outer_Table.addColumn("이름");
        Outer_Table.addColumn("갯수");
        Outer_Table.addColumn("가격");
       
        Outer_Table.setColumnCount(3);

        for(int j = 0 ; j < i ; j++){
            Outer_Table.removeRow(0);
        }

        Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
        

        int vColIndex = 0;
        TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
        int width = 150;
        col.setPreferredWidth(width);

        vColIndex = 1;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width = 50;
        col.setPreferredWidth(width);
 
        vColIndex = 2;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width =60;
        col.setPreferredWidth(width);
//

       

	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon(PurchaseA.class.getResource("/com/javalec/loginimages/PayBtn.png")));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertAction();
				}
			});
			btnNewButton.setBounds(103, 694, 170, 56);
		}
		return btnNewButton;
	}
	
	
	
	
	
	private void SearchAction() {
		
		
		
		DaoCart dao = new DaoCart();
		beanList = dao.PurchaseSelectList();
		
		for(int index = 0; index <beanList.size(); index++) {
		
		String[] menuinfo = {beanList.get(index).getMenuname(), Integer.toString(beanList.get(index).getMenuquantity()), Integer.toString(beanList.get(index).getTotalprice())      };
		sumquantity += beanList.get(index).getMenuquantity();
		sumprice += beanList.get(index).getTotalprice();
		
		Outer_Table.addRow(menuinfo);
		}
		lblTotalQuantity.setText("총"+Integer.toString(sumquantity)+"개");
		lblTotal.setText(Integer.toString(sumprice)+"원");
		
	}
//	private void SearchAction(){
//		DaoCart dbAction = new DaoCart();
//		beanList = dbAction.SelectList();
//		
//		int listCount = beanList.size();
//		
//		for (int index = 0; index < listCount; index++) {
//			Style style = new Style();
//			ImageIcon icon = style.imageSize("./"+beanList.get(index).getFilename());
//			Object[] tempData = {icon, beanList.get(index).getMenuname(),
//					Integer.toString(beanList.get(index).getCartquantity())};
//			Outer_Table.addRow(tempData);
//		}
//
//	}
	private JLabel getLblTotal() {
		if (lblTotal == null) {
			lblTotal = new JLabel("");
			lblTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
			lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTotal.setBounds(235, 368, 87, 26);
		}
		return lblTotal;
	}
	
	
	private void insertAction() {
		
		DaoPurchase dao = new DaoPurchase();
	
		
		if(dao.insertAction() && dao.DeleteCartListAction()) {
			//성공
			JOptionPane.showMessageDialog(null, "구매가 완료되었습니다!");
			
		}else {
			//실패
			JOptionPane.showMessageDialog(null, "전산오류! 고객센터로 문의해주세요");
		}
		
	}
	
	
	
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("카드결제");
			lblNewLabel_3.setFont(new Font("Apple Braille", Font.BOLD, 20));
			lblNewLabel_3.setBounds(38, 76, 87, 47);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(PurchaseA.class.getResource("/com/javalec/loginimages/PurchaseTop.png")));
			lblNewLabel_2.setBounds(6, 6, 330, 50);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Cart cart = new Cart();
					cart.setVisible(true);
					setVisible(false);
				
				}
			});
			lblNewLabel_4.setBounds(6, 6, 49, 47);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblTotalQuantity() {
		if (lblTotalQuantity == null) {
			lblTotalQuantity = new JLabel("");
			lblTotalQuantity.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTotalQuantity.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
			lblTotalQuantity.setBounds(162, 368, 66, 26);
		}
		return lblTotalQuantity;
	}
}//end
