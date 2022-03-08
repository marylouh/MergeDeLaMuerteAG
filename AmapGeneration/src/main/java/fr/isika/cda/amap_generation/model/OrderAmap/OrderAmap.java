package fr.isika.cda.amap_generation.model.OrderAmap;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class OrderAmap {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id; 
	
	@Column(name = "DATE_COMMANDE")
	//@Temporal(TemporalType.DATE)
	private Date orederDate; 
	
	@Column(name = "MONTANT_TOTAL")
	private BigDecimal totalCost; 

	@OneToOne
	@JoinColumn(name = "FK_PANIER", unique = true)
	private BasketShop basketShop;
	@OneToMany
	@JoinColumn(name = "FK_LIGNE_COMMANDE")
	private List<OrderLine> orderLines;
	
	
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
	public long getId() {
		return id;
	}
	
}
