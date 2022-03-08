package fr.isika.cda.amap_generation.model.supplier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ShopProduct extends Product {

	
	@ManyToOne 
	@JoinColumn(name="FK_SUPPLIER_SHOP")
	private Supplier supplier;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "SHOP_PRODUCT_TYPE")
	private ShopProductType shopProductType;

	@ManyToOne @JoinColumn(name="FK_CATALOG")
	private ProductCatalog catalog;
	
	
	// Getters & Setters
	public ShopProductType getShopProductType() {
		return shopProductType;
	}

	public void setShopProductType(ShopProductType shopProductType) {
		this.shopProductType = shopProductType;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}

