package com.proje.contractapi.service;

import com.proje.contractapi.exception.ContractNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.proje.contractapi.model.Contract;
import com.proje.contractapi.repository.ContractRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;

    @Override
    public List<Contract> getContracts() {
        return contractRepository.findAllByOrderByName();
    }

    @Override
    public List<Contract> getContractsContainingText(String text) {
        return contractRepository.findByPriceContainingOrNameContainingIgnoreCaseOrderByName(text, text);
    }

    @Override
    public Contract validateAndGetContract(String price) {
        return contractRepository.findById(price)
                .orElseThrow(
                        () -> new ContractNotFoundException(String.format("Contract with price is not found", price)));
    }

    @Override
    public Contract saveContract(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public void deleteContract(Contract contract) {
        contractRepository.delete(contract);
    }
}
