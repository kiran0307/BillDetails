package com.Billing.BillDetails.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Billing.BillDetails.Dao.ReturnDao;
import com.Billing.BillDetails.Model.ReturnMgt;

@Service
public class ReturnServiceImplement implements ReturnService {

	@Autowired
	private ReturnDao returndao;
	@Override
	public List<ReturnMgt> getReturnlist() {
		return returndao.findAll();
	}

	@Override
	public ReturnMgt getReturnRecord(int returnId) {
		return returndao.findById(returnId).orElse(null);
	}

	@Override
	public ReturnMgt addReturnRecord(ReturnMgt returns) {
		returndao.save(returns);
		return returns;
	}

	@Override
	public List<ReturnMgt> addReturnRecords(List<ReturnMgt> returns) {
		List<ReturnMgt> savedreturns = returndao.saveAll(returns);
		return savedreturns;
	}

}
