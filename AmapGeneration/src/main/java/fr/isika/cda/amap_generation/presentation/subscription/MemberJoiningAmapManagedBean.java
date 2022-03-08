package fr.isika.cda.amap_generation.presentation.subscription;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda.amap_generation.business.subscription.MemberJoiningAmapService;
import fr.isika.cda.amap_generation.model.user.TypeOfMember;
import fr.isika.cda.amap_generation.model.user.TypeOfPlace;

@ManagedBean
@SessionScoped
public class MemberJoiningAmapManagedBean {
	
	@Inject
	private MemberJoiningAmapService joiningService;
	
	private MemberJoiningAmapDto joiningDto = new MemberJoiningAmapDto();
	
	
	@PostConstruct
	public void getRegisteredAuthenticate() {
		
		HttpSession session = (HttpSession) FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getSession(true);
		
		//Registered reg = (Registered) session.getAttribute("registeredConnected");
		//this.joiningDto.setName(reg.getLastName()+" " +reg.getLastName());
	}

	
	
	public TypeOfPlace[] allTypeOfPlace() {
		return TypeOfPlace.values();
	}

	public MemberJoiningAmapService getJoiningService() {
		return joiningService;
	}

	public void setJoiningService(MemberJoiningAmapService joiningService) {
		this.joiningService = joiningService;
	}

	public MemberJoiningAmapDto getJoiningDto() {
		return joiningDto;
	}

	public void setJoiningDto(MemberJoiningAmapDto joiningDto) {
		this.joiningDto = joiningDto;
	}
	
	public TypeOfMember[] allTypeOfMember() {
		return TypeOfMember.values();
	}

	public String subscriptionAmap() {
		return joiningService.createJoiningMember(joiningDto);
	}
	
}
