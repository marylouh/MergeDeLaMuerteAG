package fr.isika.cda.amap_generation.model.amap;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import fr.isika.cda.amap_generation.model.user.Member;

@Entity
public class Message extends Post {

	@ManyToOne
	@JoinColumn(name = "FK_CONVERSATION")
	private Conversation conversation;

	@OneToOne
	@JoinColumn(name= "FK_EXPEDITOR")
	private Member expeditor;

	@ManyToOne
	@JoinColumn(name = "FK_RECIPIENT")
	private Member recipient;

	public Member getRecipient() {
		return recipient;
	}

	public void setRecipient(Member recipient) {
		this.recipient = recipient;
	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

	public Member getExpeditor() {
		return expeditor;
	}

	public void setExpeditor(Member expeditor) {
		this.expeditor = expeditor;
	}

}
