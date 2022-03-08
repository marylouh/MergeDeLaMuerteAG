package fr.isika.cda.amap_generation.presentation.activityAdmin.dtos;

import fr.isika.cda.amap_generation.model.amap.Event;

public class EventDto extends ActivityAdminDto {

	private static final long serialVersionUID = 101L;

	// Event
	private String referenceEvent;

	// Getters & Setters
	public String getReferenceEvent() {
		return referenceEvent;
	}

	public void setReferenceEvent(String referenceEvent) {
		this.referenceEvent = referenceEvent;
	}

	public static EventDto fromEntity(Event eventEntity) {
		EventDto event = new EventDto();
		event.setId(eventEntity.getId());
		event.setActivityName(eventEntity.getActivityName());
		event.setActivityDate(eventEntity.getActivityDate());
		event.setNumberOfParticipants(eventEntity.getNumberOfParticipants());
		event.setShortDescription(eventEntity.getShortDescription());
		event.setProgramDescription(eventEntity.getProgramDescription());
		event.setActivityType(eventEntity.getActivityType());
		event.setReferenceEvent(eventEntity.getReferenceEvent());
		return event;
	}

	public static EventDto fromActivityDto(ActivityAdminDto activityAdminDto) {
		EventDto event = new EventDto();
		event.setId(activityAdminDto.getId());
		event.setActivityName(activityAdminDto.getActivityName());
		event.setActivityDate(activityAdminDto.getActivityDate());
		event.setNumberOfParticipants(activityAdminDto.getNumberOfParticipants());
		event.setShortDescription(activityAdminDto.getShortDescription());
		event.setProgramDescription(activityAdminDto.getProgramDescription());
		event.setActivityType(activityAdminDto.getActivityType());
		return event;
	}

	public static Event fromActivityEntity(EventDto activity) {
		Event event = new Event(activity.getId());
		event.setActivityName(activity.getActivityName());
		event.setActivityDate(activity.getActivityDate());
		event.setNumberOfParticipants(activity.getNumberOfParticipants());
		event.setShortDescription(activity.getShortDescription());
		event.setProgramDescription(activity.getProgramDescription());
		event.setActivityType(activity.getActivityType());
		return event;
	}

}
