package br.com.vehicle.qualitymanagement.view.resource;

import br.com.vehicle.qualitymanagement.domain.QualityControl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import br.com.vehicle.qualitymanagement.domain.NonCompliance;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class NonComplianceRequest {

    private String title;
    private String description;
    private Date date;
    private String origin;
    private boolean enabled;
    private String violatedRuleCode;
    private String violatedRuleDescription;
    private QualityControl qualityControl;

    public NonCompliance toDomain() {
        return new NonCompliance(
            null,
            title,
            description,
            new java.sql.Date(date.getTime()),
            origin,
            enabled,
            violatedRuleCode,
            violatedRuleDescription,
            qualityControl
        );
    }
}
