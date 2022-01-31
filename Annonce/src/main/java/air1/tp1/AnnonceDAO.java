package air1.tp1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnnonceDAO extends DAO<Annonce> {
	public AnnonceDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Annonce obj) {
		// TODO Auto-generated method stub
		try {
//			ResultSet result = this.connect
//									.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
//									.executeQuery("select nextval('\"Annonce_id_seq\"') as id");
//			if (result.first()) {
//				int id = result.getInt("id");
				PreparedStatement prepare = this.connect
												.prepareStatement("INSERT INTO annonce (title, description, adress, mail, date) VALUES(?, ?, ?, ?, ?)");
				//prepare.setLong(1, id);
				prepare.setString(1, obj.getTitle());
				prepare.setString(2, obj.getDescription());
				prepare.setString(3, obj.getAdress());
				prepare.setString(4, obj.getMail());
				prepare.setDate(5, obj.getDate());
				
				prepare.executeUpdate();
				
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Annonce find(String title) {
		// TODO Auto-generated method stub
		Annonce annonce = new Annonce();
		
		try {
			PreparedStatement prepare = this.connect
											.prepareStatement("SELECT * FROM annonce WHERE title = ?",
													ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prepare.setString(1, title);
			ResultSet result = prepare.executeQuery();
			
			if (result.first()) {
				annonce.setTitle(result.getString("title"));
				annonce.setDescription(result.getString("description"));
				annonce.setAdress(result.getString("adress"));
				annonce.setMail(result.getString("mail"));
				annonce.setDate(result.getDate("date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return annonce;
	}

	@Override
	public ArrayList<Annonce> list() {
		// TODO Auto-generated method stub
		ArrayList<Annonce> AnnonceList = new ArrayList<Annonce>();
		Annonce annonce = new Annonce();
		
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
											.executeQuery("SELECT * FROM annonce");
			while (result.next()) {
				annonce = new Annonce(result.getString("title"), result.getString("description"), result.getString("adress"), result.getString("mail"), result.getDate("date"));
				AnnonceList.add(annonce);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return AnnonceList;
	}
	
	@Override
	public boolean update(Annonce obj) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement prepare = this.connect
											.prepareStatement("UPDATE annonce SET description = ?, adress = ?, mail = ?, date = ? WHERE title = ?");
			
			
			prepare.setString(1, obj.getDescription());
			prepare.setString(2, obj.getAdress());
			prepare.setString(3, obj.getMail());
			prepare.setDate(4, obj.getDate());
			prepare.setString(5, obj.getTitle());
//			prepare.setLong(6, obj.getId());
			
			prepare.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean delete(Annonce obj) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement prepare = this.connect
											.prepareStatement("DELETE FROM annonce WHERE title = ?",
													ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			prepare.setString(1, obj.getTitle());
			prepare.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
}
