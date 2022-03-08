package fr.isika.cda.amap_generation.business.profileManagement;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda.amap_generation.dao.profileManagement.ProfileManagementDao;
import fr.isika.cda.amap_generation.model.amap.AmapAdministrator;
import fr.isika.cda.amap_generation.model.amap.TypeOfRentalFormulas;
import fr.isika.cda.amap_generation.model.supplier.Supplier;
import fr.isika.cda.amap_generation.model.user.Administrator;
import fr.isika.cda.amap_generation.model.user.Member;
import fr.isika.cda.amap_generation.model.user.Person;
import fr.isika.cda.amap_generation.model.user.Registered;
import fr.isika.cda.amap_generation.presentation.authentication.AuthenticationDto;

@Stateless
public class ProfileManagementService {

		@Inject
		private ProfileManagementDao profileManagementDao;

		public void verificationOfSessionInfosAndSessionFilling() {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			Long amapId = (Long) session.getAttribute("idAmap");
			Long idLogin = (Long) session.getAttribute("idLogin");

			if (amapId != null) {
				if (this.profileManagementDao.getAllSuppliersWithAmap(amapId) != null) {

					Supplier supplier = this.profileManagementDao.getSupplierById(idLogin);
					session.setAttribute("supplierConnected", supplier);

				} else if (this.profileManagementDao.getAllRegisteredsWithAmap(amapId) != null) {
					Registered registered = this.profileManagementDao.getRegisteredById(idLogin);
					session.setAttribute("registeredConnected", registered);

					Member member = this.profileManagementDao.getMemberInRegistredTable(registered.getId());
					session.setAttribute("memberConnected", member);

				}
			} else {

				AmapAdministrator amapAdministrator = this.profileManagementDao.getAmapAdministartorById(idLogin);
				session.setAttribute("amapAdminConnected", amapAdministrator);

				Administrator administrator = this.profileManagementDao.getAdministratorById(idLogin);
				session.setAttribute("administratorConnected", administrator);
			}
		}

		public AmapAdministrator getAWbyId(Long id) {
			return this.profileManagementDao.getAmapAdministartorById(id);
		}

		public Registered getRegisteredById(Long id) {
			return this.profileManagementDao.getRegisteredById(id);
		}

		public Registered getRegisteredByIdPerson(Long id) {
			return this.profileManagementDao.getRegisteredByIdPerson(id);

		}

		// Authentication

		public Person authentication(AuthenticationDto authenticationDto) {
			FacesContext context = FacesContext.getCurrentInstance();
			Person p = profileManagementDao.isPersonExist(authenticationDto);

			if (p != null) {

				HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
						.getSession(false);

				session.setAttribute("idLogin", p.getId());
				return p;
			} else {
				context.addMessage(null, new FacesMessage("non reconnu"));
				return null;
			}
		}

		public TypeOfRentalFormulas typeOfRentalFormulasByAmapId(Long id) {
			return this.profileManagementDao.typeOfRentalFormulasByAmapId(id);
		}

		public String logout() {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.invalidate();
			return "indexAmap.xhtml";
		}

}
