package com.donxux.producerserver.repository;

import com.donxux.producerserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
