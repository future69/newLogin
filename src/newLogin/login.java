package newLogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class login extends JFrame {
	
	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;
	private JLabel lblProblem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setBounds(112, 85, 68, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(112, 110, 68, 14);
		contentPane.add(lblPassword);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(180, 82, 86, 20);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = textFieldUsername.getText();
				char[] password = passwordField.getPassword();
				
				//Check null
				if (CheckNull(username, password) == true) {
					lblProblem.setText("Invalid userid or password");
				}
				
				else {
					loginController loginControl = new loginController();
					String role[] = loginControl.passUserInfo(username, password);
					//Set local variables from retrieved data
					String name = role[1];
					String theRole = role[0];
					if(role[0] != null) {
						//Open different pages depending on user role
						switch(role[0].trim()) {
							case "manager":
								JFrame homepageManager = new homepageManager(username,name,theRole);
								homepageManager.setVisible(true);
								dispose();
								break;
							case "user":
								JFrame homepageUser = new homepageUser(username,name,theRole);
								homepageUser.setVisible(true);
								dispose();
								break;
						}
					}
					else {
						lblProblem.setText("Invalid userid or password");
					}
				}
				
			}
			
		});
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 110, 86, 20);
		contentPane.add(passwordField);
		btnLogin.setBounds(129, 148, 93, 20);
		contentPane.add(btnLogin);
		
		lblProblem = new JLabel("");
		lblProblem.setBounds(134, 187, 183, 14);
		contentPane.add(lblProblem);
		
		
	}

	//Method to check null
		public boolean CheckNull(String username, char[] password) {
			if (username.isBlank() || String.valueOf(password).isBlank()) {
				return true;
			}
			else {
				return false;
			}
		}
}
