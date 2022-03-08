package fr.isika.cda.amap_generation.model.supplier;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_PRODUCT", discriminatorType = DiscriminatorType.STRING)
@NamedQueries({ @NamedQuery(name = "Product.findAll", query = "select p from Product p"),
		@NamedQuery(name = "ShopProduct.findAll", query = "select s from ShopProduct s") })
public abstract class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	protected Long id;

	@Column(name = "NAME")
	protected String name;

	@Column(name = "SHORT_DESC")
	protected String shortDescription;

	@Lob
	@Column(name = "LONG_DESC")
	protected String longDescription;

	@Column(name = "PRICE")
	protected BigDecimal price;

	@Column(name = "DATE_OF_CREATION")
	protected Date dateOfCreation;

	@Column(name = "IMAGE")
	protected Byte image;

	@Column(name = "QUANTITY")
	protected int quantity;

	// Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}


	public Byte getImage() {
		return image;
	}

	public void setImage(Byte image) {
		this.image = image;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantite) {
		this.quantity = quantite;
	}

}
