package air1.tp1;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AnnonceUpdate
 */
@WebServlet("/AnnonceUpdate")
public class AnnonceUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnonceUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/AnnonceUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Annonce annonce = new Annonce();
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String adress = request.getParameter("adress");
		String mail = request.getParameter("mail");
		
		ArrayList<String> paraList = new ArrayList<String>();
		paraList.add(title);
		paraList.add(description);
		paraList.add(adress);
		paraList.add(mail);
		
		// validation du formulaire: tous les champs sont obligatoires
		boolean validResult = true;
		for (String i : paraList) {
			if (i == null || i.length() == 0) {
				validResult = false;
				break;
			}
		}
		
		if (!validResult) {
			request.setAttribute("message", "Tous les champs sont obligatoires!");
			this.getServletContext().getRequestDispatcher("/AnnonceUpdate.jsp").forward(request, response);
			
		} else {
			annonce.setTitle(title);
			annonce.setDescription(description);
			annonce.setAdress(adress);
			annonce.setMail(mail);
			long ms = System.currentTimeMillis();
			Date date = new Date(ms);
			annonce.setDate(date);
			
			try {
				DAO<Annonce> annonceDAO = new AnnonceDAO(ConnectionDB.getInstance());
				boolean result = annonceDAO.update(annonce);
				
				if (result) {
					request.setAttribute("message", "Annonce updated!");
				}
				
			} catch (Exception e) {
				System.out.println("Exception: doPost (AnnonceUpdate)!");
				request.setAttribute("message", "Error exception");
				this.getServletContext().getRequestDispatcher("/AnnonceUpdate.jsp").forward(request, response);
				e.printStackTrace();
			}
			
			this.getServletContext().getRequestDispatcher("/AnnonceList").forward(request, response);
		}
	}

}
