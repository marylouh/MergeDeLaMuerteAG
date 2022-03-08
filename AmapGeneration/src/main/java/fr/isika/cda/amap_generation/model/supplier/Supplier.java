package fr.isika.cda.amap_generation.model.supplier;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.isika.cda.amap_generation.model.amap.Amap;
import fr.isika.cda.amap_generation.model.user.Address;
import fr.isika.cda.amap_generation.model.user.Person;

@Entity
//@PrimaryKeyJoinColumn(name = "idPerson")
public class Supplier extends Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3416280990594647036L;

	@Column(name = "COMPANY_NAME")
	private String companyName;
	
	@Column(name = "SIRET_NUMBER")
	private String siretNumber;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_OF_ENTRY")
	private Date dateOfEntry;

	@OneToOne
	@JoinColumn(name = "FK_BIO_CERTIFICATION", unique = true)
	private BioCertification bioCertification;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "SUPPLIER_ID")
	private List<Address> addresses;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_SUPPLIER_BASKET")
	private List<BasketProduct> basketProducts;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_SUPPLIER_SHOP")
	private List<ShopProduct> ShopProducts;
	
	@ManyToOne
	@JoinColumn(name = "idAmap", nullable = true)
	private Amap amap;
	
	// Getters & Setters

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

	public Date getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(Date dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

	public BioCertification getBioCertification() {
		return bioCertification;
	}

	public void setBioCertification(BioCertification bioCertification) {
		this.bioCertification = bioCertification;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<BasketProduct> getBasketProducts() {
		return basketProducts;
	}

	public void setBasketProducts(List<BasketProduct> basketProducts) {
		this.basketProducts = basketProducts;
	}

	public List<ShopProduct> getShopProducts() {
		return ShopProducts;
	}

	public void setShopProducts(List<ShopProduct> shopProducts) {
		ShopProducts = shopProducts;
	}

	public Amap getAmap() {
		return amap;
	}

	public void setAmap(Amap amap) {
		this.amap = amap;
	}

	
}
