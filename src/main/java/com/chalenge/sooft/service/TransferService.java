package com.chalenge.sooft.service;

import com.chalenge.sooft.controller.dto.TransferDto;
import com.chalenge.sooft.entity.Company;
import com.chalenge.sooft.entity.Transfer;
import com.chalenge.sooft.repository.CompanyRepository;
import com.chalenge.sooft.repository.TransferRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public Transfer saveOrUpdateTransfer(TransferDto transferDto) {
        Optional<Company> companyOp = companyRepository.findById(transferDto.getCompanyId());
        Transfer transfer = new ModelMapper().map(transferDto, Transfer.class);
        transfer.setCompany(companyOp.get());
        return transferRepository.save(transfer);
    }

    public List<Transfer> getAllTransfers() {
        return transferRepository.findAll();
    }

    public List<Transfer> getTransfersByCompany(Long companyId) {
        Optional<Company> companyOp = companyRepository.findById(companyId);
        if (companyOp.isPresent()) {
            return companyOp.get().getTransfers();
        } else {
            return new ArrayList<>();
        }
    }

}
