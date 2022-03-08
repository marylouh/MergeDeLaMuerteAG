package fr.isika.cda.amap_generation.model.supplier;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import fr.isika.cda.amap_generation.model.amap.BasketRental;

@Entity
public class Basket {
	
	public enum seasonState {
		SPRING, SUMMER, AUTUMN, WINTER
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "NUMBER_OF_PRODUCTS")
	private Integer numberOfProducts;
	
	@Column(name = "IS_AVAILABLE")
	private boolean isAvailable;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "SEASON")
	private seasonState season;
	
	@ManyToOne 
	@JoinColumn(name="BASKET_RENTAL_ID")
	private BasketRental basketRental;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_BASKET")
	private List<BasketProduct> basketProducts;
	

	// Getters & Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberOfProducts() {
		return numberOfProducts;
	}

	public void setNumberOfProducts(Integer numberOfProducts) {
		this.numberOfProducts = numberOfProducts;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public seasonState getSeason() {
		return season;
	}

	public void setSeason(seasonState season) {
		this.season = season;
	}
	
	

}
