package persistence;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import model.SheetA;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadExcel {

	//public static final String EXCEL = "../files/ShowExcel.xlsx";
	public static final String EXCEL = "C:/Users/MSI/eclipse-workspace/exceltucom/files/ShowExcel.xlsx";
	public static Workbook workbook;
	public static List<SheetA> sheets;

	/**
	 * Load of workbook
	 */
	public void loadFile() {
		try {
		   workbook = WorkbookFactory.create(new FileInputStream(EXCEL));
		} catch (IOException | InvalidFormatException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * returns sheet name
	 */
	public String getName(int i) {
		loadFile();
		return workbook.getSheetName(i);
	}
	/**
	 * Read of all sheets names
	 * @return
	 */
	public List<SheetA> getSheets(){
		loadFile();
		sheets = new ArrayList<>();
		for (int i = 0; i < workbook.getNumberOfSheets(); i++)
		{
		    Sheet sheet = workbook.getSheetAt(i);
		    sheets.add(new SheetA(sheet.getSheetName())); 
		}
		return sheets;
	}
	
	public List<String[]> getSheet1(){
	  loadFile();
	  List<String[]> data = new ArrayList<>();
	  
	  Sheet sheet = workbook.getSheetAt(0);
	  int numOfRows = sheet.getPhysicalNumberOfRows();
	  int numOfCols = sheet.getRow(0).getPhysicalNumberOfCells();
	  
	  for(int i = 2; i < numOfRows; i++) {
		  //System.out.println("numofRow " + i);
		  Row row = sheet.getRow(i);
		  String[] cellData = new String[numOfCols];
	      for(int j = 0; j < numOfCols; j++) {
	    	   Cell cell = row.getCell(j);
	    	   cell.setCellType(Cell.CELL_TYPE_STRING);
	           cellData[j]= cell.getStringCellValue();
	          
	           }
	      data.add(cellData); 
	 }
	 return data;
	}
	
	/*
	 private void readSheet(Sheet sheet) {
	        Iterator<Row> rowItr = sheet.iterator();
	        List<Employee> empList = new ArrayList<>();
	        // Iterate through rows
	        while(rowItr.hasNext()) {
	            Employee emp = new Employee();
	            Row row = rowItr.next();
	            // skip header (First row)
	            if(row.getRowNum() == 0) {
	                continue;
	            }
	            Iterator<Cell> cellItr = row.cellIterator();
	            // Iterate each cell in a row
	            while(cellItr.hasNext()) {
	                
	                Cell cell = cellItr.next();
	                int index = cell.getColumnIndex();
	                switch(index) {
	                case 0:
	                    emp.setFirstName((String)getValueFromCell(cell));
	                    break;
	                case 1:
	                    emp.setLastName((String)getValueFromCell(cell));
	                    break;
	                case 2:
	                    emp.setDepartment((String)getValueFromCell(cell));
	                    break;
	                case 3:
	                    emp.setDob((Date)getValueFromCell(cell));
	                    break;
	                }
	            }
	            empList.add(emp);
	        }
	        for(Employee emp : empList) {
	            System.out.println("Employee information- " + emp.toString());
	        }
	        
	    }
	    
*/
	// prueba inicial
	/*
	 * public void loadSheets() {
	 * 
	 * // Creating a Workbook from an Excel file (.xls or .xlsx) Workbook workbook =
	 * WorkbookFactory.create(new File(EXCEL));
	 * 
	 * // Retrieving the number of sheets in the Workbook
	 * System.out.println("Workbook has " + workbook.getNumberOfSheets() +
	 * " Sheets : ");
	 * 
	 * 
	 * ============================================================= Iterating over
	 * all the sheets in the workbook (Multiple ways)
	 * =============================================================
	 * 
	 * 
	 * // 1. You can obtain a sheetIterator and iterate over it Iterator<Sheet>
	 * sheetIterator = workbook.sheetIterator();
	 * System.out.println("Retrieving Sheets using Iterator"); while
	 * (sheetIterator.hasNext()) { Sheet sheet = sheetIterator.next();
	 * System.out.println("=> " + sheet.getSheetName()); }
	 * 
	 * // 2. Or you can use a for-each loop
	 * System.out.println("Retrieving Sheets using for-each loop"); for(Sheet sheet:
	 * workbook) { System.out.println("=> " + sheet.getSheetName()); }
	 * 
	 * // 3. Or you can use a Java 8 forEach with lambda
	 * System.out.println("Retrieving Sheets using Java 8 forEach with lambda");
	 * workbook.forEach(sheet -> { System.out.println("=> " + sheet.getSheetName());
	 * });
	 * 
	 * 
	 * ================================================================== Iterating
	 * over all the rows and columns in a Sheet (Multiple ways)
	 * ==================================================================
	 * 
	 * 
	 * // Getting the Sheet at index zero Sheet sheet = workbook.getSheetAt(0);
	 * 
	 * // Create a DataFormatter to format and get each cell's value as String
	 * DataFormatter dataFormatter = new DataFormatter();
	 * 
	 * // 1. You can obtain a rowIterator and columnIterator and iterate over them
	 * System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
	 * Iterator<Row> rowIterator = sheet.rowIterator(); 
	 * while(rowIterator.hasNext()) { 
	 *     Row row = rowIterator.next();
	 *    // Now let's iterate over the columns of the current row 
	 *    Iterator<Cell> cellIterator = row.cellIterator();
	 *        while (cellIterator.hasNext()) { 
	 *            Cell cell = cellIterator.next(); 
	 *            String cellValue = dataFormatter.formatCellValue(cell);
	 *             System.out.print(cellValue + "\t"); }
	 *              System.out.println(); 
	 *        }
	 * 
	 * // 2. Or you can use a for-each loop to iterate over the rows and columns
	 * System.out.
	 * println("\n\nIterating over Rows and Columns using for-each loop\n"); for
	 * (Row row: sheet) { for(Cell cell: row) { String cellValue =
	 * dataFormatter.formatCellValue(cell); System.out.print(cellValue + "\t"); }
	 * System.out.println(); }
	 * 
	 * // 3. Or you can use Java 8 forEach loop with lambda System.out.
	 * println("\n\nIterating over Rows and Columns using Java 8 forEach with lambda\n"
	 * ); sheet.forEach(row -> { row.forEach(cell -> { String cellValue =
	 * dataFormatter.formatCellValue(cell); System.out.print(cellValue + "\t"); });
	 * System.out.println(); });
	 * 
	 * // Closing the workbook workbook.close(); }
	 */

}
