package fr.isika.cda.amap_generation.dao.OrderAmap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.amap_generation.model.OrderAmap.OrderAmap;
import fr.isika.cda.amap_generation.model.OrderAmap.OrderLine;

import fr.isika.cda.amap_generation.model.supplier.ShopProduct;
import fr.isika.cda.amap_generation.presentation.OrderAmap.OrderAmapDTO;
import fr.isika.cda.amap_generation.presentation.products.ProductDTO;



@Stateless
public class OrderAmapDao {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Long createOrderAmap(List<ProductDTO>productDto) {
		
		OrderAmap orderAmap = new OrderAmap(); 
		entityManager.persist(orderAmap);
		List<OrderLine> orderLines = new ArrayList<OrderLine>(); 
		BigDecimal orderPrice = BigDecimal.ZERO; 
		
		for (ProductDTO shopProduct : productDto) {
			
			OrderLine orderLine = createOrderLine(shopProduct); 
			orderLines.add(orderLine); 
			orderPrice = orderPrice.add(orderLine.getLineCost()); 
			orderLine.setOrderAmap(orderAmap);
		
		}
		
		orderAmap.setTotalCost(orderPrice);
		orderAmap.setOrderLines(orderLines);
		entityManager.merge(orderAmap); 
		return orderAmap.getId(); 
		
	}

	private OrderLine createOrderLine(ProductDTO shopProduct) {
		OrderLine orderLine = new OrderLine(); 
		orderLine.setLineCost(shopProduct.getPrice().multiply(BigDecimal.valueOf(shopProduct.getQuantity())));
		orderLine.setQuantity(shopProduct.getQuantity());
		
		ShopProduct product = entityManager.find(ShopProduct.class, shopProduct.getId());  
		orderLine.setShopProduct(product);
		entityManager.persist(orderLine);
		return orderLine; 
		
		
	}
	public OrderAmapDTO getOrderById(Long id) {
		OrderAmap orderAmap = this.entityManager.createNamedQuery("SELECT or FROM OrderAmap or WHERE or.id = id_or", OrderAmap.class)
				.setParameter("id_or", id).getSingleResult(); 
		
				return OrdertoDto(orderAmap); 
	}
	
	public List<OrderAmapDTO>getAllOrdersAmap(){
		List<OrderAmapDTO> orderDTOlist = new ArrayList<OrderAmapDTO>(); 
		List <OrderAmap> orderList = this.entityManager.createNamedQuery("SELECT or FROM OrderAmap or ",OrderAmap.class ).getResultList();
		for(OrderAmap order: orderList) {
			orderDTOlist.add(OrdertoDto(order)); 
		}
		return orderDTOlist; 
		
	}

	private OrderAmapDTO OrdertoDto(OrderAmap orderAmap) {
		OrderAmapDTO orderAmapDTO = new OrderAmapDTO(); 
		orderAmapDTO.setId(orderAmap.getId());
		orderAmapDTO.setOrederDate(orderAmap.getOrederDate());
		orderAmapDTO.setTotalCost(orderAmap.getTotalCost());
		//gérer la partie Adhérent et session 
		return orderAmapDTO; 
		
		
		
		
		
		
	}
}
		
	
	
		
		
	


