package fr.isika.cda.amap_generation.model.user;

import javax.persistence.*;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 50, name = "REFERENCE_ACCOUNT")
	private String referenceAccount;

	@Column(length = 32, name = "ACCOUNT_ORDER")
	private String order;

	@Column(length = 50, name = "PROCESSED_ORDER")
	private String processedOrder;

	@Column(length = 50, name = "INVOICE")
	private String invoice;

	public Long getId() {
		return id;
	}

	public String getReferenceAccount() {
		return referenceAccount;
	}

	public void setReferenceAccount(String referenceAccount) {
		this.referenceAccount = referenceAccount;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getProcessedOrder() {
		return processedOrder;
	}

	public void setProcessedOrder(String processedOrder) {
		this.processedOrder = processedOrder;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [id=");
		builder.append(id);
		builder.append("\nOrder=");
		builder.append(order);
		builder.append(",\nProcessedOrder=");
		builder.append(processedOrder);
		builder.append("\nInvoice=");
		builder.append(invoice);
		builder.append("\nSubcriber=");
		builder.append("]");
		return builder.toString();
	}
}