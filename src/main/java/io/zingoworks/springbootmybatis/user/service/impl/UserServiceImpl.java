package io.zingoworks.springbootmybatis.user.service.impl;

import io.zingoworks.springbootmybatis.user.dao.UserRepository;
import io.zingoworks.springbootmybatis.user.model.User;
import io.zingoworks.springbootmybatis.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(long id) {
        return null;
    }

    @Override
    public Optional<User> findByName(String name) {
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public void update(User user) {
    }

    @Override
    public void deleteById(long id) {

    }

}
