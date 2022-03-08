package fr.isika.cda.amap_generation.model.amap;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("3")
public class BasketRental extends Rental {
	
	private int possibleNumberOfBaskets;
	
	
	//--------------Constructeur----------------------- 
	public BasketRental() {
		super();
		// TODO Auto-generated constructor stub
	} 
	//---------------getter & setter---------------


	public int getPossibleNumberOfBaskets() {
		return possibleNumberOfBaskets;
	}


	public void setPossibleNumberOfBaskets(int possibleNumberOfBaskets) {
		this.possibleNumberOfBaskets = possibleNumberOfBaskets;
	}
	//-------------------To String------------------------

	@Override
	public String toString() {
		return "BasketRental [possibleNumberOfBaskets=" + possibleNumberOfBaskets + "]";
	}
	
	
	
	
	
	

}




