package ResultView;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import Controller.Control;

public class linkR  extends JFrame  {
	linkR thisFrame ;
	public static ArrayList<String> allSwitch = new ArrayList<>();
	public static ArrayList<String> allIn = new ArrayList<>();
	public JTextField getS , getA, geta,getb,getc;
	Control c = new Control();
	public int row;
	public int column;
	DefaultTableModel model;
	
	class ListenerMgr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(EXIT_ON_CLOSE)) {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				System.exit(0);
			}
			}
		}
		public linkR() {
			JPanel getall = new JPanel();
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
			 model = (DefaultTableModel)table.getModel();
			model.addColumn("D/M/Y");
			model.addColumn("TIME");
			model.addColumn("DETAIL");
			// Data Row
			for(int i=0;i <= 30; i++){
				model.addRow(new Object[0]);
		//		model.setValueAt(i+1, i, 0);
				}
			JButton get = new JButton ("ACCEPT");
			get.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Control.day.add(geta.getText());
					Control.month.add(getb.getText());
					Control.year.add(getc.getText());
					model.setValueAt(geta.getText(), column, 0);
					model.setValueAt(getb.getText(), column, 1);
					model.setValueAt(getc.getText(), column, 2);
					column++;
					geta.setText("");
					getb.setText("");
					getc.setText("");
				}
			});	

	
			text.add(show);
			text.add(geta);
			text.add(show1);
			text.add(getb);
			text.add(show2);
			text.add(getc);
			text.add(get);
			linkP.add(scrollPane);
			center.add(linkP);
			center.add(text);
			add(center, BorderLayout.CENTER);
		}




	

}
