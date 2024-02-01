package com.Billing.BillDetails.Service;

import java.util.Collections;
import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Billing.BillDetails.Dao.InvoiceDao;
import com.Billing.BillDetails.Model.InvoiceDetails;
//import com.Billing.BillDetails.Model.InvoiceDetailsResponse;
//import com.Billing.BillDetails.Model.StoreManagementResponse;
import com.Billing.BillDetails.Model.StoreManagementResponse;

import feign.FeignException;

@Service
public class InvoiceServiceImplement implements InvoiceService {
	@Autowired
	private InvoiceDao invoicedao;
	
	@Autowired
	private FeignStoreManagementService storeservice;
	
	@Autowired
	private ModelMapper modelmapper;

	@Override
	public List<InvoiceDetails> getAllInvoiceDetails() {
		return invoicedao.findAll();
	}

	@Override
	public InvoiceDetails getInvoicebyId(int invoiceId) {
		 return invoicedao.findById(invoiceId).orElse(null);
	}
	
	@Override
	public InvoiceDetails addInvoice(InvoiceDetails invoice) {
		return invoicedao.save(invoice);
	}

	@Override
	public List<InvoiceDetails> addInvoices(List<InvoiceDetails> invoices) {
		return invoicedao.saveAll(invoices);
	}
	
	@Override
	public List<StoreManagementResponse> getAllStores() {
	    try {
	        ResponseEntity<List<StoreManagementResponse>> storeResponseEntity = storeservice.getAllStores();

	        if (storeResponseEntity.getStatusCode().is2xxSuccessful()) {
	            return storeResponseEntity.getBody();
	        } else {
	            // Log the error response if available
	            String errorMessage = storeResponseEntity.getBody() != null ?
	                    storeResponseEntity.getBody().toString() : "No error message available";

	            // Handle the case when the Feign Client call was not successful
	            throw new RuntimeException("Error fetching store details. Status code: " +
	                    storeResponseEntity.getStatusCode() + ", Error message: " + errorMessage);
	        }
	    } catch (FeignException feignException) {
	        // Handle Feign-specific exceptions
	        // You might want to extract more details from the FeignException if needed
	        throw new RuntimeException("Feign client error while fetching store details", feignException);
	    } catch (Exception e) {
	        // Handle other exceptions
	        throw new RuntimeException("Error fetching store details: " + e.getMessage(), e);
	    }
	}

    }







