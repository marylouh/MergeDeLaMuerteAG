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
public class MessagePanel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column (name = "NOMBRE_DE_CONVERSATIONS")
	private int numberOfConversations;
	
	@OneToMany @JoinColumn(name="FK_CONVERSATIONS")
	private List<Conversation> conversations;

	public int getNumberOfConversations() {
		return numberOfConversations;
	}

	public void setNumberOfConversations(int numberOfConversations) {
		this.numberOfConversations = numberOfConversations;
	}

	public List<Conversation> getConversation() {
		return conversations;
	}

	public void setConversation(List<Conversation> conversation) {
		this.conversations = conversation;
	}

	public Long getId() {
		return id;
	}
	
}
