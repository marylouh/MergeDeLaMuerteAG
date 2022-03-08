package fr.isika.cda.amap_generation.presentation.registration;

import java.io.Serializable;
import java.util.Date;

import fr.isika.cda.amap_generation.model.user.Gender;
import fr.isika.cda.amap_generation.model.user.TypeOfPlace;

public class SupplierRegistrationDto implements Serializable {
	
private static final long serialVersionUID = -2596978776126573231L;
	
	// Person
	public String lastName;
	private String firstName;
	private String age;
	private Date birthDate;
	private Gender gender;
	private String login;
	private String password;
	
	// Supplier
	private String companyName;
	private String siretNumber;
	private Date dateOfEntry;
	
	// Address
	private String number;
	private TypeOfPlace typeOfPlace;
	private String nameOfPlace;
	private String postalCode;
	private String town;
	public String getLastName() {
		return lastName;
	}
	
	public Date getDateOfEntry() {
		return dateOfEntry;
	}
	public void setDateOfEntry(Date dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSiretNumber() {
		return siretNumber;
	}
	public void setSiretNumber(String siretNumber) {
		this.siretNumber = siretNumber;
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
