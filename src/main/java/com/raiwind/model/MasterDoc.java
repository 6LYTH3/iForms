package com.raiwind.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "masterdoc")
public class MasterDoc {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String projectName;
	@NotNull
	@Column(unique = true)
	private String jobno;
	private String docnum;
	private int rev;
	private Date date;
	private String formId;

	public MasterDoc() {

	}

	public MasterDoc(String projectName, String jobno, String docnum, int rev, Date date, String formId) {
		this.projectName = projectName;
		this.jobno = jobno;
		this.docnum = docnum;
		this.rev = rev;
		this.date = date;
		this.formId = formId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getJobno() {
		return jobno;
	}

	public void setJobno(String jobno) {
		this.jobno = jobno;
	}

	public String getDocnum() {
		return docnum;
	}

	public void setDocnum(String docnum) {
		this.docnum = docnum;
	}

	public int getRev() {
		return rev;
	}

	public void setRev(int rev) {
		this.rev = rev;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

}
