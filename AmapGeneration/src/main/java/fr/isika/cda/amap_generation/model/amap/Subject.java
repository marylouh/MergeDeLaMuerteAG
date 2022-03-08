package fr.isika.cda.amap_generation.model.amap;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column (name = "NOMBRE_MESSAGES")
	private int numberOfMessages;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Forum forum;
	
	@OneToMany @JoinColumn(name="FK_MESSAGE_FORUM")
	private List<ForumMessage> forumMessages;

	public int getNumberOfMessages() {
		return numberOfMessages;
	}

	public void setNumberOfMessages(int numberOfMessages) {
		this.numberOfMessages = numberOfMessages;
	}

	public List<ForumMessage> getForumMessage() {
		return forumMessages;
	}

	public void setForumMessage(List<ForumMessage> forumMessage) {
		forumMessages = forumMessage;
	}

	
	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public Long getId() {
		return id;
	}
}
