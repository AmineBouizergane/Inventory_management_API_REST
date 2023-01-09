package com.example.inventory_management.service.impl;

import com.example.inventory_management.dto.ClientDTO;
import com.example.inventory_management.exceptions.EntityNotFoundException;
import com.example.inventory_management.exceptions.ErrorCodes;
import com.example.inventory_management.exceptions.InvalidEntityException;
import com.example.inventory_management.model.Client;
import com.example.inventory_management.repository.ClientRepos;
import com.example.inventory_management.service.ClientService;
import com.example.inventory_management.utils.ErrorMsgConstant;
import com.example.inventory_management.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
    private ClientRepos clientRepos;

    @Autowired
    public ClientServiceImpl(ClientRepos clientRepos){
        this.clientRepos = clientRepos;
    }
    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        List<String> errors = ClientValidator.validate(clientDTO);
        if(!errors.isEmpty())
        {
            log.error("Invalid client", clientDTO);
            throw new InvalidEntityException(ErrorMsgConstant.INVALID_CLIENT, ErrorCodes.CLIENT_NOT_VALID, errors);
        }
        return ClientDTO.fromEntity(
                clientRepos.save(ClientDTO.toEntity(clientDTO))
        );
    }

    @Override
    public ClientDTO findById(Integer id) {
        if(id == null){
            log.error("Client ID is null");
            return null;
        }

        Optional<Client> client = clientRepos.findById(id);
        ClientDTO clientDTO = ClientDTO.fromEntity(client.get());
        return Optional.of(clientDTO).orElseThrow(() ->
                new EntityNotFoundException(ErrorMsgConstant.UNAVAILABLE_CLIENT, ErrorCodes.CLIENT_NOT_FOUND)
        );
    }

    @Override
    public List<ClientDTO> findAll() {
        return clientRepos.findAll().stream()
                .map(ClientDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Client ID is null");
            return;
        }
        clientRepos.deleteById(id);
    }
}
