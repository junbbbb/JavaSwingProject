package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.javalec.dao.DaoMain;
import com.javalec.dto.DtoMain;
import com.javalec.dto.DtoMenu;
import com.javalec.style.Style;
import com.javalec.util.DBConnect;
import java.awt.Font;

public class CoffeeMain {

	private JFrame CoffeeMain;
	private JLabel lbladver;
	private JLabel lblReco1;
	private JLabel lblReco2;
	private JLabel lblReco3;
	private JLabel lblMypageBtn;
	private JLabel lblOrder;
	private JLabel lblHome;
	private JLabel lblCustomer;
	private JLabel lblPoint;
	public static String[] recommend = new String[3];

	DaoMain dao = new DaoMain();
	private JLabel label;
	int time = 1;
	int i = 1;
	private JLabel lblMenuBar;
	private JLabel lblRecommendFrame;
	private JLabel label_1;
	private JLabel lblMenu;
	private JLabel label_2;
	private JLabel lblRecommendName1;
	private JLabel lblRecommendName1_1;
	private JLabel lblRecommendName1_2;
	private JLabel lblRecommendPrice1;
	private JLabel lblRecommendPrice1_1;
	private JLabel lblRecommendPrice1_2;
	private JLabel lblCartBtn;
	Style style = new Style();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeMain window = new CoffeeMain();
					window.CoffeeMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CoffeeMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		CoffeeMain = new JFrame();
		CoffeeMain.getContentPane().setBackground(Color.WHITE);
		randomMenu();
		CoffeeMain.setTitle("FirstProject(KL) Main");
		CoffeeMain.setBounds(600, 100, 375, 812);
		CoffeeMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CoffeeMain.getContentPane().setLayout(null);
		CoffeeMain.getContentPane().add(getLblMypageBtn());
		CoffeeMain.getContentPane().add(getLblCartBtn());
		CoffeeMain.getContentPane().add(getLblCustomer());
		CoffeeMain.getContentPane().add(getLblReco2());
		CoffeeMain.getContentPane().add(getLblReco3());
		CoffeeMain.getContentPane().add(getLblReco1());
		CoffeeMain.getContentPane().add(getLblOrder());
		CoffeeMain.getContentPane().add(getLblHome());
		CoffeeMain.getContentPane().add(getLblPoint());
		CoffeeMain.getContentPane().add(getLabel());
		CoffeeMain.getContentPane().add(getLbladver());
		CoffeeMain.getContentPane().add(getLblMenuBar());
		CoffeeMain.getContentPane().add(getLabel_1());
		CoffeeMain.getContentPane().add(getLblMenu());
		CoffeeMain.getContentPane().add(getLabel_2());
		CoffeeMain.getContentPane().add(getLblRecommendName1());
		CoffeeMain.getContentPane().add(getLblRecommendName1_1());
		CoffeeMain.getContentPane().add(getLblRecommendName1_2());
		CoffeeMain.getContentPane().add(getLblRecommendPrice1());
		CoffeeMain.getContentPane().add(getLblRecommendPrice1_1());
		CoffeeMain.getContentPane().add(getLblRecommendPrice1_2());
		CoffeeMain.getContentPane().add(getLblRecommendFrame());
		imageSet();
		
		CoffeeMain.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				Timer timer = new Timer();
				TimerTask task = new TimerTask() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
//						if(time % 2 == 0) {					
							countImage();
//						}
//						time++;
					}
				};
				
				timer.schedule(task, 0, 3000);

			}
		});
	}
	private JLabel getLbladver() {
		if (lbladver == null) {
			lbladver = new JLabel("");
			lbladver.setIcon(new ImageIcon(CoffeeMain.class.getResource("/com/javalec/image/adver1.jpeg")));
			lbladver.setHorizontalAlignment(SwingConstants.CENTER);
			lbladver.setBounds(36, 91, 301, 366);
		}
		return lbladver;
	}
	private JLabel getLblReco1() {
		if (lblReco1 == null) {
			lblReco1 = new JLabel("");
			lblReco1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MenuInformation.randomid = recommend[0];
					menuPopup();
					
				}
			});
			lblReco1.setHorizontalAlignment(SwingConstants.CENTER);
			lblReco1.setBounds(28, 538, 77, 77);
		}
		return lblReco1;
	}
	private JLabel getLblReco2() {
		if (lblReco2 == null) {
			lblReco2 = new JLabel("");
			lblReco2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MenuInformation.randomid = recommend[1];
					menuPopup();
				}
			});
			lblReco2.setHorizontalAlignment(SwingConstants.CENTER);
			lblReco2.setBounds(147, 536, 77, 77);
		}
		return lblReco2;
	}
	private JLabel getLblReco3() {
		if (lblReco3 == null) {
			lblReco3 = new JLabel("");
			lblReco3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MenuInformation.randomid = recommend[2];
					menuPopup();
				}
			});
			lblReco3.setHorizontalAlignment(SwingConstants.CENTER);
			lblReco3.setBounds(267, 535, 77, 77);
		}
		return lblReco3;
	}
	private JLabel getLblMypageBtn() {
		if (lblMypageBtn == null) {
			lblMypageBtn = new JLabel("");
			lblMypageBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				Mypage mypage = new Mypage();
				mypage.setVisible(true);
				CoffeeMain.setVisible(false);
				
					
				}
			});
			lblMypageBtn.setHorizontalAlignment(SwingConstants.CENTER);
			lblMypageBtn.setBounds(291, 723, 49, 44);
		}
		return lblMypageBtn;
	}
	private JLabel getLblOrder() {
		if (lblOrder == null) {
			lblOrder = new JLabel("");
			
			lblOrder.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					 CoffeeOrder coffeeorder = new CoffeeOrder();
					 coffeeorder.main(null);
			         CoffeeMain.setVisible(false);
				
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblOrder.setIcon(new ImageIcon(CoffeeMain.class.getResource("/com/javalec/loginimages/orderbtnClicked.png")));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblOrder.setIcon(new ImageIcon());
				}
			});
			lblOrder.setHorizontalAlignment(SwingConstants.CENTER);
			lblOrder.setBounds(161, 698, 60, 60);
		}
		return lblOrder;
	}
	private JLabel getLblHome() {
		if (lblHome == null) {
			lblHome = new JLabel("");
			lblHome.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
//					CoffeeMain main = new CoffeeMain();
//		            main.main(null);
				}
			});
			lblHome.setHorizontalAlignment(SwingConstants.CENTER);
			lblHome.setBounds(31, 723, 47, 43);
		}
		return lblHome;
	}
	
	// M
	private String whoAreYou() {
		DaoMain daoMain = new DaoMain(Login1.id);
		DtoMain dto = daoMain.getNicname();
		
		return dto.getCustnickname();
	}
	private JLabel getLblCustomer() {
		if (lblCustomer == null) {
			lblCustomer = new JLabel(whoAreYou());
			
			lblCustomer.setHorizontalAlignment(SwingConstants.CENTER);
			lblCustomer.setBounds(50, 53, 149, 16);
		}
		return lblCustomer;
	}
	private JLabel getLblPoint() {
		if (lblPoint == null) {
			lblPoint = new JLabel("");
			lblPoint.setIcon(new ImageIcon(CoffeeMain.class.getResource("/com/javalec/loginimages/StampLogo.png")));
			lblPoint.setForeground(new Color(158, 132, 112));
			lblPoint.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					CoffeeMain.setVisible(false);
					Stamp stamp = new Stamp();
					stamp.setVisible(true);
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblPoint.setIcon(new ImageIcon(CoffeeMain.class.getResource("/com/javalec/loginimages/StampLogoClicked.png")));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblPoint.setIcon(new ImageIcon(CoffeeMain.class.getResource("/com/javalec/loginimages/StampLogo.png")));
				}
			});
			lblPoint.setHorizontalAlignment(SwingConstants.CENTER);
			lblPoint.setBounds(299, 40, 63, 49);
		}
		return lblPoint;
	}
	
	// 랜덤으로 추천메뉴 띄우기
	private void randomMenu() {
		ArrayList<String> menuid = dao.selectRandomMenu();
		
		Random random = new Random();
		for(int i = 0; i < 3; i++) {
			int num = random.nextInt(menuid.size());
			recommend[i] = menuid.get(num);
			for(int j = 0; j < i; j++) {
				if(recommend[j].equals(recommend[i])) {
					i--; 
				}
			
			}
		}
	}
	
	// MenuInfo 팝업
	private void menuPopup() {
		MenuInformation info = new MenuInformation();
		info.setVisible(true);
		CoffeeMain.setVisible(false);
	}
	
	// 랜덤메뉴 이미지 세팅
	private void imageSet() {
		
		for(int i = 0; i < 3; i++) {
			if(i == 0) {
				DaoMain.menuid = recommend[i];
				DtoMenu dto = dao.selectMenuInfo();
				lblRecommendName1.setText(dto.getMenuname());
				lblRecommendPrice1.setText(Integer.toString(dto.getMenuprice())+"원");
				
				String filePath = Integer.toString(DBConnect.filename);
				
				lblReco1.setIcon(style.imageSize77(filePath));
				lblReco1.setHorizontalAlignment(SwingConstants.CENTER);
				
				File file = new File(filePath);
				file.delete();
			}else if(i == 1) {
				DaoMain.menuid = recommend[i];
				DtoMenu dto = dao.selectMenuInfo();
				lblRecommendName1_1.setText(dto.getMenuname());
				lblRecommendPrice1_1.setText(Integer.toString(dto.getMenuprice())+"원");
				
				String filePath = Integer.toString(DBConnect.filename);
				
				lblReco2.setIcon(style.imageSize77(filePath));
				lblReco2.setHorizontalAlignment(SwingConstants.CENTER);
				
				File file = new File(filePath);
				file.delete();
			}else {
				DaoMain.menuid = recommend[i];
				DtoMenu dto = dao.selectMenuInfo();
				lblRecommendName1_2.setText(dto.getMenuname());
				lblRecommendPrice1_2.setText(Integer.toString(dto.getMenuprice())+"원");
				
				String filePath = Integer.toString(DBConnect.filename);
				
				lblReco3.setIcon(style.imageSize77(filePath));
				lblReco3.setHorizontalAlignment(SwingConstants.CENTER);
				
				File file = new File(filePath);
				file.delete();
				
			}
		}
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("이번주");
			label.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
			label.setBounds(118, 472, 47, 37);
		}
		return label;
	}
	
	private void countImage() {
		
		int count = dao.countImage();
		if(i > count) {
			i = 1;
		}
		dao.i = i;
		dao.adverImage();
		String filePath = Integer.toString(DBConnect.filename);
		
		lbladver.setIcon(new ImageIcon(filePath));
		lbladver.setHorizontalAlignment(SwingConstants.CENTER);
		
		File file = new File(filePath);
		file.delete();
		i++;
	}
	
	
	private JLabel getLblMenuBar() {
		if (lblMenuBar == null) {
			lblMenuBar = new JLabel("M");
			lblMenuBar.setIcon(new ImageIcon(CoffeeMain.class.getResource("/com/javalec/loginimages/MenuBar.png")));
			lblMenuBar.setBounds(0, 691, 375, 93);
		}
		return lblMenuBar;
	}
	private JLabel getLblRecommendFrame() {
		if (lblRecommendFrame == null) {
			lblRecommendFrame = new JLabel("recommend frame");
			lblRecommendFrame.setIcon(new ImageIcon(CoffeeMain.class.getResource("/com/javalec/loginimages/recommend frame.png")));
			lblRecommendFrame.setBounds(0, 509, 375, 193);
		}
		return lblRecommendFrame;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("추천메뉴!");
			label_1.setFont(new Font("Apple Color Emoji", Font.BOLD, 24));
			label_1.setForeground(new Color(228, 132, 70));
			label_1.setBounds(170, 471, 108, 37);
		}
		return label_1;
	}
	private JLabel getLblMenu() {
		if (lblMenu == null) {
			lblMenu = new JLabel("");
			lblMenu.setIcon(new ImageIcon(CoffeeMain.class.getResource("/com/javalec/loginimages/Category.png")));
			lblMenu.setBounds(26, 42, 47, 32);
		}
		return lblMenu;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("New label");
			label_2.setIcon(new ImageIcon(CoffeeMain.class.getResource("/com/javalec/loginimages/Name.png")));
			label_2.setBounds(95, 44, 188, 32);
		}
		return label_2;
	}
	private JLabel getLblRecommendName1() {
		if (lblRecommendName1 == null) {
			lblRecommendName1 = new JLabel("name1");
			lblRecommendName1.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			lblRecommendName1.setBounds(30, 625, 77, 16);
		}
		return lblRecommendName1;
	}
	private JLabel getLblRecommendName1_1() {
		if (lblRecommendName1_1 == null) {
			lblRecommendName1_1 = new JLabel("name1");
			lblRecommendName1_1.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			lblRecommendName1_1.setBounds(147, 625, 77, 16);
		}
		return lblRecommendName1_1;
	}
	private JLabel getLblRecommendName1_2() {
		if (lblRecommendName1_2 == null) {
			lblRecommendName1_2 = new JLabel("name1");
			lblRecommendName1_2.setFont(new Font("Apple Braille", Font.PLAIN, 13));
			lblRecommendName1_2.setBounds(267, 625, 77, 16);
		}
		return lblRecommendName1_2;
	}
	private JLabel getLblRecommendPrice1() {
		if (lblRecommendPrice1 == null) {
			lblRecommendPrice1 = new JLabel("New label");
			lblRecommendPrice1.setFont(new Font("Apple Symbols", Font.PLAIN, 12));
			lblRecommendPrice1.setBounds(28, 649, 61, 16);
		}
		return lblRecommendPrice1;
	}
	private JLabel getLblRecommendPrice1_1() {
		if (lblRecommendPrice1_1 == null) {
			lblRecommendPrice1_1 = new JLabel("New label");
			lblRecommendPrice1_1.setFont(new Font("Apple Symbols", Font.PLAIN, 12));
			lblRecommendPrice1_1.setBounds(147, 649, 61, 16);
		}
		return lblRecommendPrice1_1;
	}
	private JLabel getLblRecommendPrice1_2() {
		if (lblRecommendPrice1_2 == null) {
			lblRecommendPrice1_2 = new JLabel("New label");
			lblRecommendPrice1_2.setFont(new Font("Apple Symbols", Font.PLAIN, 12));
			lblRecommendPrice1_2.setBounds(269, 649, 61, 16);
		}
		return lblRecommendPrice1_2;
	}
	private JLabel getLblCartBtn() {
		if (lblCartBtn == null) {
			lblCartBtn = new JLabel("");
			lblCartBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Cart cart = new Cart();
					cart.setVisible(true);
					CoffeeMain.setVisible(false);
				}
			});
			lblCartBtn.setBounds(228, 724, 49, 43);
		}
		return lblCartBtn;
	}
} // End
