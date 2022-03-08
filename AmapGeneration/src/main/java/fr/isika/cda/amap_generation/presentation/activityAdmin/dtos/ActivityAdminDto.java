package fr.isika.cda.amap_generation.presentation.activityAdmin.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import fr.isika.cda.amap_generation.model.amap.ActivityType;
import fr.isika.cda.amap_generation.model.supplier.Supplier;
import fr.isika.cda.amap_generation.model.user.Registered;

//DTO : Data Access Object
public class ActivityAdminDto implements Serializable {
	
	private static final long serialVersionUID = 101L;
		
	//Activity
	protected Long id;
	protected String activityName;
	protected Date activityDate;
	protected Integer numberOfParticipants;
	protected String shortDescription;
	protected String programDescription;
	protected ActivityType activityType;
	protected Supplier supplier;
	protected List<Registered> participants;
	
	//Getters & Setters
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
	public ActivityType getActivityType() {
		return activityType;
	}
	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}
	public Integer getNumberOfParticipants() {
		return numberOfParticipants;
	}
	public void setNumberOfParticipants(Integer numberOfParticipants) {
		this.numberOfParticipants = numberOfParticipants;
	}
	public Supplier getSupplier() {
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
