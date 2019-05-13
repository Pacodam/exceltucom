package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Manager;
import model.SheetA;

/**
 * Servlet implementation class ExcelConfigs
 */
@WebServlet("/ExcelConfigs")
public class ExcelConfigs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Manager manager = Manager.getInstance();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcelConfigs() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 if(request.getParameter("send") != null) {
    	  //la selección nos dice qué sheet queremos editar
    	   int selection = Integer.parseInt(request.getParameter("selection"));
    	   System.out.println(selection);
    	   HashMap<String, String> sheetCols = manager.getSheetCol(selection);
    	   request.setAttribute("cols", sheetCols);
    	   request.setAttribute("name", manager.getSheetName(selection));
    	   request.getRequestDispatcher("/jsp/conf.jsp").forward(request, response);
    	 }
    	
        }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SheetA> sheets = manager.getSheets();
    	request.setAttribute("sheets", sheets);
    	HashMap<String, String> sheetCols = null;
    	if(request.getParameter("selection") != null) {
    		 int selection = Integer.parseInt(request.getParameter("selection"));
    		 sheetCols = manager.getSheetCol(selection);
    		 request.setAttribute("name", manager.getSheetName(selection));
    	}
    	else {
    	   sheetCols = manager.getSheetCol(1);
    	   request.setAttribute("name", manager.getSheetName(1));
    	}
  	     request.setAttribute("cols", sheetCols);
		getServletContext().getRequestDispatcher("/jsp/conf.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 if(request.getParameter("send") != null) {
	    	   int selection = Integer.parseInt(request.getParameter("selection"));
	    	   request.setAttribute("selection", selection);
	    	   System.out.println(selection);
	    	 }
		doGet( request, response);
	}

}
