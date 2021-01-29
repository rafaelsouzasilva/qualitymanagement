package br.com.vehicle.qualitymanagement.infra.adapter;

import br.com.vehicle.qualitymanagement.domain.QualityControl;
import br.com.vehicle.qualitymanagement.infra.jpa.entity.QualityControlEntity;
import br.com.vehicle.qualitymanagement.infra.jpa.repository.QualityControlRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class QualityControlAdapter {

    private QualityControlRepository qualityControlRepository;

    public QualityControlAdapter(QualityControlRepository qualityControlRepository) {
        this.qualityControlRepository = qualityControlRepository;
    }

    public List<QualityControl> findAll() {
        return qualityControlRepository.findAll()
                    .stream()
                    .map(QualityControlEntity::toDomain)
                    .collect(Collectors.toList());
    }

    public QualityControl findById(UUID id) {
        return qualityControlRepository.findById(id).get().toDomain();
    }
}
