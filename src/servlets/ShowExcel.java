package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Manager;
import model.SheetA;

/**
 * Servlet implementation class ShowExcel
 */
@WebServlet("/ShowExcel")
public class ShowExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Manager manager = Manager.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowExcel() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        }
     

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<SheetA> sheets = manager.getSheets();
    	request.setAttribute("sheets", sheets);
    	if(request.getParameter("index") != null) {
    		int index = Integer.parseInt(request.getParameter("index"));
    		System.out.println(index);
    		request.setAttribute("sheet", sheets.get(index+1).getName());
    		request.setAttribute("data", manager.getSheetByIndex(index));
    	}
    	else {
    		System.out.println("here");
    	request.setAttribute("sheet", sheets.get(1).getName());
    	request.setAttribute("data", manager.getSheetByIndex(0));
    	}
		getServletContext().getRequestDispatcher("/jsp/init.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
