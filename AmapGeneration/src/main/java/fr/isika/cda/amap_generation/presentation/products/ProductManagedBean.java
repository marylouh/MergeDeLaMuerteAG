package fr.isika.cda.amap_generation.presentation.products;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda.amap_generation.business.products.ProductService;
import fr.isika.cda.amap_generation.model.supplier.BasketProductType;
import fr.isika.cda.amap_generation.model.supplier.Product;
import fr.isika.cda.amap_generation.model.supplier.ShopProductType;

@ManagedBean
@SessionScoped
public class ProductManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7313340029973189047L;
	
	@Inject
	private ProductService productService; 
	
	// Pour faire le lien avec le formulaire dans la page web
	// on instancie l'objet java qui va recevoir les données
	private ProductDTO productDTO = new ProductDTO();
	
	// Si je change tranforme la méthode enum en classe
//	public ShopProductType[] allTypeOfShopProduct{
//		return shopProductType.values();
//	}

	public String addShopProduct() {
		productService.createShopProd(productDTO); 
		return "listShopProduct.xhtml?faces-redirect=true"; 	
	}
	
	public String addBasketProduct() {
		productService.createBasketProd(productDTO); 
		return "listBasketProduct.xhtml?faces-redirect=true"; 	
	}
	
	public List<ProductDTO> getAllShop(){
		 return this.productService.getAllShopProduct();
	}
	
	public List<ProductDTO> getAllBasket(){
		return this.productService.getAllBasketProduct();
	}

	public ShopProductType[] allShopType() {
		return ShopProductType.values();
	}
	
	public BasketProductType[] allBasketType() {
		return BasketProductType.values();
	}
	
	public String removeProduct(Long idProduct) {
		productService.deleteProduct(idProduct);
		return "listBasketProduct.xhtml?faces-redirect=true";
	}
	
	public String editProduct(Long idProduct) {
		productService.editProduct(idProduct);
		return "modifyProduct.xhtml";
	}
	
	public String updateProduct(Product product) {
		productService.updateProduct(product);
		return "listShopProduct.xhtml?faces-redirect=true";
	}
	
	public String update() {
		return "listBasketProduct.xhtml?faces-redirect=true";
	}
	
	// Getters & Setters
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	
}
