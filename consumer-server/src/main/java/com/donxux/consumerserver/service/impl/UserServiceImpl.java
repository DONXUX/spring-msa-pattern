package com.donxux.consumerserver.service.impl;

import com.donxux.consumerserver.model.User;
import com.donxux.consumerserver.repository.UserRepository;
import com.donxux.consumerserver.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    @Transactional
    public void insertUser(User user) throws JsonProcessingException {
        userRepository.save(user);
        final String json = objectMapper.writeValueAsString(user);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
