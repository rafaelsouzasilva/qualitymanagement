package br.com.vehicle.qualitymanagement.service;

import br.com.vehicle.qualitymanagement.infra.adapter.NonComplianceAdapter;
import br.com.vehicle.qualitymanagement.domain.NonCompliance;
import org.springframework.stereotype.Service;

@Service
public class NonComplianceService {

    private NonComplianceAdapter nonComplianceAdapter;

    public NonComplianceService(NonComplianceAdapter nonComplianceAdapter) {
        this.nonComplianceAdapter = nonComplianceAdapter;
    }
    
    public NonCompliance create(NonCompliance nonCompliance) {
        return nonComplianceAdapter.save(nonCompliance);
    }
}
