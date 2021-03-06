package com.kh.miniproject.view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.miniproject.member.controller.MemberManager;
import com.kh.miniproject.view.decoration.RoundedButton;


public class MemberJoinPanel extends JPanel {
	private MainFrame mf;
	private MainPanel mp;
	MemberManager mm = new MemberManager();
	boolean overlapCheck = false;
	
	
	private ImageChange it;

	public MemberJoinPanel(MainFrame mf){
		this.mf = mf;

		this.setLayout(null);
		this.setSize(mf.getWidth(), mf.getHeight());
		this.setBackground(Color.BLACK);

		// 뒤로가기 버튼
		JButton goback = new JButton();
		Image back = new ImageIcon("icon/pointer.png").getImage().getScaledInstance(100, 100, 0);
		goback.setIcon(new ImageIcon(back));
		goback.setBorderPainted(false);
		goback.setBounds(25, 25, 100, 100);
		goback.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				StartPanel sp = new StartPanel(mf);
				changePanel(sp);
			}
		});
		this.add(goback);

		//상단 회원가입 패널 //패널 위 라벨로 구성
		JPanel memberJoinText = new JPanel();
		memberJoinText.setLayout(null);
		memberJoinText.setLocation(300, 50);
		memberJoinText.setBackground(Color.WHITE);
		memberJoinText.setSize(600,100);
		JLabel titleLayer = new JLabel();
		Image titleLayerI = new ImageIcon("icon/titleLayer.png").getImage().getScaledInstance(600, 100, 0);
		titleLayer.setIcon(new ImageIcon(titleLayerI));
		titleLayer.setBounds(0, 0, 600, 100);
		//패널 위 "회원가입" 라벨
		JLabel text = new JLabel("회원가입");
		text.setBounds(0, 0, 600, 100);
		text.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		text.setHorizontalAlignment(JTextField.CENTER);
		memberJoinText.add(text);
		memberJoinText.add(titleLayer);

		//회원 가입 메인 패널 //
		JPanel joinMain = new JPanel();
		joinMain.setLayout(null);
		joinMain.setSize(1000,500);
		joinMain.setLocation(100, 200);
		joinMain.setBackground(Color.LIGHT_GRAY);

		//회원 정보 입력 텍스트필드, 라벨
		JLabel id = new JLabel("아이디");
		id.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		id.setBounds(30, 0, 100, 100);
		JTextField textId = new JTextField();
		textId.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		textId.setBounds(30, 70, 200, 30);

		JLabel pwd = new JLabel("비밀번호");
		pwd.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		pwd.setBounds(30, 80, 100, 100);		
		JPasswordField textPwd = new JPasswordField();		
		textPwd.setFont(new Font("맑은 고딕", Font.BOLD, 14));	
		textPwd.setBounds(30, 150, 200, 30);

		JLabel name = new JLabel("이름");
		name.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		name.setBounds(30, 160, 100, 100);
		JTextField textName = new JTextField();
		textName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		textName.setBounds(30, 230, 200, 30);

		JLabel phoneNum = new JLabel("전화번호( ' - ' 제외 숫자입력 )");
		phoneNum.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		phoneNum.setBounds(30, 240, 300, 100);
		JTextField textPhoneNum = new JTextField();
		textPhoneNum.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		textPhoneNum.setBounds(30, 310, 200, 30);

		JLabel email = new JLabel("메일");
		email.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		email.setBounds(30, 320, 100, 100);
		JTextField textEmail = new JTextField();
		textEmail.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		textEmail.setBounds(30, 390, 200, 30);
		
		JButton overlap = new RoundedButton("ID 중복확인");
		overlap.setBounds(250, 70, 130, 30);
		overlap.setForeground(Color.WHITE);
		overlap.setBackground(Color.black);
		overlap.setFont(new Font("맑은 고딕", Font.BOLD, 16));

		Dialog overlapDialog = new Dialog(mf);
		overlapDialog.setBounds(500, 380, 200, 100);

		JButton dialogClose = new RoundedButton("닫기");
		dialogClose.setBounds(50, 125, 50, 70);

		JLabel checkOverlap = new JLabel("중복된 아이디 입니다.");
		checkOverlap.setHorizontalAlignment(JLabel.CENTER);
		
		overlapDialog.add(dialogClose, "South");
		overlapDialog.add(checkOverlap, "North");
		
		//중복 검사 팝업창 //checkOverlap 기능 연결하여 중복 검사 필요
		overlap.addActionListener(new ActionListener(){	
			@Override
			public void actionPerformed(ActionEvent e) {
				checkOverlap.setText(overlapCheck(textId.getText()));
				overlapDialog.setVisible(true);
			}
		});
		//중복 검사 팝업창 닫기 버튼
		dialogClose.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				overlapDialog.setVisible(false);
			}
		});

		//가입 버튼
		JButton join = new RoundedButton("가입");
		join.setBounds(30, 435, 100, 50);
		join.setBackground(Color.BLACK);
		join.setForeground(Color.WHITE);
		join.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		//가입버튼 기능 구현
		join.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean phoneCheck = true;
				boolean phoneLength = false;
				checkOverlap.setText(overlapCheck(textId.getText()));
			
				for(int i = 0; i < textPhoneNum.getText().length(); i++){
					char[] ch = textPhoneNum.getText().toCharArray();
					if(ch.length == 11 || ch.length == 10){
						phoneLength = true;
					}
					if(!(ch[i] >= '0' && ch[i] <= '9')){
						phoneCheck = false;
					}
				}
			
				if(textName.getText().equals("") || textId.getText().equals("")
						|| textPwd.getText().equals("")
						|| textEmail.getText().equals("")
						|| textPhoneNum.getText().equals("")
						){

					checkOverlap.setText("모든 정보를 입력하세요.");
					overlapDialog.setVisible(true);
				}else if(overlapCheck == true && phoneCheck == true && 
						phoneLength == true){
					checkOverlap.setText("가입 완료되었습니다.");
					mm.memberJoin(textName.getText(), textId.getText(),
							textPwd.getText(), textEmail.getText(),
							textPhoneNum.getText());
						textName.setText(""); textId.setText(""); textPwd.setText("");
						textEmail.setText(""); textPhoneNum.setText("");
					overlapDialog.setVisible(true);
					
					StartPanel sp = new StartPanel(mf);
					changePanel(sp);
					
				}if(overlapCheck == false){
					checkOverlap.setText("ID 중복확인을 다시 해주세요.");
					overlapDialog.setVisible(true);
				}if(phoneCheck == false || phoneLength == false){
					checkOverlap.setText("전화번호를 다시 확인해주세요.");
					overlapDialog.setVisible(true);
				}
			}
		});

		//광고창
		JLabel capture = new JLabel();
		Image capImage = new ImageIcon("icon/project-1.PNG").getImage().getScaledInstance(450, 400, 0);
		capture.setIcon(new ImageIcon(capImage));
		capture.setBounds(500, 50, 450, 400);

		it = new ImageChange(capture, 3);
		it.start();

		joinMain.add(join);
		joinMain.add(capture);
		joinMain.add(overlap);
		joinMain.add(email);
		joinMain.add(textEmail);
		joinMain.add(phoneNum);
		joinMain.add(textPhoneNum);
		joinMain.add(name);
		joinMain.add(textName);
		joinMain.add(id);
		joinMain.add(textId);
		joinMain.add(pwd);
		joinMain.add(textPwd);

		this.add(joinMain);
		this.add(memberJoinText);
		mf.add(this);
	}

	public String overlapCheck(String s){
		int check = mm.checkUser(s);


		if(check == 0){		// 중복 x
			overlapCheck = true;
			return "사용 가능한 아이디입니다.";
		}else if(check == 1){	// 중복 o
			overlapCheck = false;
			return "중복된 아이디 입니다.";
		}
		return "";
	}
	
	public void changePanel(JPanel panel)
	{
		mf.remove(this);
		mf.add(panel);
		mf.repaint();
		it.interrupt();
	}


}