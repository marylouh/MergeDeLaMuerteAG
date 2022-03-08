package fr.isika.cda.amap_generation.presentation.registration;

import java.io.Serializable;
import java.util.Date;

import fr.isika.cda.amap_generation.model.amap.Amap;
import fr.isika.cda.amap_generation.model.user.Gender;
import fr.isika.cda.amap_generation.model.user.TypeOfPlace;

// DTO : Data Acces Object
public class RegistrationDto implements Serializable {

	private static final long serialVersionUID = -2596978776126573231L;

	// Person
	private String lastName;
	private String firstName;
	private String age;
	private Date birthDate;
	private Gender gender;
	private String login;
	private String password;

	// Registered
	private String alias;
	private String referenceInsciption;

	// Address
	private String number;
	private TypeOfPlace typeOfPlace;
	private String nameOfPlace;
	private String postalCode;
	private String town;

	// Amap
	private Amap amap;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getReferenceInsciption() {
		return referenceInsciption;
	}

	public void setReferenceInsciption(String referenceInsciption) {
		this.referenceInsciption = referenceInsciption;
	}

	public Amap getAmap() {
		return amap;
	}

	public void setAmap(Amap amap) {
		this.amap = amap;
	}

}
