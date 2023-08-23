package newLogin;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class homepageUser extends JFrame {

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
					homepageUser frame = new homepageUser(username,name,theRole);
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
	public homepageUser(String username, String name, String theRole) {
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
