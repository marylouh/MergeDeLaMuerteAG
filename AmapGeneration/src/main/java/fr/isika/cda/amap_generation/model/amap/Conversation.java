package fr.isika.cda.amap_generation.model.amap;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Conversation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column (name = "nombre_messages")
	private int numberOfMessages;
	
	@OneToMany @JoinColumn(name="fk_messages")
	private List<Message> messages = new ArrayList<>();
	
//	@ManyToMany
//	@JoinColumn(name = "FK_FIRST_MEMBER")
//	private HashSet<Member> members = new HashSet<>();
	

	public int getNumberOfMessages() {
		return numberOfMessages;
	}

	public void setNumberOfMessages(int numberOfMessages) {
		this.numberOfMessages = numberOfMessages;
	}

	public List<Message> getMessage() {
		return messages;
	}

	public void setMessage(List<Message> message) {
		this.messages = message;
	}

	public Long getId() {
		return id;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

//	public HashSet<Member> getMembers() {
//		return members;
//	}
//
//	public void setMembers(HashSet<Member> members) {
//		this.members = members;
//	}
	
	
}
