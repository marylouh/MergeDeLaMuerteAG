package fr.isika.cda.amap_generation.model.OrderAmap;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@Column(name = "TYPE-PAIEMENT")
	@Enumerated(EnumType.STRING)
	protected Payment payment;

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
	public long getId() {
		return id;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderAmap [id=");
		builder.append(id);
		builder.append(", orederDate=");
		builder.append(orederDate);
		builder.append(", totalCost=");
		builder.append(totalCost);
		builder.append(", payment=");
		builder.append(payment);
		builder.append(", basketShop=");
		builder.append(basketShop);
		builder.append(", orderLines=");
		builder.append(orderLines);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	
	

}
