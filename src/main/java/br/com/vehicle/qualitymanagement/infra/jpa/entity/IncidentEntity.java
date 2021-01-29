package br.com.vehicle.qualitymanagement.infra.jpa.entity;

import br.com.vehicle.qualitymanagement.domain.NonCompliance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "incident")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class IncidentEntity {

    @Id
    private UUID id;
    private String title;
    private String description;
    @Column(name = "incident_date")
    private Date date;
    private String origin;
    private boolean enabled;
    @Column(name = "violated_rule_code")
    private String violatedRuleCode;
    @Column(name = "violated_rule_description")
    private String violatedRuleDescription;
    @ManyToOne
    @JoinColumn(name = "quality_control_id", referencedColumnName = "id")
    private QualityControlEntity qualityControlEntity;

    public static IncidentEntity fromNonCompliance(NonCompliance nonCompliance) {
        UUID id = (nonCompliance.getId() == null) ? UUID.randomUUID() : nonCompliance.getId();
        return new IncidentEntity(
            id,
            nonCompliance.getTitle(),
            nonCompliance.getDescription(),
            nonCompliance.getDate(),
            nonCompliance.getOrigin(),
            nonCompliance.isEnabled(),
            nonCompliance.getViolatedRuleCode(),
            nonCompliance.getViolatedRuleDescription(),
            QualityControlEntity.fromDomain(nonCompliance.getQualityControl().getId())
        );
    }

    public NonCompliance toNonCompliance() {
        return new NonCompliance(
            id,
            title,
            description,
            date,
            origin,
            enabled,
            violatedRuleCode,
            violatedRuleDescription,
            qualityControlEntity.toDomain()
        );
    }
}
