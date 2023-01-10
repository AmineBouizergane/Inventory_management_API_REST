package com.example.inventory_management.service.impl;

import com.example.inventory_management.dto.LineOrderClientDTO;
import com.example.inventory_management.dto.OrderClientDTO;
import com.example.inventory_management.exceptions.EntityNotFoundException;
import com.example.inventory_management.exceptions.ErrorCodes;
import com.example.inventory_management.exceptions.InvalidEntityException;
import com.example.inventory_management.model.Client;
import com.example.inventory_management.model.Item;
import com.example.inventory_management.model.OrderClient;
import com.example.inventory_management.repository.ClientRepos;
import com.example.inventory_management.repository.ItemRepos;
import com.example.inventory_management.repository.LineOrderClientRepos;
import com.example.inventory_management.repository.OrderClientRepos;
import com.example.inventory_management.service.OrderClientService;
import com.example.inventory_management.utils.ErrorMsgConstant;
import com.example.inventory_management.validator.LineOrderClientValidator;
import com.example.inventory_management.validator.OrderClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderClientServiceImpl implements OrderClientService {

    private OrderClientRepos orderClientRepos;
    private ClientRepos clientRepos;
    private ItemRepos itemRepos;
    private LineOrderClientRepos lineOrderClientRepos;

    @Autowired
    public OrderClientServiceImpl(OrderClientRepos orderClientRepos,
                                  ClientRepos clientRepos,
                                  ItemRepos itemRepos,
                                  LineOrderClientRepos lineOrderClientRepos) {
        this.orderClientRepos = orderClientRepos;
        this.clientRepos = clientRepos;
        this.itemRepos = itemRepos;
        this.lineOrderClientRepos = lineOrderClientRepos;

    }


    @Override
    public OrderClientDTO save(OrderClientDTO orderClientDTO) {
        List<String> errors = OrderClientValidator.validate(orderClientDTO);
        if(!errors.isEmpty())
        {
            log.error("Invalid Order Client", orderClientDTO);
            throw new InvalidEntityException(ErrorMsgConstant.INVALID_ORDER, ErrorCodes.ORDER_CLIENT_NOT_VALID, errors);
        }

        Optional<Client> client = clientRepos.findById(orderClientDTO.getClient().getId());

        if(!client.isPresent()){
            log.warn("No client with ID {} was found", orderClientDTO.getClient().getId());
            throw new EntityNotFoundException(ErrorMsgConstant.UNAVAILABLE_CLIENT, ErrorCodes.CLIENT_NOT_FOUND);
        }

        AtomicInteger index = new AtomicInteger(1);
        orderClientDTO.getLineOrderClientList().forEach(line -> {
            List<String> errorsLine = LineOrderClientValidator.validate(line);
            if(errorsLine.isEmpty())
            {
                errors.add("Line order n°"+ index +"is invalid");
                Optional<Item> item = itemRepos.findById(line.getItem().getId());
                if (item.isEmpty()){
                    errors.add("Item (Id =>"+line.getItem().getId() +" | Designation =>"+line.getItem().getDesignation()+") of line order n°"+index+" is not available");
                }
            }
            index.getAndIncrement();
        });
        if(!errors.isEmpty()){
            log.warn("There was a problem registering the order");
            throw new InvalidEntityException(ErrorMsgConstant.INVALID_ORDER_LINE, ErrorCodes.LINE_ORDER_LINE_NOT_VALID, errors);
        }

         OrderClientDTO orderClientDTOSaved = OrderClientDTO.fromEntity(
                orderClientRepos.save(OrderClientDTO.toEntity(orderClientDTO))
        );

        orderClientDTO.getLineOrderClientList().forEach(line -> {
            line.setOrderClient(orderClientDTOSaved);
            lineOrderClientRepos.save(LineOrderClientDTO.toEntity(line));
        });

        return null;
    }

    @Override
    public OrderClientDTO findById(Integer id) {
        if(id == null){
            log.error("Order ID is null");
            return null;
        }

        Optional<OrderClient> orderClient = orderClientRepos.findById(id);
        OrderClientDTO clientDTO = OrderClientDTO.fromEntity(orderClient.get());
        return Optional.of(clientDTO).orElseThrow(() ->
                new EntityNotFoundException(ErrorMsgConstant.UNAVAILABLE_ORDER, ErrorCodes.ORDER_CLIENT_NOT_FOUND)
        );
    }

    @Override
    public OrderClientDTO findByCode(String code) {
        if(code == null){
            log.error("Order ID is null");
            return null;
        }

        Optional<OrderClient> orderClient = orderClientRepos.findByCode(code);
        OrderClientDTO clientDTO = OrderClientDTO.fromEntity(orderClient.get());
        return Optional.of(clientDTO).orElseThrow(() ->
                new EntityNotFoundException(ErrorMsgConstant.UNAVAILABLE_ORDER, ErrorCodes.ORDER_CLIENT_NOT_FOUND)
        );
    }

    @Override
    public List<OrderClientDTO> findAll() {
        return orderClientRepos.findAll().stream()
                .map(OrderClientDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Order ID is null");
            return;
        }
        orderClientRepos.deleteById(id);
    }
}
