package br.com.vehicle.qualitymanagement.infra.adapter;

import br.com.vehicle.qualitymanagement.domain.NonCompliance;
import br.com.vehicle.qualitymanagement.infra.jpa.entity.IncidentEntity;
import br.com.vehicle.qualitymanagement.infra.jpa.entity.QualityControlEntity;
import br.com.vehicle.qualitymanagement.infra.jpa.repository.IncidentRepository;
import br.com.vehicle.qualitymanagement.infra.jpa.repository.QualityControlRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class NonComplianceAdapter { 

    private IncidentRepository incidentRepository;
    private QualityControlRepository qualityControlRepository;

    public NonComplianceAdapter(IncidentRepository incidentRepository, QualityControlRepository qualityControlRepository) {
        this.incidentRepository = incidentRepository;
        this.qualityControlRepository = qualityControlRepository;
    }

    public NonCompliance save(NonCompliance nonCompliance) {
        IncidentEntity entity = IncidentEntity.fromNonCompliance(nonCompliance);
        QualityControlEntity qualityControlEntity = qualityControlRepository.findById(entity.getQualityControlEntity().getId()).get();
        entity.setQualityControlEntity(qualityControlEntity);
        return incidentRepository.save(entity).toNonCompliance();
    }

    public List<NonCompliance> findAll() {
        return incidentRepository.findAll()
                .stream()
                .map(IncidentEntity::toNonCompliance)
                .collect(Collectors.toList());
    }

    public NonCompliance find(UUID id) {
        return incidentRepository.findById(id).get().toNonCompliance();
    }

    public void delete(UUID id) {
        Optional<IncidentEntity> entity = incidentRepository.findById(id);
        entity.get().setEnabled(false);
    }
}
