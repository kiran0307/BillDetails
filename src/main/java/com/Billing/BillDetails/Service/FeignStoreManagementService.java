package com.Billing.BillDetails.Service;

import java.util.List;

//import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import com.Billing.BillDetails.Model.InvoiceDetails;
import com.Billing.BillDetails.Model.StoreManagementResponse;

@FeignClient(name = "store-service", url = "http://localhost:8080", path ="/store")
public interface FeignStoreManagementService {
	
	@GetMapping
	public ResponseEntity<List<StoreManagementResponse>> getAllStores();
	}

