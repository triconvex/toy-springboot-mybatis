package io.zingoworks.springbootmybatis.user.dao;

import io.zingoworks.springbootmybatis.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String name);

}
