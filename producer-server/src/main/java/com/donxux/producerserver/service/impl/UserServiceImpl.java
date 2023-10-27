package com.donxux.producerserver.service.impl;

import com.donxux.producerserver.model.OutboxEvent;
import com.donxux.producerserver.model.User;
import com.donxux.producerserver.repository.OutboxEventRepository;
import com.donxux.producerserver.repository.UserRepository;
import com.donxux.producerserver.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final OutboxEventRepository outboxEventRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    @Transactional
    public void insertUser(User user) throws JsonProcessingException {
        userRepository.save(user);
        final String json = objectMapper.writeValueAsString(user);
        outboxEventRepository.save(
                new OutboxEvent(null, "user", "user", "insertUser", json)
        );
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
