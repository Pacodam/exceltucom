package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.SheetA;
import persistence.ReadExcel;

public class Manager {

	private ReadExcel excel;
	
	private static final Manager instance = new Manager();
	public static Manager getInstance() { return instance; }
	
	//Controller inits the initial view (SplitView with JPanel left and Jpanel right)
		 public Manager() {
		   excel = new ReadExcel();
		   //excel.loadSheets();
		   excel.getSheet1();
		 }
		 
		 public List<SheetA> getSheets(){
			 List<SheetA> sheets = excel.getSheets();
			 SheetA s = new SheetA("Configuration");
			 s.setHref("jsp/conf.jsp");
			 sheets.add(0, s);
			 return sheets;
		 }
		 
		 public String getSheetName(int i) {
			 return excel.getName(i);
		 }
		 
		 public List<String[]> getSheet1() {
			 System.out.println("sizzzze " + excel.getSheet1().size());
			 return excel.getSheet1();
		 }
}
