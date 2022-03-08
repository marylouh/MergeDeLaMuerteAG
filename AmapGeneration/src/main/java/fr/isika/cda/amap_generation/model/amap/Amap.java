package fr.isika.cda.amap_generation.model.amap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.isika.cda.amap_generation.model.supplier.Supplier;
import fr.isika.cda.amap_generation.model.user.Address;
import fr.isika.cda.amap_generation.model.user.Registered;

@Entity
@Table
public class Amap implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6485264776732397188L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "NOM_AMAP")
	private String nameAmap;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_ADRESS")
	private Address localisation;

	@Temporal(TemporalType.DATE)
	private Date dateOfSubscription;

	@Column(name = "Slogan")
	private String slogan;

	@Column(name = "STATUT_INSCRIPTION")
	@Enumerated(EnumType.STRING)
	private Status registerStatus;

	@Column(name = "TYPE_DE_FORMULE")
	@Enumerated(EnumType.STRING)
	private TypeOfRentalFormulas typeOfRentalFormulas;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Supplier> suppliers = new ArrayList<>();

	@OneToMany(targetEntity = Registered.class, mappedBy = "amap")
	private List<Registered> registereds = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, targetEntity = AmapAdministrator.class, mappedBy = "amap")
	private List<AmapAdministrator> amapWebMaster = new ArrayList<>();

	@OneToMany(targetEntity = Rental.class, mappedBy = "amap")
	private List<Rental> rentals = new ArrayList<>();

	// --------------Constructeur-----------------------
	public Amap() {
	}

//----------------getter & setter------------

	public String getNameAmap() {
		return nameAmap;
	}

	public void setNameAmap(String nameAmap) {
		this.nameAmap = nameAmap;
	}

	public Address getLocalisation() {
		return localisation;
	}

	public void setLocalisation(Address localisation) {
		this.localisation = localisation;
	}

	public Date getDateOfSubscription() {
		return dateOfSubscription;
	}

	public void setDateOfSubscription(Date dateOfSubscription) {
		this.dateOfSubscription = dateOfSubscription;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public long getId() {
		return id;
	}

	public List<Registered> getRegistereds() {
		return registereds;
	}

	public void setRegistereds(List<Registered> registereds) {
		this.registereds = registereds;
	}

	public List<AmapAdministrator> getAmapWebMaster() {
		return amapWebMaster;
	}

	public void setAmapWebMaster(List<AmapAdministrator> amapWebMaster) {
		this.amapWebMaster = amapWebMaster;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	public Status getRegisterStatus() {
		return registerStatus;
	}

	public void setRegisterStatus(Status registerStatus) {
		this.registerStatus = registerStatus;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public boolean addRegistered(Registered registered) {
		registered.setAmap(this);
		return this.registereds.add(registered);
	}

	public boolean addSupplier(Supplier supplier) {
		supplier.setAmap(this);
		return this.suppliers.add(supplier);
	}
	
	

	public TypeOfRentalFormulas getTypeOfRentalFormulas() {
		return typeOfRentalFormulas;
	}

	public void setTypeOfRentalFormulas(TypeOfRentalFormulas typeOfRentalFormulas) {
		this.typeOfRentalFormulas = typeOfRentalFormulas;
	}

	public boolean addWebMaster(AmapAdministrator amapAdministrator) {
		amapAdministrator.setAmap(this);
		return this.amapWebMaster.add(amapAdministrator);
	}

	// -------------------To String------------------------

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Amap [id=");
		builder.append(id);
		builder.append(", nameAmap=");
		builder.append(nameAmap);
		builder.append(", localisation=");
		builder.append(localisation);
		builder.append(", dateOfSubscription=");
		builder.append(dateOfSubscription);
		builder.append(", suppliers=");
		builder.append(suppliers);
		builder.append(", registereds=");
		builder.append(registereds);
		builder.append(", amapWebMaster=");
		builder.append(amapWebMaster);
		builder.append(", rentals=");
		builder.append(rentals);
		builder.append("]");
		return builder.toString();
	}

}
