package ResultView;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import Controller.Control;

public class Finder  extends JFrame  {
	public JTextField getS , getA, geta,getb,getc;
	static DefaultTableModel model;
	public static int column;
	public JComboBox<String> c;
	public ArrayList<String> check = new ArrayList<String>();
	public ArrayList<String> checkOne = new ArrayList<String>();
	class ListenerMgr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(EXIT_ON_CLOSE)) {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				System.exit(0);
			}
			}
		}
	public Finder() {
		JPanel text = new JPanel();
		JPanel center = new JPanel();
		JPanel linkP = new JPanel();
		getS= new JTextField(10);
		// Table
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		 model = new DefaultTableModel(){
			 public Class<?> getColumnClass(int column){
				 switch (column) {
				 case 0:
					 return Boolean.class;
				 case 1:
					 return String.class;
				 case 2:
					 return String.class;
				 case 3:
					 return String.class;
				 }
				return null;
				 
			 }
		 };
		 table.setModel(model);
		 model.addColumn("Select");
		model.addColumn("D/M/Y");
		model.addColumn("TIME");
		model.addColumn("DETAIL");
				// Model for Table
		JLabel show = new JLabel("D/M/Y : ");
		  geta= new JTextField (10);
		  c = new JComboBox<String>();
		 for(int i =0;i<Control.day1.size();i++){
			 int count = 0;
			 for(int j=i+1;j<Control.day1.size();j++){
				 if(Control.day1.get(i).equals(Control.day1.get(j))){
					 count = count +1;
				 }
			 }
			 if(count ==0){
				 checkOne.add(Control.day1.get(i));
			 }
			 
		 }
		 for(int i =0;i<checkOne.size();i++){
			 c.addItem(checkOne.get(i));
			}
		JButton get = new JButton ("Find");
		get.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(c.getSelectedItem().equals("")){
					
				}
				else{	
					for (int i = 0; i < model.getRowCount(); i++) {
						model.removeRow(i);
					}
					column=0;
					for(int i=0;i < Control.day1.size(); i++){
						if(c.getSelectedItem().equals(Control.day1.get(i))){
							model.addRow(new Object[0]);
							System.out.println(i);
							model.setValueAt(false, column, 0);
							model.setValueAt(Control.day1.get(i), column, 1);
							model.setValueAt(Control.month1.get(i), column, 2);
							model.setValueAt(Control.year1.get(i), column, 3);
							column++;
						}
					}
				}
			}
		});	

		text.add(show);
		text.add(c);
		text.add(get);
		linkP.add(scrollPane);
		center.add(linkP);
		center.add(text);
		add(center, BorderLayout.CENTER);
	}




	

}
