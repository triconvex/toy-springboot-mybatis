package io.zingoworks.springbootmybatis.user.dao;

import io.zingoworks.springbootmybatis.user.model.User;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

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
        User user = userRepository.save(defaultUser);
        User selected = userRepository.findById(user.getId()).orElse(null);

        Assertions.assertThat(selected).isNotNull();
    }

    @Test
    public void findByName() {
        User user = userRepository.save(defaultUser);
        User selected = userRepository.findByName(user.getName()).orElse(null);

        Assertions.assertThat(selected).isNotNull();
        Assertions.assertThat(selected.getName()).isEqualTo(user.getName());
        Assertions.assertThat(selected.getPassword()).isEqualTo(user.getPassword());
    }

    @Test(expected = NoSuchElementException.class)
    public void delete() {
        User user = userRepository.save(defaultUser);
        userRepository.deleteById(user.getId());
        userRepository.findById(user.getId()).orElseThrow(NoSuchElementException::new);
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void delete_doesnt_exist() {
        userRepository.deleteById(0L);
    }

}