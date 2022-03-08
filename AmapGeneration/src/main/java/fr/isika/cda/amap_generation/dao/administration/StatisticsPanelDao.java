package fr.isika.cda.amap_generation.dao.administration;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.amap_generation.model.OrderAmap.OrderAmap;
import fr.isika.cda.amap_generation.model.amap.Activity;
import fr.isika.cda.amap_generation.model.amap.Amap;
import fr.isika.cda.amap_generation.model.amap.Event;
import fr.isika.cda.amap_generation.model.amap.Workshop;
import fr.isika.cda.amap_generation.model.user.Member;

@Stateless
public class StatisticsPanelDao {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Amap> getAllAmapByMonth(int m, int a) {
		List<Amap> amaps = this.entityManager
				.createQuery("SELECT am FROM Amap am WHERE MONTH(am.dateOfSubscription) LIKE :mois AND YEAR(am.dateOfSubscription) LIKE :annee ")
				.setParameter("mois", m).setParameter("annee", a).getResultList();
		return amaps;
	}
	
	public List<Activity> getAllActivityByMonth(int m, int a) {
		List<Activity> activities = this.entityManager
				.createQuery("SELECT ac FROM Activity ac WHERE MONTH(ac.activityDate) LIKE :mois AND YEAR(ac.activityDate) LIKE :annee ")
				.setParameter("mois", m).setParameter("annee", a).getResultList();

		return activities;
	}
	
	public List<Workshop> getAllWorkshoptByMonth(int m, int a) {
		List<Workshop> workshops = this.entityManager
				.createQuery("SELECT wk FROM Activity wk WHERE wk.activityType = :workshop AND MONTH(wk.activityDate) LIKE :mois AND YEAR(wk.activityDate) LIKE :annee ")
				.setParameter("mois", m).setParameter("annee", a).setParameter("workshop", fr.isika.cda.amap_generation.model.amap.ActivityType.WORKSHOP).getResultList();
		return workshops;
	}
	
	public List<Event> getAllEventByMonth(int m, int a) {
		List<Event> events = this.entityManager
				.createQuery("SELECT ev FROM Activity ev WHERE ev.activityType = :event AND MONTH(ev.activityDate) LIKE :mois AND YEAR(ev.activityDate) LIKE :annee ")
				.setParameter("mois", m).setParameter("annee", a).setParameter("event", fr.isika.cda.amap_generation.model.amap.ActivityType.EVENT).getResultList();
		return events;
	}
	
	public List<Member> getAllMembersByMonth(int m, int a) {
		List<Member> members = this.entityManager
				.createQuery("SELECT m FROM Member m WHERE MONTH(m.dateOfSubscription) LIKE :mois AND YEAR(m.dateOfSubscription) LIKE :annee ")
				.setParameter("mois", m).setParameter("annee", a).getResultList();
		return members;
	}
	
	public List<OrderAmap> getAllOrdersByMonth(int m, int a) {
		List<OrderAmap> orders = this.entityManager
				.createQuery("SELECT o FROM OrderAmap o WHERE MONTH(o.dateOfSubscription) LIKE :mois AND YEAR(o.dateOfSubscription) LIKE :annee ")
				.setParameter("mois", m).setParameter("annee", a).getResultList();
		return orders;
	}
	
	
}
