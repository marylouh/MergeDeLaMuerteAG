package fr.isika.cda.amap_generation.presentation.subscription;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import fr.isika.cda.amap_generation.business.subscription.SubscriptionService;

	public class MemberSubscriptionBasketFormulasDto implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = -2596978776126573231L;
		
		// Pour s'abonner aux paniers de notre AMAP, c'est très simple !
		// Veuillez compléter le formulaire ci-dessous en choisissant le panier "coup de coeur" 
		// qui correspond à vos envies et vos besoins.
		
		
		// Vos coordonnées (prévoir Bouton "Adhérent AMAP" - si les coordonnées sont déjà renseignées en BDD)
		
		private String firstName;
		private String lastName;
		private Date birthDate;
		
		private Integer numRue;
		private String rue;
		private String codePostal;
		private String ville;
		
		private String email;
		private String telPerso;
		private String telPro;
		
		// choix de votre abonnement panier
		
		private String soloBasket;
		private String duoBasket;
		private String familyBasket;
		
		// coordonneés bancaires
		private Integer iban;
		private Integer bic;
		
		
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public Date getBirthDate() {
			return birthDate;
		}
		public void setBirthDate(Date birthDate) {
			this.birthDate = birthDate;
		}
		public Integer getNumRue() {
			return numRue;
		}
		public void setNumRue(Integer numRue) {
			this.numRue = numRue;
		}
		public String getRue() {
			return rue;
		}
		public void setRue(String rue) {
			this.rue = rue;
		}
		public String getCodePostal() {
			return codePostal;
		}
		public void setCodePostal(String codePostal) {
			this.codePostal = codePostal;
		}
		public String getVille() {
			return ville;
		}
		public void setVille(String ville) {
			this.ville = ville;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getTelPerso() {
			return telPerso;
		}
		public void setTelPerso(String telPerso) {
			this.telPerso = telPerso;
		}
		public String getTelPro() {
			return telPro;
		}
		public void setTelPro(String telPro) {
			this.telPro = telPro;
		}
		public String getSoloBasket() {
			return soloBasket;
		}
		
		public void setSoloBasket(String soloBasket) {
			this.soloBasket = soloBasket;
		}
	
		public String getDuoBasket() {
			return duoBasket;
		}
	
		public void setDuoBasket(String duoBasket) {
			this.duoBasket = duoBasket;
		}
		
		public String getFamilyBasket() {
			return familyBasket;
		}
	
		public void setFamilyBasket(String familyBasket) {
			this.familyBasket = familyBasket;
		}
		
		public Integer getIban() {
			return iban;
		}
		public void setIban(Integer iban) {
			this.iban = iban;
		}
		public Integer getBic() {
			return bic;
		}
		public void setBic(Integer bic) {
			this.bic = bic;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("EntreeCarnetAdresses [firstName=");
			builder.append(firstName);
			builder.append(", lastName=");
			builder.append(lastName);
			builder.append(", birthDate=");
			builder.append(birthDate);
			builder.append(", numRue=");
			builder.append(numRue);
			builder.append(", rue=");
			builder.append(rue);
			builder.append(", codePostal=");
			builder.append(codePostal);
			builder.append(", ville=");
			builder.append(ville);
			builder.append(", email=");
			builder.append(email);
			builder.append(", telPerso=");
			builder.append(telPerso);
			builder.append(", telPro=");
			builder.append(telPro);
			builder.append("]");
			builder.append(", soloBasket=");
			builder.append(soloBasket);
			builder.append(", duoBasket=");
			builder.append(duoBasket);
			builder.append(", familyBasket=");
			builder.append(familyBasket);
			builder.append(", iban=");
			builder.append(iban);
			builder.append(", bic=");
			builder.append(bic);
			builder.append("]");
			return builder.toString();
		}
		public List<SubscriptionService> getAllSubscriptions() {
			// TODO Auto-generated method stub
			return null;
		}
	}	
