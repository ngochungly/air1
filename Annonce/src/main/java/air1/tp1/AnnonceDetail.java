package air1.tp1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AnnonceRead
 */
@WebServlet("/AnnonceDetail")
public class AnnonceDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnonceDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Annonce annonce = new Annonce();
		String title = request.getParameter("title");
		
		try {
			// recherche l'annonce avec title
			DAO<Annonce> annonceDAO = new AnnonceDAO(ConnectionDB.getInstance());
			annonce = annonceDAO.find(title);
			
			// set annonce pour envoyer à JSP
			request.setAttribute("annonce", annonce);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/AnnonceDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Annonce annonce = new Annonce();
		String title = request.getParameter("title");
		String submit_type = request.getParameter("button");
		
		try {
			// recherche l'annonce avec title
			DAO<Annonce> annonceDAO = new AnnonceDAO(ConnectionDB.getInstance());
			annonce = annonceDAO.find(title);
			
			if (submit_type.equals("update")) {
				// set annonce pour envoyer à JSP
				request.setAttribute("annonce", annonce);
				
				this.getServletContext().getRequestDispatcher("/AnnonceUpdate.jsp").forward(request, response);

			} else if (submit_type.equals("delete")) {
				boolean result = annonceDAO.delete(annonce);
				
				if (result) {
					request.setAttribute("message", "Annonce deleted!");
				} else {
					request.setAttribute("message", "Annonce deleted fail!");
				}
				
				this.getServletContext().getRequestDispatcher("/AnnonceList").forward(request, response);
				
			} else {
				request.setAttribute("message", "Submit_type invalid.");
				this.getServletContext().getRequestDispatcher("/PageErreur.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

}
