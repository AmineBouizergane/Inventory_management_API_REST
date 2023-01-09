package com.example.inventory_management.service.impl;


import com.example.inventory_management.dto.CompanyDTO;
import com.example.inventory_management.exceptions.EntityNotFoundException;
import com.example.inventory_management.exceptions.ErrorCodes;
import com.example.inventory_management.exceptions.InvalidEntityException;
import com.example.inventory_management.model.Company;
import com.example.inventory_management.repository.CompanyRepos;
import com.example.inventory_management.service.CompanyService;
import com.example.inventory_management.utils.ErrorMsgConstant;
import com.example.inventory_management.validator.CompanyValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepos companyRepos;

    @Autowired
    public CompanyServiceImpl(CompanyRepos companyRepos){
        this.companyRepos = companyRepos;
    }
    @Override
    public CompanyDTO save(CompanyDTO companyDTO) {
        List<String> errors = CompanyValidator.validate(companyDTO);
        if(!errors.isEmpty())
        {
            log.error("Invalid company", companyDTO);
            throw new InvalidEntityException(ErrorMsgConstant.INVALID_COMPANY, ErrorCodes.COMPANY_NOT_VALID, errors);
        }
        return CompanyDTO.fromEntity(
                companyRepos.save(CompanyDTO.toEntity(companyDTO))
        );
    }

    @Override
    public CompanyDTO findById(Integer id) {
        if(id == null){
            log.error("Company ID is null");
            return null;
        }

        Optional<Company> company = companyRepos.findById(id);
        CompanyDTO companyDTO = CompanyDTO.fromEntity(company.get());
        return Optional.of(companyDTO).orElseThrow(() ->
                new EntityNotFoundException(ErrorMsgConstant.UNAVAILABLE_COMPANY, ErrorCodes.COMPANY_NOT_FOUND)
        );
    }

    @Override
    public List<CompanyDTO> findAll() {
        return companyRepos.findAll().stream()
                .map(CompanyDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Company ID is null");
            return;
        }
        companyRepos.deleteById(id);
    }
}
