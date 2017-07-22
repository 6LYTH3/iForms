package com.raiwind.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.raiwind.model.GeneralContractor;
import com.raiwind.model.GeneralContractorRepository;
import com.raiwind.model.MasterDoc;
import com.raiwind.model.MasterDocRepository;

@Controller
public class GeneralContractorController {
	private static final String INDIRECT_COST = "INDIRECT COST";

	private static final String DIRECT_COST = "DIRECT COST";

	private static final String GENCONTR = "GENCONTR";

	@Autowired
	private MasterDocRepository mr;

	@Autowired
	private GeneralContractorRepository gr;

	@RequestMapping("/createGeneralContrator")
	public String CreateFrom(String projectName, String jobno, String docnum, int rev, String date, int fd1m, int fd1l,
			int fd1c, int fd1t, String fd1r,

			int fd2m, int fd2l, int fd2c, int fd2t, String fd2r,

			int fd3m, int fd3l, int fd3c, int fd3t, String fd3r,

			int fd4m, int fd4l, int fd4c, int fd4t, String fd4r,

			int fd5m, int fd5l, int fd5c, int fd5t, String fd5r,

			int fd6m, int fd6l, int fd6c, int fd6t, String fd6r,

			int fd7m, int fd7l, int fd7c, int fd7t, String fd7r,

			int fd8m, int fd8l, int fd8c, int fd8t, String fd8r,

			int fd9m, int fd9l, int fd9c, int fd9t, String fd9r,

			int fd10m, int fd10l, int fd10c, int fd10t, String fd10r,

			int fi1m, int fi1l, int fi1c, int fi1t, String fi1r,

			int fi2m, int fi2l, int fi2c, int fi2t, String fi2r,

			int fi3m, int fi3l, int fi3c, int fi3t, String fi3r,

			int fi4m, int fi4l, int fi4c, int fi4t, String fi4r,

			int fi5m, int fi5l, int fi5c, int fi5t, String fi5r,

			int fi6m, int fi6l, int fi6c, int fi6t, String fi6r,

			int fi7m, int fi7l, int fi7c, int fi7t, String fi7r) {

		int max = (int) mr.count() + 1;
		String formId = GENCONTR + max;

		/* Add Master */
		MasterDoc md = new MasterDoc(projectName, jobno, docnum, rev, new Date(), formId, GENCONTR);
		mr.save(md);

		addCost(fd1m, fd1l, fd1c, fd1t, fd1r, "COMMON TEMPORARY FACILITY WORK", formId, DIRECT_COST);
		addCost(fd2m, fd2l, fd2c, fd2t, fd2r, "CIVIL WORK", formId, DIRECT_COST);
		addCost(fd3m, fd3l, fd3c, fd3t, fd3r, "ARCHITECTURE WORK", formId, DIRECT_COST);
		addCost(fd4m, fd4l, fd4c, fd4t, fd4r, "STEEL STRUCTURE WORK", formId, DIRECT_COST);
		addCost(fd5m, fd5l, fd5c, fd5t, fd5r, "PIPING WORK", formId, DIRECT_COST);
		addCost(fd6m, fd6l, fd6c, fd6t, fd6r, "PAINTING WORK", formId, DIRECT_COST);
		addCost(fd7m, fd7l, fd7c, fd7t, fd7r, "INSULATION WORK", formId, DIRECT_COST);
		addCost(fd8m, fd8l, fd8c, fd8t, fd8r, "EQUIPMENT INSTALLATION WORK", formId, DIRECT_COST);
		addCost(fd9m, fd9l, fd9c, fd9t, fd9r, "ELECTRICAL WORK", formId, DIRECT_COST);
		addCost(fd10m, fd10l, fd10c, fd10t, fd10r, "INSTRUMENT WORK", formId, DIRECT_COST);
		addCost(fi1m, fi1l, fi1c, fi1t, fi1r, "INDIRECT LABOR", formId, INDIRECT_COST);
		addCost(fi2m, fi2l, fi2c, fi2t, fi2r, "TEMPORARY FACILITIES", formId, INDIRECT_COST);
		addCost(fi3m, fi3l, fi3c, fi3t, fi3r, "GENERAL FIELD EXPENSES", formId, INDIRECT_COST);
		addCost(fi4m, fi4l, fi4c, fi4t, fi4r, "INSURANCE", formId, INDIRECT_COST);
		addCost(fi5m, fi5l, fi5c, fi5t, fi5r, "HSE", formId, INDIRECT_COST);
		addCost(fi6m, fi6l, fi6c, fi6t, fi6r, "PROFIT", formId, INDIRECT_COST);
		addCost(fi7m, fi7l, fi7c, fi7t, fi7r, "TAX", formId, INDIRECT_COST);

		return "redirect:/form1-list.html";

	}

	private void addCost(int matrial, int labor, int construction, int total, String remark, String topic,
			String formId, String section) {
		GeneralContractor gc = new GeneralContractor(matrial, labor, construction, total, remark, topic, formId,
				section);
		gr.save(gc);
	}

	@RequestMapping("/getGenernalConFormId")
	@ResponseBody
	public List<GeneralContractor> GetFormId(String formId) {
		return gr.findByFormId(formId);
	}

	@RequestMapping("/getGenernalConFormIdAndTopic")
	@ResponseBody
	public GeneralContractor GetFormIdAndTopic(String formId, String topic) {
		return gr.findByFormIdAndTopic(formId, topic);
	}
}
