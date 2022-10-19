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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.javalec.dao.Daomypage;
import com.javalec.dto.Dtocustomer;
import com.javalec.style.Style;
import com.javalec.util.DBConnect;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MypageUpdate {

	private JFrame frmMypage;
	private JLabel lblMypagebtn;
	private JLabel lblLikebtn;
	private JLabel lblCartbtn;
	private JLabel lblMypage;
	private JLabel lblSingupicon;
	private JLabel lblId;
	private JTextField tfId;
	private JLabel lblPw;
	private JPasswordField pfPw1;
	private JLabel lblPw_2;
	private JPasswordField pfPw2;
	private JLabel lblName;
	private JTextField tfName;
	private JLabel lblTel;
	private JTextField tfTel;
	private JLabel lblAddress;
	private JTextField tfAddress;
	private JLabel lblEmail;
	private JTextField tfEmail1;
	private JComboBox cbEmail;
	private JLabel lblNick;
	private JTextField tfNickname;
	private JLabel lblPw_2_1_1_1_1_1;
	private JComboBox cbQuestion;
	private JLabel lblAnswer;
	private JTextField tfAnswer;
	private JLabel lblPhoto;
	private JTextField tfPhotowhere;
	private JLabel lblSelect;
	private JLabel lblNewLabel_1_1;
	private JLabel lblPreview;
	private JLabel lblUpdatebtn;
	private JLabel lblPwlimit;
	private JLabel lblPwcheck;
	private JLabel lblIdcheck;
	
	// Field
	  private boolean pwcheck = false;
	  private JLabel lblDeletebtn;
	  private JTextField tfQuestion;
	  private JLabel lblPw_2_1_1_1_1_1_1;
	  JFileChooser chooser = new JFileChooser();
	  String filePath;
	  private JTextField tfEmail2;
	  private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MypageUpdate window = new MypageUpdate();
					window.frmMypage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MypageUpdate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMypage = new JFrame();
		frmMypage.getContentPane().setBackground(Color.WHITE);
		frmMypage.setBackground(Color.WHITE);
		frmMypage.setTitle("Mypage");
		frmMypage.setBounds(600, 100, 375, 812);
		frmMypage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMypage.getContentPane().setLayout(null);
		frmMypage.getContentPane().add(getLblNewLabel_1());
		frmMypage.getContentPane().add(getLblMypagebtn());
		frmMypage.getContentPane().add(getLblLikebtn());
		frmMypage.getContentPane().add(getLblCartbtn());
		frmMypage.getContentPane().add(getLblSingupicon());
		frmMypage.getContentPane().add(getLblMypage());
		frmMypage.getContentPane().add(getLblId());
		frmMypage.getContentPane().add(getTfId());
		frmMypage.getContentPane().add(getLblPw());
		frmMypage.getContentPane().add(getPfPw1());
		frmMypage.getContentPane().add(getLblPw_2());
		frmMypage.getContentPane().add(getPfPw2());
		frmMypage.getContentPane().add(getLblName());
		frmMypage.getContentPane().add(getTfName());
		frmMypage.getContentPane().add(getLblTel());
		frmMypage.getContentPane().add(getTfTel());
		frmMypage.getContentPane().add(getLblAddress());
		frmMypage.getContentPane().add(getTfAddress());
		frmMypage.getContentPane().add(getLblEmail());
		frmMypage.getContentPane().add(getTfEmail1());
		frmMypage.getContentPane().add(getCbEmail());
		frmMypage.getContentPane().add(getLblNick());
		frmMypage.getContentPane().add(getTfNickname());
		frmMypage.getContentPane().add(getLblPw_2_1_1_1_1_1());
		frmMypage.getContentPane().add(getCbQuestion());
		frmMypage.getContentPane().add(getLblAnswer());
		frmMypage.getContentPane().add(getTfAnswer());
		frmMypage.getContentPane().add(getLblPhoto());
		frmMypage.getContentPane().add(getTfPhotowhere());
		frmMypage.getContentPane().add(getLblSelect());
		frmMypage.getContentPane().add(getLblNewLabel_1_1());
		frmMypage.getContentPane().add(getLblPreview());
		frmMypage.getContentPane().add(getLblUpdatebtn());
		frmMypage.getContentPane().add(getLblPwlimit());
		frmMypage.getContentPane().add(getLblPwcheck());
		frmMypage.getContentPane().add(getLblIdcheck());
		frmMypage.getContentPane().add(getLblDeletebtn());
		frmMypage.getContentPane().add(getTfQuestion());
		frmMypage.getContentPane().add(getLblPw_2_1_1_1_1_1_1());
		frmMypage.getContentPane().add(getTfEmail2());
		frmMypage.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				searchAction();
			}
		});
	}
	private JLabel getLblMypagebtn() {
		if (lblMypagebtn == null) {
			lblMypagebtn = new JLabel("");
			lblMypagebtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Mypage mypage = new Mypage();
					mypage.setVisible(true);
					frmMypage.setVisible(false);
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblMypagebtn.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/pressProfile.png"));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblMypagebtn.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/Profilebtn.png"));
				}
			});
			lblMypagebtn.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/Profilebtn.png"));
			lblMypagebtn.setBounds(320, 736, 24, 24);
		}
		return lblMypagebtn;
	}
	private JLabel getLblLikebtn() {
		if (lblLikebtn == null) {
			lblLikebtn = new JLabel("");
			lblLikebtn.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/Likebtn.png"));
			lblLikebtn.setBounds(107, 736, 24, 24);
		}
		return lblLikebtn;
	}
	private JLabel getLblCartbtn() {
		if (lblCartbtn == null) {
			lblCartbtn = new JLabel("");
			lblCartbtn.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/cartbtn.png"));
			lblCartbtn.setBounds(245, 736, 24, 24);
		}
		return lblCartbtn;
	}
	private JLabel getLblMypage() {
		if (lblMypage == null) {
			lblMypage = new JLabel("");
			lblMypage.setIcon(new ImageIcon(Mypage.class.getResource("/com/javalec/loginimages/updateMypage.png")));
			lblMypage.setHorizontalAlignment(SwingConstants.CENTER);
			lblMypage.setFont(new Font("Apple LiGothic", Font.PLAIN, 25));
			lblMypage.setBounds(14, 6, 330, 50);
		}
		return lblMypage;
	}
	private JLabel getLblSingupicon() {
		if (lblSingupicon == null) {
			lblSingupicon = new JLabel("");
			lblSingupicon.setHorizontalAlignment(SwingConstants.CENTER);
			lblSingupicon.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/Mypageicon.png"));
			lblSingupicon.setBounds(60, 0, 52, 60);
		}
		return lblSingupicon;
	}
	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID");
			lblId.setHorizontalAlignment(SwingConstants.RIGHT);
			lblId.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			lblId.setBounds(48, 70, 36, 32);
		}
		return lblId;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setColumns(10);
			tfId.setBackground(Color.LIGHT_GRAY);
			tfId.setBounds(90, 68, 215, 32);
		}
		return tfId;
	}
	private JLabel getLblPw() {
		if (lblPw == null) {
			lblPw = new JLabel("PW");
			lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPw.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			lblPw.setBounds(48, 114, 36, 32);
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
			pfPw1.setBackground(Color.LIGHT_GRAY);
			pfPw1.setBounds(90, 112, 215, 32);
		}
		return pfPw1;
	}
	private JLabel getLblPw_2() {
		if (lblPw_2 == null) {
			lblPw_2 = new JLabel("PW 확인");
			lblPw_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPw_2.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			lblPw_2.setBounds(32, 158, 52, 32);
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
			pfPw2.setBackground(Color.LIGHT_GRAY);
			pfPw2.setBounds(90, 156, 215, 32);
		}
		return pfPw2;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name");
			lblName.setHorizontalAlignment(SwingConstants.RIGHT);
			lblName.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			lblName.setBounds(32, 202, 52, 32);
		}
		return lblName;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBackground(Color.LIGHT_GRAY);
			tfName.setBounds(90, 200, 215, 32);
		}
		return tfName;
	}
	private JLabel getLblTel() {
		if (lblTel == null) {
			lblTel = new JLabel("Tel");
			lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTel.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			lblTel.setBounds(32, 246, 52, 32);
		}
		return lblTel;
	}
	private JTextField getTfTel() {
		if (tfTel == null) {
			tfTel = new JTextField();
			tfTel.setColumns(10);
			tfTel.setBackground(Color.LIGHT_GRAY);
			tfTel.setBounds(90, 244, 215, 32);
		}
		return tfTel;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address");
			lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAddress.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			lblAddress.setBounds(28, 290, 56, 32);
		}
		return lblAddress;
	}
	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setColumns(10);
			tfAddress.setBackground(Color.LIGHT_GRAY);
			tfAddress.setBounds(90, 288, 215, 32);
		}
		return tfAddress;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email");
			lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
			lblEmail.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			lblEmail.setBounds(28, 334, 56, 32);
		}
		return lblEmail;
	}
	private JTextField getTfEmail1() {
		if (tfEmail1 == null) {
			tfEmail1 = new JTextField();
			tfEmail1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tfEmail1.setText("");
				}
			});
			tfEmail1.setColumns(10);
			tfEmail1.setBackground(Color.LIGHT_GRAY);
			tfEmail1.setBounds(90, 332, 215, 32);
		}
		return tfEmail1;
	}
	private JTextField getTfEmail2() {
		if (tfEmail2 == null) {
			tfEmail2 = new JTextField();
			tfEmail2.setColumns(10);
			tfEmail2.setBackground(Color.LIGHT_GRAY);
			tfEmail2.setBounds(90, 363, 80, 32);
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
			cbEmail.setForeground(Color.BLACK);
			cbEmail.setModel(new DefaultComboBoxModel(new String[] {"직접입력..", "gmail.com", "naver.com", "daum.net", "hanmail.com", "nate.com"}));
			cbEmail.setBounds(173, 367, 104, 27);
		}
		return cbEmail;
	}
	private JLabel getLblNick() {
		if (lblNick == null) {
			lblNick = new JLabel("NIck");
			lblNick.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNick.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			lblNick.setBounds(28, 396, 56, 32);
		}
		return lblNick;
	}
	private JTextField getTfNickname() {
		if (tfNickname == null) {
			tfNickname = new JTextField();
			tfNickname.setColumns(10);
			tfNickname.setBackground(Color.LIGHT_GRAY);
			tfNickname.setBounds(90, 394, 215, 32);
		}
		return tfNickname;
	}
	private JLabel getLblPw_2_1_1_1_1_1() {
		if (lblPw_2_1_1_1_1_1 == null) {
			lblPw_2_1_1_1_1_1 = new JLabel("Question");
			lblPw_2_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPw_2_1_1_1_1_1.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			lblPw_2_1_1_1_1_1.setBounds(15, 427, 69, 32);
		}
		return lblPw_2_1_1_1_1_1;
	}
	private JComboBox getCbQuestion() {
		if (cbQuestion == null) {
			cbQuestion = new JComboBox();
			cbQuestion.setModel(new DefaultComboBoxModel(new String[] {"당신의 출생년도는?", "당신의 아버지의 성함은?", "당신의 어머니의 성함은?", "가장 아끼는 보물 1호는?", "당신이 졸업한 초등학교의 이름은?", "당신이 졸업한 중학교의 이름은?", "당신이 졸업한 고등학교의 이름은?"}));
			cbQuestion.setBounds(90, 429, 206, 27);
		}
		return cbQuestion;
	}
	private JLabel getLblAnswer() {
		if (lblAnswer == null) {
			lblAnswer = new JLabel("Answer");
			lblAnswer.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAnswer.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			lblAnswer.setBounds(15, 489, 69, 32);
		}
		return lblAnswer;
	}
	private JTextField getTfAnswer() {
		if (tfAnswer == null) {
			tfAnswer = new JTextField();
			tfAnswer.setColumns(10);
			tfAnswer.setBackground(Color.LIGHT_GRAY);
			tfAnswer.setBounds(90, 487, 215, 32);
		}
		return tfAnswer;
	}
	private JLabel getLblPhoto() {
		if (lblPhoto == null) {
			lblPhoto = new JLabel("Photo");
			lblPhoto.setHorizontalAlignment(SwingConstants.CENTER);
			lblPhoto.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			lblPhoto.setBounds(33, 528, 69, 32);
		}
		return lblPhoto;
	}
	private JTextField getTfPhotowhere() {
		if (tfPhotowhere == null) {
			tfPhotowhere = new JTextField();
			tfPhotowhere.setColumns(10);
			tfPhotowhere.setBackground(Color.LIGHT_GRAY);
			tfPhotowhere.setBounds(90, 531, 215, 32);
		}
		return tfPhotowhere;
	}
	// select file
	private JLabel getLblSelect() {
		if (lblSelect == null) {
			lblSelect = new JLabel("선택");
			lblSelect.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					FilePath();
				}
			});
			lblSelect.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/signupicon/selectbtn.png"));
			lblSelect.setHorizontalAlignment(SwingConstants.CENTER);
			lblSelect.setBounds(308, 534, 44, 25);
		}
		return lblSelect;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("사진크기최대 145*145");
			lblNewLabel_1_1.setBounds(193, 560, 145, 16);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblPreview() {
		if (lblPreview == null) {
			lblPreview = new JLabel("");
			lblPreview.setHorizontalAlignment(SwingConstants.CENTER);
			lblPreview.setBounds(28, 568, 145, 145);
		}
		return lblPreview;
	}
	private JLabel getLblUpdatebtn() {
		if (lblUpdatebtn == null) {
			lblUpdatebtn = new JLabel("");
			lblUpdatebtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(tfPhotowhere.getText().length()==0) {
						updateAction2();
					}else {
						updateAction();
					}
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					lblUpdatebtn.setIcon(new ImageIcon(MypageUpdate.class.getResource("/com/javalec/loginimages/updatebtnclicked.png")));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblUpdatebtn.setIcon(new ImageIcon(MypageUpdate.class.getResource("/com/javalec/loginimages/updatebtn.png")));
				}
			});
			lblUpdatebtn.setIcon(new ImageIcon(MypageUpdate.class.getResource("/com/javalec/loginimages/updatebtn.png")));
			lblUpdatebtn.setBounds(196, 619, 156, 59);
		}
		return lblUpdatebtn;
	}
	private JLabel getLblPwlimit() {
		if (lblPwlimit == null) {
			lblPwlimit = new JLabel("");
			lblPwlimit.setFont(new Font("Lucida Grande", Font.ITALIC, 10));
			lblPwlimit.setBounds(82, 136, 171, 16);
		}
		return lblPwlimit;
	}
	private JLabel getLblPwcheck() {
		if (lblPwcheck == null) {
			lblPwcheck = new JLabel("");
			lblPwcheck.setFont(new Font("Lucida Grande", Font.ITALIC, 10));
			lblPwcheck.setBounds(82, 179, 171, 16);
		}
		return lblPwcheck;
	}
	private JLabel getLblIdcheck() {
		if (lblIdcheck == null) {
			lblIdcheck = new JLabel("");
			lblIdcheck.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/signupicon/idcheckbtn.png"));
			lblIdcheck.setBounds(254, 387, 44, 32);
		}
		return lblIdcheck;
	}
	private JLabel getLblDeletebtn() {
		if (lblDeletebtn == null) {
			lblDeletebtn = new JLabel("");
			lblDeletebtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
		               Daomypage dao = new Daomypage();
		               dao.deleteAction(); // 탈퇴하기
		               JOptionPane.showMessageDialog(null, "계정 탈퇴가 완료되었습니다.");
		               frmMypage.setVisible(false);
		               Login1 window = new Login1();
		               window.main(null);
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblDeletebtn.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/pressDelete.png"));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblDeletebtn.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/Deletebtn.png"));
				}
			});
			lblDeletebtn.setIcon(new ImageIcon(MypageUpdate.class.getResource("/com/javalec/loginimages/out.png")));
			lblDeletebtn.setBounds(196, 690, 156, 59);
		}
		return lblDeletebtn;
	}
	private JTextField getTfQuestion() {
		if (tfQuestion == null) {
			tfQuestion = new JTextField();
			tfQuestion.setColumns(10);
			tfQuestion.setBackground(Color.LIGHT_GRAY);
			tfQuestion.setBounds(90, 453, 215, 32);
		}
		return tfQuestion;
	}
	private JLabel getLblPw_2_1_1_1_1_1_1() {
		if (lblPw_2_1_1_1_1_1_1 == null) {
			lblPw_2_1_1_1_1_1_1 = new JLabel("Now Que");
			lblPw_2_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPw_2_1_1_1_1_1_1.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			lblPw_2_1_1_1_1_1_1.setBounds(15, 455, 69, 32);
		}
		return lblPw_2_1_1_1_1_1_1;
	}
	
	// Method
	
	   // -------------------- 고객 정보 출력 메소드 --------------------
	   private void searchAction() {
	      Daomypage dao = new Daomypage(); // Daomypage 클래스 인스턴스 선언
	      Dtocustomer dtoList = dao.selectList();


	      tfId.setText(dtoList.getCustid());
	      tfName.setText(dtoList.getCname());
	      pfPw1.setText(dtoList.getCustpw());
	      tfTel.setText(dtoList.getCtelno());
	      tfAddress.setText(dtoList.getCaddress());
	      tfEmail1.setText(dtoList.getCemail());
	      tfNickname.setText(dtoList.getCnickname());
	      tfQuestion.setText(dtoList.getCquestion());
	      tfAnswer.setText(dtoList.getCanswer());
	      
	        // Image처리
	        // File name이 틀려야 즉각 보여주기가 가능하여   
	        // ShareVar에서 int값으로 정의하여 계속 증가하게 하여 file name으로 사용후 삭제
	        
	        // Image 소스확인
			filePath = Integer.toString(DBConnect.filename);
			//tfPhotowhere.setText(filePath);
			Style style = new Style();
			lblPreview.setIcon(style.imageSize145(filePath));
			lblPreview.setHorizontalAlignment(SwingConstants.CENTER);
			
			File file = new File(filePath);
			file.delete();
			
			tfPhotowhere.setText("");

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
	
		// Data 수정
		private void updateAction() {
			
			String pw = pfPw1.getText().trim();
			String name = tfName.getText().trim();
			String telno = tfTel.getText().trim();
			String address = tfAddress.getText().trim();
			String email = tfEmail1.getText().trim()+tfEmail2.getText().trim();
			String nickname = tfNickname.getText().trim();
			String question = cbQuestion.getSelectedItem().toString();
			String answer = tfAnswer.getText().trim();
			
			// Image File
			// Image input & Default Image setting
			FileInputStream cimage = null;
				File file = new File(tfPhotowhere.getText());
				try {
					cimage = new FileInputStream(file);

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			Daomypage dbaction = new Daomypage(pw, name, telno, address, email, nickname, question, answer, cimage);
			boolean update = dbaction.UpdateAction();
			if(update == true){
		          JOptionPane.showMessageDialog(null, tfName.getText()+" 님의 정보가 수정 되었습니다.!");                    
			}else{
		          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
			}

		}
		
		
		private void updateAction2() {
			
			String pw = pfPw1.getText().trim();
			String name = tfName.getText().trim();
			String telno = tfTel.getText().trim();
			String address = tfAddress.getText().trim();
			String email = tfEmail1.getText().trim()+tfEmail2.getText().trim();
			String nickname = tfNickname.getText().trim();
			String question = cbQuestion.getSelectedItem().toString();
			String answer = tfAnswer.getText().trim();
			
			
			Daomypage dbaction = new Daomypage(pw, name, telno, address, email, nickname, question, answer);
			boolean update = dbaction.UpdateActionnoimage();
			if(update == true){
		          JOptionPane.showMessageDialog(null, tfName.getText()+" 님의 정보가 수정 되었습니다.!");                    
			}else{
		          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
			}

		}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					CoffeeMain a = new CoffeeMain();
					a.main(null);
					frmMypage.setVisible(false);
					
				}
			});
			lblNewLabel_1.setBounds(14, 9, 52, 50);
		}
		return lblNewLabel_1;
	}
} //END
