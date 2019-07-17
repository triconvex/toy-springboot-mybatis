package io.zingoworks.springbootmybatis.user.service;

import io.zingoworks.springbootmybatis.user.model.User;

import java.util.List;

public interface UserService {

    User create();

    User findById(long id);

    User findByUser(String name);

    List<User> findAll();

    User update(User user);

    void deleteById(long id);

}