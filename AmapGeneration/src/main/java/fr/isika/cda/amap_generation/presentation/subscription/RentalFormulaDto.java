package fr.isika.cda.amap_generation.presentation.subscription;

import java.io.Serializable;

public class RentalFormulaDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 578412443815687055L;

	private String typeFormula;

	private Double price;

	private String service1;

	private String service2;

	private String service3;
	

	public String getTypeFormula() {
		return typeFormula;
	}

	public void setTypeFormula(String typeFormula) {
		this.typeFormula = typeFormula;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getService1() {
		return service1;
	}

	public void setService1(String service1) {
		this.service1 = service1;
	}

	public String getService2() {
		return service2;
	}

	public void setService2(String service2) {
		this.service2 = service2;
	}

	public String getService3() {
		return service3;
	}

	public void setService3(String service3) {
		this.service3 = service3;
	}
	
}
