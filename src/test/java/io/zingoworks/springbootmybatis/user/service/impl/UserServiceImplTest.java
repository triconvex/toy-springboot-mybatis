package io.zingoworks.springbootmybatis.user.service.impl;

import io.zingoworks.springbootmybatis.user.dao.UserRepository;
import io.zingoworks.springbootmybatis.user.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Java6Assertions.assertThat;

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
    public void save() {
        User user = userService.save(defaultUser);
        User selected = userRepository.findById(user.getId()).orElse(null);

        assertThat(selected).isNotNull();
    }

    @Test
    public void findById() {
        User user = userService.save(defaultUser);
        User selected = userService.findById(user.getId()).orElse(null);

        assertThat(selected).isNotNull();
        assertThat(selected.getName()).isEqualTo(user.getName());
        assertThat(selected.getPassword()).isEqualTo(user.getPassword());
    }

    @Test
    public void findByName() {
        User user = userService.save(defaultUser);
        User selected = userService.findByName(user.getName()).orElse(null);

        assertThat(selected).isNotNull();
        assertThat(selected.getName()).isEqualTo(user.getName());
        assertThat(selected.getPassword()).isEqualTo(user.getPassword());
    }

    @Test
    public void findAll() {
        userService.save(defaultUser);
        userService.save(defaultUser);
        userService.save(defaultUser);

        List<User> users = userService.findAll();
        assertThat(users.size()).isEqualTo(3);
    }

    @Test
    public void update() {
        User original = userService.save(defaultUser);
        User target = User.builder()
                .id(original.getId())
                .name("updated")
                .password("password")
                .build();

        userService.update(target);
        User user = userRepository.findById(original.getId()).orElseThrow(NoSuchElementException::new);

        assertThat(user.getName()).isEqualTo(target.getName());
    }

    @Test
    public void deleteById() {
        User user = userService.save(defaultUser);
        userService.deleteById(user.getId());
        User deleted = userRepository.findById(user.getId()).orElse(null);

        assertThat(deleted).isNull();
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void deleteById_doesnt_exist() {
        userRepository.deleteById(0L);
    }

}