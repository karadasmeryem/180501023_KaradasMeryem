package Model;

import java.awt.BorderLayout; 

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DBCon.Helfer;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton; 
import Model.Kunden; 
import Model.Versicherung;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent; 
import DBCon.Helfer;

public class updater extends JFrame {

	private JPanel contentPane;
	private JTextField textField; 
	private static Versicherung versicherung; 
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updater frame = new updater(versicherung);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param versicherung2 
	 */
	public updater(Versicherung versicherung2) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 225, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName_1 = new JLabel("Versicherung Type");
		lblName_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName_1.setBounds(26, 10, 143, 17);
		contentPane.add(lblName_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(26, 37, 143, 27); 
		textField.setText(versicherung.getName());
		contentPane.add(textField);
		
		JButton btn_add_1 = new JButton("Hinzuf\u00FCgen");
		btn_add_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if(Helfer.confirm("sure")) { 
				try {
					versicherung.updateVersicherung(versicherung.getId(), textField.getText()); 
					Helfer.showMsg("erfolgreich!"); 
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		btn_add_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_add_1.setBounds(26, 64, 143, 39);
		contentPane.add(btn_add_1);
	}
	

}
