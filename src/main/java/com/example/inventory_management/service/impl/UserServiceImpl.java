package com.example.inventory_management.service.impl;


import com.example.inventory_management.dto.UserDTO;
import com.example.inventory_management.exceptions.EntityNotFoundException;
import com.example.inventory_management.exceptions.ErrorCodes;
import com.example.inventory_management.exceptions.InvalidEntityException;
import com.example.inventory_management.model.User;
import com.example.inventory_management.repository.UserRepos;
import com.example.inventory_management.service.UserService;
import com.example.inventory_management.utils.ErrorMsgConstant;
import com.example.inventory_management.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private UserRepos userRepos;

    @Autowired
    public UserServiceImpl(UserRepos userRepos){
        this.userRepos = userRepos;
    }
    @Override
    public UserDTO save(UserDTO userDTO) {
        List<String> errors = UserValidator.validate(userDTO);
        if(!errors.isEmpty())
        {
            log.error("Invalid user", userDTO);
            throw new InvalidEntityException(ErrorMsgConstant.INVALID_USER, ErrorCodes.USER_NOT_VALID, errors);
        }
        return UserDTO.fromEntity(
                userRepos.save(UserDTO.toEntity(userDTO))
        );
    }

    @Override
    public UserDTO findById(Integer id) {
        if(id == null){
            log.error("User ID is null");
            return null;
        }

        Optional<User> user = userRepos.findById(id);
        UserDTO userDTO = UserDTO.fromEntity(user.get());
        return Optional.of(userDTO).orElseThrow(() ->
                new EntityNotFoundException(ErrorMsgConstant.UNAVAILABLE_USER, ErrorCodes.USER_NOT_FOUND)
        );
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepos.findAll().stream()
                .map(UserDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("User ID is null");
            return;
        }
        userRepos.deleteById(id);
    }
}
