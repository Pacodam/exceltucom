package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import model.Alumno;
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
		   excel.getSheetByIndex(0);
		 }
		 
		 public List<SheetA> getSheets(){
			 List<SheetA> sheets = excel.getSheets();
			 sheets.get(0).setHref("ShowExcel?index=0");
			 sheets.get(1).setHref("ShowExcel?index=1");
			 sheets.get(2).setHref("ShowExcel?index=2");
			 sheets.get(3).setHref("ShowExcel?index=3");
			 sheets.get(4).setHref("ShowExcel?index=4");
			 SheetA s = new SheetA("Configuration");
			 s.setHref("ExcelConfigs");
			 sheets.add(0, s);
			 return sheets;
		 }
		 
		 public String getSheetName(int i) {
			 return excel.getName(i);
		 }
		 
		 public List<String[]> getSheetByIndex(int i) {
			 return excel.getSheetByIndex(i);
		 }
		 
		 public List<Alumno> getAlumnos(){
			 return excel.getAlumnos();
		 }
		 
		 public HashMap<String, String> getSheetCol(int i){
			 return excel.getSheetCol(i);
		 }
}
