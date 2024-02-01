package com.Billing.BillDetails.Service;

import java.util.List;

import com.Billing.BillDetails.Model.InvoiceDetails;
import com.Billing.BillDetails.Model.InvoiceDetailsResponse;
import com.Billing.BillDetails.Model.StoreManagementResponse;

public interface InvoiceService {
	List<InvoiceDetails> getAllInvoiceDetails();

	InvoiceDetails getInvoicebyId(int invoiceId);

	InvoiceDetails addInvoice(InvoiceDetails invoice);

    List<InvoiceDetails> addInvoices(List<InvoiceDetails> invoices);

	List<StoreManagementResponse> getAllStores();

}
