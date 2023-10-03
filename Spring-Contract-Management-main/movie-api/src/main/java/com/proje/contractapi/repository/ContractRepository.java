package com.proje.contractapi.repository;

import com.proje.contractapi.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, String> {

    List<Contract> findAllByOrderByName();

    List<Contract> findByPriceContainingOrNameContainingIgnoreCaseOrderByName(String price, String name);
}
