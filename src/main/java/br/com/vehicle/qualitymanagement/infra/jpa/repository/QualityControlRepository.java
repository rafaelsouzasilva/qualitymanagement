package br.com.vehicle.qualitymanagement.infra.jpa.repository;

import br.com.vehicle.qualitymanagement.infra.jpa.entity.QualityControlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QualityControlRepository extends JpaRepository<QualityControlEntity, UUID> { }
