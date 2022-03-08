package fr.isika.cda.amap_generation.model.amap;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Workshop extends Activity {

	@Column(name = "REFERENCE_WORKSHOP")
	private String referenceWorkshop;

	public Workshop() {
		String tempRef = UUID.randomUUID().toString().substring(0, 10);
		this.referenceWorkshop = tempRef;
	}

	public Workshop(Long id) {
		super(id);
	}

	public String getReferenceWorkshop() {
		return referenceWorkshop;
	}

	public void setReferenceWorkshop(String referenceWorkshop) {
		this.referenceWorkshop = referenceWorkshop;
	}
}
