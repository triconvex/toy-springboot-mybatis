package io.zingoworks.springbootmybatis.user;

import io.zingoworks.springbootmybatis.api.response.ApiResult;
import io.zingoworks.springbootmybatis.user.model.User;
import io.zingoworks.springbootmybatis.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping
    public ApiResult<User> saveUser(User user) {
        return new ApiResult<>(userService.save(user));
    }

    @GetMapping("/{id}")
    public ApiResult<User> getUser(@PathVariable long id) {
        return new ApiResult<>(userService.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @GetMapping
    public ApiResult<List<User>> getUsers() {
        return new ApiResult<>(userService.findAll());
    }

    @PutMapping("/{id}")
    public ApiResult<User> updateUser(@PathVariable long id, User target) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ApiResult<String> deleteUser(@PathVariable long id) {
        userService.deleteById(id);
        return new ApiResult<>("User deleted");
    }

}
