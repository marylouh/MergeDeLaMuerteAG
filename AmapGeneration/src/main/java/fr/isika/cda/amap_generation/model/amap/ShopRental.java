package fr.isika.cda.amap_generation.model.amap;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("2")
public class ShopRental extends Rental{
	
	private int possibleNumberOfProducts;

	
	//--------------Constructeur----------------------- 
	public ShopRental() {
		super();
		// TODO Auto-generated constructor stub
	} 
	//---------------getter & setter---------------


	public int getPossibleNumberOfProducts() {
		return possibleNumberOfProducts;
	}


	public void setPossibleNumberOfProducts(int possibleNumberOfProducts) {
		this.possibleNumberOfProducts = possibleNumberOfProducts;
	}

	//-------------------To String------------------------
	@Override
	public String toString() {
		return "ShopRental [possibleNumberOfProducts=" + possibleNumberOfProducts + "]";
	}

	
	
	
	
}


