package fr.isika.cda.amap_generation.model.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "PERSON_TYPE", discriminatorType = DiscriminatorType.STRING)
@NamedQueries(@NamedQuery(name = "Person.findAll", query = "select u from Person u"))
public abstract class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_PERSON")
	protected Long idPerson;

	@Column(name = "NOM")
	protected String lastName;

	@Column(name = "PRENOM")
	protected String firstName;

	@Column(name = "AGE")
	protected int age;

	@Temporal(TemporalType.DATE)
	@Column(name = "NAISSANCE")
	protected Date birthDate;

	@Column(name = "CIVILITE")
	@Enumerated(EnumType.STRING)
	protected Gender gender;

	@Column(name = "IDENTIFIANT")
	private String login;

	@Column(name = "MOT_DE_PASSE")
	private String password;
	
	@Column(name="PERSON_TYPE")
	@Enumerated(EnumType.STRING)
	protected PersonType personType;
	
	public Person() {
		super();
	}

	public Long getId() {
		return idPerson;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
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

	public PersonType getPersonType() {
		return personType;
	}

	public void setPersonType(PersonType personType) {
		this.personType = personType;
	}
	
	

}
