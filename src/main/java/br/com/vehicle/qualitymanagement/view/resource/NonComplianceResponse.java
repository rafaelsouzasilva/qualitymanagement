package br.com.vehicle.qualitymanagement.view.resource;

import br.com.vehicle.qualitymanagement.domain.QualityControl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;
import br.com.vehicle.qualitymanagement.domain.NonCompliance;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class NonComplianceResponse {

    private UUID id;
    private String title;
    private String description;
    private Date date;
    private String origin;
    private boolean enabled;
    private String violatedRuleCode;
    private String violatedRuleDescription;
    private QualityControl qualityControl;

    public static NonComplianceResponse fromDomain(NonCompliance nonCompliance) {
        return new NonComplianceResponse(
            nonCompliance.getId(),
            nonCompliance.getTitle(),
            nonCompliance.getDescription(),
            nonCompliance.getDate(),
            nonCompliance.getOrigin(),
            nonCompliance.isEnabled(),
            nonCompliance.getViolatedRuleCode(),
            nonCompliance.getViolatedRuleDescription(),
            nonCompliance.getQualityControl()
        );
    }
}
