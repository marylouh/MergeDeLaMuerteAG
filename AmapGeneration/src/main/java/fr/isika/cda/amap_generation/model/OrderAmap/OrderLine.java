package fr.isika.cda.amap_generation.model.OrderAmap;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


import fr.isika.cda.amap_generation.model.supplier.ShopProduct;

@Entity
public class OrderLine {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id; 
	@OneToOne
	//@JoinColumn(name = "FK_PRODUIT", unique = true)
	private ShopProduct shopProduct; 
	@Column(name = "Quantité")
	private int quantity; 
	@ManyToOne
	//@JoinColumn(name = "FK_BASKETSHOP")
	private BasketShop basketShop; 
	@ManyToOne
	@JoinColumn(name = "FK_COMMANDE")
	private OrderAmap orderAmap; 
	@Column(name = "Prix_ligne")
	private BigDecimal lineCost;
	public ShopProduct getShopProduct() {
		return shopProduct;
	}
	public void setShopProduct(ShopProduct shopProduct) {
		this.shopProduct = shopProduct;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BasketShop getBasketShop() {
		return basketShop;
	}
	public void setBasketShop(BasketShop basketShop) {
		this.basketShop = basketShop;
	}
	public OrderAmap getOrderAmap() {
		return orderAmap;
	}
	public void setOrderAmap(OrderAmap orderAmap) {
		this.orderAmap = orderAmap;
	}
	public BigDecimal getLineCost() {
		return lineCost;
	}
	public void setLineCost(BigDecimal lineCost) {
		this.lineCost = lineCost;
	}
	public long getId() {
		return id;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderLine [id=");
		builder.append(id);
		builder.append(", shopProduct=");
		builder.append(shopProduct);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", basketShop=");
		builder.append(basketShop);
		builder.append(", orderAmap=");
		builder.append(orderAmap);
		builder.append(", lineCost=");
		builder.append(lineCost);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
