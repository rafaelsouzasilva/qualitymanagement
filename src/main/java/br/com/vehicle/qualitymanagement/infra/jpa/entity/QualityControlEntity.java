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
@Table(name = "quality_control")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class QualityControlEntity {

    @Id
    private UUID id;
    private String description;
    @Column(name = "evaluation_date")
    private Date evaluationDate;
    private boolean enabled;
    private boolean closed;

    @ManyToOne
    @JoinColumn(name = "parametrization_quality_control_id", referencedColumnName = "id")
    private ParametrizationQualityControlEntity parametrizationQualityControlEntity;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private EmployeeEntity employeeEntity;

}
