package br.com.vehicle.qualitymanagement.infra.jpa.repository;

import br.com.vehicle.qualitymanagement.infra.jpa.entity.IncidentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IncidentRepository extends JpaRepository<IncidentEntity, UUID> {

    List<IncidentEntity> findByQualityControlEntityId(UUID id);
    List<IncidentEntity> findByEnabled(boolean enabled);
}
