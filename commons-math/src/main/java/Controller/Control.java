package Controller;

import java.awt.Component;
import java.util.ArrayList;

import ResultView.detailView;
import ResultView.detailViewD;
import ResultView.detailViewV;
import ResultView.linkR;



public class Control  {
	public static ArrayList<String>day = new ArrayList<>();
	public static ArrayList<String>month = new ArrayList<>();
	public static ArrayList<String>year = new ArrayList<>();
	public static linkR frame;
	public static detailView frame1;
	public static detailViewV frame2;
	public static detailViewD frame3;
	public static ArrayList<String>day1 = new ArrayList<>();
	public static ArrayList<String>month1 = new ArrayList<>();
	public static ArrayList<String>year1 = new ArrayList<>();
	
	public void link (){
		frame = new linkR();
		frame.setTitle("TABLE1");
		frame.pack();
		frame.setVisible(true);
		frame.setSize(700, 550);
	}
	public void detail (){
		frame1 = new detailView();
		frame1.setTitle("TABLE1");
		frame1.pack();
		frame1.setVisible(true);
		frame1.setSize(700, 200);
	}
	public void detailV (){
		frame2 = new detailViewV();
		frame2.setTitle("TABLE1");
		frame2.pack();
		frame2.setVisible(true);
		frame2.setSize(700, 200);
	}
	public void detailD(){
		frame3 = new detailViewD();
		frame3.setTitle("TABLE1");
		frame3.pack();
		frame3.setVisible(true);
		frame3.setSize(700, 200);
	}







}
