package br.com.vehicle.qualitymanagement.infra.adapter;

import br.com.vehicle.qualitymanagement.domain.User;
import br.com.vehicle.qualitymanagement.infra.jpa.entity.UserEntity;
import br.com.vehicle.qualitymanagement.infra.jpa.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserAdapter {

    private UserRepository userRepository;

    public UserAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(UserEntity.fromDomain(user)).toDomain();
    }

    public List<User> findAll() {
        return userRepository.findAll().stream().map(UserEntity::toDomain).collect(Collectors.toList());
    }
}
