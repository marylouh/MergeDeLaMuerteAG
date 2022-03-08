package fr.isika.cda.amap_generation.business.Shop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.amap_generation.dao.OrderAmap.OrderAmapDao;
import fr.isika.cda.amap_generation.dao.products.ProductDao;
import fr.isika.cda.amap_generation.model.supplier.ShopProduct;
import fr.isika.cda.amap_generation.presentation.products.ProductDTO;

@Stateless
public class ShopServices {
	@Inject
	OrderAmapDao orderAmapDao; 
	private List<ProductDTO> ShoppingCard = new ArrayList<>();
	private BigDecimal totalCostBasket; 
	private Long idOrder;
	
	
	@Inject
	ProductDao productDao; 
	private ShopProduct shopProduct; 
	private ProductDTO product = new ProductDTO(); 
	private List<ProductDTO> productsList; 
	

	public void addProduct(ProductDTO product) {
		for (ProductDTO productInCard: ShoppingCard) {
			if (productInCard.getId().equals(product.getId())) {
				productInCard.setQuantity(productInCard.getQuantity()+1);
				calculateCost(); 
			}
			else product.setQuantity(1);
			ShoppingCard.add(product); 
			calculateCost(); 
	}
		
			
	}
	public void calculateCost() {
		//TODO calculer le prix qui s'affiche dans le panier
	}
	
	
	public void removeProduct() {
		//TODO I don't know 
		//List.remove 
		//findProductsInCart()
	}

	public void setQuantity() {
		
	}







	public void  discardShoppingCard(){
		
		ShoppingCard.clear();
			
		//TODO remettre le prix à Zero 
	 
	}
	public void makeAnOrder() {
		//TODO passer la commande 
		//TODO OrderDAo
	}

	public void viewProductById() {
		//TODO afficher le produit par Id 
		//TODO ProductsDAO
		
	}
	public void getAllProducts() {
		//TODO 
		//TODO ProductsDAO
		
	}



	}

		
	