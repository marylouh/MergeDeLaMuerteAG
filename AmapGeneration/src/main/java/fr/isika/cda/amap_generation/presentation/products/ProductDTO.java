package fr.isika.cda.amap_generation.presentation.products;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import fr.isika.cda.amap_generation.model.supplier.BasketProductType;
import fr.isika.cda.amap_generation.model.supplier.ShopProductType;
import fr.isika.cda.amap_generation.model.supplier.Supplier;

public class ProductDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7992141893592706330L;

	// Product
	private Long id;
	private String name;
	private String shortDescription;
	private String longDescription;
	private BigDecimal price;
	private Date dateOfCreation;
	private int quantity;
	private Byte image;

	// Supplier
	private Supplier supplier;

	// ShopProduct
	private ShopProductType shopProductType;

	// BasketProduct
	private BasketProductType basketProductType;

	// Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantite) {
		this.quantity = quantite;
	}

	public Byte getImage() {
		return image;
	}

	public void setImage(Byte image) {
		this.image = image;
	}

	public ShopProductType getShopProductType() {
		return shopProductType;
	}

	public void setShopProductType(ShopProductType shopProductType) {
		this.shopProductType = shopProductType;
	}

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

}
