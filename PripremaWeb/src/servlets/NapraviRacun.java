package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Racun;
import beans.Racuni;

/**
 * Servlet implementation class NapraviRacun
 */
@WebServlet("/NapraviRacun")
public class NapraviRacun extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NapraviRacun() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Racuni racuni = (Racuni) request.getSession().getAttribute("racuni");
		
		//preuzimanje parametara
		String brojRacuna = (String) request.getParameter("txt_broj");
		String tipRacuna = (String) request.getParameter("tip_racuna");
		
		String raspolozivoStanjeTekst = (String) request.getParameter("txt_raspolozivo");
		int raspolozivoStanje = Integer.parseInt(raspolozivoStanjeTekst);
		
		String rezervisanoStanjeTekst = (String) request.getParameter("txt_rezervisano");
		int rezervisanoStanje = Integer.parseInt(rezervisanoStanjeTekst);
		String online = (String) request.getParameter("cb_online");
		if(online !=null)
			online="DA";
		else
			online="NE";
		int ukupno = rezervisanoStanje + raspolozivoStanje;
		
		Racun noviRacun = new Racun(brojRacuna,tipRacuna,raspolozivoStanje,rezervisanoStanje,ukupno,online,"DA");
		
		if(racuni==null){
			racuni=new Racuni();
			request.getSession().setAttribute("racuni", racuni);
		}
		
		Boolean dodat=racuni.dodajRacun(noviRacun); 
		System.out.println("Dodat je " + dodat);
		
		if(dodat){
			request.setAttribute("error", "");
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/JSP/racuni.jsp");
			disp.forward(request, response);
		}else{
			//moramo da mu kazemo gde je greska
			String error = "Ponavlja se!";
			request.setAttribute("error", error);
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/JSP/racuni.jsp");
			disp.forward(request, response);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
