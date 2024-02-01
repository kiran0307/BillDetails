package com.Billing.BillDetails.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Billing.BillDetails.Model.ReturnMgt;

public interface ReturnDao extends JpaRepository<ReturnMgt, Integer>  {

}
