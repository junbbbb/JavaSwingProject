package com.javalec.base;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

	public class Stamp extends JDialog {
		private JLabel lblNewLabel;
		private JLabel lblNewLabel_1;
		private JLabel lblNewLabel_2;
		private JLabel lblNewLabel_3;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Stamp dialog = new Stamp();
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
		public Stamp() {
			getContentPane().setBackground(Color.WHITE);
			getContentPane().setLayout(null);
			getContentPane().add(getLblNewLabel_3());
			getContentPane().add(getLblNewLabel_2());
			getContentPane().add(getLblNewLabel_1());
			getContentPane().add(getLblNewLabel());
			setTitle("My Stamp");
			setBounds(600, 100, 375, 812);

		}

		private JLabel getLblNewLabel() {
			if (lblNewLabel == null) {
				lblNewLabel = new JLabel("New label");
				lblNewLabel.setIcon(new ImageIcon(Stamp.class.getResource("/com/javalec/loginimages/StampImage.png")));
				lblNewLabel.setBounds(3, 5, 343, 679);
			}
			return lblNewLabel;
		}
		private JLabel getLblNewLabel_1() {
			if (lblNewLabel_1 == null) {
				lblNewLabel_1 = new JLabel("New label");
				lblNewLabel_1.setIcon(new ImageIcon(Stamp.class.getResource("/com/javalec/loginimages/MenuBar3.png")));
				lblNewLabel_1.setBounds(0, 696, 375, 96);
			}
			return lblNewLabel_1;
		}
		private JLabel getLblNewLabel_2() {
			if (lblNewLabel_2 == null) {
				lblNewLabel_2 = new JLabel("");
				lblNewLabel_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						CoffeeMain coffeemain = new CoffeeMain();
						coffeemain.main(null);
						setVisible(false);
					}
				});
				lblNewLabel_2.setBounds(6, 6, 60, 52);
			}
			return lblNewLabel_2;
		}
		private JLabel getLblNewLabel_3() {
			if (lblNewLabel_3 == null) {
				lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						CoffeeMain coffeemain = new CoffeeMain();
						coffeemain.main(null);
						setVisible(false);
					}
				});
				lblNewLabel_3.setBounds(20, 716, 60, 56);
			}
			return lblNewLabel_3;
		}
}
