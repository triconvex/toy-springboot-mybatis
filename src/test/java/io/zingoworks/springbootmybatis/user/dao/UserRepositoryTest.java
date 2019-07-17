package io.zingoworks.springbootmybatis.user.dao;

import io.zingoworks.springbootmybatis.user.model.User;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//TODO https://stackoverflow.com/questions/41092716/how-to-reset-between-tests
// 현재 메소드마다 인메모리 DB환경 초기화, -> 어떤식으로 효율적으로?
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

        //TODO Assertions 검증에 제일 편한가? 어떤점이 좋은가? 차별점은?
        //TODO assertJ core 어떤라이브러리에 들어가있나?

    @Test
    public void findById() {
        User user = User.builder()
                .name("name")
                .password("password")
                .build();

        userRepository.save(user);
        User subject = userRepository.findById(1L).orElseThrow(NoSuchElementException::new);

        Assertions.assertThat(subject.getName()).isEqualTo("name");
        Assertions.assertThat(subject.getPassword()).isEqualTo("password");
    }

    @Test
    public void findByName() {
        User user = User.builder()
                .name("name")
                .password("password")
                .build();

        userRepository.save(user);
        User subject = userRepository.findByName("name").orElseThrow(NoSuchElementException::new);

        Assertions.assertThat(subject.getName()).isEqualTo("name");
        Assertions.assertThat(subject.getPassword()).isEqualTo("password");
    }

    @Test(expected = NoSuchElementException.class)
    public void delete() {
        User user = User.builder()
                .name("name")
                .password("password")
                .build();

        userRepository.save(user);
        userRepository.deleteById(1L);

        userRepository.findById(1L).orElseThrow(NoSuchElementException::new);
    }

    @Test(expected = EmptyResultDataAccessException.class)
    //TODO https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/dao/EmptyResultDataAccessException.html
    public void delete_doesnt_exist() {
        User user = User.builder()
                .name("name")
                .password("password")
                .build();

        userRepository.save(user);
        userRepository.deleteById(2L);
    }

}