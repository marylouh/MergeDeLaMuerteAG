package fr.isika.cda.amap_generation.business.products;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.amap_generation.dao.products.ProductDao;
import fr.isika.cda.amap_generation.model.supplier.BasketProduct;
import fr.isika.cda.amap_generation.model.supplier.Product;
import fr.isika.cda.amap_generation.model.supplier.ShopProduct;
import fr.isika.cda.amap_generation.presentation.products.ProductDTO;

@Stateless
public class ProductService {
	
	@Inject
	private ProductDao repository;
	
	// Créer un produit
	public Long createShopProd(ProductDTO product) {
		Long idProduct = this.repository.persistShop(product);
		return idProduct;
	}
	
	public Long createBasketProd(ProductDTO product) {
		Long idProduct = this.repository.persistBasket(product);
		return idProduct;
	}
	
	// Supprimer un produit
	public void deleteProduct (Long productId) {
		this.repository.deleteProduct(productId);
	}
	
	// Modifier un produit
	public void editProduct (Long productId) {
		this.repository.editProduct(productId);
	}
	
	public void updateProduct (Product product) {
		this.repository.updateProduct(product);
	}
	
	// lister les produits
	public List<ProductDTO> getAllShopProduct() {
		List<ProductDTO> finalList = new ArrayList<ProductDTO>();
		List<ShopProduct> products  = this.repository.getAllShopProducts();
		
		for(Product p : products) {
			
			ProductDTO pDto =  new ProductDTO();
			pDto.setId(p.getId());
			pDto.setName(p.getName());
			pDto.setQuantity(p.getQuantity());
			pDto.setPrice(p.getPrice());
			pDto.setShortDescription(p.getShortDescription());
			pDto.setLongDescription(p.getLongDescription());
			pDto.setDateOfCreation(p.getDateOfCreation());
			
			finalList.add(pDto);	
		}
		return finalList;
	}
	
	public List<ProductDTO> getAllBasketProduct() {
		List<ProductDTO> finalList = new ArrayList<ProductDTO>();
		List<BasketProduct> products  = this.repository.getAllBasketProducts();
		
		for(Product p : products) {
			
			ProductDTO pDto =  new ProductDTO();
			pDto.setId(p.getId());
			pDto.setName(p.getName());
			pDto.setQuantity(p.getQuantity());
			pDto.setPrice(p.getPrice());
			pDto.setShortDescription(p.getShortDescription());
			pDto.setLongDescription(p.getLongDescription());
			pDto.setDateOfCreation(p.getDateOfCreation());
			
			finalList.add(pDto);	
		}
		return finalList;
	}
	
}
