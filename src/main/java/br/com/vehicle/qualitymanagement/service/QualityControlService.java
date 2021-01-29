package br.com.vehicle.qualitymanagement.service;

import br.com.vehicle.qualitymanagement.domain.QualityControl;
import br.com.vehicle.qualitymanagement.infra.adapter.QualityControlAdapter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class QualityControlService {

    private QualityControlAdapter qualityControlAdapter;

    public QualityControlService(QualityControlAdapter qualityControlAdapter) {
        this.qualityControlAdapter = qualityControlAdapter;
    }
    
    public List<QualityControl> findAll() {
        return qualityControlAdapter.findAll();
    }

    public QualityControl findById(UUID id) {
        return qualityControlAdapter.findById(id);
    }

}
