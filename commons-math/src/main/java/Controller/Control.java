package Controller;

import java.awt.Component;
import java.util.ArrayList;

import ResultView.linkR;



public class Control  {
	public static ArrayList<String>day = new ArrayList<>();
	public static ArrayList<String>month = new ArrayList<>();
	public static ArrayList<String>year = new ArrayList<>();
	public void link (){
		linkR frame = new linkR();
		frame.setTitle("TABLE1");
		frame.pack();
		frame.setVisible(true);
		frame.setSize(700, 550);
	}







}
