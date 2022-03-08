package fr.isika.cda.amap_generation.business.activity;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.amap_generation.dao.activity.ActivityDao;
import fr.isika.cda.amap_generation.model.amap.Activity;
import fr.isika.cda.amap_generation.model.amap.ActivityType;
import fr.isika.cda.amap_generation.model.amap.Event;
import fr.isika.cda.amap_generation.model.amap.Workshop;
import fr.isika.cda.amap_generation.presentation.activityAdmin.dtos.ActivityAdminDto;
import fr.isika.cda.amap_generation.presentation.activityAdmin.dtos.EventDto;
import fr.isika.cda.amap_generation.presentation.activityAdmin.dtos.WorkshopDto;

@Stateless
public class ActivityService {

	@Inject
	private ActivityDao repository;

	// Create

	public Long createEvent(EventDto activity) {
		Event event = EventDto.fromActivityEntity(activity);
		return persister(event);
	}

	public Long createWorkshop(WorkshopDto activity) {
		Workshop workshop = WorkshopDto.fromActivityEntity(activity);
		return persister(workshop);
	}

	private <T extends Activity> Long persister(T activity) {
		return this.repository.persistence(activity);
	}

	// Read

	public List<EventDto> getAllEvents() {
		return repository.findAllEvents().stream().map(eventEntity -> EventDto.fromEntity(eventEntity))
				.collect(Collectors.toList());
	}

	public List<WorkshopDto> getAllWorkshops() {
		return repository.findAllWorkshops().stream().map(workshopEntity -> WorkshopDto.fromEntity(workshopEntity))
				.collect(Collectors.toList());
	}
	
	public List<EventDto> getEventsBySupplier(Long idSupplier) {
		return getAllEvents().parallelStream()
			.filter(eventDto -> eventDto.getSupplier().getId().equals(idSupplier))
			.collect(Collectors.toList());
	}

	// Update

	public void update(ActivityAdminDto activityAdminDto) {
		if(ActivityType.EVENT.equals(activityAdminDto.getActivityType())) {
			EventDto eventDto = EventDto.fromActivityDto(activityAdminDto);
			update(eventDto);
		} else if(ActivityType.WORKSHOP.equals(activityAdminDto.getActivityType())) {
			WorkshopDto workshopDto = WorkshopDto.fromActivityDto(activityAdminDto);
			update(workshopDto);
		}
	}
	private void update(EventDto eventDto) {
		this.repository.merge(eventDto);
	}
	private void update(WorkshopDto workshopDto) {
		this.repository.merge(workshopDto);
	}
	
	public void update(Long id) {
		this.repository.merge(id);
	}

	// Delete

	public void delete(Event event) {
		this.repository.suppression(event);
	}

	public void delete(Workshop workshop) {
		this.repository.suppression(workshop);
	}

	public void delete(Long id) {
		this.repository.suppression(id);
	}

	

}
