package air1.tp1;

import java.sql.Date;

public class Annonce {
	//private Integer id;
	private String title;
	private String description;
	private String adress;
	private String mail;
	private Date date;
	
	public Annonce() {
		// TODO Auto-generated constructor stub
	}
	
//	public Integer getId() {
//		return id;
//	}
//	
//	public void setId(Integer id) {
//		this.id = id;
//	}
	
	public Annonce(String title, String description, String adress, String mail, Date date) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.description = description;
		this.adress = adress;
		this.mail = mail;
		this.date = date;
	}

	// Title
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	// Description
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	// Adress
	public String getAdress() {
		return adress;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	
	// Mail
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	// Date
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
}
