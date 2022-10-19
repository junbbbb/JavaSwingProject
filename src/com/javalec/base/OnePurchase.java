package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.DaoMain;
import com.javalec.dto.DtoMain;
import com.javalec.dto.DtoMenu;
import com.javalec.dto.DtoPurchase;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.security.DomainCombiner;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OnePurchase extends JDialog {

	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JTable innerTable;
	private JButton btnCancel;
	private JButton btnBying;
	private JLabel lblTotalPrice;
	
	private int orderid = 0;
	private String menuname;

	public static String store;
	
	private final DefaultTableModel OuterTable = new DefaultTableModel();
	ArrayList<DtoPurchase> beanList = new ArrayList<DtoPurchase>();

	DaoMain dao = new DaoMain();
	private JLabel lblStore;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OnePurchase dialog = new OnePurchase();
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
	public OnePurchase() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tableInit();
				insertTable();
			}
		});
		setTitle("Purchase");
		setBounds(600, 100, 330, 549);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getScrollPane());
		getContentPane().add(getBtnCancel());
		getContentPane().add(getBtnBying());
		getContentPane().add(getLblTotalPrice());
		getContentPane().add(getLblStore());

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("/Users/dingye/Downloads/card.png"));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(6, 34, 318, 197);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("총 결제금액 : ");
			lblNewLabel_1.setBounds(39, 254, 71, 16);
		}
		return lblNewLabel_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(39, 287, 253, 148);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable();
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(OuterTable);
		}
		return innerTable;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MenuInformation info = new MenuInformation();
					info.setVisible(true);
					setVisible(false);
				}
			});
			btnCancel.setBounds(30, 455, 117, 29);
		}
		return btnCancel;
	}
	private JButton getBtnBying() {
		if (btnBying == null) {
			btnBying = new JButton("결제하기");
			btnBying.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					orderid++;
					DaoMain dao = new DaoMain(Login1.id, store, menuname, Integer.toString(orderid));
					dao.insertAction();
					
					JOptionPane.showMessageDialog(null, "결제가 완료되었습니다. 감사합니다.");
				}
			});
			btnBying.setBounds(175, 455, 117, 29);
		}
		return btnBying;
	}
	
	private void tableInit() {
        int i = OuterTable.getRowCount();
        
        OuterTable.addColumn("이름");
        OuterTable.addColumn("갯수");
        OuterTable.addColumn("가격");
        OuterTable.setColumnCount(3);

        for(int j = 0 ; j < i ; j++){
            OuterTable.removeRow(0);
        }

        innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);
        

        int vColIndex = 0;
        TableColumn col = innerTable.getColumnModel().getColumn(vColIndex);
        int width = 110;
        col.setPreferredWidth(width);

        vColIndex = 1;
        col = innerTable.getColumnModel().getColumn(vColIndex);
        width = 50;
        col.setPreferredWidth(width);
        
        vColIndex = 2;
        col = innerTable.getColumnModel().getColumn(vColIndex);
        width = 85;
        col.setPreferredWidth(width);

	}
	
	// M
	
	public void insertTable() {
		DtoPurchase recommend = dao.recommendMenu();
		menuname = recommend.getMenuname();
		
		String[] menuinfo = {recommend.getMenuname(), Integer.toString(recommend.getMenuquantity()), Integer.toString(recommend.getTotalprice())};
		
		OuterTable.addRow(menuinfo);
		
		
	}
	private JLabel getLblTotalPrice() {
		if (lblTotalPrice == null) {
			lblTotalPrice = new JLabel(Integer.toString(dao.recommendMenu().getTotalprice()));
			lblTotalPrice.setBounds(111, 254, 104, 16);
		}
		return lblTotalPrice;
	}
	private JLabel getLblStore() {
		if (lblStore == null) {
			lblStore = new JLabel(store);
			lblStore.setHorizontalAlignment(SwingConstants.RIGHT);
			lblStore.setBounds(196, 254, 96, 16);
		}
		return lblStore;
	}
} // End
