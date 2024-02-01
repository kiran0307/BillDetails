package com.Billing.BillDetails.Model;

public class InvoiceDetailsResponse {
	
	private int stockId;
	private int invoiceId;
    private String invoiceType;
    private int invoiceNumber;
    private int numberofLines;
    private int totalBill;
    private StoreManagementResponse storemgtresponse;
    
    public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.invoiceId = stockId;
	}
	
    public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public int getNumberofLines() {
		return numberofLines;
	}

	public void setNumberofLines(int numberofLines) {
		this.numberofLines = numberofLines;
	}

	public int getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(int totalBill) {
		this.totalBill = totalBill;
	}
	
	public StoreManagementResponse getStoreManagement() {
		return storemgtresponse;
	}
	
	public void setStoreManagement(StoreManagementResponse storemgtresponse ) {
		this.storemgtresponse = storemgtresponse;
	}
}
