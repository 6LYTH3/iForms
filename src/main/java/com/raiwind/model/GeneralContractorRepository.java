package com.raiwind.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GeneralContractorRepository extends CrudRepository<GeneralContractor, Long> {

	public List<GeneralContractor> findByFormId(String formId);

	public GeneralContractor findByFormIdAndTopic(String formId, String topic);
}
