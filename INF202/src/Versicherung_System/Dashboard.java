package Versicherung_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	private Component component;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KundenFrame frame = new KundenFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**

	/**
	 * Create the frame.
	 */
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 900, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 224, 208));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JButton btnEnterKunden = new JButton("KUNDEN");
		btnEnterKunden.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEnterKunden.setForeground(new Color(255, 255, 255));
		btnEnterKunden.setBackground(new Color(255, 102, 0));
		btnEnterKunden.setBounds(478, 388, 146, 28);
		component = contentPane.add(btnEnterKunden);
		btnEnterKunden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                enterKunden();
            }

			private void Personal() {
				PersonalFrame frame = new PersonalFrame();
				frame.setVisible(true);
				dispose();
				
			}
        });
		
		
		JButton btnEnterPersonal = new JButton("PERSONAL");
		btnEnterPersonal.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEnterPersonal.setForeground(new Color(25, 25, 112));
		btnEnterPersonal.setBackground(new Color(230, 230, 250));
		btnEnterPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonalFrame frame = new PersonalFrame();
				frame.setVisible(true);
				dispose();
			}
		});
		btnEnterPersonal.setBounds(63, 58, 186, 44);
		contentPane.add(btnEnterPersonal);
		

		
		JLabel lblKunden = new JLabel("");
		lblKunden.setBounds(419, 165, 427, 251);
		contentPane.add(lblKunden);
		lblKunden.setIcon(new ImageIcon("C:\\Users\\ASUS\\Desktop\\KundenPhoto.png"));
		
		
		JLabel lblPersonal = new JLabel("");
		lblPersonal.setBounds(65, 165, 252, 251);
		contentPane.add(lblPersonal);
		lblPersonal.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\PersonalPhoto.png"));
		setUndecorated(true);
	}

	protected void enterKunden() {
		// TODO Auto-generated method stub
		
	}

}