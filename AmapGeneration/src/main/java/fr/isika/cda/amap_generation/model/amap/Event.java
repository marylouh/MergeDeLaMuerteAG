package fr.isika.cda.amap_generation.model.amap;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Event extends Activity {

	@Column(name = "REFERENCE_EVENT")
	private String referenceEvent;

	public Event() {
		String tempRef = UUID.randomUUID().toString().substring(0, 10);
		this.referenceEvent = tempRef;
	}

	public Event(Long id) {
		super(id);
	}

	public String getReferenceEvent() {
		return referenceEvent;
	}

	public void setReferenceEvent(String referenceEvent) {
		this.referenceEvent = referenceEvent;
	}

}