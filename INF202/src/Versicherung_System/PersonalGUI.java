package Versicherung_System;
import Model.VerPersonal;  


import java.awt.BorderLayout; 

import java.awt.EventQueue;
import Model.VerPersonal; 
import DBCon.Helfer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTextPane;  
import Model.Versicherung;

public class PersonalGUI extends JFrame {  
	
    static VerPersonal verpersonal = new VerPersonal () ; 
    Versicherung versicherung = new Versicherung () ; 
	private JPanel w_pane; 
	private JTextField fld_Name;
	private JTextField fld_Tcno;
	private JPasswordField fld_Pass;
	private JTextField fld_personalID;
	private DefaultTableModel personalModel = null; 
	private Object[] personalData = null; 
	private JTable table_personal;
	private JTable table_versich;
	private JTextField fld_versich;
	private DefaultTableModel versicherungModel = null ;  
	private Object[] versicherungData = null;  
	private JPopupMenu versicherungMenu;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalGUI frame = new PersonalGUI(verpersonal);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */ 
	
	public PersonalGUI(final VerPersonal verpersonal) throws SQLException { 
		// default mitarbeiter modell
		
		personalModel = new DefaultTableModel(); 
		Object[] colPersonalName = new Object [4]; 
		colPersonalName[0] = "ID";  
		colPersonalName[1] = "IDNummer";  
		colPersonalName[2] = "Name Nachname";  
		colPersonalName[3] = "Passwort"; 
		personalModel.setColumnIdentifiers(colPersonalName); 
		personalData = new Object[4]; 
		for(int i=0; i < verpersonal.getPersonalList().size(); i++ ) { 
			personalData[0] = verpersonal.getPersonalList().get(i).getId(); 
			personalData[1] = verpersonal.getPersonalList().get(i).getTcno(); 
			personalData[2] = verpersonal.getPersonalList().get(i).getName(); 
			personalData[3] = verpersonal.getPersonalList().get(i).getPassword(); 
			personalModel.addRow(personalData);
		}
		// default versicherung_type modell
		
				versicherungModel = new DefaultTableModel(); 
				Object[] colVersich = new Object [2]; 
				colVersich[0] = "ID";  
				colVersich[1] = "Versicherung Type";  
				versicherungModel.setColumnIdentifiers(colVersich); 
				versicherungData = new Object[4]; 
				for(int i=0; i < versicherung.getVersicherungList().size(); i++ ) { 
					versicherungData[0] = versicherung.getVersicherungList().get(i).getId(); 
					versicherungData[1] = versicherung.getVersicherungList().get(i).getName(); 
					versicherungModel.addRow(versicherungData);
				}
				
		
		setEnabled(true);
		setTitle("Verwaltung System");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 526); 
		w_pane = new JPanel();
		w_pane.setBackground(Color.WHITE);
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		w_pane.setLayout(new BorderLayout(0, 0));
		setContentPane(w_pane);
		
		JLabel lblNewLabel = new JLabel("Wilkommen Sie " + verpersonal.getName());
		lblNewLabel.setEnabled(false);
		lblNewLabel.setBounds(10, 11, 278, 21);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.BLACK);
		w_pane.add(lblNewLabel, BorderLayout.NORTH);
		 
		
		JButton btnNewButton = new JButton("Zurück");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				 { 
					LoginSeite login=new LoginSeite();
					login.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(595, 12, 89, 23);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		w_pane.add(btnNewButton);
		 
		JTabbedPane w_tab = new JTabbedPane(JTabbedPane.TOP);
		w_tab.setBackground(Color.CYAN);
		w_tab.setFont(new Font("Tahoma", Font.BOLD, 14));
		w_tab.setBounds(10, 61, 674, 349);
		w_pane.add(w_tab); 
		JPanel w_Personal = new JPanel();
		w_Personal.setForeground(Color.WHITE);
		w_tab.addTab("Personalmanagement", null, w_Personal, null);
		w_Personal.setLayout(null);

		JLabel lblName = new JLabel("Name-Nachname");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(541, 11, 156, 14);
		w_Personal.add(lblName);

		JLabel lblBenutzerID = new JLabel("Identifikationsnummer");
		lblBenutzerID.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBenutzerID.setBounds(541, 67, 180, 14);
		w_Personal.add(lblBenutzerID);

		JLabel lblSifre = new JLabel("Passwort");
		lblSifre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSifre.setBounds(541, 120, 118, 14);
		w_Personal.add(lblSifre);

		JLabel lblPsswort = new JLabel("Benutzer ID");
		lblPsswort.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPsswort.setBounds(541, 222, 142, 14);
		w_Personal.add(lblPsswort);  
		
		fld_Name = new JTextField();
		fld_Name.setBounds(541, 35, 156, 21);
		w_Personal.add(fld_Name);
		fld_Name.setColumns(10);

		fld_Tcno = new JTextField();
		fld_Tcno.setText("");
		fld_Tcno.setColumns(10);
		fld_Tcno.setBounds(541, 89, 156, 21);
		w_Personal.add(fld_Tcno);

	    fld_Pass = new JPasswordField();
		fld_Pass.setBounds(541, 145, 156, 21);
		w_Personal.add(fld_Pass); 
		 
		fld_personalID = new JTextField();
		fld_personalID.setText("");
		fld_personalID.setColumns(10);
		fld_personalID.setBounds(541, 249, 156, 21);
		w_Personal.add(fld_personalID);  
		
		JButton btn_add = new JButton("Hinzuf\u00FCgen");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if ( fld_Tcno.getText().length() ==0 || fld_Pass.getText().length()==0 ||fld_Name.getText().length() ==0 ) { 
					DBCon.Helfer.showMsg("fill");
				}else {  
					try {
					boolean control = verpersonal.addPersonal(fld_Tcno.getText(), fld_Pass.getText(),fld_Name.getText()); 
					if(control) { 
						Helfer.showMsg("Erfolgreich");  
						fld_Tcno.setText(null); 
						fld_Pass.setText(null); 	 
						fld_Name.setText(null);  
						updatePersonalModel(); 
						
					}
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				} 
			} 
		}); 
		btnNewButton.setForeground(Color.DARK_GRAY);
		btn_add.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_add.setBounds(541, 176, 156, 38);
		w_Personal.add(btn_add); 
		 
		JButton btnlöschen = new JButton("L\u00F6schen");
		btnlöschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if(fld_personalID.getText().length() == 0) {  
					Helfer.showMsg("Bitte wählen Sie eine gültige Mitarbeiter aus");
				}else {   
					if(Helfer.confirm("sure")) { 
						int selectID = Integer.parseInt(fld_personalID.getText()); 
						try {
						boolean control = verpersonal.deletePersonal(selectID);  
						if(control) {  
							Helfer.showMsg("erfolgreich");  
							fld_personalID.setText(null);
							updatePersonalModel();
						}
						}catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}  
					}
				}
			}
		});
		btnlöschen.setForeground(Color.DARK_GRAY);
		btnlöschen.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnlöschen.setBounds(541, 280, 156, 45);
		w_Personal.add(btnlöschen);

		JScrollPane w_scrollpersonal = new JScrollPane();
		w_scrollpersonal.setBounds(10, 11, 521, 390);
		w_Personal.add(w_scrollpersonal);
		
		table_personal = new JTable(personalModel);
		w_scrollpersonal.setViewportView(table_personal); 
		
		JPanel versicherung = new JPanel();
		versicherung.setBackground(Color.WHITE);
		w_tab.addTab("Versicherung", null, versicherung, null);
		versicherung.setLayout(null);
		
		JScrollPane scroll_versich = new JScrollPane();
		scroll_versich.setBounds(0, 10, 412, 420);
		versicherung.add(scroll_versich);
		 
		versicherungMenu = new JPopupMenu (); 
		JMenuItem updateMenu = new JMenuItem("aktualisieren");  
		JMenuItem deleteMenu = new JMenuItem("löschen");  
		versicherungMenu.add(updateMenu); 
		versicherungMenu.add(deleteMenu); 
		 
		updateMenu.addActionListener(new ActionListener() { 
		

			@Override
			public void actionPerformed(ActionEvent e) { 
				/* int selID = Integer.parseInt(table_versich.getValueAt(table_versich.getSelectedRow(), 0).toString()); 
				Versicherung selectVersicherung = versicherung.getFetch(selID); 
				updateGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
				updateGUI.setVisible(true); */
				
				
			} 
			
		});
		 
		/* Mouse'ýn týkldaýðý koordinatlarý almak için */
		table_versich = new JTable(versicherungModel); 
		table_versich.setComponentPopupMenu(versicherungMenu); 
		table_versich.addMouseListener(new MouseAdapter() {   
			
			public void mousePressed(MouseEvent e) {  
				Point point = e.getPoint(); 
				int selectedRow = table_versich.rowAtPoint(point); 
				table_versich.setRowSelectionInterval(selectedRow, selectedRow); 
				
			}
			
		});
		scroll_versich.setViewportView(table_versich);
		
		JLabel lblName_1 = new JLabel("Versicherung Type");
		lblName_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName_1.setBounds(450, 86, 156, 23);
		versicherung.add(lblName_1);
		
		fld_versich = new JTextField();
		fld_versich.setColumns(10);
		fld_versich.setBounds(450, 121, 156, 38);
		versicherung.add(fld_versich);
		
		JButton btn_add_1 = new JButton("Hinzuf\u00FCgen");
		btn_add_1.addActionListener(new ActionListener() { 
		
			public void actionPerformed(ActionEvent e) { 
				if(fld_versich.getText().length()==0) { 
					Helfer.showMsg("fill"); 
				}else { 
					try { /* if(Versicherung.addVersicherung(fld_versich.getText())); */ 
					    Helfer.showMsg("erfolgreich");
						updateversicherungModel();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			  
			}
		});
		btn_add_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_add_1.setBounds(450, 179, 156, 56);
		versicherung.add(btn_add_1);
		table_personal.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) { 
				fld_personalID.setText(table_personal.getValueAt(table_personal.getSelectedRow(), 0).toString());   	 
			}
		}); 
		table_personal.getModel().addTableModelListener(new TableModelListener(){ 

			@Override
			public void tableChanged(TableModelEvent e) {
				if(e.getType() == TableModelEvent.UPDATE) {
				int selectID = Integer.parseInt(table_personal.getValueAt(table_personal.getSelectedRow(), 0).toString()); 
				 
				String selectName = table_personal.getValueAt(table_personal.getSelectedRow(), 1).toString();  
				String selectTcno = table_personal.getValueAt(table_personal.getSelectedRow(), 2).toString();  
				String selectPass = table_personal.getValueAt(table_personal.getSelectedRow(), 3).toString(); 
				 
				
					try {
						boolean control = verpersonal.updatePersonal(selectID, selectTcno, selectPass, selectName);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				
			  } 
		  }	
	   });
    }
	 
	
	public void updatePersonalModel() throws SQLException { 
		DefaultTableModel clearModel = (DefaultTableModel) table_personal.getModel(); 
		clearModel.setRowCount(0);
				for(int i=0; i < verpersonal.getPersonalList().size(); i++ ) { 
					personalData[0] = verpersonal.getPersonalList().get(i).getId(); 
					personalData[1] = verpersonal.getPersonalList().get(i).getName(); 
					personalData[2] = verpersonal.getPersonalList().get(i).getTcno(); 
					personalData[3] = verpersonal.getPersonalList().get(i).getPassword(); 
					personalModel.addRow(personalData);
				}
	}    
	
	public void updateversicherungModel() throws SQLException { 
		DefaultTableModel clearModel = (DefaultTableModel) table_versich.getModel(); 
		clearModel.setRowCount(0);  
		for(int i=0; i < versicherung.getVersicherungList().size(); i++ ) { 
			versicherungData[0] = versicherung.getVersicherungList().get(i).getId(); 
			versicherungData[1] = versicherung.getVersicherungList().get(i).getName(); 
			versicherungModel.addRow(versicherungData);
		}
	            }
	}

