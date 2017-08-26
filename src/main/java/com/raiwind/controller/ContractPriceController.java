package com.raiwind.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.raiwind.model.ContractPrice;
import com.raiwind.model.ContractPriceRepository;
import com.raiwind.model.MasterDoc;
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
	public String createContract(String projectName, String jobno, String docnum, int rev, String date, int fd1m,
			String fd1r,

			int fd2m, String fd2r,

			int fd3m, String fd3r,

			int fi1m, String fi1r,

			int fi2m, String fi2r,

			int fi3m, String fi3r,

			int fi4m, String fi4r,

			int fi5m, String fi5r,

			int fi6m, String fi6r,

			int fi7m, String fi7r) {

		int max = (int) mr.count() + 1;
		String formId = CONTRACT + max;

		/* Add Master */
		MasterDoc md = new MasterDoc(projectName, jobno, docnum, rev, new Date(), formId, CONTRACT);
		mr.save(md);

		addCost(fd1m, fd1r, "DIRECT MATERIALS", formId, DIRECT_COST);
		addCost(fd2m, fd2r, "DIRECT LABOUR", formId, DIRECT_COST);
		addCost(fd3m, fd3r, "CONSTRUCTION EQUIPMENT", formId, DIRECT_COST);
		addCost(fi1m, fi1r, "INDIRECT LABOR", formId, INDIRECT_COST);
		addCost(fi2m, fi2r, "TEMPORARY FACILITIES", formId, INDIRECT_COST);
		addCost(fi3m, fi3r, "GENERAL FIELD EXPENSES", formId, INDIRECT_COST);
		addCost(fi4m, fi4r, "INSURANCE", formId, INDIRECT_COST);
		addCost(fi5m, fi5r, "HSE", formId, INDIRECT_COST);
		addCost(fi6m, fi6r, "PROFIT", formId, INDIRECT_COST);
		addCost(fi7m, fi7r, "TAX", formId, INDIRECT_COST);

		return "redirect:/form2-list.html";
	}

	private void addCost(int amount, String remark, String topic, String formId, String section) {
		ContractPrice cp = new ContractPrice(amount, remark, topic, formId, section);
		cr.save(cp);
	}

	@RequestMapping("/getContractPriceFormId")
	@ResponseBody
	public List<ContractPrice> GetFormId(String formId) {
		return cr.findByFormId(formId);
	}

	@RequestMapping("/getContractPriceFormIdAndTopic")
	@ResponseBody
	public ContractPrice GetFormIdAndTopic(String formId, String topic) {
		return cr.findByFormIdAndTopic(formId, topic);
	}
}
