package fr.isika.cda.amap_generation.model.amap;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("1")
public class ActivityCenterRental extends Rental {
	
	
	
	private int possibleNumberOfActivities;

	
	
	//--------------Constructeur-----------------------
	public ActivityCenterRental() {
		super();
		// TODO Auto-generated constructor stub
	} 
	//---------------getter & setter---------------



	public int getPossibleNumberOfActivities() {
		return possibleNumberOfActivities;
	}



	public void setPossibleNumberOfActivities(int possibleNumberOfActivities) {
		this.possibleNumberOfActivities = possibleNumberOfActivities;
	}
	//-------------------To String------------------------



	@Override
	public String toString() {
		return "ActivityCenterRental [possibleNumberOfActivities=" + possibleNumberOfActivities + "]";
	}
	
	

}
