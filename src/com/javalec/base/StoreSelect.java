package com.javalec.base;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.DaoCoffeeOrder;
import com.javalec.dto.DtoOrder;
import com.javalec.util.DBConnect;

public class StoreSelect {

	private JFrame frmStoreSelect;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable innerTable;

	// --- Table
	private final DefaultTableModel OuterTable = new DefaultTableModel();
	
	// -- file 정리
	ArrayList<DtoOrder> storeList = null;	
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	public static boolean active = false;
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreSelect window = new StoreSelect();
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
	public StoreSelect() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStoreSelect = new JFrame();
		frmStoreSelect.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tableInit();
				queryAction();
			}
			@Override
			public void windowClosed(WindowEvent e) {
				closingAction();
			}
		});
		frmStoreSelect.setTitle("Store Select");
		frmStoreSelect.setBounds(600, 100, 330, 549);
		frmStoreSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStoreSelect.getContentPane().setLayout(null);
		frmStoreSelect.getContentPane().add(getLblNewLabel());
		frmStoreSelect.getContentPane().add(getScrollPane());
		frmStoreSelect.getContentPane().add(getLblNewLabel_1());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("매장 선택");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(6, 12, 318, 16);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 45, 287, 431);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable() {
			public Class getColumnClass(int column) { 				// <--****************
		        return (column == 0) ? Icon.class : Object.class; 	// <--****************
		      }
		};
			innerTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					OnePurchase purchase = new OnePurchase();
					OnePurchase.store = tableClick();
					purchase.setVisible(true);
					frmStoreSelect.setVisible(false);
					active = true;
				}
			});
		innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		innerTable.setRowHeight(98); 		// <--***************************************************
		innerTable.setModel(OuterTable);
		}
		return innerTable;
	}
	
	// M
	
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
        int width = 98;
        col.setPreferredWidth(width);

        vColIndex = 1;
        col = innerTable.getColumnModel().getColumn(vColIndex);
        width = 130;
        col.setPreferredWidth(width);

	}
	
	private void queryAction() {
		DaoCoffeeOrder dbAction = new DaoCoffeeOrder();
		storeList = dbAction.selectList();
		
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

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("취소");
			lblNewLabel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MenuInformation info = new MenuInformation();
					frmStoreSelect.setVisible(false);
				}
			});
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(20, 490, 287, 16);
		}
		return lblNewLabel_1;
	}

	private String tableClick() {
		String store = "";
		
		int i = innerTable.getSelectedRow();
		store = (String)innerTable.getValueAt(i, 1);
		
		return store;
	}
	
	
	
	
	
} // End
