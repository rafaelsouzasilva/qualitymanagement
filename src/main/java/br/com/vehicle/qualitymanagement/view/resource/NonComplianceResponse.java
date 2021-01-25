package br.com.vehicle.qualitymanagement.view.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;
import br.com.vehicle.qualitymanagement.domain.NonCompliance;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class NonComplianceResponse {

    private UUID id;
    private String description;

    public static NonComplianceResponse fromDomain(NonCompliance nonCompliance) {
        return new NonComplianceResponse(nonCompliance.getId(), nonCompliance.getDescription());
    }
}
