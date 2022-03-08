package fr.isika.cda.amap_generation.presentation.subscription;

import fr.isika.cda.amap_generation.model.user.TypeOfMember;
import fr.isika.cda.amap_generation.model.user.TypeOfPlace;

public class MemberJoiningAmapDto {

	
	// Address
		private String number;
		private TypeOfPlace typeOfPlace;
		private String nameOfPlace;
		private String postalCode;
		private String town;
		private TypeOfMember typeOfMember;
		private String name;
		private String numCard;
		private String crypto;
		private String validite;
		
		public String getNumber() {
			return number;
		}
		public void setNumber(String number) {
			this.number = number;
		}
		public TypeOfPlace getTypeOfPlace() {
			return typeOfPlace;
		}
		public void setTypeOfPlace(TypeOfPlace typeOfPlace) {
			this.typeOfPlace = typeOfPlace;
		}
		public String getNameOfPlace() {
			return nameOfPlace;
		}
		public void setNameOfPlace(String nameOfPlace) {
			this.nameOfPlace = nameOfPlace;
		}
		public String getPostalCode() {
			return postalCode;
		}
		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}
		public String getTown() {
			return town;
		}
		public void setTown(String town) {
			this.town = town;
		}
		public TypeOfMember getTypeOfMember() {
			return typeOfMember;
		}
		public void setTypeOfMember(TypeOfMember typeOfMember) {
			this.typeOfMember = typeOfMember;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getNumCard() {
			return numCard;
		}
		public void setNumCard(String numCard) {
			this.numCard = numCard;
		}
		public String getCrypto() {
			return crypto;
		}
		public void setCrypto(String crypto) {
			this.crypto = crypto;
		}
		public String getValidite() {
			return validite;
		}
		public void setValidite(String validite) {
			this.validite = validite;
		}
		
		
		
		
		
}
