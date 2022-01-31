package tp4.univ.paris13;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import tp4.univ.paris13.hibernate.HibernateUtil;
import tp4.univ.paris13.model.Personne;

public class Test {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session session = null;
		
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			List<Personne> personnes = session.createCriteria(Personne.class).list();
			System.out.println("With CRITERIA API : personnes : "+personnes.size());

			List<Personne> personnesHQL = session.createQuery("FROM Personne").list();
			System.out.println("WITH HQL QUERY : personnesHQL : "+personnesHQL.size());
			
			List<Personne> personnesSQL = session.createSQLQuery("select * from personne").list();
			System.out.println("WITH SQL QUERY : personnesSQL : "+personnesSQL.size());
			
			tx.commit();
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}

	}

}
