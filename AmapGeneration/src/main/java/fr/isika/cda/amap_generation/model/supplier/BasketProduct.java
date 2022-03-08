package fr.isika.cda.amap_generation.model.supplier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "BasketProduct.findAll", query = "select b from BasketProduct b")
})
public class BasketProduct extends Product {
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "BASKET_PRODUCT_TYPE")
	private BasketProductType basketProductType;
	
	@ManyToOne 
	@JoinColumn(name="FK_SUPPLIER_BASKET")
	private Supplier supplier;
	
	@ManyToOne 
	@JoinColumn(name="FK_BASKET")
	private Basket basket;
	
	public BasketProduct(Long id) {
		super(id);
	}
	public BasketProduct() {
		super();
	}

	// Getters & Setters
	public BasketProductType getBasketProductType() {
		return basketProductType;
	}

	public void setBasketProductType(BasketProductType basketProductType) {
		this.basketProductType = basketProductType;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}
	
	
}
