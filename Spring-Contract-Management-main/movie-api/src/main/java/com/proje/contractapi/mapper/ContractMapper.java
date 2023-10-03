package com.proje.contractapi.mapper;

import com.proje.contractapi.model.Contract;
import com.proje.contractapi.rest.dto.ContractDto;
import com.proje.contractapi.rest.dto.CreateContractRequest;

public interface ContractMapper {

    Contract toContract(CreateContractRequest createContractRequest);

    ContractDto toContractDto(Contract contract);
}