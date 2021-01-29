package br.com.vehicle.qualitymanagement.infra.jpa.entity;

import br.com.vehicle.qualitymanagement.domain.ParametrizationQualityControl;
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
import java.sql.Time;
import java.util.UUID;

@Entity
@Table(name = "parametrization_quality_control")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ParametrizationQualityControlEntity {

    @Id
    private UUID id;
    private String description;
    @Column(name = "start_time_allowed")
    private Time startTimeAllowed;
    @Column(name = "end_time_allowed")
    private Time endTimeAllowed;
    @ManyToOne
    @JoinColumn(name = "process_id", referencedColumnName = "id")
    private ProcessEntity processEntity;

    public ParametrizationQualityControl toDomain() {
        return new ParametrizationQualityControl(
            id,
            description,
            processEntity.toDomain()
        );
    }
}
