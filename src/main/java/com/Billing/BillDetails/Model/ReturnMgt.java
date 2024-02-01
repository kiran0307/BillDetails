package com.Billing.BillDetails.Model;
//import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class ReturnMgt {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)	
	private int returnId;
	private String returnReason;
	private int invoiceId;
	private int invoiceNumber;
	
	
	
	public int getReturnId() {
		return returnId;
	}
	public void setReturnId(int returnId) {
		this.returnId = returnId;
	}
	public String getReturnReason() {
		return returnReason;
	}
	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public int getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	
	
	public ReturnMgt() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ReturnMgt(int returnId, int typeId, String returnReason, int invoiceId, int invoiceNumber) {
		super();
		this.returnId = returnId;
		this.returnReason = returnReason;
		this.invoiceId = invoiceId;
		this.invoiceNumber = invoiceNumber;
	}
	
	
	@Override
	public String toString() {
		return "ReturnMgt [returnId=" + returnId + ", returnReason=" + returnReason + ", invoiceId=" + invoiceId
				+ ", invoiceNumber=" + invoiceNumber + "]";
	}
	

			
}
