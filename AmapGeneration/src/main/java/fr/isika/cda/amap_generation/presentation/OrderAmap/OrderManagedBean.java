package fr.isika.cda.amap_generation.presentation.OrderAmap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;



import fr.isika.cda.amap_generation.business.OrderAmap.OrderServices;

@Named
@SessionScoped

public class OrderManagedBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private OrderServices orderServices;
	
	private List<OrderAmapDTO> listOrderAmap = new ArrayList<>(); 
	
	private OrderAmapDTO orderAmap; 
	
	public String getOrder (Long id) {
		
		orderAmap = orderServices.getOrderByID(id); 
		return ""; 		
	}
	public String orderDetails(Long id) {
		orderAmap = orderServices.getOrderByID(id); 
		return "2"; 
		
	}
	public List<OrderAmapDTO>gelAllOrders(){
		listOrderAmap = orderServices.getAllOrders(); 
		listOrderAmap.sort(Comparator.comparing(OrderAmapDTO :: getOrederDate));
		
		return listOrderAmap; 
	
	}
	
	
	
	
	
	
	
	

}
