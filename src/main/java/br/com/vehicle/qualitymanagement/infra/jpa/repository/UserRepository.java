package br.com.vehicle.qualitymanagement.infra.jpa.repository;

import br.com.vehicle.qualitymanagement.infra.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByEmail(String email);
}
