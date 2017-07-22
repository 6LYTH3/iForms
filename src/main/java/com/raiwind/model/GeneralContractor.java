package com.raiwind.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "generalcontractor")
public class GeneralContractor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int matrial;
	private int labor;
	private int construction;
	private int total;
	private String remark;
	private String topic;
	private String formId;
	private String section;

	public GeneralContractor() {

	}

	public GeneralContractor(int matrial, int labor, int construction, int total, String remark, String topic,
			String formId, String section) {
		this.matrial = matrial;
		this.labor = labor;
		this.construction = construction;
		this.total = total;
		this.remark = remark;
		this.topic = topic;
		this.formId = formId;
		this.section = section;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getMatrial() {
		return matrial;
	}

	public void setMatrial(int matrial) {
		this.matrial = matrial;
	}

	public int getLabor() {
		return labor;
	}

	public void setLabor(int labor) {
		this.labor = labor;
	}

	public int getConstruction() {
		return construction;
	}

	public void setConstruction(int construction) {
		this.construction = construction;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

}
