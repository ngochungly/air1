package tp4.univ.paris13.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import tp4.univ.paris13.model.Adresse;
import tp4.univ.paris13.model.Personne;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration().configure();
			configuration.addPackage("tp4.univ.paris13.model")
							.addClass(Personne.class)
							.addClass(Adresse.class);
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);           
		}
		return sessionFactory;
	}

}
