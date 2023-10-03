package com.proje.contractapi.mapper;

import org.springframework.stereotype.Service;

import com.proje.contractapi.model.Contract;
import com.proje.contractapi.rest.dto.ContractDto;
import com.proje.contractapi.rest.dto.CreateContractRequest;

import java.time.format.DateTimeFormatter;

@Service
public class ContractMapperImpl implements ContractMapper {
    

    @Override
    public Contract toContract(CreateContractRequest createContractRequest) {
        if (createContractRequest == null) {
            return null;
        }
        return new Contract(createContractRequest.getPrice(), createContractRequest.getName(),
                createContractRequest.getFile());
    }

    @Override
    public ContractDto toContractDto(Contract contract) {
        if (contract == null) {
            return null;
        }
        return new ContractDto(contract.getPrice(), contract.getName(), contract.getFile(),
                DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(contract.getCreatedAt()));
    }
}
