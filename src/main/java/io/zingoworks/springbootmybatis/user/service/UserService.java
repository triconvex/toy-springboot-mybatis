package io.zingoworks.springbootmybatis.user.service;

import io.zingoworks.springbootmybatis.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User create(User user);

    Optional<User> findById(long id);

    Optional<User> findByName(String name);

    List<User> findAll();

    void update(User user);

    void deleteById(long id);

}
