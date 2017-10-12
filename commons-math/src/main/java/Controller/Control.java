package Controller;

import java.util.ArrayList;

import Model.Database;
import Model.Write;
import ResultView.DetailView;
import ResultView.DetailViewD;
import ResultView.DetailViewV;
import ResultView.Finder;
import ResultView.LinkR;

//thiti
public class Control  {
	public static ArrayList<String>day = new ArrayList<>();
	public static ArrayList<String>month = new ArrayList<>();
	public static ArrayList<String>year = new ArrayList<>();
	public static LinkR frame;
	public static DetailView frame1;
	public static DetailViewV frame2;
	public static DetailViewD frame3;
	public static Finder frame4;
	public static Write writeFile = new Write();
	public static ArrayList<String>day1 = new ArrayList<>();
	public static ArrayList<String>month1 = new ArrayList<>();
	public static ArrayList<String>year1 = new ArrayList<>();
	public static Database d = new Database();
	public void link (){
		frame = new LinkR();
		frame.setTitle("TABLE1");
		frame.pack();
		frame.setVisible(true);
		frame.setSize(700, 550);
	}
	public void detail (){
		frame1 = new DetailView();
		frame1.setTitle("TABLE1");
		frame1.pack();
		frame1.setVisible(true);
		frame1.setSize(700, 200);
	}
	public void detailV (){
		frame2 = new DetailViewV();
		frame2.setTitle("TABLE1");
		frame2.pack();
		frame2.setVisible(true);
		frame2.setSize(700, 200);
	}
	public void detailD(){
		frame3 = new DetailViewD();
		frame3.setTitle("TABLE1");
		frame3.pack();
		frame3.setVisible(true);
		frame3.setSize(700, 200);
	}
	public void finder(){
		frame4 = new Finder();
		frame4.setTitle("TABLE1");
		frame4.pack();
		frame4.setVisible(true);
		frame4.setSize(700, 500);
	}
	public void writeToFile(){
		writeFile.writeToFile();
	}







}
