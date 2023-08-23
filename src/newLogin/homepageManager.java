package newLogin;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class homepageManager extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String username = null;
					String name = null;
					String theRole = null;
					homepageManager frame = new homepageManager(username,name,theRole);
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
	public homepageManager(String username, String name, String theRole) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("");
		lblWelcome.setBounds(10, 22, 203, 14);
		contentPane.add(lblWelcome);
		
		lblWelcome.setText("Welcome " + name);
		
		JLabel lblUsername = new JLabel("");
		lblUsername.setBounds(10, 47, 203, 14);
		contentPane.add(lblUsername);
		
		JLabel lblRole = new JLabel("Welcome <dynamic>");
		lblRole.setBounds(10, 72, 203, 14);
		contentPane.add(lblRole);
		
		lblUsername.setText("Username : "+username);
		lblRole.setText("Role : "+theRole);
		
		//Access restricted webpage (https://dxc.com/sg/en)
		JButton btnNewButton = new JButton("Restricted webpage");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String targetUrl = "https://dxc.com/sg/en";
					try {
						java.awt.Desktop.getDesktop().browse(java.net.URI.create(targetUrl));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnNewButton.setBounds(13, 116, 200, 50);
		contentPane.add(btnNewButton);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame loginPage = new login();
				loginPage.setVisible(true);
				
				dispose();
			}
		});
		btnLogout.setBounds(334, 18, 90, 23);
		contentPane.add(btnLogout);
		
	}

}
