package fr.isika.cda.amap_generation.model.amap;

import javax.persistence.Column;

//import java.awt.Image;

import javax.persistence.Entity;

@Entity
public class Tutorial extends Post {

	@Column(name = "SHORT_DESCRIPTION")
	private String shortDescription;
	
//	private Image picture;
	
	public Tutorial() {
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

//	public Image getPicture() {
//		return picture;
//	}
//
//	public void setPicture(Image picture) {
//		this.picture = picture;
//	}
	
}
