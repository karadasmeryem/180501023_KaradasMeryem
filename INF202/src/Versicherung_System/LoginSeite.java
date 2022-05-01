package Versicherung_System;

import java.awt.BorderLayout; 

import java.awt.EventQueue;

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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextPane; 
 

public class LoginSeite extends JFrame { 
	
	private DefaultTableModel tablo;
	private JPanel contentPane;
	private JPanel w_Pane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblX;
	private JLabel lblTitle;
	private JLabel lblLoginMessage;

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
		w_Pane.setBackground(new Color(64, 224, 208));
		w_Pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_Pane);
		w_Pane.setLayout(null);
		setUndecorated(true); 
		
		txtUsername = new JTextField();
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
		txtUsername.setText("Benutzername");
		txtUsername.setBackground(new Color(224, 255, 255));
		txtUsername.setBounds(181, 76, 260, 46);
		w_Pane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassword.getText().equals("Password")) {
				txtPassword.setEchoChar('●');
				txtPassword.setText("");
			}
				else{
					txtPassword.selectAll();}
				}
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassword.getText().equals(""))
				   txtPassword.setText("Password");
				   txtPassword.setEchoChar('●');
			}
		});
		txtPassword.setText("Password");
		txtPassword.setBackground(new Color(224, 255, 255));
		txtPassword.setBounds(181, 132, 260, 53);
		w_Pane.add(txtPassword);
		
		JButton btnNewButton = new JButton("Anmelden");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtUsername.getText().equals("admin")&& txtPassword.getText().equals("123456")) {
					lblLoginMessage.setText("");
					JOptionPane.showMessageDialog(null,"Anmeldung erfolgreich");
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
					dispose();
				}
				else if(txtUsername.getText().equals("")|| txtPassword.getText().equals("Benutzername")||
						txtPassword.getText().equals("")|| txtPassword.getText().equals("Passwort")) {
					lblLoginMessage.setText("Bitte geben Sie alle Informationen ein");
				}
				else {
					lblLoginMessage.setText("Benutzername oder Password sind nicht richtig");
					
				}
				
			}

		
		});
			
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setForeground(SystemColor.inactiveCaptionText);
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setBounds(210, 326, 152, 36);
		w_Pane.add(btnNewButton);
		
		JLabel lblImage = new JLabel("");
		lblImage.setForeground(new Color(0, 0, 0));
		lblImage.setBackground(new Color(102, 205, 170));
		lblImage.setBounds(90, 326, 400, 400);
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
		
		lblTitle = new JLabel("Herzlich Wilkommen ! ");
		lblTitle.setBackground(new Color(255, 0, 255));
		lblTitle.setBorder(new LineBorder(SystemColor.activeCaption));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblTitle.setForeground(SystemColor.controlLtHighlight);
		lblTitle.setBounds(44, 10, 521, 56);
		w_Pane.add(lblTitle);
		
		lblLoginMessage = new JLabel("");
		lblLoginMessage.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLoginMessage.setForeground(new Color(255, 0, 0));
		lblLoginMessage.setBounds(132, 487, 338, 28);
		w_Pane.add(lblLoginMessage);
		
		JTextPane txtpnHier = new JTextPane();
		txtpnHier.setBackground(new Color(224, 255, 255));
		txtpnHier.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtpnHier.setText("Hier geht's zum Login :");
		txtpnHier.setBounds(32, 295, 135, 21);
		w_Pane.add(txtpnHier);
		
		JTextPane txtpnBenutzenSieDie = new JTextPane();
		txtpnBenutzenSieDie.setText("Benutzen Sie die App zum ersten Mal oder haben Sie noch ein Versicherungs-App login ? ");
		txtpnBenutzenSieDie.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtpnBenutzenSieDie.setBackground(new Color(224, 255, 255));
		txtpnBenutzenSieDie.setBounds(32, 205, 493, 28);
		w_Pane.add(txtpnBenutzenSieDie);
		
		JButton btnRegistrieren = new JButton("Registrieren");
		btnRegistrieren.setForeground(Color.BLACK);
		btnRegistrieren.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnRegistrieren.setBackground(SystemColor.menu);
		btnRegistrieren.setBounds(210, 243, 152, 36);
		w_Pane.add(btnRegistrieren);
	}
}
