package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.event.MenuKeyEvent;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class log {

	private JFrame frame;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					log window = new log();
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
	public log() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 255, 255));
		frame.setBounds(100, 100, 673, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 255, 0));
		panel.setBounds(10, 10, 639, 413);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 204));
		panel_1.setBounds(115, 0, 524, 413);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		user = new JTextField();
		user.setBounds(179, 94, 197, 34);
		panel_1.add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String id = user.getText();
					String pa = pass.getText();
					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Covid","root","hieunghia3107");
						Statement st = conn.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM patient WHERE ID= '"+id+"'AND Password='"+pa+"'");
						if(rs.next())
							JOptionPane.showMessageDialog(null, "Success!!");
						else {
							JOptionPane.showMessageDialog(null, "Invalid!!");
							user.setText("");
							pass.setText("");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		pass.setBounds(179, 182, 197, 34);
		panel_1.add(pass);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(82, 185, 68, 24);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(82, 88, 80, 42);
		lblNewLabel_1.setBackground(new Color(102, 204, 153));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1);
		
		JButton btnLogin = new JButton("Enter");
		
		btnLogin.setBounds(203, 257, 155, 34);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = user.getText();
				String pa = pass.getText();
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Covid","root","hieunghia3107");
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM patient WHERE ID= '"+id+"'AND Password='"+pa+"'");
					if(rs.next())
						JOptionPane.showMessageDialog(null, "Success!!");
					else {
						JOptionPane.showMessageDialog(null, "Invalid!!");
						user.setText("");
						pass.setText("");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(btnLogin);
		
		JLabel lblNewLabel_2 = new JLabel(" ");
		lblNewLabel_2.setBounds(10, 10, 504, 382);
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/2.jpg"));
		lblNewLabel_2.setIcon(icon);
		panel_1.add(lblNewLabel_2);
	}
}
