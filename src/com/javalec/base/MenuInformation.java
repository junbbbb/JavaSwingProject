package com.javalec.base;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.javalec.dao.DaoMain;
import com.javalec.dto.DtoMenu;
import com.javalec.util.DBConnect;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

public class MenuInformation extends JDialog {

	private JLabel lblImage;
	private JLabel lblNewLabel_1;
	private JTextField tfName;
	private JLabel lblNewLabel_1_1;
	private JTextField tfPrice;
	public static String randomid;
	
	private JButton btnBuying;
	private JButton btnAddToCart;
	private JLabel lblClose;
	private JLabel lblNewLabel_1_6;
	private JSpinner spinner;
	public int quantity = 1;
	
	DaoMain dao = new DaoMain();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInformation dialog = new MenuInformation();
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
	public MenuInformation() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Menu Information");
		setBounds(600, 100, 375, 812);
		getContentPane().setLayout(null);
		getContentPane().add(getLblImage());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getTfName());
		getContentPane().add(getLblNewLabel_1_1());
		getContentPane().add(getTfPrice());
		getContentPane().add(getBtnBuying());
		getContentPane().add(getBtnAddToCart());
		getContentPane().add(getLblClose());
		getContentPane().add(getLblNewLabel_1_6());
		getContentPane().add(getSpinner());
		selectInfo();
		if(StoreSelect.active == true) {
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowActivated(WindowEvent e) {
				}
			});
		}
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblImage.setBounds(76, 43, 191, 164);
		}
		return lblImage;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Name : ");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1.setBounds(42, 224, 93, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setEditable(false);
			tfName.setBounds(137, 219, 130, 26);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("Price : ");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_1.setBounds(42, 257, 93, 16);
		}
		return lblNewLabel_1_1;
	}
	private JTextField getTfPrice() {
		if (tfPrice == null) {
			tfPrice = new JTextField();
			tfPrice.setEditable(false);
			tfPrice.setColumns(10);
			tfPrice.setBounds(137, 252, 130, 26);
		}
		return tfPrice;
	}
	
	// 선택된 랜덤메뉴 
	private void selectInfo() {
		DaoMain.menuid = randomid;
		DtoMenu dto = dao.selectMenuInfo();
		
		String filePath = Integer.toString(DBConnect.filename);
		
		
		lblImage.setIcon(new ImageIcon(filePath));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfName.setText(dto.getMenuname());
		tfPrice.setText(Integer.toString(dto.getMenuprice()));
		
		DaoMain.mname = dto.getMenuname();
		DaoMain.price = dto.getMenuprice();
		
		
		File file = new File(filePath);
		file.delete();
		
	}
	
	private JButton getBtnBuying() {
		if (btnBuying == null) {
			btnBuying = new JButton("바로 주문");
			btnBuying.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StoreSelect select = new StoreSelect();
					select.main(null);
					setVisible(false);
					
				}
			});
			btnBuying.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			btnBuying.setBounds(177, 356, 100, 91);
		}
		return btnBuying;
	}
	private JButton getBtnAddToCart() {
		if (btnAddToCart == null) {
			btnAddToCart = new JButton("장바구니 담기");
			btnAddToCart.setBounds(50, 356, 100, 91);
		}
		return btnAddToCart;
	}
	private JLabel getLblClose() {
		if (lblClose == null) {
			lblClose = new JLabel("닫기");
			lblClose.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					CoffeeMain coffeeMain = new CoffeeMain();
					coffeeMain.main(null);
					setVisible(false);
				}
			});
			lblClose.setHorizontalAlignment(SwingConstants.CENTER);
			lblClose.setBounds(0, 486, 330, 35);
		}
		return lblClose;
	}
	private JLabel getLblNewLabel_1_6() {
		if (lblNewLabel_1_6 == null) {
			lblNewLabel_1_6 = new JLabel("Quantity : ");
			lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_6.setBounds(42, 290, 91, 16);
		}
		return lblNewLabel_1_6;
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setBounds(137, 288, 41, 25);
			spinner.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					DtoMenu dto = dao.selectMenuInfo();
					quantity = (int)(((JSpinner)e.getSource()).getValue());//팔린갯수
					int totalPrice = quantity*dto.getMenuprice();
					tfPrice.setText(Integer.toString((totalPrice)));
					
					DaoMain.quantity = quantity;
				}
			});
//			spinner.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//				lblPrice.setText(Integer.toString(Integer.parseInt(String.valueOf(spinner.getValue())) *1000));
//				}
//			});
			spinner.setModel(new SpinnerNumberModel(1, 1, null, 1));
		}
		return spinner;
	}

	
	
} // End
