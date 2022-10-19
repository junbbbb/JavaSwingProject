package com.javalec.base;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.DaoMain;
import com.javalec.dto.DtoMain;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class Mypage extends JDialog {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Mypage dialog = new Mypage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Mypage() {
		setTitle("Mypage");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel_8());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_4());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_5());
		getContentPane().add(getLblNewLabel_6());
		getContentPane().add(getLblNewLabel_7());
		setBounds(600, 100, 375, 812);
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Mypage.class.getResource("/com/javalec/loginimages/MypageImage.png")));
			lblNewLabel.setBounds(29, 85, 100, 100);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Stamp stamp = new Stamp();
					stamp.setVisible(true);
					setVisible(false);
				}
			});
			lblNewLabel_2.setBounds(27, 227, 144, 52);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MypageUpdate mypageupdate = new MypageUpdate();
					mypageupdate.main(null);
					setVisible(false);
					
				}
			});
			lblNewLabel_3.setBounds(198, 230, 147, 48);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setBounds(22, 358, 332, 44);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(Mypage.class.getResource("/com/javalec/loginimages/wecomenickname.png")));
			lblNewLabel_1.setBounds(173, 110, 97, 49);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("");
			lblNewLabel_5.setIcon(new ImageIcon(Mypage.class.getResource("/com/javalec/loginimages/MypageAll.png")));
			lblNewLabel_5.setBounds(16, 227, 359, 472);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("");
			lblNewLabel_6.setIcon(new ImageIcon(Mypage.class.getResource("/com/javalec/loginimages/MypageTop.png")));
			lblNewLabel_6.setBounds(16, 21, 330, 50);
		}
		return lblNewLabel_6;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel(whoAreYou());
			lblNewLabel_7.setFont(new Font("Apple SD Gothic Neo", Font.BOLD, 19));
			lblNewLabel_7.setBounds(171, 107, 83, 29);
		}
		return lblNewLabel_7;
	}
	
	
	
	
	
	private String whoAreYou() {
		DaoMain daoMain = new DaoMain(Login1.id);
		DtoMain dto = daoMain.getNicname();
		
		return dto.getCustnickname();
	}
	
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("");
			lblNewLabel_8.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JOptionPane.showMessageDialog(null, "로그아웃 되었습니다!");
					Login1 login1 = new Login1();
					login1.main(null);
					setVisible(false);
				}
			});
			lblNewLabel_8.setBounds(297, 26, 55, 52);
		}
		return lblNewLabel_8;
	}
}//end ----------------------
