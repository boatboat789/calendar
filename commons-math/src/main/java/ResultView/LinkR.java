package ResultView;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controller.Control;

public class LinkR  extends JFrame  {
	public  ArrayList<String> remover = new ArrayList<>();
	public  ArrayList<String> remover1 = new ArrayList<>();
	public JTextField getS , getA, geta,getb,getc;
	Control c = new Control();
	public static int column;
	static DefaultTableModel model;
	public static int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	class ListenerMgr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(EXIT_ON_CLOSE)) {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				System.exit(0);
			}
			}
		}
	public LinkR() {
		JPanel text = new JPanel();
		JPanel center = new JPanel();
		JPanel linkP = new JPanel();
		getS= new JTextField(10);
		JLabel show = new JLabel("D/M/Y : ");
		JLabel show1 = new JLabel("TIME : ");
		JLabel show2 = new JLabel("DETAIL : ");
		  geta= new JTextField (5);
		  getb= new JTextField (5);
		  getc= new JTextField (5);
		//getA.setEditable ( false );
		// ScrollPane for Table
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);
		// Table
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		// Model for Table
		// Menu Bar
        JMenuBar menuBar=new JMenuBar();
        
        // Menu 1
        JMenu menu1 = new JMenu("file");
        JMenuItem menu1_1 = new JMenuItem("update delete");
        JMenuItem menu1_2 = new JMenuItem("update insert");
        JMenuItem menu1_3 = new JMenuItem("WriteFile");
        menu1.add(menu1_1);
        menu1.add(menu1_2);
        menu1.add(menu1_3);
        menuBar.add(menu1);
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
		// Data Row
		for(int i=0;i < Control.day1.size(); i++){
			model.addRow(new Object[0]);
			model.setValueAt(false, i, 0);
			model.setValueAt(Control.day1.get(i), column, 1);
			model.setValueAt(Control.month1.get(i), column, 2);
			model.setValueAt(Control.year1.get(i), column, 3);
			column++;
			}
		JButton get = new JButton ("ACCEPT");
		get.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(geta.getText().equals("")){
					
				}
				else if(getb.getText().equals("")){
					
				}
				else if(getc.getText().equals("")){
					
				}
				else if(geta.getText().split("/").length <2){
					
				}
				else if(getb.getText().split(":").length <1){
					
				}
				else {
					Control.day.add(geta.getText());
					Control.month.add(getb.getText());
					Control.year.add(getc.getText());
					model.addRow(new Object[0]);
					model.setValueAt(false, column, 0);
					model.setValueAt(geta.getText(), column, 1);
					model.setValueAt(getb.getText(), column, 2);
					model.setValueAt(getc.getText(), column, 3);
					column++;
					geta.setText("");
					getb.setText("");
					getc.setText("");
				}
			}
		});	
		JButton delete = new JButton ("DELETE");
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < model.getRowCount(); i++) {
					Boolean chked = Boolean.valueOf(model.getValueAt(i, 0).toString());
					if (chked == true) {
						model.removeRow(i);
						remover.add(Control.day1.get(i));
						Control.day1.remove(i);
						Control.month1.remove(i);
						Control.year1.remove(i);
						column--;	
						}
					}
				
				}
			});	
		menu1_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i =0 ;i <remover.size();i++){
					try {
						Control.d.delete(remover.get(i));
					
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				remover.clear();

			}
			});
		menu1_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i =0 ;i <Control.day.size();i++){
					try {
						Control.d.insert(Control.day.get(i),Control.month.get(i),Control.year.get(i));
						Control.day1.add(Control.day.get(i));
						Control.month1.add(Control.month.get(i));
						Control.year1.add(Control.year.get(i));
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				Control.month.clear();
				Control.day.clear();
				Control.year.clear();
				}
			});	
		menu1_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Control.writeFile.writeToFile();;
				}
			});	
		 // Menu 2
        JMenu menu2 = new JMenu("add");
        JMenuItem menu2_1 = new JMenuItem("Daily");
        JMenuItem menu2_2 = new JMenuItem("Weekly");
        JMenuItem menu2_3 = new JMenuItem("Montly");
        JMenuItem menu2_4 = new JMenuItem("Find");
        menu2.add(menu2_1);
        menu2.add(menu2_2);
        menu2.add(menu2_3);
        menu2.add(menu2_4);
        menuBar.add(menu2);
    	menu2_1.addActionListener(new ActionListener() {
			@Override
				public void actionPerformed(ActionEvent e) {
				c.detailD();
				}
			});
		menu2_2.addActionListener(new ActionListener() {
			@Override
				public void actionPerformed(ActionEvent e) {
					c.detailV();
				}
			});	
		menu2_3.addActionListener(new ActionListener() {
			@Override
				public void actionPerformed(ActionEvent e) {
					c.detail();
				}
			});	
		menu2_4.addActionListener(new ActionListener() {
			@Override
				public void actionPerformed(ActionEvent e) {
					c.finder();
				}
			});
		text.add(show);
		text.add(geta);
		text.add(show1);
		text.add(getb);
		text.add(show2);
		text.add(getc);
		text.add(get);
		text.add(delete);
		linkP.add(scrollPane);
		center.add(linkP);
		center.add(text);
		setJMenuBar(menuBar);
		add(center, BorderLayout.CENTER);
	}





	

}
