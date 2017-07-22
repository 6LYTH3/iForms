package com.raiwind.model;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MasterDocRepository extends CrudRepository<MasterDoc, Long> {

	@Modifying
	@Transactional
	@Query("delete from MasterDoc m where m.jobno = ?1")
	public void deleteByJobno(String jobno);

	public MasterDoc findByFormId(String formId);

	public MasterDoc findByJobno(String jobno);

	public List<MasterDoc> findByTypeOrderByIdDesc(String type);
}
