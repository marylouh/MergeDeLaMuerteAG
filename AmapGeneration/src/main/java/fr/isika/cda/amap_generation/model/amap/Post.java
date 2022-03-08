package fr.isika.cda.amap_generation.model.amap;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import fr.isika.cda.amap_generation.model.user.Member;

@Entity
public abstract class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column (length = 150, name = "TITRE_DU_POST")
	private String publicationTitle;
	
	@OneToOne
	@JoinColumn(name="MEMBER_ID")
	private Member author;
	
	@Column (name = "DATE_DE_PUBLICATION")
	private Date dateOfPublication;

	@Column (length = 500, name = "CONTENU_DU_POST")
	private String content;

	public String getPublicationTitle() {
		return publicationTitle;
	}

	
	public void setPublicationTitle(String publicationTitle) {
		this.publicationTitle = publicationTitle;
	}

	public Member getAuthor() {
		return author;
	}

	public void setAuthor(Member author) {
		this.author = author;
	}

	public Date getDateOfPublication() {
		return dateOfPublication;
	}

	public void setDateOfPublication(Date dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getId() {
		return id;
	}
	
}
