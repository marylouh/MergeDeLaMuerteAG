package fr.isika.cda.amap_generation.model.amap;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class AmapAdministrator implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -682776329048849417L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String loginAwm;

	private String passwordAwm;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idAmap", nullable = true)
	private Amap amap;

	// ----------Constructeur-------------------

	public AmapAdministrator() {
		super();
		// TODO Auto-generated constructor stub
	}

	// ----------Getters & Setters-------------------
	public String getLoginAwm() {
		return loginAwm;
	}

	public void setLoginAwm(String loginAwm) {
		this.loginAwm = loginAwm;
	}
	public String getPasswordAwm() {
		return passwordAwm;
	}

	public void setPasswordAwm(String passwordAwm) {
		this.passwordAwm = passwordAwm;
	}

	public Amap getAmap() {
		return amap;
	}

	public void setAmap(Amap amap) {
		this.amap = amap;
	}

	public long getId() {
		return id;
	}
	// -------------------To String------------------------

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AmapWebMaster [id=");
		builder.append(id);
		builder.append(", loginAwm=");
		builder.append(loginAwm);
		builder.append(", passwordAwm=");
		builder.append(passwordAwm);
		builder.append(", amap=");
		builder.append(amap);
		builder.append("]");
		return builder.toString();
	}
}