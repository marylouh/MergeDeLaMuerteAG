package fr.isika.cda.amap_generation.model.supplier;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import fr.isika.cda.amap_generation.model.amap.ShopRental;


@Entity
public class ProductCatalog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_PRODUCT_CATALOG")
	private Long idProductCatalog;
	
	@ManyToOne 
	@JoinColumn(name="SHOP_RENTAL_ID")
	private ShopRental shoRental;
	
	// Test, si concluant  à supprimer
//	@ManyToMany
//    @JoinTable( name = "ShopProduct_ProductCatalog",
//                joinColumns = @JoinColumn( name = "idProductCatalog" ),
//                inverseJoinColumns = @JoinColumn( name = "idShopProduct" ) )
//    private List<ShopProduct> shopProducts;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_CATALOG")
	private List<ShopProduct> shopProducts;
	
	// Getters & Setters
	public Long getIdProductCatalog() {
		return idProductCatalog;
	}


	public void setIdProductCatalog(Long idProductCatalog) {
		this.idProductCatalog = idProductCatalog;
	}


	public ShopRental getShoRental() {
		return shoRental;
	}


	public void setShoRental(ShopRental shoRental) {
		this.shoRental = shoRental;
	}


	public List<ShopProduct> getShopProducts() {
		return shopProducts;
	}


	public void setShopProducts(List<ShopProduct> shopProducts) {
		this.shopProducts = shopProducts;
	}
	

}
