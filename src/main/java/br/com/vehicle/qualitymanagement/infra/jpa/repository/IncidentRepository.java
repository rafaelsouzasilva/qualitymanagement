package br.com.vehicle.qualitymanagement.infra.jpa.repository;

import br.com.vehicle.qualitymanagement.infra.jpa.entity.IncidentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IncidentRepository extends JpaRepository<IncidentEntity, UUID> { }
