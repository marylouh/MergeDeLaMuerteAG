package fr.isika.cda.amap_generation.model.amap;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ForumMessage extends Post {

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_SUBJECT")
	private Subject subject;

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}
