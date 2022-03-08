package fr.isika.cda.amap_generation.presentation.OrderAmap;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import fr.isika.cda.amap_generation.model.OrderAmap.BasketShop;
import fr.isika.cda.amap_generation.model.OrderAmap.OrderLine;
import fr.isika.cda.amap_generation.model.OrderAmap.Payment;

public class OrderAmapDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private long id; 
	private Date orederDate; 	
	
	private BigDecimal totalCost; 
	protected Payment payment;
	private BasketShop basketShop;	
	private List<OrderLine> orderLines; 
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getOrederDate() {
		return orederDate;
	}
	public void setOrederDate(Date orederDate) {
		this.orederDate = orederDate;
	}
	public BigDecimal getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public BasketShop getBasketShop() {
		return basketShop;
	}
	public void setBasketShop(BasketShop basketShop) {
		this.basketShop = basketShop;
	}
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	
	
	

}
