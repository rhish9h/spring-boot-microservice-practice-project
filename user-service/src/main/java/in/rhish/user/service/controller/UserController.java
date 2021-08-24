package in.rhish.user.service.controller;

import in.rhish.user.service.dto.UserWithDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import in.rhish.user.service.entity.User;
import in.rhish.user.service.service.UserService;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserWithDepartment getUserByIdWithDepartment(@PathVariable("id") Long userId) throws Exception {
        return userService.getUserByIdWithDepartment(userId);
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

}
