package com.Billing.BillDetails.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Billing.BillDetails.Model.ReturnMgt;
import com.Billing.BillDetails.Service.ReturnService;

@RestController
@RequestMapping("/return")
public class ReturnMgtController {
	
	@Autowired
	private ReturnService returnservice;
	
	@GetMapping
	public List<ReturnMgt> getreturnlist()
	{
		return this.returnservice.getReturnlist();
	}
	
	@GetMapping("/{returnId}")
	public ReturnMgt getbyId(@PathVariable String returnId)
	{
		return this.returnservice.getReturnRecord(Integer.parseInt(returnId));
		
	}
	
	
	@PostMapping("/add")
	   public ResponseEntity<?> addInvoiceDetails(@RequestBody List<ReturnMgt> returnrecords) {
	        if (returnrecords.isEmpty()) {
	            return ResponseEntity.badRequest().body("Store list cannot be empty");
	        }

	        if (returnrecords.size() == 1) {
	        	ReturnMgt addedreturn = returnservice.addReturnRecord(returnrecords.get(0));
	            return ResponseEntity.ok(addedreturn);
	        } else {
	            List<ReturnMgt> addedreturns = returnservice.addReturnRecords(returnrecords);
	            return ResponseEntity.ok(addedreturns);
	       }
	   }

}
