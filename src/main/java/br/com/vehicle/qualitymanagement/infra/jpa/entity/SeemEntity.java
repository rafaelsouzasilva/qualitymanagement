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
import javax.persistence.Table;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "seem")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class SeemEntity {

    @Id
    private UUID id;
    private String description;
    @Column(name = "seem_date")
    private Date date;
    private boolean conclusive;
    private boolean enabled;
    @ManyToOne
    @JoinColumn(name = "incident_id", referencedColumnName = "id")
    private IncidentEntity incidentEntity;

}
