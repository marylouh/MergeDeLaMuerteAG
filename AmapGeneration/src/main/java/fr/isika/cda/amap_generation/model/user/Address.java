package fr.isika.cda.amap_generation.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import fr.isika.cda.amap_generation.model.supplier.Supplier;

@Entity
@NamedQueries(@NamedQuery(name = "Address.findAll", query = "select a from Address a"))
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 5, name = "NUMERO_RUE")
	private String number;

	@Column(name = "TYPE_RUE")
	@Enumerated(EnumType.STRING)
	private TypeOfPlace typeOfPlace;

	@Column(length = 50, name = "NOM_RUE")
	private String nameOfPlace;

	@Column(length = 10, name = "CODE_POSTAL")
	private String postalCode;

	@Column(length = 30, name = "VILLE")
	private String town;

	@ManyToOne
	@JoinColumn(name = "registered_ID")
	private Registered registered;

	@ManyToOne
	@JoinColumn(name = "SUPPLIER_ID")
	private Supplier supplier;

	public Address() {
		super();
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

	public Long getId() {
		return id;
	}

	public Registered getRegistered() {
		return registered;
	}

	public void setRegistered(Registered registered) {
		this.registered = registered;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [id=");
		builder.append(id);
		builder.append(", number=");
		builder.append(number);
		builder.append(", typeOfPlace=");
		builder.append(typeOfPlace);
		builder.append(", nameOfPlace=");
		builder.append(nameOfPlace);
		builder.append(", postalCode=");
		builder.append(postalCode);
		builder.append(", town=");
		builder.append(town);
		builder.append("]");
		return builder.toString();
	}

}
