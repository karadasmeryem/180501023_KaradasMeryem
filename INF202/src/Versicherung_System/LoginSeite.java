package Versicherung_System;

import java.awt.EventQueue;  

import DBCon.*;  
import Model.Personal2;
import Versicherung_System.PersonalGUI ; 
import Model.Kunden; 
import Versicherung_System.KundenGUI ;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane; 
import Model.VerPersonal;

public class LoginSeite extends JFrame { 
	
	private DefaultTableModel tablo;
	private JPanel contentPane;
	private JPanel w_Pane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblX;
	private JLabel lblTitle;
	private JLabel lblLoginMessage;
	private JTabbedPane tabbedPane;
	private JTextField textField_1;
	private JPasswordField passwordField_1; 
	private DBCon conn = new DBCon();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSeite frame = new LoginSeite();
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
	public LoginSeite() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700); 
		w_Pane = new JPanel();
		w_Pane.setBackground(new Color(135, 206, 250));
		w_Pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_Pane);
		w_Pane.setLayout(null);
		setUndecorated(true); 

		lblTitle = new JLabel("Herzlich Wilkommen ! ");
		lblTitle.setBackground(new Color(255, 0, 255));
		lblTitle.setBorder(new LineBorder(SystemColor.activeCaption));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblTitle.setForeground(new Color(0, 0, 0));
		lblTitle.setBounds(70, 10, 521, 56);
		w_Pane.add(lblTitle); 
		
		JLabel lblImage = new JLabel("");
		lblImage.setForeground(new Color(0, 0, 0));
		lblImage.setBackground(new Color(102, 205, 170));
		lblImage.setBounds(150, 420, 390, 280);
		w_Pane.add(lblImage);
		lblImage.setIcon(new ImageIcon("C:\\Users\\ASUS\\Desktop\\Versicherungphoto.png"));
		
		lblX = new JLabel("     X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Möchten Sie dieses Programm wirklich schließen?","Bestätigung",JOptionPane.YES_NO_OPTION)==0) {
					LoginSeite.this.dispose();
			}
			}
		});
		
		lblX.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblX.setForeground(new Color(255, 0, 0));
		lblX.setBounds(645, 18, 45, 46);
		w_Pane.add(lblX);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(23, 91, 650, 319);
		w_Pane.add(tabbedPane);
		
		JPanel panel_kunden = new JPanel();
		tabbedPane.addTab("Kunden Login", null, panel_kunden, null);
		panel_kunden.setBackground(new Color(255, 255, 255));
		panel_kunden.setLayout(null);
		
		lblTitle = new JLabel("Benutzername:");
		lblTitle.setBounds(112, 26, 184, 50);
		panel_kunden.add(lblTitle);
		lblTitle.setBackground(new Color(245, 255, 250));
		lblTitle.setBorder(new LineBorder(SystemColor.activeCaption));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTitle.setForeground(Color.BLACK);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswort.setForeground(Color.BLACK);
		lblPasswort.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPasswort.setBorder(new LineBorder(SystemColor.activeCaption));
		lblPasswort.setBackground(Color.WHITE);
		lblPasswort.setBounds(112, 86, 184, 50);
		panel_kunden.add(lblPasswort);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(340, 33, 163, 39);
		panel_kunden.add(txtUsername);
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUsername.getText().equals("Benutzername")) {
					txtUsername.setText("");
				}
				else {
					txtUsername.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().equals(""))
					txtUsername.setText("Benutzername");
			}
		});
		txtUsername.setBackground(new Color(255, 255, 255));
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(340, 94, 163, 39);
		panel_kunden.add(txtPassword);
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassword.getPassword().equals("Password")) {
				txtPassword.setEchoChar('●');
				txtPassword.setText("");
			}
				else{
					txtPassword.selectAll();}
				}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassword.getPassword().equals(""))
				   txtPassword.setText("Password");
				   txtPassword.setEchoChar('●');
			}
		});
		txtPassword.setBackground(new Color(255, 255, 255));
		
		JTextPane txtpnLogin = new JTextPane();
		txtpnLogin.setBounds(34, 160, 282, 45);
		panel_kunden.add(txtpnLogin);
		txtpnLogin.setText("Benutzen Sie die App zum ersten Mal oder  haben Sie noch ein Versicherungs-App login ? ");
		txtpnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnLogin.setBackground(new Color(240, 248, 255));
		
		JTextPane txtpnHier = new JTextPane();
		txtpnHier.setBounds(352, 172, 168, 33);
		panel_kunden.add(txtpnHier);
		txtpnHier.setBackground(new Color(240, 248, 255));
		txtpnHier.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnHier.setText("Hier geht's zum Login :");
		
		JButton btnRegistrieren = new JButton("Registrieren");
		btnRegistrieren.setBounds(133, 215, 163, 67);
		panel_kunden.add(btnRegistrieren);
		btnRegistrieren.setForeground(Color.BLACK);
		btnRegistrieren.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnRegistrieren.setBackground(SystemColor.menu);
		
		JButton btnAnmelden = new JButton("Anmelden");
		btnAnmelden.setBounds(340, 215, 163, 67);
		panel_kunden.add(btnAnmelden);
		btnAnmelden.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) { 
				if (txtUsername.getText().length() == 0 || txtPassword.getText().length() == 0) {
					Helfer.showMsg("fill"); 
				}else {  
					try {
						Connection con = conn.connDb(); 
						Statement st = con.createStatement(); 
						ResultSet rs = st.executeQuery("SELECT * FROM  benutzer"); 
						while(rs.next()) {	 
							if (textField_1.getText().equals(rs.getString("tcno")) && passwordField_1.getText().equals(rs.getString("password"))) {} 
							Kunden kunden = new Kunden(); { 
								kunden.setId(rs.getInt("id"));  
								kunden.setPassword("pasword");
								kunden.setTcno(rs.getString("tcno"));
								kunden.setName(rs.getString("name"));
								kunden.setType(rs.getString("type")); 
							    KundenGUI bGUI = new KundenGUI(kunden); 
							    bGUI.setVisible(true); 
							    dispose();
							}				 
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					
				}
				
			}
		});
	
		btnAnmelden.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnAnmelden.setForeground(SystemColor.inactiveCaptionText);
		btnAnmelden.setBackground(SystemColor.menu);
		panel_kunden.setLayout(null);
		
		JPanel panel_personal = new JPanel();
		panel_personal.setLayout(null);
		panel_personal.setBackground(Color.WHITE);
		tabbedPane.addTab("Personal Login", null, panel_personal, null);
		
		JLabel lblTitle_2 = new JLabel("Benutzername:");
		lblTitle_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle_2.setForeground(Color.BLACK);
		lblTitle_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTitle_2.setBorder(new LineBorder(SystemColor.activeCaption));
		lblTitle_2.setBackground(new Color(245, 255, 250));
		lblTitle_2.setBounds(112, 26, 184, 50);
		panel_personal.add(lblTitle_2);
		
		JLabel lblPasswort_2 = new JLabel("Passwort:");
		lblPasswort_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswort_2.setForeground(Color.BLACK);
		lblPasswort_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPasswort_2.setBorder(new LineBorder(SystemColor.activeCaption));
		lblPasswort_2.setBackground(Color.WHITE);
		lblPasswort_2.setBounds(112, 86, 184, 50);
		panel_personal.add(lblPasswort_2);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(340, 33, 163, 39);
		panel_personal.add(textField_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField_1.setBackground(Color.WHITE);
		passwordField_1.setBounds(340, 94, 163, 39);
		panel_personal.add(passwordField_1);
		
		JTextPane txtpnHier_2 = new JTextPane();
		txtpnHier_2.setText("Hier geht's zum Login :");
		txtpnHier_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtpnHier_2.setBackground(new Color(240, 248, 255));
		txtpnHier_2.setBounds(229, 159, 168, 33);
		panel_personal.add(txtpnHier_2);
		
		JButton btnAnmelden_2 = new JButton("Anmelden");
		btnAnmelden_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (textField_1.getText().length() == 0 || passwordField_1.getText().length() == 0) {
					Helfer.showMsg("fill"); 
				}else {  
					try {
						Connection con = conn.connDb(); 
						Statement st = con.createStatement(); 
						ResultSet rs = st.executeQuery("SELECT * FROM  benutzer"); 
						while(rs.next()) {	 
							if (textField_1.getText().equals(rs.getString("tcno")) && passwordField_1.getText().equals(rs.getString("password"))) {} 
							VerPersonal VerPersonal = new VerPersonal(); { 
								VerPersonal.setId(rs.getInt("id"));  
								VerPersonal.setPassword("pasword");
								VerPersonal.setTcno(rs.getString("tcno"));
								VerPersonal.setName(rs.getString("name"));
								VerPersonal.setType(rs.getString("type")); 
							    PersonalGUI bGUI = new PersonalGUI(VerPersonal); 
							    bGUI.setVisible(true); 
							    dispose();
							}				 
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					
				}
			}
		});
		btnAnmelden_2.setForeground(Color.BLACK);
		btnAnmelden_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnAnmelden_2.setBackground(SystemColor.menu);
		btnAnmelden_2.setBounds(229, 215, 163, 67);
		panel_personal.add(btnAnmelden_2);
		
		lblLoginMessage = new JLabel("");
		lblLoginMessage.setBounds(174, 74, 499, 46);
		w_Pane.add(lblLoginMessage);
		lblLoginMessage.setBackground(Color.WHITE);
		lblLoginMessage.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLoginMessage.setForeground(Color.BLACK);;
		
		
	}
}
