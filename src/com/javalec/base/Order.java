package com.javalec.base;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.JobAttributes;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.DaoMenuList;
import com.javalec.dao.DaoOrder;
import com.javalec.dto.Dto;
import com.javalec.style.Style;
import com.javalec.util.DBConnect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Order extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblImage;
	private JLabel lblName;
	private JLabel lblCart;
	private JLabel lblPickup;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblQuantitiy;
	private JLabel label;
	private JLabel lblCount;
	private JLabel lblPlus;
	private JLabel lblMinus;
	private JLabel lblNewLabel_3;
	private JLabel label_1;
	private JLabel lblPrice;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Order dialog = new Order();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Order() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				serarchAction();
			}
		});
		setBounds(600, 100, 375, 812);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(254, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblName());
		contentPanel.add(getLabel_1());
		contentPanel.add(getLblQuantitiy());
		contentPanel.add(getLblPickup());
		contentPanel.add(getLblCart());
		contentPanel.add(getLblImage());
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getLblNewLabel_1());
		contentPanel.add(getLblNewLabel_2());
		contentPanel.add(getLabel());
		contentPanel.add(getLblCount());
		contentPanel.add(getLblPlus());
		contentPanel.add(getLblMinus());
		contentPanel.add(getLblNewLabel_3());
		contentPanel.add(getLblPrice());
		contentPanel.add(getLblNewLabel_4());
		contentPanel.add(getLblNewLabel_5());
		contentPanel.add(getLblNewLabel_6());
		
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setBounds(30, 85, 317, 342);
		}
		return lblImage;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("name");
			lblName.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 18));
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			lblName.setBounds(48, 393, 112, 33);
		}
		return lblName;
	}
	private JLabel getLblCart() {
		if (lblCart == null) {
			lblCart = new JLabel("");
			lblCart.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					insertCartAction();
				}
			});
			lblCart.setIcon(null);
			lblCart.setBounds(0, 720, 188, 64);
		}
		return lblCart;
	}
	private JLabel getLblPickup() {
		if (lblPickup == null) {
			lblPickup = new JLabel("");
			lblPickup.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
			});
			lblPickup.setIcon(null);
			lblPickup.setBounds(187, 720, 188, 65);
		}
		return lblPickup;
	}
	
	
	//--------function
	
	private void serarchAction() {
		Style style = new Style();
		DaoMenuList dbAction = new DaoMenuList();
        Dto dto = dbAction.TableClick();
        
        
        lblName.setText(dto.getMenuname());
        lblPrice.setText(Integer.toString(dto.getMenuprice())+"원");
        
        
        // Image처리
        // File name이 틀려야 즉각 보여주기가 가능하여   
        // ShareVar에서 int값으로 정의하여 계속 증가하게 하여 file name으로 사용후 삭제
        
		String filePath = Integer.toString(DBConnect.filename);
		
		
		lblImage.setIcon(style.imageSize179(filePath));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		
		File file = new File(filePath);
		file.delete();
		
		
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(Order.class.getResource("/com/javalec/image/OrderHotIce.png")));
			lblNewLabel.setBounds(20, 532, 324, 39);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setIcon(new ImageIcon(Order.class.getResource("/com/javalec/image/OrderTop.png")));
			lblNewLabel_1.setBounds(13, 15, 330, 50);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					MenuList menulist = new MenuList();
					menulist.setVisible(true);
				}
			});
			lblNewLabel_2.setBounds(26, 19, 45, 50);
		}
		return lblNewLabel_2;
	}
	
	private void insertCartAction() {
		int menuquantity = Integer.parseInt(lblCount.getText())  ;
		System.out.println(menuquantity);
		DaoOrder daoOrder = new DaoOrder(menuquantity);
		System.out.println("insertactions 전까지는 성공");
		if(daoOrder.insertCartAction()) {
			OrderYesorNo orderyesorno = new OrderYesorNo();
			orderyesorno.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "실패");
		}
		
		
	}
	private JLabel getLblQuantitiy() {
		if (lblQuantitiy == null) {
			lblQuantitiy = new JLabel("quantitiy");
			lblQuantitiy.setIcon(new ImageIcon(Order.class.getResource("/com/javalec/image/quantity.png")));
			lblQuantitiy.setBounds(20, 583, 331, 70);
		}
		return lblQuantitiy;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Cart cart = new Cart();
					cart.setVisible(true);
					setVisible(false);
					
				}
			});
			label.setBounds(288, 6, 74, 69);
		}
		return label;
	}
	private JLabel getLblCount() {
		if (lblCount == null) {
			lblCount = new JLabel("0");
			lblCount.setHorizontalAlignment(SwingConstants.CENTER);
			lblCount.setBounds(255, 606, 61, 56);
		}
		return lblCount;
	}
	private JLabel getLblPlus() {
		if (lblPlus == null) {
			lblPlus = new JLabel("");
			lblPlus.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblCount.setText(Integer.toString(Integer.parseInt(lblCount.getText())+1));
					
					
				}
			});
			lblPlus.setBounds(302, 615, 61, 39);
		}
		return lblPlus;
	}
	private JLabel getLblMinus() {
		if (lblMinus == null) {
			lblMinus = new JLabel("");
			lblMinus.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblCount.setText(Integer.toString(Integer.parseInt(lblCount.getText())-1));
					
					
				}
			});
			lblMinus.setBounds(208, 616, 53, 39);
		}
		return lblMinus;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon(Order.class.getResource("/com/javalec/image/OrderBar.png")));
			lblNewLabel_3.setBounds(0, 720, 375, 64);
		}
		return lblNewLabel_3;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("");
			label_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Cart cart = new Cart();
					cart.setVisible(true);
					setVisible(false);
				}
			});
			label_1.setIcon(new ImageIcon(Order.class.getResource("/com/javalec/image/OrderList.png")));
			label_1.setBounds(297, 668, 74, 71);
		}
		return label_1;
	}
	private JLabel getLblPrice() {
		if (lblPrice == null) {
			lblPrice = new JLabel("price");
			lblPrice.setForeground(new Color(227, 132, 69));
			lblPrice.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 18));
			lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
			lblPrice.setBounds(161, 392, 100, 33);
		}
		return lblPrice;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("진한 에스프레소와 뜨거운 물을 섞어 스타벅스의 깔끔하고 ");
			lblNewLabel_4.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 13));
			lblNewLabel_4.setBounds(42, 461, 302, 28);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("강렬한 에스프레소를 가장 부드럽게 잘 느낄 수 있는 커피");
			lblNewLabel_5.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 13));
			lblNewLabel_5.setBounds(43, 488, 290, 16);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("New label");
			lblNewLabel_6.setIcon(new ImageIcon(Order.class.getResource("/com/javalec/loginimages/OrderBack2.png")));
			lblNewLabel_6.setBounds(24, 96, 329, 424);
		}
		return lblNewLabel_6;
	}
}//End ----------------
