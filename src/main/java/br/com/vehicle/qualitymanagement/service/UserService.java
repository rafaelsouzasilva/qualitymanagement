package br.com.vehicle.qualitymanagement.service;

import br.com.vehicle.qualitymanagement.infra.adapter.UserAdapter;
import br.com.vehicle.qualitymanagement.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserAdapter userAdapter;

    public UserService(UserAdapter userAdapter) {
        this.userAdapter = userAdapter;
    }

    public User create(User user) {
        return userAdapter.save(user);
    }

    public List<User> findAll() {
        return userAdapter.findAll();
    }
}
