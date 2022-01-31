package air1.tp1;

import java.sql.Connection;
import java.util.ArrayList;

public abstract class DAO<T> {
	protected Connection connect = null;
	
	// Constructeur
	public DAO(Connection conn) {
		this.connect = conn;
	}
	
	// Methode de creation d'item
	public abstract boolean create(T obj);
	
	// Methode de recherche un item
	public abstract T find(String title);
	
	// Methode de recherche tous les items
	public abstract ArrayList<T> list();
	
	// Methode de mise à jour
	public abstract boolean update(T obj);
	
	// Methode pour effacer un item
	public abstract boolean delete(T obj);
}
