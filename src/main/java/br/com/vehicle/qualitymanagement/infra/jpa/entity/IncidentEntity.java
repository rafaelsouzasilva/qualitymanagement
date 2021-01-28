package br.com.vehicle.qualitymanagement.infra.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

}
