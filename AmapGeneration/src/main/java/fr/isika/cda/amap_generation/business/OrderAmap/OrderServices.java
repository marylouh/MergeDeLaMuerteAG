package fr.isika.cda.amap_generation.business.OrderAmap;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.amap_generation.dao.OrderAmap.OrderAmapDao;
import fr.isika.cda.amap_generation.presentation.OrderAmap.OrderAmapDTO;
import fr.isika.cda.amap_generation.presentation.products.ProductDTO;




@Stateless
public class OrderServices {
	
	
	@Inject
	private OrderAmapDao orderAmapdao; 
	
	public Long createOrder (List<ProductDTO>products) {
		return orderAmapdao.createOrderAmap(products); 
	}
	
	public OrderAmapDTO getOrderByID(Long OrderId) {
		return orderAmapdao.getOrderById(OrderId); 
		
	}
	
	public List<OrderAmapDTO> getAllOrders (){
		return orderAmapdao.getAllOrdersAmap(); 
	}
	

	
	
	
}
