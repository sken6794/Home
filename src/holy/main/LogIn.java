package holy.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import holy.dao.HMemberDAO;

public class LogIn extends JFrame{
	
	public LogIn() {
		
		HMemberDAO hmemberDAO = new HMemberDAO();
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("ID :  ");
		JLabel pswrd = new JLabel("Password :  ");
		JTextField txtID = new JTextField(10);
		JPasswordField txtPass = new JPasswordField(10);
		JButton logBtn = new JButton("Log In");
		
		panel.add(label);
		panel.add(txtID);
		panel.add(pswrd);
		panel.add(txtPass);
		panel.add(logBtn);
		
		logBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				char[] a = txtPass.getPassword();
				String pwd = "";
				for(char b : a) {
					pwd+=b;
				}
				if( hmemberDAO.login(txtID.getText(), pwd)) {
					JOptionPane.showMessageDialog(null, "로그인 성공");
				}else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}
				
				
			}
		});
		
		
		add(panel);
		
		setVisible(true);
		setSize(600,400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		new LogIn();
		
	}

}
