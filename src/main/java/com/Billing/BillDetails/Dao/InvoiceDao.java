package com.Billing.BillDetails.Dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.Billing.BillDetails.Model.InvoiceDetails;

public interface InvoiceDao extends JpaRepository <InvoiceDetails, Integer> {

}
