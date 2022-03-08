package fr.isika.cda.amap_generation.model.amap;

import java.util.Date;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.isika.cda.amap_generation.model.supplier.Supplier;
import fr.isika.cda.amap_generation.model.user.Registered;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ACTIVITY_TYPE_DISC", discriminatorType = DiscriminatorType.STRING)
@NamedQueries({ @NamedQuery(name = "Activity.findAll", query = "select a from Activity a") })
public abstract class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "ACTIVITY_NAME")
	private String activityName;

	@Temporal(TemporalType.DATE)
	@Column(name = "ACTIVITY_DATE")
	private Date activityDate;

	@Column(name = "NUMBER_OF_PARTICIPANTS")
	private Integer numberOfParticipants;

	@Column(name = "SHORT_DESCRIPTION")
	private String shortDescription;

	@Lob
	@Column(name = "PROGRAM_DESCRIPTION")
	private String programDescription;

//		private Image picture;

	@Enumerated(EnumType.STRING)
	@Column(name = "ACTIVITY_TYPE_ENUM")
	private ActivityType activityType;

	@ManyToOne
	@JoinColumn(name = "FK_SUPPLIER")
	private Supplier supplier;

	@OneToMany
	@JoinColumn(name = "FK_REGISTEREDLIST")
	private List<Registered> participants;

	public Activity() {
		super();
	}

	public Activity(Long id2) {
		this.id = id2;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public Integer getNumberOfParticipants() {
		return numberOfParticipants;
	}

	public void setNumberOfParticipants(Integer numberOfParticipants) {
		this.numberOfParticipants = numberOfParticipants;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getProgramDescription() {
		return programDescription;
	}

	public void setProgramDescription(String programDescription) {
		this.programDescription = programDescription;
	}

//		public Image getPicture() {
//			return picture;
//		}
	//
//		public void setPicture(Image picture) {
//			this.picture = picture;
//		}

	public Long getId() {
		return id;
	}

	public ActivityType getActivityType() {
		return activityType;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	public Supplier getSupplierId() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<Registered> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Registered> participants) {
		this.participants = participants;
	}

}
