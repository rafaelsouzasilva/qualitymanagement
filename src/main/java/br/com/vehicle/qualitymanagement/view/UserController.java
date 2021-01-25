package br.com.vehicle.qualitymanagement.view;

import br.com.vehicle.qualitymanagement.domain.User;
import br.com.vehicle.qualitymanagement.service.UserService;
import br.com.vehicle.qualitymanagement.view.resource.UserRequest;
import br.com.vehicle.qualitymanagement.view.resource.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest user) {
        User savedUser = userService.create(user.toDomain());
        UserResponse userResponse = UserResponse.fromDomain(savedUser);
        return ResponseEntity.created(URI.create("/users/" + userResponse.getId())).body(userResponse);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> list() {
        List<User> userList = userService.findAll();
        List<UserResponse> responseList = userList.stream().map(UserResponse::fromDomain).collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }
}
