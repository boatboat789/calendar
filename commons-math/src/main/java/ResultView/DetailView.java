package ResultView;
//thiti
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

public class DetailView  extends JFrame  {
	public JTextField getS , getA, geta,getb,getc;

	class ListenerMgr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(EXIT_ON_CLOSE)) {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				System.exit(0);
			}
			}
		}
	public DetailView() {
		JPanel getall = new JPanel();
		JPanel text = new JPanel();
		JPanel center = new JPanel();
		JPanel linkP = new JPanel();
		getS= new JTextField(10);
		JLabel show = new JLabel("D/M/Y : ");
		JLabel show1 = new JLabel("TIME : ");
		JLabel show2 = new JLabel("DETAIL : ");
		  geta= new JTextField (10);
		  getb= new JTextField (5);
		  getc= new JTextField (7);

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
					String[] x = geta.getText().split("/");
					String x1 = getb.getText();
					String x2 = getc.getText();
					for(int i = Integer.parseInt(x[1]); i<=12 ; i++){
						System.out.println(i+" "+x[0]+" "+LinkR.days[i]);
						if(Integer.parseInt(x[0]) <=LinkR.days[i]){
							System.out.println();
							LinkR.model.addRow(new Object[0]);
							LinkR.model.setValueAt(false, LinkR.column, 0);
							String d = x[0]+"/"+i+"/"+x[2];
							LinkR.model.setValueAt(d, LinkR.column, 1);
							LinkR.model.setValueAt(x1, LinkR.column, 2);
							LinkR.model.setValueAt(x2, LinkR.column, 3);
							Control.day.add(d);
							Control.month.add(x1);
							Control.year.add(x2);
							LinkR.column++;
							geta.setText("");
							getb.setText("");
							getc.setText("");
						}
					}
				}
			}
		});	

		text.add(show);
		text.add(geta);
		text.add(show1);
		text.add(getb);
		text.add(show2);
		text.add(getc);
		text.add(get);
		center.add(linkP);
		center.add(text);
		add(center, BorderLayout.CENTER);
	}




	

}
