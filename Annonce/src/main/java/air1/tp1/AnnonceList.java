package air1.tp1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AnnonceList
 */
@WebServlet("/AnnonceList")
public class AnnonceList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnonceList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// recherche la liste de tous les éléments
			DAO<Annonce> annonceDAO = new AnnonceDAO(ConnectionDB.getInstance());
			ArrayList<Annonce> annonceList = annonceDAO.list();
			
			// envoie la liste à JSP
			request.setAttribute("annonceList", annonceList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/AnnonceList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
