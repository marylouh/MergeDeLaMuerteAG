package fr.isika.cda.amap_generation.presentation.activityAdmin;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda.amap_generation.business.activity.ActivityService;
import fr.isika.cda.amap_generation.model.amap.ActivityType;
import fr.isika.cda.amap_generation.model.amap.Event;
import fr.isika.cda.amap_generation.model.amap.Workshop;
import fr.isika.cda.amap_generation.presentation.activityAdmin.dtos.ActivityAdminDto;
import fr.isika.cda.amap_generation.presentation.activityAdmin.dtos.EventDto;
import fr.isika.cda.amap_generation.presentation.activityAdmin.dtos.WorkshopDto;

@ManagedBean
@SessionScoped
public class ActivityController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2367082669588726251L;

	@Inject
	protected ActivityService activityService;

	private EventDto eventDto;
	private WorkshopDto workshopDto;
	private ActivityAdminDto activityCreationHelper = new ActivityAdminDto();
	
	private Event event;
	private Workshop workshop;

	private List<EventDto> events = new ArrayList<>();
	private List<WorkshopDto> workshops = new ArrayList<>();

	public ActivityType[] allActivityTypes() {
		return ActivityType.values();
	}

	/** -----INITIALIZATION----- **/

	@PostConstruct
	private void init() {
		reloadEvents();
		reloadWorkshops();
	}

	public void reloadEvents() {
		events = activityService.getAllEvents();
	}

	public void reloadWorkshops() {
		workshops = activityService.getAllWorkshops();
	}

	/** -----UPDATE----- **/

	public String editEvent(EventDto eventDto) {
		this.eventDto = eventDto;
		return "activityEventUpdate.xhtml";
	}

	public String editWorkshop(WorkshopDto workshopDto) {
		this.workshopDto = workshopDto;
		return "activityWorkshopUpdate.xhtml";
	}

	public String editEvent() {
		activityService.update(eventDto);
		eventDto = new EventDto();
		reloadEvents();
		return "activityUpdated.xhtml?faces-redirect=true";
	}

	public String editWorkshop() {
		activityService.update(workshopDto);
		workshopDto = new WorkshopDto();
		reloadWorkshops();
		return "activityUpdated.xhtml?faces-redirect=true";
	}

	/** -----DELETE----- **/

	public String delete(Long id) {
		activityService.delete(id);
		reloadEvents();
		reloadWorkshops();
		return "activityDeleted.xhtml?faces-redirect=true";
	}

	/** -----CREATE----- **/

	public String addActivity() throws ParseException {
		if (ActivityType.EVENT.equals(activityCreationHelper.getActivityType())) {
			activityService.createEvent(creationEvent());
			this.eventDto = new EventDto();
		} else if (ActivityType.WORKSHOP.equals(activityCreationHelper.getActivityType())) {
			activityService.createWorkshop(creationWorkshop());
			this.workshopDto = new WorkshopDto();
		}
		activityCreationHelper = new ActivityAdminDto();
		reloadEvents();
		reloadWorkshops();
		return "activityCreated.xhtml";
	}

	public EventDto creationEvent() {
		this.eventDto = new EventDto();
		this.eventDto.setActivityName(activityCreationHelper.getActivityName());
		this.eventDto.setActivityDate(activityCreationHelper.getActivityDate());
		this.eventDto.setNumberOfParticipants(activityCreationHelper.getNumberOfParticipants());
		this.eventDto.setShortDescription(activityCreationHelper.getShortDescription());
		this.eventDto.setProgramDescription(activityCreationHelper.getProgramDescription());
		this.eventDto.setActivityType(activityCreationHelper.getActivityType());
		return eventDto;
	}

	public WorkshopDto creationWorkshop() {
		this.workshopDto = new WorkshopDto();
		this.workshopDto.setActivityName(activityCreationHelper.getActivityName());
		this.workshopDto.setActivityDate(activityCreationHelper.getActivityDate());
		this.workshopDto.setNumberOfParticipants(activityCreationHelper.getNumberOfParticipants());
		this.workshopDto.setShortDescription(activityCreationHelper.getShortDescription());
		this.workshopDto.setProgramDescription(activityCreationHelper.getProgramDescription());
		this.workshopDto.setActivityType(activityCreationHelper.getActivityType());
		return workshopDto;
	}
	
	/** -----ACTIVITY SUBSCRIPTION----- **/
	
	//Event

	public void eventSubscribe(EventDto eventDto) {
		this.eventDto = eventDto;
		Integer nbFreePlacesEv = this.eventDto.getNumberOfParticipants();
		if (nbFreePlacesEv > 0) {
			this.eventDto.setNumberOfParticipants(nbFreePlacesEv - 1);
		} else {
			activityNotSubscribed();
		}
		eventSubscribe();
	}
	
	public String eventSubscribe() {
		activityService.update(eventDto);
		eventDto = new EventDto();
		reloadEvents();
		return "activitySubscribed.xhtml?faces-redirect=true";
	}
	
	public void eventUnsubscribe(EventDto eventDto) {
		this.eventDto = eventDto;
		Integer nbFreePlacesEv = this.eventDto.getNumberOfParticipants();
		this.eventDto.setNumberOfParticipants(nbFreePlacesEv + 1);
		eventUnsubscribe();
	}
	
	public String eventUnsubscribe() {
		activityService.update(eventDto);
		eventDto = new EventDto();
		reloadEvents();
		return "activityUnsubscribed.xhtml?faces-redirect=true";
	}
	
	//Workshop
	
	public void workshopSubscribe(WorkshopDto workshopDto) {
		this.workshopDto = workshopDto;
		Integer nbFreePlacesWs = this.workshopDto.getNumberOfParticipants();
		if (nbFreePlacesWs > 0) {
			this.workshopDto.setNumberOfParticipants(nbFreePlacesWs - 1);
		} else {
			activityNotSubscribed();
		}
		workshopSubscribe();
	}
	
	public String workshopSubscribe() {
		activityService.update(workshopDto);
		workshopDto = new WorkshopDto();
		reloadWorkshops();
		return "activitySubscribed.xhtml?faces-redirect=true";
	}

	public void workshopUnsubscribe(WorkshopDto workshopDto) {
		this.workshopDto = workshopDto;
		Integer nbFreePlacesWs = this.workshopDto.getNumberOfParticipants();
		this.workshopDto.setNumberOfParticipants(nbFreePlacesWs + 1);
		workshopUnsubscribe();
	}
	
	public String workshopUnsubscribe() {
		activityService.update(workshopDto);
		workshopDto = new WorkshopDto();
		reloadWorkshops();
		return "activityUnsubscribed.xhtml?faces-redirect=true";
	}
	
	public String activityNotSubscribed() {
		return "activityNotSubscribed.xhtml?faces-redirect=true";
	}
	
	/** -----DEMO METHOD----- **/

	public String demo() throws ParseException {
		this.activityCreationHelper = new ActivityAdminDto();

		this.activityCreationHelper.setActivityName("Mes Beaux Légumes");
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		this.activityCreationHelper.setActivityDate(sf.parse("10/03/2022"));
		this.activityCreationHelper.setNumberOfParticipants(6);
		this.activityCreationHelper.setShortDescription("Un atelier très sympa !");
		this.activityCreationHelper.setProgramDescription("14h-15h : Création de bocaux de légumes lacto-fermentés");

		return "";
	}

	/** -----GETTERS & SETTERS----- **/

	public List<EventDto> getEvents() {
		return events;
	}

	public List<WorkshopDto> getWorkshops() {
		return workshops;
	}

	public EventDto getEventDto() {
		return eventDto;
	}

	public WorkshopDto getWorkshopDto() {
		return workshopDto;
	}

	public ActivityAdminDto getActivityCreationHelper() {
		return activityCreationHelper;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Workshop getWorkshop() {
		return workshop;
	}

	public void setWorkshop(Workshop workshop) {
		this.workshop = workshop;
	}
	
}
