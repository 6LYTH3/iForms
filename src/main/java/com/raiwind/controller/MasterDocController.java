package com.raiwind.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.raiwind.model.MasterDoc;
import com.raiwind.model.MasterDocRepository;

@Controller
public class MasterDocController {
	// private SimpleDateFormat shifdate = new SimpleDateFormat("dd-MMM-yyyy");

	@Autowired
	private MasterDocRepository mr;

	@RequestMapping("/addMasterDoc")
	@ResponseBody
	public List<MasterDoc> AddDoc(String projectName, String jobno, String docnum, int rev, String date, String formId,
			String type) {
		MasterDoc md = new MasterDoc(projectName, jobno, docnum, rev, new Date(), formId, type);
		mr.save(md);
		return (List<MasterDoc>) mr.findAll();
	}

	@RequestMapping("/DelMacterDocWithJobno")
	@ResponseBody
	public List<MasterDoc> DelDocWithJobno(String jobno) {
		mr.deleteByJobno(jobno);
		return (List<MasterDoc>) mr.findAll();
	}

	@RequestMapping("/getMasterFormId")
	@ResponseBody
	public MasterDoc GetFormId(String formId) {
		return mr.findByFormId(formId);
	}

	@RequestMapping("/getMasterJobno")
	@ResponseBody
	public MasterDoc GetJobno(String jobno) {
		return mr.findByJobno(jobno);
	}

	@RequestMapping("/showAllMaster")
	@ResponseBody
	public List<MasterDoc> ShowAllGeneralCon(String type) {
		return mr.findByTypeOrderByIdDesc(type);
	}
}
