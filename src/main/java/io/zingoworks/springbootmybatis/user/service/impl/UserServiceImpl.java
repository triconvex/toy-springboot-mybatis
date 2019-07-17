package io.zingoworks.springbootmybatis.user.service.impl;

import io.zingoworks.springbootmybatis.user.dao.UserRepository;
import io.zingoworks.springbootmybatis.user.model.User;
import io.zingoworks.springbootmybatis.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User create() {
        return null;
    }

    @Override
    public User findById(long id) {
        return null;
    }

    @Override
    public User findByUser(String name) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

}
