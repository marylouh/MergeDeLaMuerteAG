package fr.isika.cda.amap_generation.business.administration;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.amap_generation.dao.administration.StatisticsPanelDao;
import fr.isika.cda.amap_generation.model.OrderAmap.OrderAmap;
import fr.isika.cda.amap_generation.model.amap.Activity;
import fr.isika.cda.amap_generation.model.amap.Amap;
import fr.isika.cda.amap_generation.model.amap.Event;
import fr.isika.cda.amap_generation.model.amap.Workshop;
import fr.isika.cda.amap_generation.model.user.Member;

@Stateless
public class StatisticsPanelService {
	
	@Inject
	private StatisticsPanelDao statDao;
	
public List<Amap> getAllAmapsByMonth(int m, int a){
	return this.statDao.getAllAmapByMonth(m, a);
}
public List<Activity> getAllActivityByMonth(int m, int a){
	return this.statDao.getAllActivityByMonth(m, a);
}
public List<Workshop> getAllWorkshoptByMonth(int m, int a){
	return this.statDao.getAllWorkshoptByMonth(m, a);
}
public List<Event> getAllEventByMonth(int m, int a){
	return this.statDao.getAllEventByMonth(m, a);
}


public List<Member> getAllMembersByMonth(int m, int a){
	return this.statDao.getAllMembersByMonth(m, a);
}

public List<OrderAmap> getAllOrdersByMonth(int m, int a){
	return this.statDao.getAllOrdersByMonth(m, a);
}
}
