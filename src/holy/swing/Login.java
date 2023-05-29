package holy.swing;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

import holy.dao.HMemberDAO;

import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JToolBar;

public class Login extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();


	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {


		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("CENTER CINEMA THEATER");

		ImagePanel MainPanel = new ImagePanel(new ImageIcon("C:\\Users\\admin\\Desktop\\tnwjd\\themeee.jpg").getImage());
		MainPanel.setBounds(0, 0, 724, 521);
		MainPanel.setForeground(new Color(245, 245, 245));

		frame.setSize(new Dimension(994, 774));
		frame.setPreferredSize(MainPanel.getDim());
		frame.getContentPane().setLayout(null);

		frame.getContentPane().add(MainPanel);

		JButton btnNewButton = new JButton("로그인하기");
		btnNewButton.setBounds(153, 239, 114, 28);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("공체 Light", Font.PLAIN, 16));

		MainPanel.setLayout(null);
		btnNewButton.setBackground(new Color(255, 250, 250));
		MainPanel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
		

			}
		});

		JButton btnNewButton_1 = new JButton("회원가입");
		btnNewButton_1.setBounds(480, 239, 120, 28);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("공체 Light", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBackground(new Color(255, 250, 250));
		MainPanel.add(btnNewButton_1);
		
		JPanel loginpanel = new JPanel();
		loginpanel.setBounds(0, 0, 724, 521);
		frame.getContentPane().add(loginpanel);




	}
	
	public void login2() {

		HMemberDAO hmemberDAO = new HMemberDAO();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("CENTER CINEMA THEATER");

		ImagePanel loginPanel = new ImagePanel(new ImageIcon("C:\\Users\\admin\\Desktop\\tnwjd\\00.jpg").getImage());
		loginPanel.setBounds(0, 0, 724, 521);
		loginPanel.setForeground(new Color(245, 245, 245));

		frame.setSize(new Dimension(994, 774));
		frame.setPreferredSize(loginPanel.getDim());
		frame.getContentPane().setLayout(null);

		frame.getContentPane().add(loginPanel);
		
		JButton btnNewButton = new JButton("로그인하기");
		JTextField txtID = new JTextField(10);
		JPasswordField txtPass = new JPasswordField(10);

		btnNewButton.addActionListener(new ActionListener() {

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



		setVisible(true);
		setSize(600,400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}
}
