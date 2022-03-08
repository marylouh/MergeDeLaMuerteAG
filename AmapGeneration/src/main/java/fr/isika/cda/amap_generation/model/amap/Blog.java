package fr.isika.cda.amap_generation.model.amap;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Blog{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column (name = "nombre_articles")
	private int numberOfArticles;

	@OneToMany 
	@JoinColumn(name="fk_articles")
	private List<Article> articles;



	public int getNumberOfArticles() {
		return numberOfArticles;
	}

	public void setNumberOfArticles(int numberOfSubjects) {
		this.numberOfArticles = numberOfSubjects;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> article) {
		articles = article;
	}

	public Long getId() {
		return id;
	}

	}
