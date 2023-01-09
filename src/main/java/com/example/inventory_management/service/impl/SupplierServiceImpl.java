package com.example.inventory_management.service.impl;

import com.example.inventory_management.dto.ClientDTO;
import com.example.inventory_management.dto.SupplierDTO;
import com.example.inventory_management.exceptions.EntityNotFoundException;
import com.example.inventory_management.exceptions.ErrorCodes;
import com.example.inventory_management.exceptions.InvalidEntityException;
import com.example.inventory_management.model.Client;
import com.example.inventory_management.model.Supplier;
import com.example.inventory_management.repository.ClientRepos;
import com.example.inventory_management.repository.SupplierRepos;
import com.example.inventory_management.service.SupplierService;
import com.example.inventory_management.utils.ErrorMsgConstant;
import com.example.inventory_management.validator.ClientValidator;
import com.example.inventory_management.validator.SupplierValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SupplierServiceImpl implements SupplierService {
    private SupplierRepos supplierRepos;

    @Autowired
    public SupplierServiceImpl(SupplierRepos supplierRepos){
        this.supplierRepos = supplierRepos;
    }
    @Override
    public SupplierDTO save(SupplierDTO supplierDTO) {
        List<String> errors = SupplierValidator.validate(supplierDTO);
        if(!errors.isEmpty())
        {
            log.error("Invalid supplier", supplierDTO);
            throw new InvalidEntityException(ErrorMsgConstant.INVALID_SUPPLIER, ErrorCodes.SUPPLIER_NOT_VALID, errors);
        }
        return SupplierDTO.fromEntity(
                supplierRepos.save(SupplierDTO.toEntity(supplierDTO))
        );
    }

    @Override
    public SupplierDTO findById(Integer id) {
        if(id == null){
            log.error("Supplier ID is null");
            return null;
        }

        Optional<Supplier> supplier = supplierRepos.findById(id);
        SupplierDTO supplierDTO = SupplierDTO.fromEntity(supplier.get());
        return Optional.of(supplierDTO).orElseThrow(() ->
                new EntityNotFoundException(ErrorMsgConstant.UNAVAILABLE_SUPPLIER, ErrorCodes.SUPPLIER_NOT_FOUND)
        );
    }

    @Override
    public List<SupplierDTO> findAll() {
        return supplierRepos.findAll().stream()
                .map(SupplierDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Supplier ID is null");
            return;
        }
        supplierRepos.deleteById(id);
    }
}
