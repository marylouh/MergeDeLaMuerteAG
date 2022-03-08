package fr.isika.cda.amap_generation.model.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

//@PrimaryKeyJoinColumn(name = "idPerson")
@NamedQueries({ @NamedQuery(name = "Administrator.findAll", query = "select a from Administrator a") })
@Entity
public class Administrator implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8603131738848600183L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADMIN_ID")
	private Long id;

	@Column(name = "IDENTIFIANT")
	private String loginAdmin;

	@Column(name = "MOT_DE_PASSE")
	private String passwordAdmin;

	public Administrator() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getLoginAdmin() {
		return loginAdmin;
	}

	public void setLoginAdmin(String loginAdmin) {
		this.loginAdmin = loginAdmin;
	}

	public String getPasswordAdmin() {
		return passwordAdmin;
	}

	public void setPasswordAdmin(String passwordAdmin) {
		this.passwordAdmin = passwordAdmin;
	}

}
