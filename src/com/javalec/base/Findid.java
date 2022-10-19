package com.javalec.base;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.Daofindid;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Findid extends JDialog {
	private JLabel lblfindIcon;
	private JLabel lblSignUp;
	private JLabel lblName;
	private JTextField tfName;
	private JLabel lblEmail;
	private JTextField tfEmail1;
	private JTextField tfEmail2;
	private JComboBox cbEmail;
	private JLabel lblFindid;
	private JLabel lblFindid_1;
	private JLabel lblFindid_1_1;
	private JLabel lblBackground;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Findid dialog = new Findid();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Findid() {
		setTitle("ID 찾기");
		setBounds(700, 300, 375, 300);
		getContentPane().setLayout(null);
		getContentPane().add(getLblfindIcon());
		getContentPane().add(getLblSignUp());
		getContentPane().add(getLblName());
		getContentPane().add(getTfName());
		getContentPane().add(getLblEmail());
		getContentPane().add(getTfEmail1());
		getContentPane().add(getTfEmail2());
		getContentPane().add(getCbEmail());
		getContentPane().add(getLblFindid());
		getContentPane().add(getLblFindid_1());
		getContentPane().add(getLblFindid_1_1());
		getContentPane().add(getLblBackground());
	}
	private JLabel getLblfindIcon() {
		if (lblfindIcon == null) {
			lblfindIcon = new JLabel("");
			lblfindIcon.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/signupicon/findid2.png"));
			lblfindIcon.setHorizontalAlignment(SwingConstants.CENTER);
			lblfindIcon.setBounds(77, 6, 60, 52);
		}
		return lblfindIcon;
	}
	private JLabel getLblSignUp() {
		if (lblSignUp == null) {
			lblSignUp = new JLabel("ID 찾기");
			lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
			lblSignUp.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
			lblSignUp.setBounds(0, 0, 375, 69);
		}
		return lblSignUp;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name");
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			lblName.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
			lblName.setBounds(25, 80, 52, 32);
		}
		return lblName;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBackground(new Color(236, 224, 209));
			tfName.setBounds(82, 80, 171, 32);
		}
		return tfName;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email");
			lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
			lblEmail.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
			lblEmail.setBounds(25, 114, 56, 32);
		}
		return lblEmail;
	}
	private JTextField getTfEmail1() {
		if (tfEmail1 == null) {
			tfEmail1 = new JTextField();
			tfEmail1.setColumns(10);
			tfEmail1.setBackground(new Color(236, 224, 209));
			tfEmail1.setBounds(82, 114, 96, 32);
		}
		return tfEmail1;
	}
	private JTextField getTfEmail2() {
		if (tfEmail2 == null) {
			tfEmail2 = new JTextField();
			tfEmail2.setColumns(10);
			tfEmail2.setBackground(new Color(236, 224, 209));
			tfEmail2.setBounds(174, 114, 96, 32);
		}
		return tfEmail2;
	}
	private JComboBox getCbEmail() {
		if (cbEmail == null) {
			cbEmail = new JComboBox();
			cbEmail.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cbEmail.getSelectedItem().toString()=="직접입력..") { // 콤보박스 선택시 텍스트 입력 막기
                        tfEmail2.setEditable(true);
                        tfEmail2.setText("@");//.뒤에는 메쏘드(디자인의 프로펄티), "" -> 빈 칸으로 만
                        tfEmail2.requestFocus();  // 커서 다시 깜빡이도록
                    }else {
                        String domain = cbEmail.getSelectedItem().toString(); // 이메일 콤보박스 값 불러오기
                        tfEmail2.setText("@"+domain);
                        tfEmail2.setEditable(false);
                    }
				}
			});
			cbEmail.setModel(new DefaultComboBoxModel(new String[] {"직접입력..", "gmail.com", "naver.com", "daum.net", "hanmail.com", "nate.com"}));
			cbEmail.setForeground(Color.BLACK);
			cbEmail.setBounds(265, 118, 104, 27);
		}
		return cbEmail;
	}
	private JLabel getLblFindid() {
		if (lblFindid == null) {
			lblFindid = new JLabel("");
			lblFindid.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
			lblFindid.setHorizontalAlignment(SwingConstants.CENTER);
			lblFindid.setBounds(44, 191, 313, 16);
		}
		return lblFindid;
	}
	// ID search BTN
	private JLabel getLblFindid_1() {
		if (lblFindid_1 == null) {
			lblFindid_1 = new JLabel("");
			lblFindid_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					findId(tfName.getText(), (tfEmail1.getText()+tfEmail2.getText()));
				}
			});
			lblFindid_1.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/Findid.png"));
			lblFindid_1.setBounds(142, 158, 80, 20);
		}
		return lblFindid_1;
	}
	private JLabel getLblFindid_1_1() {
		if (lblFindid_1_1 == null) {
			lblFindid_1_1 = new JLabel("");
			lblFindid_1_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
				}
			});
			lblFindid_1_1.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/Close.png"));
			lblFindid_1_1.setBounds(142, 229, 80, 20);
		}
		return lblFindid_1_1;
	}
	private JLabel getLblBackground() {
		if (lblBackground == null) {
			lblBackground = new JLabel("");
			lblBackground.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/FindBackground.png"));
			lblBackground.setBounds(0, 0, 375, 272);
		}
		return lblBackground;
	}
	// Method
	
	private String findId(String name, String email) {
		String id = "";
		Daofindid dfi = new Daofindid(name, email);
		id = dfi.findId();
		//찾은 아이디 출력하는거 여기다 만들면 됨.
		if(!id.equals("")) {
			lblFindid.setText("당신의 ID는 " + id + "입니다.");
			//아이디가 있을때
		}else {
			JOptionPane.showMessageDialog(null, "아이디를 찾을 수 없습니다.");
			//아이디가 없을때
		}
		return id;
		
	}
	
} //END
