package com.javalec.base;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.javalec.dao.Daosignup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Signup {

	private JFrame frmSignUp;
	private JLabel lblSignUp;
	private JLabel lblSingupicon;
	private JLabel btnSignup;
	private JLabel lblId;
	private JTextField tfId;
	private JLabel lblPw;
	private JPasswordField pfPw1;
	private JLabel lblPw_2;
	private JPasswordField pfPw2;
	private JLabel lblIdcheck;
	private JLabel lblPwcheck;
	private JCheckBox cbPwview;
	private JLabel lblName;
	private JLabel lblTel;
	private JLabel lblAddress;
	private JLabel lblEmail;
	private JLabel lblPw_2_1_1_1_1_1;
	private JTextField tfName;
	private JTextField tfTel;
	private JTextField tfAddress;
	private JTextField tfEmail;
	private JTextField tfEmail2;
	private JLabel lblAnswer;
	private JTextField tfAnswer;
	private JLabel lblNick;
	private JTextField tfNick;
	private JLabel lblPhoto;
	private JTextField tfPhotowhere;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblPreview;
	private JLabel lblBackground;
	private JComboBox cbQuestion;
	private JComboBox cbEmail;
	private JLabel lblBackbtn;
	private JLabel lblPwlimit;
	
	// 선언
    private boolean idcheck = false;
    private boolean pwcheck = false;
    ArrayList<String> arraylist = new ArrayList<String>();
	JFileChooser chooser = new JFileChooser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup window = new Signup();
					window.frmSignUp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Signup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignUp = new JFrame();
		frmSignUp.setTitle("Sign Up");
		frmSignUp.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				
			}
		});
		frmSignUp.setBounds(700, 100, 375, 812);
		frmSignUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSignUp.getContentPane().setLayout(null);
		frmSignUp.getContentPane().add(getBtnSignup());
		frmSignUp.getContentPane().add(getLblId());
		frmSignUp.getContentPane().add(getTfId());
		frmSignUp.getContentPane().add(getLblPw());
		frmSignUp.getContentPane().add(getPfPw1());
		frmSignUp.getContentPane().add(getLblPw_2());
		frmSignUp.getContentPane().add(getPfPw2());
		frmSignUp.getContentPane().add(getLblIdcheck());
		frmSignUp.getContentPane().add(getLblPwcheck());
		frmSignUp.getContentPane().add(getCbPwview());
		frmSignUp.getContentPane().add(getLblName());
		frmSignUp.getContentPane().add(getLblTel());
		frmSignUp.getContentPane().add(getLblAddress());
		frmSignUp.getContentPane().add(getLblSingupicon());
		frmSignUp.getContentPane().add(getLblEmail());
		frmSignUp.getContentPane().add(getLblPw_2_1_1_1_1_1());
		frmSignUp.getContentPane().add(getTfName());
		frmSignUp.getContentPane().add(getTfTel());
		frmSignUp.getContentPane().add(getTfAddress());
		frmSignUp.getContentPane().add(getTfEmail());
		frmSignUp.getContentPane().add(getTfEmail2());
		frmSignUp.getContentPane().add(getLblAnswer());
		frmSignUp.getContentPane().add(getTfAnswer());
		frmSignUp.getContentPane().add(getLblNick());
		frmSignUp.getContentPane().add(getTfNick());
		frmSignUp.getContentPane().add(getLblPhoto());
		frmSignUp.getContentPane().add(getTfPhotowhere());
		frmSignUp.getContentPane().add(getLblNewLabel());
		frmSignUp.getContentPane().add(getLblNewLabel_1());
		frmSignUp.getContentPane().add(getLblNewLabel_2());
		frmSignUp.getContentPane().add(getLblPreview());
		frmSignUp.getContentPane().add(getCbQuestion());
		frmSignUp.getContentPane().add(getCbEmail());
		frmSignUp.getContentPane().add(getLblBackbtn());
		frmSignUp.getContentPane().add(getLblSignUp());
		frmSignUp.getContentPane().add(getLblPwlimit());
		frmSignUp.getContentPane().add(getLblBackground());
	}
	private JLabel getLblSignUp() {
		if (lblSignUp == null) {
			lblSignUp = new JLabel("Sign Up");
			lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
			lblSignUp.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
			lblSignUp.setBounds(0, 0, 375, 69);
		}
		return lblSignUp;
	}
	private JLabel getLblSingupicon() {
		if (lblSingupicon == null) {
			lblSingupicon = new JLabel("");
			lblSingupicon.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/signupicon/signupicon.png"));
			lblSingupicon.setBounds(69, 9, 52, 60);
		}
		return lblSingupicon;
	}
	
	// Sign Btn
	private JLabel getBtnSignup() {
		if (btnSignup == null) {
			btnSignup = new JLabel("");
			btnSignup.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
                    int i_chk = insertFieldCheck();
                    if(i_chk == 0) {
                        if(idcheck== true && pwcheck ==true) {
                            insertAction();
                            Login1 loginPage = new Login1();
                            loginPage.main(null);
                            frmSignUp.setVisible(false);
                        }

                        if(idcheck== false) {
                            JOptionPane.showMessageDialog(null, "아이디 `체크를 확인해주세요!");
                        }
                    }
				}
			});
			btnSignup.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/SignupBtn.png"));
			btnSignup.setBounds(265, 724, 80, 40);
		}
		return btnSignup;
	}
	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID");
			lblId.setHorizontalAlignment(SwingConstants.CENTER);
			lblId.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
			lblId.setBounds(25, 101, 36, 32);
		}
		return lblId;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setColumns(10);
			tfId.setBackground(new Color(236, 224, 209));
			tfId.setBounds(82, 101, 171, 32);
		}
		return tfId;
	}
	private JLabel getLblPw() {
		if (lblPw == null) {
			lblPw = new JLabel("PW");
			lblPw.setHorizontalAlignment(SwingConstants.CENTER);
			lblPw.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
			lblPw.setBounds(25, 145, 36, 32);
		}
		return lblPw;
	}
	private JPasswordField getPfPw1() {
		if (pfPw1 == null) {
			pfPw1 = new JPasswordField();
			pfPw1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
                    char [] pass = pfPw1.getPassword();
                    String passString = new String(pass);
                    char [] pass1 = pfPw2.getPassword();
                    String passString1 = new String(pass1);
                       passString1 = passString1.replaceAll(" ", "");

                    if (passString.length() >= 4 && passString.length() <= 12) {
                        int num=passString.length();
                        lblPwlimit.setText("OK("+num+"글자입니다.)");
                        lblPwlimit.setForeground(Color.decode("#1D0BE5"));
                        pfPw2.setEditable(true);
                    } else if(passString.length()==0) {
                    	lblPwlimit.setText("");
                    }
                    else if(!(passString.length() >= 4 && passString.length() <= 12)) {
                        int num=passString.length();
                        lblPwlimit.setText("비밀번호는 4~12글자로 해주세요.(현재"+num+"글자입니다.)");
                        lblPwlimit.setForeground(new Color(255, 0, 0));
                        pfPw2.setEditable(false);  // 조건 안 맞을 경우 입력하지 못하게 막기
                        pfPw2.setText("");  // 조건 안 맞을 경우 Pw 확인 지워지기
                    }

                    if(passString.equals(passString1)) {
                    	lblPwcheck.setText("일치합니다");
                        pwcheck = true;
                        lblPwcheck.setForeground(Color.decode("#1D0BE5"));

                    }
                    if(passString.equals("")||passString1.equals("")){  // 한 곳이 비어도 표시되지 않도록
                    	lblPwcheck.setText("");


                    }
                    else if(!passString.equals (passString1)){
                    	lblPwcheck.setText("비밀번호를 확인하세요");
                    	lblPwcheck.setForeground(new Color(255,0,0));

                    }        passString = passString.replaceAll(" ", "");  // 스페이스바 사용 금지
				}
			});
			pfPw1.setBackground(new Color(236, 224, 209));
			pfPw1.setBounds(82, 145, 171, 32);
		}
		return pfPw1;
	}
	private JLabel getLblPw_2() {
		if (lblPw_2 == null) {
			lblPw_2 = new JLabel("PW 확인");
			lblPw_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblPw_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
			lblPw_2.setBounds(25, 189, 52, 32);
		}
		return lblPw_2;
	}
	private JPasswordField getPfPw2() {
		if (pfPw2 == null) {
			pfPw2 = new JPasswordField();
			pfPw2.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
                    char [] pass = pfPw1.getPassword();
                    String passString = new String(pass);
                    char [] pass1 = pfPw2.getPassword();
                    String passString1 = new String(pass1);
                    passString = passString.replaceAll(" ", "");
                    passString1 = passString1.replaceAll(" ", "");
                    pwcheck = false;
                    if(passString.equals(passString1)) {
                        lblPwcheck.setText("일치합니다");
                        pwcheck = true;
                        lblPwcheck.setForeground(Color.decode("#1D0BE5"));

                    }
                    if(passString1.equals("")||passString.equals("")){
                    	lblPwcheck.setText("");


                    }
                    else if(!passString.equals (passString1)){
                    	lblPwcheck.setText("비밀번호를 확인하세요");
                    	lblPwcheck.setForeground(new Color(255,0,0));

                    }
				}
			});
			pfPw2.setBackground(new Color(236, 224, 209));
			pfPw2.setBounds(82, 189, 171, 32);
		}
		return pfPw2;
	}
	
	// ID check
	private JLabel getLblIdcheck() {
		if (lblIdcheck == null) {
			lblIdcheck = new JLabel("");
			lblIdcheck.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					idDuplicatedCheck();
				}
			});
			lblIdcheck.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/signupicon/idcheckbtn.png"));
			lblIdcheck.setBounds(267, 101, 44, 32);
		}
		return lblIdcheck;
	}
	private JLabel getLblPwcheck() {
		if (lblPwcheck == null) {
			lblPwcheck = new JLabel("");
			lblPwcheck.setFont(new Font("Lucida Grande", Font.ITALIC, 10));
			lblPwcheck.setBounds(82, 217, 171, 16);
		}
		return lblPwcheck;
	}
	
	// Pw View
	private JCheckBox getCbPwview() {
		if (cbPwview == null) {
			cbPwview = new JCheckBox("Pw 표시");
			cbPwview.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
                    if(cbPwview.isSelected()) {
                        pfPw1.setEchoChar((char)0);
                    }else {
                        pfPw1.setEchoChar('●');
                    }
				}
			});
			cbPwview.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
			cbPwview.setBounds(265, 149, 80, 23);
		}
		return cbPwview;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name");
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			lblName.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
			lblName.setBounds(25, 233, 52, 32);
		}
		return lblName;
	}
	private JLabel getLblTel() {
		if (lblTel == null) {
			lblTel = new JLabel("Tel");
			lblTel.setHorizontalAlignment(SwingConstants.CENTER);
			lblTel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
			lblTel.setBounds(25, 277, 52, 32);
		}
		return lblTel;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address");
			lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
			lblAddress.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
			lblAddress.setBounds(25, 321, 56, 32);
		}
		return lblAddress;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email");
			lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
			lblEmail.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
			lblEmail.setBounds(25, 365, 56, 32);
		}
		return lblEmail;
	}
	private JLabel getLblPw_2_1_1_1_1_1() {
		if (lblPw_2_1_1_1_1_1 == null) {
			lblPw_2_1_1_1_1_1 = new JLabel("Question");
			lblPw_2_1_1_1_1_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
			lblPw_2_1_1_1_1_1.setBounds(25, 455, 69, 32);
		}
		return lblPw_2_1_1_1_1_1;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBackground(new Color(236, 224, 209));
			tfName.setBounds(82, 233, 171, 32);
		}
		return tfName;
	}
	private JTextField getTfTel() {
		if (tfTel == null) {
			tfTel = new JTextField();
			tfTel.setColumns(10);
			tfTel.setBackground(new Color(236, 224, 209));
			tfTel.setBounds(82, 277, 171, 32);
		}
		return tfTel;
	}
	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setColumns(10);
			tfAddress.setBackground(new Color(236, 224, 209));
			tfAddress.setBounds(82, 321, 171, 32);
		}
		return tfAddress;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setColumns(10);
			tfEmail.setBackground(new Color(236, 224, 209));
			tfEmail.setBounds(82, 365, 96, 32);
		}
		return tfEmail;
	}
	private JTextField getTfEmail2() {
		if (tfEmail2 == null) {
			tfEmail2 = new JTextField();
			tfEmail2.setColumns(10);
			tfEmail2.setBackground(new Color(236, 224, 209));
			tfEmail2.setBounds(174, 365, 96, 32);
		}
		return tfEmail2;
	}
	private JLabel getLblAnswer() {
		if (lblAnswer == null) {
			lblAnswer = new JLabel("Answer");
			lblAnswer.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
			lblAnswer.setBounds(25, 499, 69, 32);
		}
		return lblAnswer;
	}
	private JTextField getTfAnswer() {
		if (tfAnswer == null) {
			tfAnswer = new JTextField();
			tfAnswer.setColumns(10);
			tfAnswer.setBackground(new Color(236, 224, 209));
			tfAnswer.setBounds(82, 502, 171, 32);
		}
		return tfAnswer;
	}
	private JLabel getLblNick() {
		if (lblNick == null) {
			lblNick = new JLabel("NIck");
			lblNick.setHorizontalAlignment(SwingConstants.CENTER);
			lblNick.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
			lblNick.setBounds(25, 409, 56, 32);
		}
		return lblNick;
	}
	private JTextField getTfNick() {
		if (tfNick == null) {
			tfNick = new JTextField();
			tfNick.setColumns(10);
			tfNick.setBackground(new Color(236, 224, 209));
			tfNick.setBounds(82, 409, 171, 32);
		}
		return tfNick;
	}
	private JLabel getLblPhoto() {
		if (lblPhoto == null) {
			lblPhoto = new JLabel("Photo");
			lblPhoto.setHorizontalAlignment(SwingConstants.CENTER);
			lblPhoto.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
			lblPhoto.setBounds(25, 543, 69, 32);
		}
		return lblPhoto;
	}
	private JTextField getTfPhotowhere() {
		if (tfPhotowhere == null) {
			tfPhotowhere = new JTextField();
			tfPhotowhere.setColumns(10);
			tfPhotowhere.setBackground(new Color(236, 224, 209));
			tfPhotowhere.setBounds(82, 546, 171, 32);
		}
		return tfPhotowhere;
	}
	
	// Select Image
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					FilePath();
				}
			});
			lblNewLabel.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/signupicon/selectbtn.png"));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(265, 551, 44, 25);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("사진크기최대 145*145");
			lblNewLabel_1.setBounds(82, 575, 171, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Preview");
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(25, 603, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblPreview() {
		if (lblPreview == null) {
			lblPreview = new JLabel("");
			lblPreview.setHorizontalAlignment(SwingConstants.CENTER);
			lblPreview.setBounds(33, 631, 145, 145);
		}
		return lblPreview;
	}
	private JLabel getLblBackground() {
		if (lblBackground == null) {
			lblBackground = new JLabel("");
			lblBackground.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/Loginbackground.png"));
			lblBackground.setBounds(0, 0, 375, 784);
		}
		return lblBackground;
	}
	private JComboBox getCbQuestion() {
		if (cbQuestion == null) {
			cbQuestion = new JComboBox();
			cbQuestion.setModel(new DefaultComboBoxModel(new String[] {"당신의 출생년도는?", "당신의 아버지의 성함은?", "당신의 어머니의 성함은?", "가장 아끼는 보물 1호는?", "당신이 졸업한 초등학교의 이름은?", "당신이 졸업한 중학교의 이름은?", "당신이 졸업한 고등학교의 이름은?"}));
			cbQuestion.setBounds(92, 459, 206, 27);
		}
		return cbQuestion;
	}
	// Email Select
	private JComboBox getCbEmail() {
		if (cbEmail == null) {
			cbEmail = new JComboBox();
			cbEmail.setForeground(Color.BLACK);
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
			cbEmail.setBounds(265, 369, 104, 27);
		}
		return cbEmail;
	}
	// go to LoginPage
	private JLabel getLblBackbtn() {
		if (lblBackbtn == null) {
			lblBackbtn = new JLabel("");
			lblBackbtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Login1 login = new Login1();
					login.main(null);
					frmSignUp.setVisible(false);
				}
			});
			lblBackbtn.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/signupicon/backbtn.png"));
			lblBackbtn.setHorizontalAlignment(SwingConstants.CENTER);
			lblBackbtn.setBounds(6, 19, 40, 40);
		}
		return lblBackbtn;
	}
	private JLabel getLblPwlimit() {
		if (lblPwlimit == null) {
			lblPwlimit = new JLabel("");
			lblPwlimit.setFont(new Font("Lucida Grande", Font.ITALIC, 10));
			lblPwlimit.setBounds(82, 175, 171, 16);
		}
		return lblPwlimit;
	}
	
	// Method
	
	// ID Check
    private void idDuplicatedCheck() {
        int check =0;
        //아이디 값을 가져와서 공백을 제거함
        String custid = tfId.getText().trim();
        Daosignup dao = new Daosignup(custid);
        check = dao.idDuplicatedCheck();
        if(check==1) {
            JOptionPane.showMessageDialog(null, "ID가 중복됩니다. 다시 입력해주세요");
            tfId.setText("");
            idcheck = false;

        }if(check==0) {
            JOptionPane.showMessageDialog(null, "사용가능한 ID 입니다!");
            idcheck = true;
        }
    }
    
    // InsertFieldCheck
    private int insertFieldCheck() {
        int i = 0;
        String message = "";

        if(tfId.getText().trim().length() == 0) {
            i++;
            message = "ID ";
            arraylist.add(message);
            tfId.requestFocus();//그위치에 가서 커서가 깜빡임
        }

        if(tfName.getText().trim().length() == 0) {
            i++;
            message = "이름 ";
            arraylist.add(message);
            tfName.requestFocus();//그위치에 가서 커서가 깜빡임

        }

        char[] pass1 = pfPw1.getPassword();
        char[] pass2 = pfPw2.getPassword();

        String passString1 = new String(pass1); //char를 string으로...
        String passString2 = new String(pass2); //char를 string으로...

        if(passString1.trim().length()==0) {
            i++;
            message = "비밀번호 ";
            arraylist.add(message);
            pfPw1.requestFocus();//그위치에 가서 커서가 깜빡임

        }

        if(tfTel.getText().trim().length() == 0) {
            i++;
            message = "번호 ";
            arraylist.add(message);
            tfTel.requestFocus();//그위치에 가서 커서가 깜빡임
        }

        if(tfAddress.getText().trim().length() == 0) {
            i++;
            message = "주소 ";
            arraylist.add(message);
            tfAddress.requestFocus();//그위치에 가서 커서가 깜빡임
        }
        
        if(tfNick.getText().trim().length() == 0) {
            i++;
            message = "닉네임 ";
            arraylist.add(message);
            tfId.requestFocus();//그위치에 가서 커서가 깜빡임
        }
        
        if(tfEmail.getText().trim().length() == 0) {  // 이메일 추가해야 함
            i++;
            message = "이메일 ";
            arraylist.add(message);
            tfId.requestFocus();//그위치에 가서 커서가 깜빡임
        }

        if(i>0) {
            JOptionPane.showMessageDialog(null, arraylist+"입력하세요!");
            arraylist.clear();
        }
        return i;
    }
    
	//파일경로열기
	private void FilePath() {
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("jpeg, JPG, PNG, BMP", "jpg","png","bmp");
		chooser.setFileFilter(filter);
		
		int ret = chooser.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다!", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String filePath = chooser.getSelectedFile().getPath();
		tfPhotowhere.setText(filePath);
		lblPhoto.setIcon(new ImageIcon(filePath));
		lblPhoto.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
    
    // InsertAction
    private int insertAction() {
        int check =0;
        char[] pass1 = pfPw1.getPassword();




        String custid = tfId.getText().trim();
        String ctelno = tfTel.getText().trim();
        String cname = tfName.getText().trim();
        String custpw = new String(pass1); //char를 string으로...
        String cnickname = tfNick.getText().trim();
        String caddress = tfAddress.getText().trim();  
        String cquestion = cbQuestion.getSelectedItem().toString();
        String canswer = tfAnswer.getText().trim();
        String cemail = tfEmail.getText().trim() + tfEmail2.getText();  
        FileInputStream cimage = null; 
        
        
        // Image input & Default Image setting
		File file = new File(tfPhotowhere.getText());
		try {
			if (tfPhotowhere.getText().length() == 0) {
				File file1 = new File("./DefaultImage.png");
				cimage = new FileInputStream(file1);
			} else {
				cimage = new FileInputStream(file);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Daosignup dao = new Daosignup(custid, ctelno, cname, custpw, cnickname, caddress, cquestion, canswer, cemail,
				cimage);

		boolean ok = dao.insertAction();

		if (ok == true) {
			JOptionPane.showMessageDialog(null, tfName.getText() + "님의 가입을 축하드립니다!");
			check = 1;
			return check;
		} else {
			JOptionPane.showMessageDialog(null, "DB 작업중 문제가 발생했습니다. \n 행정실에 문의 하세요!.");
			check = 0;
			return check;
		}
	}
	
	
	
	
	
	
} //End
