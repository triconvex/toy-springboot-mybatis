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
public class SimpleUserRepositoryTest {

    //TODO order 이용해서 커버리지 높여보기

    @Autowired
    private UserRepository userRepository;

    private User defaultUser;

    @Before
    public void setUp() throws Exception {
        defaultUser = User.builder()
                .name("name")
                .password("password")
                .build();
    }

    @Test
    public void save() {
        userRepository.save(defaultUser);
        User user = userRepository.findByName(defaultUser.getName()).orElse(null);

        Assertions.assertThat(user).isNotNull();
    }

    @Test
    public void findById() {
        userRepository.save(defaultUser);
        User subject = userRepository.findById(1L).orElse(null);

        Assertions.assertThat(subject).isNotNull();
    }

    @Test
    public void findByName() {
        userRepository.save(defaultUser);
        User subject = userRepository.findByName("name").orElseThrow(NoSuchElementException::new);

        Assertions.assertThat(subject.getName()).isEqualTo("name");
        Assertions.assertThat(subject.getPassword()).isEqualTo("password");
    }

    @Test(expected = NoSuchElementException.class)
    public void delete() {
        userRepository.save(defaultUser);
        userRepository.deleteById(1L);
        userRepository.findById(1L).orElseThrow(NoSuchElementException::new);
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void delete_doesnt_exist() {
        userRepository.deleteById(0L);
    }

}