
package fr.isika.cda.amap_generation.presentation.registration;

import java.io.Serializable;

import fr.isika.cda.amap_generation.model.user.TypeOfPlace;

public class AmapRegistrationDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1568L;

	// Amap
	private String nameAmap;

	// AmapWebMaster
	private String login;
	private String password;

	// Address
	private String number;
	private TypeOfPlace typeOfPlace;
	private String nameOfPlace;
	private String postalCode;
	private String town;

	public String getNameAmap() {
		return nameAmap;
	}

	public void setNameAmap(String nameAmap) {
		this.nameAmap = nameAmap;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public TypeOfPlace getTypeOfPlace() {
		return typeOfPlace;
	}

	public void setTypeOfPlace(TypeOfPlace typeOfPlace) {
		this.typeOfPlace = typeOfPlace;
	}

	public String getNameOfPlace() {
		return nameOfPlace;
	}

	public void setNameOfPlace(String nameOfPlace) {
		this.nameOfPlace = nameOfPlace;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

}
