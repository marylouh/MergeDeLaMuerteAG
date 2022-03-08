package fr.isika.cda.amap_generation.presentation.activityAdmin.dtos;

import fr.isika.cda.amap_generation.model.amap.Workshop;

public class WorkshopDto extends ActivityAdminDto {

	private static final long serialVersionUID = 101L;

	// Workshop
	private String referenceWorkshop;

	// Getters & Setters
	public String getReferenceWorkshop() {
		return referenceWorkshop;
	}
	public void setReferenceWorkshop(String referenceWorkshop) {
		this.referenceWorkshop = referenceWorkshop;
	}
	public static WorkshopDto fromEntity(Workshop workshopEntity) {
		WorkshopDto workshopDto = new WorkshopDto();
		workshopDto.setId(workshopEntity.getId());
		workshopDto.setActivityName(workshopEntity.getActivityName());
		workshopDto.setActivityDate(workshopEntity.getActivityDate());
		workshopDto.setNumberOfParticipants(workshopEntity.getNumberOfParticipants());
		workshopDto.setShortDescription(workshopEntity.getShortDescription());
		workshopDto.setProgramDescription(workshopEntity.getProgramDescription());
		workshopDto.setActivityType(workshopEntity.getActivityType());
		workshopDto.setReferenceWorkshop(workshopEntity.getReferenceWorkshop());
		return workshopDto;
	}
	
	public static WorkshopDto fromActivityDto(ActivityAdminDto activityAdminDto) {
		WorkshopDto workshopDto = new WorkshopDto();
		workshopDto.setId(activityAdminDto.getId());
		workshopDto.setActivityName(activityAdminDto.getActivityName());
		workshopDto.setActivityDate(activityAdminDto.getActivityDate());
		workshopDto.setNumberOfParticipants(activityAdminDto.getNumberOfParticipants());
		workshopDto.setShortDescription(activityAdminDto.getShortDescription());
		workshopDto.setProgramDescription(activityAdminDto.getProgramDescription());
		workshopDto.setActivityType(activityAdminDto.getActivityType());
		return workshopDto;
	}
	public static Workshop fromActivityEntity(WorkshopDto activity) {
		Workshop workshop = new Workshop(activity.getId());
		workshop.setActivityName(activity.getActivityName());
		workshop.setActivityDate(activity.getActivityDate());
		workshop.setNumberOfParticipants(activity.getNumberOfParticipants());
		workshop.setShortDescription(activity.getShortDescription());
		workshop.setProgramDescription(activity.getProgramDescription());
		workshop.setActivityType(activity.getActivityType());
		return workshop;
	}

}
