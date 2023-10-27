package com.donxux.consumerserver.service;

import com.donxux.consumerserver.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void insertUser(User user) throws JsonProcessingException;
    User getUser(Long id);
    void updateUser(User user);
    void deleteUser(Long id);
}
