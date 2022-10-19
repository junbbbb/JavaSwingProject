package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import com.javalec.dao.Daologin;

import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login1 {

	private JFrame frame;
	private JLabel lblLogo;
	private JLabel lblIdpw;
	private JLabel lblNewLabel;
	private JTextField tfId;
	private JPasswordField pfPassword;
	private JCheckBox cbRememberMe;
	private JLabel lblForgot;
	private JLabel lblSignup2;
	private JLabel lblSignup1;
	private JLabel lblForgotArrow;
	private JLabel lblSignupArrow;
	
	public static String id;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login1 window = new Login1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblLogo());
		frame.getContentPane().add(getLblIdpw());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getTfId());
		frame.getContentPane().add(getpfPassword());
		frame.getContentPane().add(getCbRememberMe());
		frame.getContentPane().add(getLblForgot());
		frame.getContentPane().add(getLblSignup2());
		frame.getContentPane().add(getLblSignup1());
		frame.getContentPane().add(getLblForgotArrow());
		frame.getContentPane().add(getLblSignupArrow());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.setBounds(600, 100, 375, 812);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("Logo");
			lblLogo.setIcon(new ImageIcon(Login1.class.getResource("/com/javalec/loginimages/Logo.png")));
			lblLogo.setBounds(40, 141, 293, 293);
		}
		return lblLogo;
	}
	private JLabel getLblIdpw() {
		if (lblIdpw == null) {
			lblIdpw = new JLabel("IDPW");
			lblIdpw.setIcon(new ImageIcon(Login1.class.getResource("/com/javalec/loginimages/IDPW.png")));
			lblIdpw.setBounds(-17, 466, 268, 83);
		}
		return lblIdpw;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Login");
			lblNewLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					customerCheck();
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblNewLabel.setIcon(new ImageIcon(Login1.class.getResource("/com/javalec/loginimages/Loginbtnclicked.png")));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblNewLabel.setIcon(new ImageIcon(Login1.class.getResource("/com/javalec/loginimages/Login.png")));
				}
			});
			lblNewLabel.setIcon(new ImageIcon(Login1.class.getResource("/com/javalec/loginimages/Login.png")));
			lblNewLabel.setBounds(258, 465, 63, 84);
		}
		return lblNewLabel;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(101, 467, 149, 36);
			tfId.setColumns(10);
		}
		return tfId;
	}
	private JPasswordField getpfPassword() {
		if (pfPassword == null) {
			pfPassword = new JPasswordField();
			pfPassword.setBounds(101, 514, 149, 35);
		}
		return pfPassword;
	}
	private JCheckBox getCbRememberMe() {
		if (cbRememberMe == null) {
			cbRememberMe = new JCheckBox("Remember Me");
			cbRememberMe.setFont(new Font("AppleGothic", Font.PLAIN, 16));
			cbRememberMe.setBounds(108, 635, 156, 41);
		}
		return cbRememberMe;
	}
	private JLabel getLblForgot() {
		if (lblForgot == null) {
			lblForgot = new JLabel("Forgot Dochi ID or password?");
			lblForgot.setForeground(new Color(228, 132, 69));
			lblForgot.setBackground(new Color(228, 132, 69));
			lblForgot.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 13));
			lblForgot.setBounds(100, 695, 165, 24);
		}
		return lblForgot;
	}
	private JLabel getLblSignup2() {
		if (lblSignup2 == null) {
			lblSignup2 = new JLabel("Create yours now.");
			lblSignup2.setForeground(new Color(228, 132, 70));
			lblSignup2.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 13));
			lblSignup2.setBounds(181, 729, 104, 16);
		}
		return lblSignup2;
	}
	private JLabel getLblSignup1() {
		if (lblSignup1 == null) {
			lblSignup1 = new JLabel("Don’t have an ID?");
			lblSignup1.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 13));
			lblSignup1.setBounds(82, 729, 104, 16);
		}
		return lblSignup1;
	}
	private JLabel getLblForgotArrow() {
		if (lblForgotArrow == null) {
			lblForgotArrow = new JLabel("New label");
			lblForgotArrow.setIcon(new ImageIcon(Login1.class.getResource("/com/javalec/loginimages/arrow.png")));
			lblForgotArrow.setBounds(263, 698, 17, 16);
		}
		return lblForgotArrow;
	}
	private JLabel getLblSignupArrow() {
		if (lblSignupArrow == null) {
			lblSignupArrow = new JLabel("New label");
			lblSignupArrow.setIcon(new ImageIcon(Login1.class.getResource("/com/javalec/loginimages/arrow.png")));
			lblSignupArrow.setBounds(281, 727, 17, 16);
		}
		return lblSignupArrow;
	}
	
	
	//--------------------function ---------------------
	
	
	
	 private void customerCheck() {
	      // 여기는 값을 받아서 넘겨주는 메소드
	      // 받아오기>>넘겨주기>>다오안에 있는 체크 메세지 실행   다오는 ?데이타베이스랑 연결  dto는 게터세터 모음집
	      int check=0;
	      int check1=0;
	       id=tfId.getText().trim();
	      String pw=pfPassword.getText().trim();
	      Daologin dao=new Daologin(id, pw);
	      check=dao.customerCheck();
	      check1=dao.customerCheck1();
	      if(check1==1) {
	         JOptionPane.showMessageDialog(null, "탈퇴된 회원입니다.");
	      }else {
	         check=dao.customerCheck();
	         if(check==1) {
	             JOptionPane.showMessageDialog(null, id+"님 로그인 되었습니다.");
	             System.out.println("0");
					CoffeeMain mainpage = new CoffeeMain();
					System.out.println("1");
					mainpage.main(null);
					System.out.println("2");
					frame.setVisible(false);
				System.out.println("3");	}
	          }
	          if(check==0) {
	             JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인하세요.");
	             /// 텍스트필드를 다 지워버리기.
	             pfPassword.setText("");
	             tfId.requestFocus();
				}
			}
	
	
	
	
	
	
	
	
	
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Welcome to Dochi Coffee!");
			lblNewLabel_1.setFont(new Font("Apple Symbols", Font.PLAIN, 24));
			lblNewLabel_1.setForeground(new Color(74, 55, 53));
			lblNewLabel_1.setBounds(77, 42, 235, 59);
		}
		return lblNewLabel_1;
	}
}//End -----------------------------
