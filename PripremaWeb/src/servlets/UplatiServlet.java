package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Racuni;

/**
 * Servlet implementation class UplatiServlet
 */
@WebServlet("/UplatiServlet")
public class UplatiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UplatiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			Racuni racuni = (Racuni) request.getSession().getAttribute("racuni");
			String id = (String) request.getParameter("id");
			int index= racuni.nadjiIndex(id);
			String iznosTxt = (String) request.getParameter("txt_iznos");
			int iznos = Integer.parseInt(iznosTxt);
			System.out.println("IZNOS" + iznos);
			System.out.println("INDEX" + index);
			racuni.getRacuni().get(index).Uplati(iznos);
			
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/JSP/racuni.jsp");
			disp.forward(request, response);
			
			
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
