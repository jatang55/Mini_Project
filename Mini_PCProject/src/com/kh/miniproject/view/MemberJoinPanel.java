package com.kh.miniproject.view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.miniproject.member.controller.MemberManager;


public class MemberJoinPanel {
	private MainFrame mf;
	private MainPanel mp;

	MemberManager mm = new MemberManager();

	public MemberJoinPanel(MainFrame mf){
		this.mf = mf;

		JPanel start = new JPanel();

		start.setLayout(null);
		start.setSize(mf.getWidth(), mf.getHeight());
		start.setBackground(Color.BLACK);

		//��� ȸ������ �г� //�г� �� �󺧷� ����
		JPanel memberJoinText = new JPanel();
		memberJoinText.setLayout(null);
		memberJoinText.setLocation(300, 50);
		memberJoinText.setBackground(Color.WHITE);
		memberJoinText.setSize(600,100);
		//�г� �� "ȸ������" ��
		JLabel text = new JLabel("ȸ������");
		text.setSize(200, 50);
		text.setLocation(200, 25);
		text.setBackground(Color.GREEN);
		text.setFont(new Font("���� ����", Font.BOLD, 40));
		text.setHorizontalAlignment(JTextField.CENTER);
		memberJoinText.add(text);

		//ȸ�� ���� ���� �г� //
		JPanel joinMain = new JPanel();
		joinMain.setLayout(null);
		joinMain.setSize(1000,500);
		joinMain.setLocation(100, 200);
		joinMain.setBackground(Color.LIGHT_GRAY);


		//ȸ�� ���� �Է� �ؽ�Ʈ�ʵ�, ��
		JLabel id = new JLabel("���̵�");
		id.setFont(new Font("���� ����", Font.BOLD, 16));
		id.setBounds(30, 0, 100, 100);
		JTextField textId = new JTextField();
		textId.setFont(new Font("���� ����", Font.BOLD, 14));
		textId.setBounds(30, 70, 200, 30);

		JLabel pwd = new JLabel("��й�ȣ");
		pwd.setFont(new Font("���� ����", Font.BOLD, 16));
		pwd.setBounds(30, 80, 100, 100);		
		JTextField textPwd = new JTextField();		
		textPwd.setFont(new Font("���� ����", Font.BOLD, 14));	
		textPwd.setBounds(30, 150, 200, 30);

		JLabel name = new JLabel("�̸�");
		name.setFont(new Font("���� ����", Font.BOLD, 16));
		name.setBounds(30, 160, 100, 100);
		JTextField textName = new JTextField();
		textName.setFont(new Font("���� ����", Font.BOLD, 14));
		textName.setBounds(30, 230, 200, 30);

		JLabel phoneNum = new JLabel("��ȭ��ȣ");
		phoneNum.setFont(new Font("���� ����", Font.BOLD, 16));
		phoneNum.setBounds(30, 240, 100, 100);
		JTextField textPhoneNum = new JTextField();
		textPhoneNum.setFont(new Font("���� ����", Font.BOLD, 14));
		textPhoneNum.setBounds(30, 310, 200, 30);

		JLabel email = new JLabel("����");
		email.setFont(new Font("���� ����", Font.BOLD, 16));
		email.setBounds(30, 320, 100, 100);
		JTextField textEmail = new JTextField();
		textEmail.setFont(new Font("���� ����", Font.BOLD, 14));
		textEmail.setBounds(30, 390, 200, 30);

		JButton overlap = new JButton("ID �ߺ�Ȯ��");
		overlap.setBounds(250, 70, 130, 30);
		overlap.setForeground(Color.WHITE);
		overlap.setBackground(Color.black);
		overlap.setFont(new Font("���� ����", Font.BOLD, 16));

		Dialog overlapDialog = new Dialog(mf);
		overlapDialog.setBounds(500, 380, 200, 100);

		JButton dialogClose = new JButton("�ݱ�");
		dialogClose.setBounds(50, 125, 50, 50);

		JLabel checkOverlap = new JLabel("�ߺ��� ���̵� �Դϴ�.");
		checkOverlap.setHorizontalAlignment(JLabel.CENTER);

		overlapDialog.add(dialogClose, "South");
		overlapDialog.add(checkOverlap, "North");
		//�ߺ� �˻� �˾�â //checkOverlap ��� �����Ͽ� �ߺ� �˻� �ʿ�
		overlap.addActionListener(new ActionListener(){	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int check = mm.checkUser(textId.getText());

				System.out.println("check : "  + check);
				
				if(check == 0){		// �ߺ� x
					checkOverlap.setText("��� ������ ���̵��Դϴ�.");
				}else if(check == 1){	// �ߺ� o
					checkOverlap.setText("�ߺ��� ���̵� �Դϴ�.");
				}
				
				overlapDialog.setVisible(true);


			}

		});
		//�ߺ� �˻� �˾�â �ݱ� ��ư
		dialogClose.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {


				overlapDialog.setVisible(false);

			}

		});



		//�ð� �߰� ��ư
		JButton join = new JButton("����");
		join.setBounds(30, 435, 100, 50);
		join.setBackground(Color.BLACK);
		join.setForeground(Color.WHITE);
		join.setFont(new Font("���� ����", Font.BOLD, 20));
		//�ð��߰� ��ư ��� ����
		join.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(textName.getText() != "" && textId.getText() != "" &&
						textPwd.getText() != "" && textEmail.getText() != "" &&
						textPhoneNum.getText() != "" ){
					
					System.out.println("��� ������ �Է��ϼž��մϴ�.");
					
				}else{
					
					mm.memberJoin(textName.getText(), textId.getText(),
							textPwd.getText(), textEmail.getText(),
							textPhoneNum.getText());
				}
				
				
			}

		});

		//����â
		JLabel capture = new JLabel();
		Image capImage = new ImageIcon("icon/project-1.PNG").getImage().getScaledInstance(450, 400, 0);
		capture.setIcon(new ImageIcon(capImage));
		capture.setBounds(500, 50, 450, 400);




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

		mf.add(joinMain);
		mf.add(memberJoinText);
		mf.add(start);


	}



}