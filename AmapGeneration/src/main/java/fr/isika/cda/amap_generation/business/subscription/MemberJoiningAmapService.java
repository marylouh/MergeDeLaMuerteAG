package fr.isika.cda.amap_generation.business.subscription;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.amap_generation.dao.subscription.MemberJoiningAmapDao;
import fr.isika.cda.amap_generation.presentation.subscription.MemberJoiningAmapDto;

@Stateless
public class MemberJoiningAmapService {
	@Inject
	private MemberJoiningAmapDao rentalDao;

	public String createJoiningMember(MemberJoiningAmapDto joiningHelper) {
		this.rentalDao.persistence(joiningHelper);
		return "indexAmap.xhtml";
	}
}
