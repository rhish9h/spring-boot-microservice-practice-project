package in.rhish.user.service.service;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import com.sun.xml.internal.ws.api.message.Message;
import in.rhish.user.service.dto.Department;
import in.rhish.user.service.dto.UserWithDepartment;
import in.rhish.user.service.entity.User;
import in.rhish.user.service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<User> getUsers() {
        log.info("Fetching all users");
        List<User> users = (List<User>) userRepository.findAll();
        return users;
    }

    public UserWithDepartment getUserByIdWithDepartment(Long userId) throws Exception {
        log.info("Fetching user with id : " + userId);
        User user = userRepository.findById(userId)
                        .orElseThrow(() -> new Exception("User with id : " + userId + " not found."));
        Department department = restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId(),
                                                            Department.class);
        return UserWithDepartment.builder()
                                .userId(user.getUserId())
                                .firstName(user.getFirstName())
                                .lastName(user.getLastName())
                                .department(department)
                                .build();
    }

    public User saveUser(User user) {
        log.info("Saving user: " + user);
        return userRepository.save(user);
    }
}
