package br.com.vehicle.qualitymanagement.infra.adapter;

import br.com.vehicle.qualitymanagement.domain.NonCompliance;

public class NonComplianceAdapter { 
    
    public NonCompliance save(NonCompliance nonCompliance) {
        return new NonCompliance();
    }
}
