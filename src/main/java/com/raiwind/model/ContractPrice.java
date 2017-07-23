package com.raiwind.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contractprice")
public class ContractPrice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int amount;
	private String remark;
	private String topic;
	private String formId;
	private String section;

	public ContractPrice() {

	}

	public ContractPrice(int amount, String remark, String topic, String formId, String section) {
		this.amount = amount;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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
