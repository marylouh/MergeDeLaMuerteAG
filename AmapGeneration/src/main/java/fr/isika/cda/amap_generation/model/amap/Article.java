package fr.isika.cda.amap_generation.model.amap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Article extends Post {
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Blog blog;
	
	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	
}
