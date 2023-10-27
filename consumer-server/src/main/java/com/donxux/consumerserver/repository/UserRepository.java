package com.donxux.consumerserver.repository;

import com.donxux.consumerserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
