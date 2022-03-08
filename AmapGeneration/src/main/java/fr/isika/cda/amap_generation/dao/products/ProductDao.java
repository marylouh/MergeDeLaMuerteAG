package fr.isika.cda.amap_generation.dao.products;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.amap_generation.model.supplier.BasketProduct;
import fr.isika.cda.amap_generation.model.supplier.Product;
import fr.isika.cda.amap_generation.model.supplier.ShopProduct;
import fr.isika.cda.amap_generation.presentation.products.ProductDTO;
import fr.isika.cda.amap_generation.utils.DateUtils;


@Stateless
public class ProductDao {

	@PersistenceContext
	private EntityManager entityManager;

	// Récuperer la date
	LocalDate currentDate = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String date = currentDate.format(formatter);
	
	public Optional<Product> searchById(Long idProduct) {
		return Optional.ofNullable(entityManager.find(Product.class, idProduct));
	}

	public void deleteProduct(Long productId) {
		Product product = this.entityManager.find(Product.class, productId);
		this.entityManager.remove(product);
	}

	public void editProduct(Long productId) {
		Product product = this.entityManager.find(Product.class, productId);

//		ProductDTO productDTO = new ProductDTO();
//		
//		productDTO.setName(product.getName());
//		productDTO.setQuantity(product.getQuantity());
//		productDTO.setPrice(product.getPrice());
//		productDTO.setShortDescription(product.getShortDescription());
//		productDTO.setLongDescription(product.getLongDescription());
//		productDTO.setDateOfCreation(product.getDateOfCreation());
//		productDTO.setImage(product.getImage());
//		productDTO.setId(product.getId());
		
		this.entityManager.merge(product);
	}
	
	public void updateProduct(Product product) {
		this.entityManager.merge(product);
	}
	
	public <T extends Product> Long persistence(T product) {
		entityManager.persist(product);
		return product.getId();
	}

	public Long persistBasket(ProductDTO productDTO) {

		BasketProduct produit = new BasketProduct();

		produit.setName(productDTO.getName());
		produit.setQuantity(productDTO.getQuantity());
		produit.setPrice(productDTO.getPrice());
		produit.setShortDescription(productDTO.getShortDescription());
		produit.setLongDescription(productDTO.getLongDescription());
		produit.setDateOfCreation(DateUtils.getTodaysDate());
		produit.setImage(productDTO.getImage());
		produit.setBasketProductType(productDTO.getBasketProductType());
		produit.setSupplier(productDTO.getSupplier());

		entityManager.persist(produit);

		return produit.getId();
	}

	public Long persistShop(ProductDTO productDTO) {

		ShopProduct produit = new ShopProduct();

		produit.setName(productDTO.getName());
		produit.setQuantity(productDTO.getQuantity());
		produit.setPrice(productDTO.getPrice());
		produit.setShortDescription(productDTO.getShortDescription());
		produit.setLongDescription(productDTO.getLongDescription());
		produit.setDateOfCreation(DateUtils.getTodaysDate());
		produit.setImage(productDTO.getImage());
		produit.setShopProductType(productDTO.getShopProductType());
		produit.setSupplier(productDTO.getSupplier());
		
		entityManager.persist(produit);

		return produit.getId();
	}

	public List<ShopProduct> getAllShopProducts() {
		return this.entityManager.createQuery("SELECT s FROM ShopProduct s", ShopProduct.class).getResultList();
	}
	
	public List<BasketProduct> getAllBasketProducts() {
		return this.entityManager.createQuery("SELECT b FROM BasketProduct b", BasketProduct.class).getResultList();
	}
	
	public List<Product> getAllProducts() {
		return this.entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
	}
	
}
