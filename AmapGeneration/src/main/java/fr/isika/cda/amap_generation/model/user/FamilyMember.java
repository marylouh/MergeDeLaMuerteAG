package fr.isika.cda.amap_generation.model.user;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class FamilyMember extends Person {

	
	@Column(name = "REFERENCE_FAMILY_MEMBER")
	private String referenceInscription;
	
	
	public FamilyMember() {
		String tempRef = UUID.randomUUID().toString().substring(0, 10);
		this.referenceInscription = tempRef;
	}


	public String getReferenceInscription() {
		return referenceInscription;
	}

	public void setReferenceInscription(String referenceInscription) {
		this.referenceInscription = referenceInscription;
	}

}
	
	
	