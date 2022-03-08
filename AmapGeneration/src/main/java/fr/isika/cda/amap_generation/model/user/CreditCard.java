package fr.isika.cda.amap_generation.model.user;

import javax.persistence.*;

@Entity
@NamedQueries(@NamedQuery(name = "CreditCard.findAll", query = "select cc from CreditCard cc"))
public class CreditCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(length = 50, name = "NOM_TITULAIRE")
	private String cardName;

	@Column(length = 32, name = "NUMERO_CARTE")
	private String cardNumber;

	@Column(length = 32, name = "MOIS_EXPIRATION")
	private String expirationMonth;

	@Column(length = 32, name = "ANNEE_EXPIRATION")
	private String expirationYear;

	@Column(length = 32, name = "CRYPTOGRAMME")
	private String cryptogram;

	@ManyToOne
	@JoinColumn(name = "idRegistered", nullable = false)
	private Registered registered;

	public CreditCard() {
	}

	public Long getId() {
		return id;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String carName) {
		this.cardName = carName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirationMonth() {
		return expirationMonth;
	}

	public void setExpirationMonth(String expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	public String getExpirationYear() {
		return expirationYear;
	}

	public void setExpirationYear(String expirationYear) {
		this.expirationYear = expirationYear;
	}

	public String getCryptogram() {
		return cryptogram;
	}

	public void setCryptogram(String cryptogram) {
		this.cryptogram = cryptogram;
	}

	public Registered getRegistered() {
		return registered;
	}

	public void setRegistered(Registered registered) {
		this.registered = registered;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreditCard [id=");
		builder.append(id);
		builder.append(", cardName=");
		builder.append(cardName);
		builder.append(", cardNumber=");
		builder.append(cardNumber);
		builder.append(", expirationMonth=");
		builder.append(expirationMonth);
		builder.append(", expirationYear=");
		builder.append(expirationYear);
		builder.append(", cryptogram=");
		builder.append(cryptogram);
		builder.append("]");
		return builder.toString();
	}

}
