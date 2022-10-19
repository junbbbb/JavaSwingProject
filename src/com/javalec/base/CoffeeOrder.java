package com.javalec.base;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.DaoCoffeeOrder;
import com.javalec.dto.DtoOrder;
import com.javalec.util.DBConnect;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;

public class CoffeeOrder {

	private JFrame frmStoreSelect;

	// --- Table
	private final DefaultTableModel OuterTable = new DefaultTableModel();
	
	ArrayList<DtoOrder> storeList = null;
	private JLabel lblNewLabel;
	private JLabel lblCount;
	private JComboBox cbSearch;
	private JTextField tfSearch;
	private JLabel lblSearch;
	private JScrollPane scrollPane;
	
	DaoCoffeeOrder dao = new DaoCoffeeOrder();
	private JLabel lblBack;
	public static String tkStoreName;
	private JLabel lblNewLabel_2;
	private JTable innerTable;
	private JLabel lblHome;
	private JLabel lblHome_1;
	private JLabel lblHome_1_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeOrder window = new CoffeeOrder();
					window.frmStoreSelect.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CoffeeOrder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStoreSelect = new JFrame();
		frmStoreSelect.getContentPane().setBackground(Color.WHITE);
		frmStoreSelect.setTitle("Store Select");
		frmStoreSelect.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tableInit();
				queryAction();
				dao.countStore();
				
			}
			@Override
			public void windowClosed(WindowEvent e) {
				closingAction();
			}
		});
		frmStoreSelect.setBounds(600, 100, 375, 812);
		frmStoreSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStoreSelect.getContentPane().setLayout(null);
		frmStoreSelect.getContentPane().add(getLblHome_1_1());
		frmStoreSelect.getContentPane().add(getLblHome_1());
		frmStoreSelect.getContentPane().add(getLblHome());
		frmStoreSelect.getContentPane().add(getScrollPane());
		frmStoreSelect.getContentPane().add(getLblNewLabel_2());
		frmStoreSelect.getContentPane().add(getLblCount());
		frmStoreSelect.getContentPane().add(getCbSearch());
		frmStoreSelect.getContentPane().add(getTfSearch());
		frmStoreSelect.getContentPane().add(getLblSearch());
		frmStoreSelect.getContentPane().add(getLblBack());
		lblCount.setText("> 전체 (" + dao.count + ")건");
		frmStoreSelect.getContentPane().add(getLblNewLabel());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("매장 선택");
			lblNewLabel.setIcon(new ImageIcon(CoffeeOrder.class.getResource("/com/javalec/loginimages/StoreMenu.png")));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(27, 16, 330, 50);
		}
		return lblNewLabel;
	}
	private JLabel getLblCount() {
		if (lblCount == null) {
			dao.countStore();
			lblCount = new JLabel("");
			lblCount.setBounds(17, 103, 98, 16);
			lblCount.setText("> 전체 (" + dao.count + ")건");
		}
		return lblCount;
	}
	private JComboBox getCbSearch() {
		if (cbSearch == null) {
			cbSearch = new JComboBox();
			cbSearch.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			cbSearch.setModel(new DefaultComboBoxModel(new String[] {"지역", "지점명"}));
			cbSearch.setBounds(15, 63, 87, 33);
		}
		return cbSearch;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 15));
			tfSearch.setToolTipText("매장명을 검색하세요");
			tfSearch.setBounds(101, 62, 189, 33);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	private JLabel getLblSearch() {
		if (lblSearch == null) {
			lblSearch = new JLabel("");
			lblSearch.setForeground(Color.DARK_GRAY);
			lblSearch.setIcon(new ImageIcon(CoffeeOrder.class.getResource("/com/javalec/loginimages/Search.png")));
			lblSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					conditionQuery();
				}
			});
			lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
			lblSearch.setBounds(300, 64, 29, 29);
		}
		return lblSearch;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
			scrollPane.setBounds(19, 147, 338, 538);
			scrollPane.setViewportView(getInnerTable());
			
		}
		return scrollPane;
	}
	
	private void tableInit() {
        int i = OuterTable.getRowCount();
        
        OuterTable.addColumn("");
        OuterTable.addColumn("");
        OuterTable.setColumnCount(2);

        for(int j = 0 ; j < i ; j++){
            OuterTable.removeRow(0);
        }

        innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);
        

        int vColIndex = 0;
        TableColumn col = innerTable.getColumnModel().getColumn(vColIndex);
        int width = 150;
        col.setPreferredWidth(width);

        vColIndex = 1;
        col = innerTable.getColumnModel().getColumn(vColIndex);
        width = 130;
        col.setPreferredWidth(width);

	}
	
	private void queryAction() {
		storeList = dao.selectList();
		
		int listCount = storeList.size();
		
		String filePath = Integer.toString(DBConnect.filename);
		
		for (int index = 0; index < listCount ; index++) {
			ImageIcon icon = new ImageIcon("./dochii.png");
			Object[] tempData = {icon, storeList.get(index).getSname()};
			OuterTable.addRow(tempData);
		}
		
		File file = new File(filePath);
		file.delete();
		
	}
	
	private void closingAction() {
		
		for(int index=0; index < storeList.size(); index++) {
			File file = new File("./dochii.png");
			file.delete();
		}
	}
	
	private JLabel getLblBack() {
		if (lblBack == null) {
			lblBack = new JLabel("");
			lblBack.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					CoffeeMain coffeeMain = new CoffeeMain();
					coffeeMain.main(null);
					frmStoreSelect.setVisible(false);
				}
			});
			lblBack.setHorizontalAlignment(SwingConstants.CENTER);
			lblBack.setBounds(21, 19, 40, 38);
		}
		return lblBack;
	}
	
	private void conditionQuery() {
		int i = cbSearch.getSelectedIndex();

		String conditionQueryColumn = "";
		switch (i) {
		case 0:
			conditionQueryColumn = "saddress";
			break;
		case 1:
			conditionQueryColumn = "sname";
			break;
		}

		tableInit(); // 테이블 정리
		conditionQueryAction(conditionQueryColumn); // ()안에 네임이면 네임글자가올거고 선택에 따른 값이 옴
	}
	
	private void conditionQueryAction(String conditionQueryColumn) {

		DaoCoffeeOrder dao = new DaoCoffeeOrder(conditionQueryColumn, tfSearch.getText());
		ArrayList<String> result = dao.conditionList();

		int listCount = result.size();
		lblCount.setText(cbSearch.getSelectedItem() + ">" + tfSearch.getText()+"(" + listCount + ")건");
		
		String filePath = Integer.toString(DBConnect.filename);
		
		for (int index = 0; index < listCount ; index++) {
			ImageIcon icon = new ImageIcon("./dochii.png");
			Object[] tempData = {icon, result.get(index)};
			OuterTable.addRow(tempData);
		}
		
		File file = new File(filePath);
		file.delete();
	}
	
	
	
	
	
	
	
	
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(CoffeeOrder.class.getResource("/com/javalec/loginimages/MenuBar3.png")));
			lblNewLabel_2.setBounds(0, 689, 375, 96);
		}
		return lblNewLabel_2;
	}
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable() {
			public Class getColumnClass(int column) { 				// <--****************
		        return (column == 0) ? Icon.class : Object.class; 	// <--****************
		      	}
		};
			innerTable.setBounds(0, 0, 334, 0);
			innerTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					TableClick();
					
				}
			});
		innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		innerTable.setRowHeight(98); 		// <--***************************************************
		innerTable.setModel(OuterTable);
		}
		
		return innerTable;
	}
	
	private void TableClick() {
        int i = innerTable.getSelectedRow();
         tkStoreName = (String)innerTable.getValueAt(i, 1);
         System.out.println(tkStoreName);
         MenuList menuList = new MenuList();
         menuList.setVisible(true);
         frmStoreSelect.setVisible(false);
         
         
	}
	private JLabel getLblHome() {
		if (lblHome == null) {
			lblHome = new JLabel("");
			lblHome.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					CoffeeMain coffeeMain = new CoffeeMain();
					coffeeMain.main(null);
					frmStoreSelect.setVisible(false);
					
					 
					 
					
				}
			});
			lblHome.setBounds(32, 723, 43, 38);
		}
		return lblHome;
	}
	private JLabel getLblHome_1() {
		if (lblHome_1 == null) {
			lblHome_1 = new JLabel("");
			lblHome_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Cart cart = new Cart();
					cart.setVisible(true);
					frmStoreSelect.setVisible(false);
				}
			});
			lblHome_1.setBounds(230, 725, 43, 38);
		}
		return lblHome_1;
	}
	private JLabel getLblHome_1_1() {
		if (lblHome_1_1 == null) {
			lblHome_1_1 = new JLabel("");
			lblHome_1_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Mypage mypage = new Mypage();
					mypage.setVisible(true);
					frmStoreSelect.setVisible(false);
					
					
					//mypage로 이
				}
			});
			lblHome_1_1.setBounds(291, 725, 43, 38);
		}
		return lblHome_1_1;
	}
}//End
