package com.raiwind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.raiwind.model.ContractPriceRepository;
import com.raiwind.model.MasterDocRepository;

@Controller
public class ContractPriceController {
	private static final String INDIRECT_COST = "INDIRECT COST";

	private static final String DIRECT_COST = "DIRECT COST";

	private static final String CONTRACT = "CONTRACT";

	@Autowired
	private MasterDocRepository mr;

	@Autowired
	private ContractPriceRepository cr;

	@RequestMapping("/createContractPrice")
	public String createContract() {
		return null;
	}
}
