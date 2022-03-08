package fr.isika.cda.amap_generation.dao.activity;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.amap_generation.model.amap.Activity;
import fr.isika.cda.amap_generation.model.amap.Event;
import fr.isika.cda.amap_generation.model.amap.Workshop;
import fr.isika.cda.amap_generation.presentation.activityAdmin.dtos.EventDto;
import fr.isika.cda.amap_generation.presentation.activityAdmin.dtos.WorkshopDto;

@Stateless
public class ActivityDao {

	@PersistenceContext
	private EntityManager entityManager;

	// Create (persist)

	public <T extends Activity> Long persistence(T activity) {
		entityManager.persist(activity);
		return activity.getId();
	}

	// Read

	public Optional<Activity> getActivityById(Long Id) {
		return Optional.ofNullable(this.entityManager.find(Activity.class, Id));
	}
	
	public List<Activity> findAll() {
		return this.entityManager.createQuery("SELECT a FROM Activity a", Activity.class).getResultList();
	}

	public List<Event> findAllEvents() {
		return this.entityManager.createQuery("SELECT e FROM Event e", Event.class).getResultList();
	}

	public List<Workshop> findAllWorkshops() {
		return this.entityManager.createQuery("SELECT w FROM Workshop w", Workshop.class).getResultList();
	}

	// Update
	public void merge(EventDto eventDto) {
		Event event = new Event(eventDto.getId());
		event.setActivityName(eventDto.getActivityName());
		event.setActivityDate(eventDto.getActivityDate());
		event.setNumberOfParticipants(eventDto.getNumberOfParticipants());
		event.setShortDescription(eventDto.getShortDescription());
		event.setProgramDescription(eventDto.getProgramDescription());
		event.setActivityType(eventDto.getActivityType());
		this.entityManager.merge(event);
	}
	
	public void merge(WorkshopDto workshopDto) {
		Workshop workshop = new Workshop(workshopDto.getId());
		workshop.setActivityName(workshopDto.getActivityName());
		workshop.setActivityDate(workshopDto.getActivityDate());
		workshop.setNumberOfParticipants(workshopDto.getNumberOfParticipants());
		workshop.setShortDescription(workshopDto.getShortDescription());
		workshop.setProgramDescription(workshopDto.getProgramDescription());
		workshop.setActivityType(workshopDto.getActivityType());
		this.entityManager.merge(workshop);
	}
	
	public <T extends Activity> void merge(Long id) {
		this.entityManager.merge(this.entityManager.find(Activity.class, id));
	}
	
	
	
//	private <T extends ActivityAdminDto> Long merge(T activity) {
//		this.entityManager.merge(activity);
//		return activity.getId();
//	}

	// Delete

	public <T extends Activity> void suppression(T activity) {
		this.entityManager.remove(getActivityById(activity.getId()).get());
	}
	public <T extends Activity> void suppression(Long id) {
		this.entityManager.remove(this.entityManager.find(Activity.class, id));
	}

}
