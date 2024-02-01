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

import com.Billing.BillDetails.Model.InvoiceDetails;
import com.Billing.BillDetails.Model.InvoiceDetailsResponse;
import com.Billing.BillDetails.Model.StoreManagementResponse;
import com.Billing.BillDetails.Service.InvoiceService;

@RestController
@RequestMapping("/invoicedetails")
public class InvoiceDetailsController {

    @Autowired
    private InvoiceService invoiceservice;

    @GetMapping
    public List<InvoiceDetails> getInvoiceDetails() {
        try {
            return this.invoiceservice.getAllInvoiceDetails();
        } catch (Exception e) {
            // Log the exception for debugging
            e.printStackTrace();
            throw new RuntimeException("Error retrieving invoice details: " + e.getMessage(), e);
        }
    }

    @GetMapping("invoice/{stockId}")
    public InvoiceDetails getInvoicebyId(@PathVariable String stockId) {
        try {
            return this.invoiceservice.getInvoicebyId(Integer.parseInt(stockId));
        } catch (Exception e) {
            // Log the exception for debugging
            e.printStackTrace();
            throw new RuntimeException("Error retrieving invoice details by ID: " + e.getMessage(), e);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addInvoiceDetails(@RequestBody List<InvoiceDetails> invocierecords) {
        try {
            if (invocierecords.isEmpty()) {
                return ResponseEntity.badRequest().body("Invoice details list cannot be empty");
            }

            if (invocierecords.size() == 1) {
                InvoiceDetails addedrecord = invoiceservice.addInvoice(invocierecords.get(0));
                return ResponseEntity.ok(addedrecord);
            } else {
                List<InvoiceDetails> addedrecords = invoiceservice.addInvoices(invocierecords);
                return ResponseEntity.ok(addedrecords);
            }
        } catch (Exception e) {
            // Log the exception for debugging
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error adding invoice details: " + e.getMessage());
        }
    }
    
    @GetMapping("/stores")
    public List<StoreManagementResponse> getAllStores() {
        try {
            return this.invoiceservice.getAllStores();
        } catch (Exception e) {
            // Log the exception for debugging
            e.printStackTrace();
            throw new RuntimeException("Error retrieving store details: " + e.getMessage(), e);
        }
    }
    

}
