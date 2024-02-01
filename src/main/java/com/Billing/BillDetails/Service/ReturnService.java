package com.Billing.BillDetails.Service;

import java.util.List;

import com.Billing.BillDetails.Model.ReturnMgt;

public interface ReturnService {
	public List<ReturnMgt> getReturnlist();
	public ReturnMgt getReturnRecord(int returnId);
	public ReturnMgt addReturnRecord(ReturnMgt returns);
	public List<ReturnMgt> addReturnRecords(List<ReturnMgt> returns);

}
