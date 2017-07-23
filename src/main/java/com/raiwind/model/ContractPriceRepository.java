package com.raiwind.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ContractPriceRepository extends CrudRepository<ContractPrice, Long> {

}
