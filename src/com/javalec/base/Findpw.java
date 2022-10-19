package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.javalec.dao.Daofindpw;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Findpw extends JDialog {
	private JLabel lblfindIcon;
	private JLabel lblSignUp;
	private JLabel lblId;
	private JTextField tfId;
	private JLabel lblQuestion;
	private JComboBox cbQuestion;
	private JLabel lblAnswer;
	private JTextField tfAnswer;
	private JLabel lblFindpwbtn;
	private JLabel lblClose;
	private JLabel lblBackground;
	private JLabel lblFindpw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Findpw dialog = new Findpw();
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
	public Findpw() {
		setBounds(700, 300, 375, 300);
		getContentPane().setLayout(null);
		getContentPane().add(getLblfindIcon());
		getContentPane().add(getLblSignUp());
		getContentPane().add(getLblId());
		getContentPane().add(getTfId());
		getContentPane().add(getLblQuestion());
		getContentPane().add(getCbQuestion());
		getContentPane().add(getLblAnswer());
		getContentPane().add(getTfAnswer());
		getContentPane().add(getLblFindpwbtn());
		getContentPane().add(getLblClose());
		getContentPane().add(getLblFindpw());
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
			lblSignUp = new JLabel("PW 찾기");
			lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
			lblSignUp.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
			lblSignUp.setBounds(0, 0, 375, 69);
		}
		return lblSignUp;
	}
	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID");
			lblId.setHorizontalAlignment(SwingConstants.CENTER);
			lblId.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
			lblId.setBounds(25, 80, 52, 32);
		}
		return lblId;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setColumns(10);
			tfId.setBackground(new Color(236, 224, 209));
			tfId.setBounds(82, 80, 171, 32);
		}
		return tfId;
	}
	private JLabel getLblQuestion() {
		if (lblQuestion == null) {
			lblQuestion = new JLabel("Question");
			lblQuestion.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
			lblQuestion.setBounds(25, 112, 69, 32);
		}
		return lblQuestion;
	}
	private JComboBox getCbQuestion() {
		if (cbQuestion == null) {
			cbQuestion = new JComboBox();
			cbQuestion.setModel(new DefaultComboBoxModel(new String[] {"당신의 출생년도는?", "당신의 아버지의 성함은?", "당신의 어머니의 성함은?", "가장 아끼는 보물 1호는?", "당신이 졸업한 초등학교의 이름은?", "당신이 졸업한 중학교의 이름은?", "당신이 졸업한 고등학교의 이름은?"}));
			cbQuestion.setBounds(92, 116, 206, 27);
		}
		return cbQuestion;
	}
	private JLabel getLblAnswer() {
		if (lblAnswer == null) {
			lblAnswer = new JLabel("Answer");
			lblAnswer.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
			lblAnswer.setBounds(25, 144, 69, 32);
		}
		return lblAnswer;
	}
	private JTextField getTfAnswer() {
		if (tfAnswer == null) {
			tfAnswer = new JTextField();
			tfAnswer.setColumns(10);
			tfAnswer.setBackground(new Color(236, 224, 209));
			tfAnswer.setBounds(82, 147, 171, 32);
		}
		return tfAnswer;
	}
	private JLabel getLblFindpwbtn() {
		if (lblFindpwbtn == null) {
			lblFindpwbtn = new JLabel("");
			lblFindpwbtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					findPw(tfId.getText(), cbQuestion.getSelectedItem().toString(), tfAnswer.getText());
				}
			});
			lblFindpwbtn.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/Findpw.png"));
			lblFindpwbtn.setBounds(260, 155, 80, 20);
		}
		return lblFindpwbtn;
	}
	private JLabel getLblClose() {
		if (lblClose == null) {
			lblClose = new JLabel("");
			lblClose.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
				}
			});
			lblClose.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/Close.png"));
			lblClose.setBounds(142, 229, 80, 20);
		}
		return lblClose;
	}
	private JLabel getLblBackground() {
		if (lblBackground == null) {
			lblBackground = new JLabel("");
			lblBackground.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/FindBackground.png"));
			lblBackground.setBounds(0, 0, 375, 272);
		}
		return lblBackground;
	}
	private JLabel getLblFindpw() {
		if (lblFindpw == null) {
			lblFindpw = new JLabel("");
			lblFindpw.setHorizontalAlignment(SwingConstants.CENTER);
			lblFindpw.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
			lblFindpw.setBounds(27, 188, 313, 16);
		}
		return lblFindpw;
	}
	
	// Method
	
	private String findPw(String id, String question, String answer) {
		String pwCheck = "";
		Daofindpw dfw = new Daofindpw(id, question, answer);
		pwCheck = dfw.findPw();
		//찾은 아이디 출력하는거 여기다 만들면 됨.
		if(!pwCheck.equals("")) {
			lblFindpw.setText("당신의 비밀번호는 "+pwCheck+"입니다.");
		}else {
			lblFindpw.setText("일치하는 정보가 없습니다.");
		}
		return pwCheck;
		
	}
	
	
} // END
