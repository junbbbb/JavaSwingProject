package com.javalec.base;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrderYesorNo extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			OrderYesorNo dialog = new OrderYesorNo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public OrderYesorNo() {
		setBounds(700, 350, 176, 173);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Cart cart = new Cart();
					cart.setVisible(true);
					setVisible(false);
					
				}
			});
			{
				JLabel lblNewLabel_2_1 = new JLabel("");
				lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						setVisible(false);
					}
				});
				lblNewLabel_2_1.setBounds(88, 106, 88, 40);
				contentPanel.add(lblNewLabel_2_1);
			}
			lblNewLabel_2.setBounds(0, 106, 88, 40);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel = new JLabel("장바구니 담기 성공!");
			lblNewLabel.setBounds(12, 24, 113, 37);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel = new JLabel("장바구니로 이동하시겠습니까?");
			lblNewLabel.setBounds(12, 55, 179, 37);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(OrderYesorNo.class.getResource("/com/javalec/loginimages/OrderPopup.png")));
			lblNewLabel_1.setBounds(1, 105, 176, 40);
			contentPanel.add(lblNewLabel_1);
		}
	}

}
