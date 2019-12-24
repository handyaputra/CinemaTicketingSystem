package Bioskop;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import NontonKuy.Frame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField passwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setTitle("Login Page");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Hp\\Downloads\\AA Project\\fix\\video-camera.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,100,  640, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel cross = new JLabel("X");
		cross.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cross.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		cross.setForeground(Color.RED);
		cross.setBounds(15, 6, 69, 20);
		contentPane.add(cross);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("src\\Bioskop\\bg.gif"));
		lblNewLabel_1.setBounds(0, 40, 639, 401);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("src\\Bioskop\\Capture.png"));
		lblNewLabel.setBounds(-22, 0, 662, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblUsername.setBounds(15, 478, 114, 14);
		contentPane.add(lblUsername);
		
		username = new JTextField();
		username.setBounds(15, 497, 202, 27);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblPassword.setBounds(247, 478, 89, 14);
		contentPane.add(lblPassword);
		
		passwd = new JPasswordField();
		passwd.setBounds(247, 497, 202, 27);
		contentPane.add(passwd);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bioskop", "root", "");
					Statement state = con.createStatement();
					String sql = "SELECT * FROM login WHERE username ='" + username.getText() + "' AND passwd = '" + passwd.getText().toString() + "'";
					ResultSet res = state.executeQuery(sql);
					if (res.next()) {
						JOptionPane.showMessageDialog(null, "Login Sukses");
						Bioskop launch = new Bioskop();
					} else {
						JOptionPane.showMessageDialog(null, "Username / Password Salah");
					}
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
		btnLogin.setBounds(464, 499, 139, 23);
		contentPane.add(btnLogin);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("src\\Bioskop\\bgg.PNG"));
		label.setBounds(0, 0, 639, 540);
		contentPane.add(label);
		
		setUndecorated(true);
	}
}
