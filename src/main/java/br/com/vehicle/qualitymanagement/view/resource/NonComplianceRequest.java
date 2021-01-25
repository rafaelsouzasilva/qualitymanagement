package br.com.vehicle.qualitymanagement.view.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;
import br.com.vehicle.qualitymanagement.domain.NonCompliance;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class NonComplianceRequest {

    private UUID id;
    private String description;

    public NonCompliance toDomain() {
        return new NonCompliance(id, description);
    }
}
