package com.raiwind.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ContractPriceRepository extends CrudRepository<ContractPrice, Long> {
	public List<ContractPrice> findByFormId(String formId);

	public ContractPrice findByFormIdAndTopic(String formId, String topic);
}
