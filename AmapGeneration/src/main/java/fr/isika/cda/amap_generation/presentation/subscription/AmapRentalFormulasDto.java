package fr.isika.cda.amap_generation.presentation.subscription;

import java.io.Serializable;

import fr.isika.cda.amap_generation.model.amap.ActivityCenterRental;
import fr.isika.cda.amap_generation.model.amap.Amap;
import fr.isika.cda.amap_generation.model.amap.BasketRental;
import fr.isika.cda.amap_generation.model.amap.ShopRental;
import fr.isika.cda.amap_generation.model.amap.TypeOfRentalFormulas;

public class AmapRentalFormulasDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 175752875878L;
	
	private Amap amap;
	
	private TypeOfRentalFormulas typeOfRentalFormulas;
	
	private ActivityCenterRental activityCenterRental;
	
	private BasketRental basketRental;
	
	private ShopRental shopRental;

	public Amap getAmap() {
		return amap;
	}

	public void setAmap(Amap amap) {
		this.amap = amap;
	}

	public TypeOfRentalFormulas getTypeOfRentalFormulas() {
		return typeOfRentalFormulas;
	}

	public void setTypeOfRentalFormulas(TypeOfRentalFormulas typeOfRentalFormulas) {
		this.typeOfRentalFormulas = typeOfRentalFormulas;
	}

	public ActivityCenterRental getActivityCenterRental() {
		return activityCenterRental;
	}

	public void setActivityCenterRental(ActivityCenterRental activityCenterRental) {
		this.activityCenterRental = activityCenterRental;
	}

	public BasketRental getBasketRental() {
		return basketRental;
	}

	public void setBasketRental(BasketRental basketRental) {
		this.basketRental = basketRental;
	}

	public ShopRental getShopRental() {
		return shopRental;
	}

	public void setShopRental(ShopRental shopRental) {
		this.shopRental = shopRental;
	}

	
	
	
	
	
}
