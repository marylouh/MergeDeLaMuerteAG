package fr.isika.cda.amap_generation.model.OrderAmap;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import fr.isika.cda.amap_generation.model.supplier.ShopProduct;

@Entity
public class BasketShop {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id; 
	
	@OneToMany	
	@JoinColumn(name = "FK_LIGNE_COMMANDE")
	private List<OrderLine>orderLines; 
	
	@OneToOne
	@JoinColumn(name = "FK_COMMANDE", unique = true)
	private OrderAmap orderAmap;

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}
	@OneToOne
	@JoinColumn(name = "FK_PRODUIT", unique = true)
	private ShopProduct shopProduct; 
	
	
	
}
	