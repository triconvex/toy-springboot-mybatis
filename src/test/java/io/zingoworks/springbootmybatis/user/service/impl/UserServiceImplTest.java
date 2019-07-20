package io.zingoworks.springbootmybatis.user.service.impl;

import io.zingoworks.springbootmybatis.user.dao.UserRepository;
import io.zingoworks.springbootmybatis.user.model.User;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;

    private User defaultUser;

    @Before
    public void setUp() {
        defaultUser = User.builder()
                .name("name")
                .password("password")
                .build();
    }

    @Test
    public void create() {
        User user = userService.create(defaultUser);
        User selected = userRepository.findById(user.getId()).orElse(null);

        Assertions.assertThat(selected).isNotNull();
    }

    @Test
    public void findById() {
        User user = userService.create(defaultUser);
        User selected = userService.findById(user.getId()).orElse(null);

        Assertions.assertThat(selected).isNotNull();
        Assertions.assertThat(selected.getName()).isEqualTo(user.getName());
        Assertions.assertThat(selected.getPassword()).isEqualTo(user.getPassword());
    }

    @Test
    public void findByName() {
        User user = userService.create(defaultUser);
        User selected = userService.findByName(user.getName()).orElse(null);

        Assertions.assertThat(selected).isNotNull();
        Assertions.assertThat(selected.getName()).isEqualTo(user.getName());
        Assertions.assertThat(selected.getPassword()).isEqualTo(user.getPassword());
    }

    @Test
    public void findAll() {
        userService.create(defaultUser);
        userService.create(defaultUser);
        userService.create(defaultUser);

        List<User> users = userService.findAll();
        Assertions.assertThat(users.size()).isEqualTo(3);
    }

    @Test
    public void update() {

    }

    @Test
    public void deleteById() {

    }

}