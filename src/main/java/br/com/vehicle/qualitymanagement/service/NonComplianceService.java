package br.com.vehicle.qualitymanagement.service;

import br.com.vehicle.qualitymanagement.infra.adapter.NonComplianceAdapter;
import br.com.vehicle.qualitymanagement.domain.NonCompliance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NonComplianceService {

    private NonComplianceAdapter nonComplianceAdapter;

    public NonComplianceService(NonComplianceAdapter nonComplianceAdapter) {
        this.nonComplianceAdapter = nonComplianceAdapter;
    }
    
    public NonCompliance create(NonCompliance nonCompliance) {
        return nonComplianceAdapter.save(nonCompliance);
    }

    public List<NonCompliance> findAll() {
        return nonComplianceAdapter.findAll();
    }

    public NonCompliance update(NonCompliance nonCompliance) {
        return nonComplianceAdapter.save(nonCompliance);
    }

    public NonCompliance find(UUID id) {
        return nonComplianceAdapter.find(id);
    }

    public void delete(UUID id) {
        nonComplianceAdapter.delete(id);
    }

    public List<NonCompliance> findAllByQualityControl(UUID id) {
        return nonComplianceAdapter.listAllByQualityControl(id);
    }
}
